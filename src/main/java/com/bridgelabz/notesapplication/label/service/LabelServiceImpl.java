package com.bridgelabz.notesapplication.label.service;

import com.bridgelabz.notesapplication.label.dto.LabelDTO;
import com.bridgelabz.notesapplication.label.entity.Label;
import com.bridgelabz.notesapplication.label.repository.LabelRepo;
import com.bridgelabz.notesapplication.util.Response;
import com.bridgelabz.notesapplication.util.UserToken;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class LabelServiceImpl implements LabelService {

    @Autowired
    LabelRepo labelRepo;

    public Response addLabel(String token, LabelDTO labelDTO) {
        int userId = UserToken.verifyToken(token);
        ModelMapper modelMapper = new ModelMapper();
        Label label = modelMapper.map(labelDTO, Label.class);
        label.setUserId(userId);
        Mono<Label> lab = labelRepo.save(label);
        return new Response("Label added successfully", lab, 200);
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
