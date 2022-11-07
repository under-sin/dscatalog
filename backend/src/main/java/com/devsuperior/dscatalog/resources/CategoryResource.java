package com.devsuperior.dscatalog.resources;

import com.devsuperior.dscatalog.dto.CategoryDTO;
import com.devsuperior.dscatalog.entities.Category;
import com.devsuperior.dscatalog.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController // Annotation do spring
@RequestMapping(value = "/categories") // definindo rota para o recurso
public class CategoryResource {
    // criando primeiro endpoint

    @Autowired
    private CategoryService service;

    @GetMapping // o getmapping configura que o ResponseEntity é um end point (web service)
    public ResponseEntity<List<CategoryDTO>> findAll() {
        List<CategoryDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}") // rota para buscar a category pelo id
    public ResponseEntity<CategoryDTO> findById(@PathVariable Long id) {
        CategoryDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping // inserindo uma nova categoria
    public ResponseEntity<CategoryDTO> insert(@RequestBody CategoryDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri(); // location header
        return ResponseEntity.created(uri).body(dto); // .created(uri) retorna http 201 que é o método para criação
    }

    @PutMapping(value = "/{id}") // atualizando a categoria
    public ResponseEntity<CategoryDTO> update(@PathVariable Long id, @RequestBody CategoryDTO dto) {
        dto = service.update(id, dto);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping(value = "/{id}") // deleta uma categoria
    public ResponseEntity<Void> delete(@PathVariable Long id) { // obs Void
        service.delete(id);
        return ResponseEntity.noContent().build(); // como não vai ter corpo, podemos retornar o noContet 204
    }
}
