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
import java.time.LocalTime;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ConsultationTest {

    @Autowired
    private VeterinaryRepo veterinaryRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PetRepo petRepo;

    @Autowired
    private VeterinaryCareRepo veterinaryCareRepo;

    @Autowired
    private TypeMedicalConsultationRepo typeMedicalConsultationRepo;

    @Autowired
    private ConsultationRepo consultationRepo;

    @Test
    public void registrarConsultationTest(){

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

        VeterinaryCare vetC = veterinaryCareRepo.save(vetCare);

        TypeMedicalConsultation tyMConsult = new TypeMedicalConsultation();
        tyMConsult.setId(1);
        tyMConsult.setDescription("rutina");

        TypeMedicalConsultation tyMedCons = typeMedicalConsultationRepo.save(tyMConsult);

        Consultation consult = new Consultation();
        consult.setId_consultation(1);
        consult.setDateConsultation(LocalDate.now());
        consult.setEndConsultation(LocalTime.parse("13:40:15"));
        consult.setStartConsultation(LocalTime.parse("10:40:15"));
        consult.setStatus(1);
        consult.setPet(pt);
        consult.setTypeMedicalConsultation(tyMedCons);
        consult.setVeterinary(vet);
        consult.setVeterinaryCare(vetC);

        //Guardamos el registro
        Consultation guardado = consultationRepo.save(consult);

        //Comprobamos que si haya quedado
        Assertions.assertNotNull(guardado);
    }

    @Test
    @Sql("classpath:Consultations.sql")
    public void eliminarConsultationTest(){
        Consultation consult = consultationRepo.findById(1).orElse(null);

        //Luego lo eliminamos
        consultationRepo.delete(consult);

        //Por último, verificamos que si haya quedado borrado
        Consultation buscado = consultationRepo.findById(1).orElse(null);
        Assertions.assertNull(buscado);
    }

    @Test
    @Sql("classpath:Consultations.sql")
    public void actualizarConsultationTest(){

        //recuperamos el registro
        Consultation guardado = consultationRepo.findById(1).orElse(null);

        //Modificamos el nombre
        guardado.setStatus(2);

        //Con save guardamos el registro modificado
        consultationRepo.save(guardado);

        //Por último, verificamos que si haya quedado actualizado
        Consultation buscado = consultationRepo.findById(1).orElse(null);
        Assertions.assertEquals(2, buscado.getStatus());
    }

    @Test
    @Sql("classpath:Consultations.sql")
    public void listarConsultationTest() {
        //Obtenemos la lista de todos los usuarios
        List<Consultation> lista = consultationRepo.findAll();

        //Imprimimos la lista
        for (Consultation consult : lista)
        {
            System.out.println(
                    consult.getId_consultation()+"\n"+
                    consult.getStatus()+"\n"+
                    consult.getDateConsultation()+"\n"+
                    consult.getStartConsultation()+"\n"+
                    consult.getEndConsultation()+"\n"+
                    consult.getTypeMedicalConsultation().getDescription()+"\n"+
                    consult.getVeterinary().getName()+"\n"+
                    consult.getVeterinaryCare().getId_veterinary_care()+"\n"+
                    consult.getPet().getName());
        }
    }
}
