package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.dtos.ProductDTO;
import co.edu.uniquindio.proyecto.entidades.Category;
import co.edu.uniquindio.proyecto.entidades.Product;
import co.edu.uniquindio.proyecto.entidades.ProductCategory;
import co.edu.uniquindio.proyecto.entidades.ProductImage;
import co.edu.uniquindio.proyecto.repositorios.CategoryRepo;
import co.edu.uniquindio.proyecto.repositorios.ProductCategoryRepo;
import co.edu.uniquindio.proyecto.repositorios.ProductImageRepo;
import co.edu.uniquindio.proyecto.repositorios.ProductRepo;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    private final ProductRepo productRepo;
    private final ProductImageRepo productImageRepo;
    private final CategoryRepo categoryRepo;
    private final ProductCategoryRepo productCategoryRepo;

    public ProductServiceImpl(ProductRepo productRepo, ProductImageRepo productImageRepo, CategoryRepo categoryRepo, ProductCategoryRepo productCategoryRepo) {
        this.productRepo = productRepo;
        this.productImageRepo = productImageRepo;
        this.categoryRepo = categoryRepo;
        this.productCategoryRepo = productCategoryRepo;
    }




    @Override
    public Product createProduct(Product product) {
        Product p = new Product(product.getNameProduct(),product.getDescription(),product.getQuantityProduct(),product.getPrice());
        Product result = productRepo.save(p);

        return result;
    }

    @Override
    public List<Product> findProducts() {

        List<Product> products;
        products = productRepo.findAll();

        return products;
    }

}
