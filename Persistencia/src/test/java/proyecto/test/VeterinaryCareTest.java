package proyecto.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import proyecto.entidades.*;
import proyecto.repositorios.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class VeterinaryCareTest {

    @Autowired
    private VeterinaryRepo veterinaryRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private VeterinaryCareRepo veterinaryCareRepo;

    @Autowired
    private PetRepo petRepo;

    @Test
    void registrarVeterinaryCareTest(){

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

        Veterinary v = new Veterinary(
                "josh",
                "3108447302",
                "1095587412",
                "josh@mail.com",
                "aloha",
                1,
                "software34evah",
                LocalDateTime.now(),
                "sftwr3lomejor");

        Veterinary vet = veterinaryRepo.save(v);

        Pet pet = new Pet();
        pet.setId(1);
        pet.setName("pepito");
        pet.setBirthdate(LocalDate.now());
        pet.setStatus(PetStatus.CASA);
        pet.setSex(1);
        pet.setUser(usr);
        pet.setTypePet(TypePet.PERRO);

        Pet pt = petRepo.save(pet);

        VeterinaryCare vetCare = new VeterinaryCare();
        vetCare.setId_veterinary_care(1);
        vetCare.setMessage("se le realizo una radiografia");
        vetCare.setPet(pt);
        vetCare.setVeterinary(vet);

        //Guardamos el registro
        VeterinaryCare guardado = veterinaryCareRepo.save(vetCare);

        //Comprobamos que si haya quedado
        Assertions.assertNotNull(guardado);
    }
/*
    @Test
    @Sql("classpath:VeterinaryCares.sql")
    void eliminarVeterinaryCareTest(){
        VeterinaryCare consult = veterinaryCareRepo.findById(1).orElse(null);

        //Luego lo eliminamos
        veterinaryCareRepo.delete(consult);

        //Por último, verificamos que si haya quedado borrado
        VeterinaryCare buscado = veterinaryCareRepo.findById(1).orElse(null);
        Assertions.assertNull(buscado);
    }

    @Test
    @Sql("classpath:VeterinaryCares.sql")
    void actualizarVeterinaryCareTest(){

        //recuperamos el registro
        VeterinaryCare guardado = veterinaryCareRepo.findById(1).orElse(null);

        //Modificamos el nombre
        guardado.setMessage("se le hizo cosquillas");

        //Con save guardamos el registro modificado
        veterinaryCareRepo.save(guardado);

        //Por último, verificamos que si haya quedado actualizado
        VeterinaryCare buscado = veterinaryCareRepo.findById(1).orElse(null);
        Assertions.assertEquals("se le hizo cosquillas", buscado.getMessage());
    }

    @Test
    @Sql("classpath:VeterinaryCares.sql")
    void listarVeterinaryCaretest() {
        //Obtenemos la lista de todos los usuarios
        List<VeterinaryCare> lista = veterinaryCareRepo.findAll();

        //Imprimimos la lista
        for (VeterinaryCare vetC : lista)
        {
            System.out.println(
                    vetC.getId_veterinary_care()+"\n"+
                    vetC.getMessage()+"\n"+
                    vetC.getVeterinary().getName()+"\n"+
                    vetC.getPet().getName());
        }
    }

 */
}
