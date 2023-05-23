package co.edu.uniquindio.proyecto.rest;

import co.edu.uniquindio.proyecto.dtos.CategoryDTO;
import co.edu.uniquindio.proyecto.entidades.Category;
import co.edu.uniquindio.proyecto.servicios.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryRestController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category")
    public ResponseEntity searchCategories() throws Exception {
        try {
            List<Category> cat = categoryService.findAll();
            return ResponseEntity.ok(cat);
        }catch (Exception e) {
            return new ResponseEntity<String>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PostMapping("/category")
    public ResponseEntity saveCategories(@RequestBody Category cat) throws Exception {
        try {
            cat = categoryService.createCategory(cat);
            return ResponseEntity.ok(cat);
        }catch (Exception e) {
            return new ResponseEntity<String>(HttpStatus.EXPECTATION_FAILED);
        }
    }
}
