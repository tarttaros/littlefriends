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
class ProductCategoryTest {

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private ProductCategoryRepo productCategoryRepo;

    @Test
    void registrarProductCategoryTest(){

        Category cat = new Category(2,"Antidepresivo");

        Category catg = categoryRepo.save(cat);

        Product prod = new Product(1,"producto para el dolor","ibuprofeno",40,15000.0);

        Product prodct = productRepo.save(prod);

        ProductCategory prdctCtgry = new ProductCategory(1,prodct,catg);

        ProductCategory guardado = productCategoryRepo.save(prdctCtgry);
        Assertions.assertNotNull(guardado);
    }
/*
    @Test
    @Sql("classpath:ProductCategories.sql")
    void eliminarProductCategoryTest(){
        ProductCategory consult = productCategoryRepo.findById(1).orElse(null);

        //Luego lo eliminamos
        productCategoryRepo.delete(consult);

        //Por último, verificamos que si haya quedado borrado
        ProductCategory buscado = productCategoryRepo.findById(1).orElse(null);
        Assertions.assertNull(buscado);
    }

    @Test
    @Sql("classpath:ProductCategories.sql")
    void actualizarProductCategoryTest(){
        //recuperamos el registro
        ProductCategory guardado = productCategoryRepo.findById(1).orElse(null);

        Category cat = categoryRepo.findByName("Antidepresivo");

        //Modificamos el nombre
        guardado.setCategory(cat);

        //Con save guardamos el registro modificado
        productCategoryRepo.save(guardado);

        //Por último, verificamos que si haya quedado actualizado
        ProductCategory buscado = productCategoryRepo.findById(1).orElse(null);
        Assertions.assertEquals("Antidepresivo", buscado.getCategory().getDescription());
    }

    @Test
    @Sql("classpath:ProductCategories.sql")
    void listarProductCategoryTest() {
        //Obtenemos la lista de todos los usuarios
        List<ProductCategory> lista = productCategoryRepo.findAll();

        //Imprimimos la lista
        for (ProductCategory prodctCat : lista)
        {
            System.out.println(
                    prodctCat.getId()+"\n"+
                    prodctCat.getCategory().getDescription()+"\n"+
                    prodctCat.getProduct().getNameProduct());
        }
    }

 */
}
