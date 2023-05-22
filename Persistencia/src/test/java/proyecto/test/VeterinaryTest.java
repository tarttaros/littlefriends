package proyecto.test;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import proyecto.entidades.Veterinary;
import proyecto.repositorios.VeterinaryRepo;

import java.time.LocalDateTime;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class VeterinaryTest {

    @Autowired
    private VeterinaryRepo veterinaryRepo;

    @Test
    public void registrarVeterinarioTest(){
        Veterinary u = new Veterinary(
                "josh",
                "3108447302",
                "1095587412",
                "josh@mail.com",
                "aloha",
                1,
                "software34evah",
                LocalDateTime.now(),
                "sftwr3lomejor");

        //Guardamos el registro
        Veterinary guardado = veterinaryRepo.save(u);
        //Comprobamos que si haya quedado
        Assertions.assertNotNull(guardado);
    }

    @Test
    public void eliminarVeterinarioTest(){
        Veterinary u = new Veterinary(
                "josh",
                "3108447302",
                "1095587412",
                "josh@mail.com",
                "aloha",
                1,
                "software34evah",
                LocalDateTime.now(),
                "sftwr3lomejor");

        //Guardamos el registro
        Veterinary guardado = veterinaryRepo.save(u);
        //Luego lo eliminamos
        veterinaryRepo.delete(guardado);
        //Por último, verificamos que si haya quedado borrado
        Veterinary buscado = veterinaryRepo.getByIdentification("1095587412");
        Assertions.assertNull(buscado);
    }

    @Test
    public void actualizarVeterinarioTest(){
        Veterinary u = new Veterinary(
                "josh",
                "3108447302",
                "1095587412",
                "josh@mail.com",
                "aloha",
                1,
                "software34evah",
                LocalDateTime.now(),
                "sftwr3lomejor");

        //Guardamos el registro
        Veterinary guardado = veterinaryRepo.save(u);
        //Modificamos el nombre
        guardado.setName("Juanita Lopez");
        //Con save guardamos el registro modificado
        veterinaryRepo.save(guardado);
        //Por último, verificamos que si haya quedado actualizado
        Veterinary buscado = veterinaryRepo.getByIdentification("1095587412");
        Assertions.assertEquals("Juanita Lopez", buscado.getName());
    }

    @Test
    @Sql("classpath:Veterinaries.sql" )
    public void listarVeterinariosTest(){
        //Obtenemos la lista de todos los usuarios
        List<Veterinary> lista = veterinaryRepo.findAll();
        //Imprimimos la lista
        System.out.println(lista);
    }
}