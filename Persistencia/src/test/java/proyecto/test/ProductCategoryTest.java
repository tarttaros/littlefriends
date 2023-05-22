package proyecto.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import proyecto.entidades.Category;
import proyecto.entidades.Product;
import proyecto.entidades.ProductCategory;
import proyecto.repositorios.CategoryRepo;
import proyecto.repositorios.ProductCategoryRepo;
import proyecto.repositorios.ProductRepo;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProductCategoryTest {

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private ProductCategoryRepo productCategoryRepo;

    @Test
    public void registrarProductCategoryTest(){

        Category cat = new Category(2,"Antidepresivo");

        Category catg = categoryRepo.save(cat);

        Product prod = new Product(1,"producto para el dolor","ibuprofeno",40,15000.0);

        Product prodct = productRepo.save(prod);

        ProductCategory prdctCtgry = new ProductCategory(1,prodct,catg);

        ProductCategory guardado = productCategoryRepo.save(prdctCtgry);
        Assertions.assertNotNull(guardado);
    }

}
