package proyecto.test;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import proyecto.entidades.Product;
import proyecto.repositorios.ProductRepo;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ProductTest {

    @Autowired
    private ProductRepo productRepo;
/*
    @Test
    void registrarProductTest(){

        Product product = new Product(
                1,
                "ibuprofeno",
                "producto para el dolor",
                40,
                15000.0);

        //Guardamos el registro
        Product guardado = productRepo.save(product);

        //Comprobamos que si haya quedado
        Assertions.assertNotNull(guardado);
    }

    @Test
    void eliminarProductTest(){
        Product product = new Product(
                1,
                "ibuprofeno",
                "producto para el dolor",
                40,
                15000.0);

        //Guardamos el registro
        Product guardado = productRepo.save(product);

        //Luego lo eliminamos
        productRepo.delete(guardado);

        //Por último, verificamos que si haya quedado borrado
        Product buscado = productRepo.findById(1).orElse(null);
        Assertions.assertNull(buscado);
    }

    @Test
    void actualizarProductTest() {
        Product product = new Product(
                1,
                "ibuprofeno",
                "producto para el dolor",
                40,
                15000.0);

        //Guardamos el registro
        Product guardado = productRepo.save(product);

        //Modificamos el nombre
        guardado.setNameProduct("ibuprofeno sisa");

        //Con save guardamos el registro modificado
        productRepo.save(guardado);

        //Por último, verificamos que si haya quedado actualizado
        Product buscado = productRepo.getProductByDescription("producto para el dolor");
        Assertions.assertEquals("ibuprofeno sisa", buscado.getNameProduct());
    }

    @Test
    void listarProductsTest(){

        Product product = new Product(
                1,
                "ibuprofeno",
                "producto para el dolor",
                40,
                15000.0);

        //Guardamos el registro
        Product guardado = productRepo.save(product);

        //Obtenemos la lista de todos los usuarios
        List<Product> lista = productRepo.findAll();

        // Verificamos que la lista no esté vacía
        Assert.assertFalse("La lista de productos está vacía", lista.isEmpty());

        //Imprimimos la lista
        System.out.println(lista);
    }

 */
}
