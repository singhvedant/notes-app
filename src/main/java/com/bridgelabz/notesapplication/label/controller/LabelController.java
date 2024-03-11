package com.bridgelabz.notesapplication.label.controller;

import com.bridgelabz.notesapplication.label.entity.Label;
import com.bridgelabz.notesapplication.label.service.LabelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/label")
public class LabelController {

    @Autowired
    LabelServiceImpl labelService;

    @PostMapping("/add")
    public Mono<Label> addLabel(@RequestBody Label label) {
        return labelService.addLabel(label);
    }

    @GetMapping("/getAll")
    public Flux<Label> getAllLabels() {
        return labelService.getAllLabels();
    }

    @GetMapping("/get/{id}")
    public Mono<Label> getLabelById(@PathVariable int id) {
        return labelService.getLabelById(id);
    }

    @DeleteMapping("/delete/{id}")
    public Mono<Void> deleteLabel(@PathVariable int id) {
        return labelService.deleteLabel(id);
    }
}
