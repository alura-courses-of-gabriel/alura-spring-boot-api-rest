package com.example.aluraspringbootapirest.controller;

import com.example.aluraspringbootapirest.services.topico.delete.Delete;
import com.example.aluraspringbootapirest.services.topico.find.FindOne;
import com.example.aluraspringbootapirest.services.topico.find.FindOneOutput;
import com.example.aluraspringbootapirest.services.topico.findall.FindAll;
import com.example.aluraspringbootapirest.services.topico.findall.FindAllInput;
import com.example.aluraspringbootapirest.services.topico.findall.FindAllOutput;
import com.example.aluraspringbootapirest.services.topico.insert.Insert;
import com.example.aluraspringbootapirest.services.topico.insert.InsertInput;
import com.example.aluraspringbootapirest.services.topico.insert.InsertOutput;
import com.example.aluraspringbootapirest.services.topico.update.Update;
import com.example.aluraspringbootapirest.services.topico.update.UpdateInput;
import com.example.aluraspringbootapirest.services.topico.update.UpdateOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

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
    @Cacheable(value = "findAllTopicos")
    public ResponseEntity<Page<FindAllOutput>> findAll(
            @RequestParam(required = false) String nomeDoCurso,
            @PageableDefault(sort = "id", page = 0, size = 30, direction = Sort.Direction.ASC) Pageable pageable
    ) {

        FindAllInput input = new FindAllInput(nomeDoCurso, pageable);

        return ResponseEntity.ok(this.findAll.execute(input));
    }

    @PostMapping
    @CacheEvict(value = "findAllTopicos", allEntries = true)
    public ResponseEntity<InsertOutput> insert(@RequestBody @Valid InsertInput insertInput, UriComponentsBuilder uriComponentsBuilder) {
        InsertOutput output = this.insert.execute(insertInput);
        return ResponseEntity.created(uriComponentsBuilder.path("/topicos/{topico.id}").buildAndExpand(output.id()).toUri()).body(output);
    }

    @GetMapping("/{id}")
    @Cacheable(value = "findOneTopico")
    public ResponseEntity<FindOneOutput> findOne(@PathVariable Long id) {
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
