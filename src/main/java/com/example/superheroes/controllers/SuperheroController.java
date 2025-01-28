package com.example.superheroes.controllers;
import com.example.superheroes.config.SqsConfig;
import com.example.superheroes.models.Superhero;
import com.example.superheroes.services.SuperheroConsumer;
import com.example.superheroes.services.SuperheroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.SendMessageRequest;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SuperheroController {
    private final SuperheroService service;
    private final SqsClient sqsClient;
    private final SuperheroConsumer superheroConsumer;

    private final SqsConfig sqsConfig;

    @Autowired
    public SuperheroController(SuperheroService service, SqsClient sqsClient,
                               SuperheroConsumer superheroConsumer, SqsConfig sqsConfig) {
        this.service = service;
        this.sqsClient = sqsClient;
        this.superheroConsumer = superheroConsumer;
        this.sqsConfig = sqsConfig;
    }
    @GetMapping("/send")
    public String sendTestMessage(@RequestParam(defaultValue = "Iron Man") String superheroName) {
        sqsClient.sendMessage(SendMessageRequest.builder()
                .queueUrl(sqsConfig.getQueueUrl())
                .messageBody(superheroName)
                .build());

        return "Message sent to queue: " + superheroName;
    }

    // Other endpoints
    @PostMapping("/superhero")
    public void insertSuperhero(@RequestBody Superhero superhero) {
        service.insertSuperhero(superhero);
    }

    @PostMapping("/superheroes")
    public void insertManySuperheroes(@RequestBody List<Superhero> superheroList) {
        service.insertManySuperheroes(superheroList);
    }

    @PutMapping("/superheroes/{name}")
    public Superhero updateSuperhero(@PathVariable String name, @RequestBody Superhero updatedSuperhero) {
        return service.updateSuperhero(name, updatedSuperhero);
    }

    @DeleteMapping("/superheroes/{name}")
    public boolean deleteSuperhero(@PathVariable String name) {
        return service.deleteSuperhero(name);
    }

    @GetMapping("/superhero")
    public List<Superhero> getSuperheroes(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String universe) {
        return service.getSuperheroes(name, universe);
    }

    // Consumes a message from the SQS queue using the superheroConsumer
    @GetMapping("/getDelete")
    public String getMessage() {
        return superheroConsumer.consumeSuperhero();
    }

    // Asynchronously updates with a name by sending it to the SQS queue
    @PutMapping("/update_async")
    public String getUpdate(@RequestParam String name) {
        String response = superheroConsumer.getSuperhero();
        sqsClient.sendMessage(SendMessageRequest.builder().queueUrl(sqsConfig.getQueueUrl())
                .messageBody(name).build());
        return response + " Updated to " + name;
    }
}