package com.study.springboothyejin.web.controller;

import com.study.springboothyejin.service.OptionService;
import com.study.springboothyejin.web.dto.CategoryDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/option")
public class OptionController {

    private OptionService optionService;

    @PostMapping("/category")
    public ResponseEntity<?> addCategory(@RequestBody CategoryDto categoryDto){

        int categoryId = optionService.addCategory(categoryDto);
        return ResponseEntity
                .created(URI.create("/api/option/category" +
                        optionService.addCategory(categoryDto)))
                .body(categoryId);
    }

    @GetMapping("/categories")
    public ResponseEntity<?> getCategories(){

        return ResponseEntity.ok(optionService.getCategories());
    }

    @PutMapping("/category/{categoryId}")
    public ResponseEntity<?> modifyCategory(@PathVariable int categoryId,
                                            @RequestBody CategoryDto categoryDto){
        optionService.modifyCategory(categoryId, categoryDto);
        return ResponseEntity.ok(true);
    }
}
