package proyecto.test;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import proyecto.entidades.Category;
import proyecto.repositorios.CategoryRepo;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CategoryTest {

    @Autowired
    private CategoryRepo categoryRepo;

    @Test
    void registrarCategoryTest(){

        Category cat = new Category(1,"Antialergico");

        //Guardamos el registro
        Category guardado = categoryRepo.save(cat);

        //Comprobamos que si haya quedado
        Assertions.assertNotNull(guardado);
    }

    @Test
    @Sql("classpath:Categories.sql")
    void eliminarCategoryTest(){

        Category guardado = categoryRepo.findByName("Antialergico");

        //Luego lo eliminamos
        categoryRepo.delete(guardado);

        //Por último, verificamos que si haya quedado borrado
        Category buscado = categoryRepo.findByName("Antialergico");
        Assertions.assertNull(buscado);
    }

    @Test
    @Sql("classpath:Categories.sql")
    void actualizarCategoryTest() {

        Category guardado = categoryRepo.findByName("Antialergico");

        //Modificamos el nombre
        guardado.setDescription("Antialergico Melo");

        //Con save guardamos el registro modificado
        categoryRepo.save(guardado);

        //Por último, verificamos que si haya quedado actualizado
        Category buscado = categoryRepo.findByName("Antialergico Melo");
        Assertions.assertEquals("Antialergico Melo", buscado.getDescription());
    }

    @Test
    @Sql("classpath:Categories.sql")
    void listarCategoryTest(){

        //Obtenemos la lista de todos los usuarios
        List<Category> lista = categoryRepo.findAll();

        // Verificamos que la lista no esté vacía
        Assert.assertFalse("La lista de categorias está vacía", lista.isEmpty());

        //Imprimimos la lista
        System.out.println(lista);
    }

}
