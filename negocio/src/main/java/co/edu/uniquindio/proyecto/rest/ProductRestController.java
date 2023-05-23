package co.edu.uniquindio.proyecto.rest;

import co.edu.uniquindio.proyecto.dtos.ProductDTO;
import co.edu.uniquindio.proyecto.entidades.Product;
import co.edu.uniquindio.proyecto.servicios.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductRestController {

    @Autowired
    private ProductService productService;

    @PostMapping("/product")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) throws Exception {
        try {
            Product p = productService.createProduct(product);
            return ResponseEntity.ok(p);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping("/product")
    public ResponseEntity<List<Product>> listProduct() throws Exception {
        try {
            List<Product> p = productService.findProducts();
            return ResponseEntity.ok(p);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping("/melo")
    public ResponseEntity<String> melo() throws Exception {
        try {
            return ResponseEntity.ok("melo");
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
}
