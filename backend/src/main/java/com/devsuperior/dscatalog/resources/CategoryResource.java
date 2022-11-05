package com.devsuperior.dscatalog.resources;

import com.devsuperior.dscatalog.entities.Category;
import com.devsuperior.dscatalog.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController // Annotation do spring
@RequestMapping(value = "/categories") // definindo rota para o recurso
public class CategoryResource {
    // criando primeiro endpoint

    @Autowired
    private CategoryService service;
    @GetMapping // o getmapping configura que o ResponseEntity é um end point (web service)
    public ResponseEntity<List<Category>> findAll() {
        List<Category> list = service.findAll();
        return ResponseEntity.ok().body(list); //
    }
}
