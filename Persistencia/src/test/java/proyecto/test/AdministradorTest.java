package proyecto.test;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import proyecto.entidades.Admin;
import proyecto.repositorios.AdminRepo;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AdministradorTest {
@Autowired
private AdminRepo adminRepo;

    @Test
    public void registrarAdminTest(){

        Admin a = new Admin();
        a.setId(1);
        a.setEmail("pedro@gmail.com");
        a.setPassword("contrasenia");

        Admin a2=adminRepo.save(a);
        Assertions.assertNotNull(a2);
    }

    @Test
    @Sql("classpath:Administrador.sql")
    public void eliminarAdminTest(){

        adminRepo.deleteById(1);
        Admin a = adminRepo.findById(1).orElse(null);
        Assertions.assertNull(a);
    }


    @Test
    @Sql("classpath:Administrador.sql")
    public void actualizarAdminTest(){

        Admin a = adminRepo.findById(1).orElse(null);

        //se actualiza el nombre del Usuario
        a.setEmail("maria@gmail.com");
        adminRepo.save(a);

        //Se busca el usuario para confirmar la actualizacion
        Admin adminBuscado=adminRepo.findById(1).orElse(null);
        Assertions.assertEquals("maria@gmail.com",adminBuscado.getEmail());

    }

    @Test
    @Sql("classpath:Administrador.sql")
    public void listarAdminTest(){

        //Obtenemos la lista de todos los usuarios
        List<Admin> lista = adminRepo.findAll();

        //Imprimimos la lista
        System.out.println(lista);
    }
}
