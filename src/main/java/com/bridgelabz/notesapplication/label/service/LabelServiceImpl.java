package com.bridgelabz.notesapplication.label.service;

import com.bridgelabz.notesapplication.label.entity.Label;
import com.bridgelabz.notesapplication.label.repository.LabelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class LabelServiceImpl implements LabelService {

    @Autowired
    LabelRepo labelRepo;

    public Mono<Label> addLabel(Label label) {
        return labelRepo.save(label);
    }

    public Flux<Label> getAllLabels() {
        return labelRepo.findAll();
    }

    public Mono<Label> getLabelById(int id) {
        return labelRepo.findById(id);
    }

    public Mono<Void> deleteLabel(int id) {
        return labelRepo.deleteById(id);
    }
}
