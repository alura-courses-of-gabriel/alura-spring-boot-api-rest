package com.example.aluraspringbootapirest.controller;

import com.example.aluraspringbootapirest.services.topico.delete.Delete;
import com.example.aluraspringbootapirest.services.topico.find.FindOne;
import com.example.aluraspringbootapirest.services.topico.find.FindOneOutput;
import com.example.aluraspringbootapirest.services.topico.findall.FindAll;
import com.example.aluraspringbootapirest.services.topico.findall.FindAllOutput;
import com.example.aluraspringbootapirest.services.topico.insert.Insert;
import com.example.aluraspringbootapirest.services.topico.insert.InsertInput;
import com.example.aluraspringbootapirest.services.topico.insert.InsertOutput;
import com.example.aluraspringbootapirest.services.topico.update.Update;
import com.example.aluraspringbootapirest.services.topico.update.UpdateInput;
import com.example.aluraspringbootapirest.services.topico.update.UpdateOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicosController {

    @Autowired
    private FindAll findAll;

    @Autowired
    private Insert insert;

    @Autowired
    private FindOne findOne;

    @Autowired
    private Update update;

    @Autowired
    private Delete delete;

    @GetMapping
    public ResponseEntity<List<FindAllOutput>> findAll(String nome) {
        return ResponseEntity.ok(this.findAll.execute(nome));
    }

    @PostMapping
    public ResponseEntity<InsertOutput> insert(@RequestBody @Valid InsertInput insertInput, UriComponentsBuilder uriComponentsBuilder) {
        InsertOutput output = this.insert.execute(insertInput);
        return ResponseEntity.created(uriComponentsBuilder.path("/topicos/{topico.id}").buildAndExpand(output.id()).toUri()).body(output);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FindOneOutput> getTopico(@PathVariable Long id) {
        return ResponseEntity.ok(this.findOne.execute(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateOutput> update(@PathVariable Long id, @RequestBody UpdateInput input) {
        input.id(id);
        UpdateOutput output = this.update.execute(input);
        return ResponseEntity.ok(output);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        this.delete.execute(id);
        return ResponseEntity.ok().build();
    }
}
