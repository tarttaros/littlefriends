package proyecto.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import proyecto.entidades.ProductImage;;
import proyecto.repositorios.ProductImageRepo;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ProductImageTest {

    @Autowired
    private ProductImageRepo productImageRepo;

    @Test
    void registrarproductImageTest(){

        ProductImage pi = new ProductImage();
        pi.setId(1);
        pi.setUrl("esto es una imagen");

        ProductImage pi2=productImageRepo.save(pi);
        Assertions.assertNotNull(pi2);
    }
/*
    @Test
    @Sql("classpath:ProductImages.sql")
    void eliminarproductImageTest(){

        productImageRepo.deleteById(1);
        ProductImage pi= productImageRepo.findById(1).orElse(null);
        Assertions.assertNull(pi);
    }

    @Test
    @Sql("classpath:ProductImages.sql")
    void actualizarproductImageTestSql(){

        ProductImage pi= productImageRepo.findById(1).orElse(null);

        //se actualiza el nombre del Usuario
        pi.setUrl("imagen4");
        productImageRepo.save(pi);

        //Se busca el usuario para confirmar la actualizacion
        ProductImage productImageBuscado=productImageRepo.findById(1).orElse(null);
        Assertions.assertEquals("imagen4",productImageBuscado.getUrl());

    }

    @Test
    @Sql("classpath:ProductImages.sql")
    void listarImageTestSql(){

        List<ProductImage> listaimage=productImageRepo.findAll();

        // for se usa para mostrar los datos guardados en la lista
        for(ProductImage milistaimage:listaimage) {
            System.out.println(milistaimage);
        }
    }


 */
}
