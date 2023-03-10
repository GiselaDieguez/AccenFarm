package com.acc.accenfarm.controller;

import com.acc.accenfarm.model.Chicken;
import com.acc.accenfarm.service.ChickenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/chicken")
public class ChickenController {

    @Autowired
    private ChickenService chickenService;

    @PostMapping(value = "/newchicken")
    public ResponseEntity<Chicken> saveChicken (@Validated @RequestBody Chicken chicken){
        return ResponseEntity.status(HttpStatus.CREATED).body(chickenService.saveChicken(chicken));
    }

    @GetMapping(value = "/allchicken")
    public ResponseEntity<Page<Chicken>> getAllChicken(
            @RequestParam(required = false, defaultValue = "0")Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer size,
            @RequestParam(required = false, defaultValue = "false") Boolean enablePagination
    ){
        return ResponseEntity.ok(chickenService.getAllChicken(page, size, enablePagination));
    }

    @DeleteMapping(value = "/{Id}")
    public void deleteChicken(@PathVariable("Id") Integer Id) {
        chickenService.deleteChicken(Id);
        ResponseEntity.ok(!chickenService.existById(Id));
    }

    @GetMapping(value = "/{Id}")
    public ResponseEntity<Optional<Chicken>> findChickenById(@PathVariable("Id") Integer Id) {
        return ResponseEntity.status(HttpStatus.OK).body(chickenService.findById(Id));
    }

    @PutMapping
    public  ResponseEntity<Chicken> editChicken(@Validated @RequestBody Chicken chicken) {
        return ResponseEntity.status(HttpStatus.CREATED).body(chickenService.editChicken(chicken));
    }


}
