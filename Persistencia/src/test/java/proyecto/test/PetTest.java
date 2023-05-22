package proyecto.test;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import proyecto.entidades.*;
import proyecto.repositorios.PetRepo;
import proyecto.repositorios.TypePetRepo;
import proyecto.repositorios.UserRepo;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PetTest {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private TypePetRepo typePetRepo;

    @Autowired
    private PetRepo petRepo;

    @Test
    public void registrarPetTest(){

        User user = new User();
                user.setName("Andres carrillo");
                user.setPhoneNumber("3138545796");
                user.setIdentification("1905541001");
                user.setEmail("andres@gmail.com");
                user.setPhotoUrl("imagen1");
                user.setSex(1);
                user.setPassword("147851");
                user.setCreationDate(LocalDateTime.now());
                user.setId_user(1);

        User usr = userRepo.save(user);

        Pet pet = new Pet();
                pet.setId(1);
                pet.setName("pepito");
                pet.setBirthdate(LocalDate.now());
                pet.setStatus(PetStatus.CASA);
                pet.setSex(1);
                pet.setUser(usr);
                pet.setTypePet(TypePet.PERRO);

        //Guardamos el registro
        Pet guardado = petRepo.save(pet);

        //Comprobamos que si haya quedado
        Assertions.assertNotNull(guardado);
    }

    @Test
    @Sql("classpath:Pets.sql")
    public void eliminarPetTest(){
/*
        TypePet tp = new TypePet(1,"perro");

        TypePet typepet = typePetRepo.save(tp);

        User user = new User(
                "Andres carrillo",
                "3138545796",
                "1905541001",
                "andres@gmail.com",
                "imagen1",
                1,
                "147851",
                LocalDateTime.now(),
                1);

        User usr = userRepo.save(user);

        Pet pet = new Pet(
                1,
                "pepito",
                LocalDate.now(),
                1,
                1,
                userRepo.getById(1),
                typePetRepo.getById(1));

        //Guardamos el registro
        Pet guardado = petRepo.save(pet);

        //Luego lo eliminamos
        petRepo.delete(guardado);

        //Luego lo eliminamos
        typePetRepo.delete(typepet);

        //Luego lo eliminamos
        userRepo.delete(usr);
*/

        Pet pet = petRepo.getPetByName("pepito");

        System.out.println(pet.getName());

        //Luego lo eliminamos
        petRepo.delete(pet);

        //Por último, verificamos que si haya quedado borrado
        Pet buscado = petRepo.getPetByName("pepito");
        Assertions.assertNull(buscado);
    }

    @Test
    @Sql("classpath:Pets.sql")
    public void actualizarPetTest(){

        //Guardamos el registro
        Pet guardado = petRepo.getPetByName("luna");

        //Modificamos el nombre
        guardado.setName("sol");

        //Con save guardamos el registro modificado
        petRepo.save(guardado);

        //Por último, verificamos que si haya quedado actualizado
        Pet buscado = petRepo.getPetByName("sol");
        Assertions.assertEquals("sol", buscado.getName());
    }

    @Test
    @Sql("classpath:Pets.sql")
    public void listarPetsTest(){

        //Obtenemos la lista de todos los usuarios
        List<Pet> lista = petRepo.findAll();

        //Imprimimos la lista
        System.out.println(lista);
    }

}