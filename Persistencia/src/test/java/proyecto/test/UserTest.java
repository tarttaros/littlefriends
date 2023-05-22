package proyecto.test;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import proyecto.entidades.User;
import proyecto.repositorios.UserRepo;

import java.time.LocalDateTime;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserTest {

    @Autowired
    private UserRepo userRepo;

    @Test
    public void registrarUsuarioTest(){
        User u = new User(
        "josh",
        "3108447302",
        "1095587412",
        "josh@mail.com",
        "aloha",
        1,
        "software34evah",
        LocalDateTime.now());

        //Guardamos el registro
        User guardado = userRepo.save(u);

        //Comprobamos que si haya quedado
        Assertions.assertNotNull(guardado);
    }

    @Test
    public void eliminarUsuarioTest(){
        User u = new User(
                "josh",
                "3108447302",
                "1095587412",
                "josh@mail.com",
                "aloha",
                1,
                "software34evah",
                LocalDateTime.now());

        //Guardamos el registro
        User guardado = userRepo.save(u);

        //Luego lo eliminamos
        userRepo.delete(guardado);

        //Por último, verificamos que si haya quedado borrado
        User buscado = userRepo.getByIdentification("1095587412");
        Assertions.assertNull(buscado);
    }

    @Test
    public void actualizarUsuarioTest(){
        User u = new User(
                "josh",
                "3108447302",
                "1095587412",
                "josh@mail.com",
                "aloha",
                1,
                "software34evah",
                LocalDateTime.now());

        //Guardamos el registro
        User guardado = userRepo.save(u);

        //Modificamos el nombre
        guardado.setName("Juanita Lopez");

        //Con save guardamos el registro modificado
        userRepo.save(guardado);

        //Por último, verificamos que si haya quedado actualizado
        User buscado = userRepo.getByIdentification("1095587412");
        Assertions.assertEquals("Juanita Lopez", buscado.getName());
    }

    @Test
    @Sql("classpath:Users.sql" )
    public void listarUsuariosTest(){

        //Obtenemos la lista de todos los usuarios
        List<User> lista = userRepo.findAll();

        //Imprimimos la lista
        System.out.println(lista);
    }
}