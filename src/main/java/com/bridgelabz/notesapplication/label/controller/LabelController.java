package com.bridgelabz.notesapplication.label.controller;

import com.bridgelabz.notesapplication.label.dto.LabelDTO;
import com.bridgelabz.notesapplication.label.entity.Label;
import com.bridgelabz.notesapplication.label.service.LabelServiceImpl;
import com.bridgelabz.notesapplication.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/label")
public class LabelController {

    @Autowired
    LabelServiceImpl labelService;

    @PostMapping("/add")
    public ResponseEntity<Response> addLabel(@RequestParam String token, @RequestBody LabelDTO labelDTO) {
        Response res = labelService.addLabel(token, labelDTO);
        return ResponseEntity.ok(res);
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
