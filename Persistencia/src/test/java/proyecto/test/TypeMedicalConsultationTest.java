package proyecto.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import proyecto.entidades.*;
import proyecto.repositorios.*;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TypeMedicalConsultationTest {

    @Autowired
    private TypeMedicalConsultationRepo typeMedicalConsultationRepo;

    @Test
    public void registrarTypeMedicalConsultationTest(){

        TypeMedicalConsultation tyMConsult = new TypeMedicalConsultation();
        tyMConsult.setId(1);
        tyMConsult.setDescription("rutina");

        //Guardamos el registro
        TypeMedicalConsultation guardado = typeMedicalConsultationRepo.save(tyMConsult);

        //Comprobamos que si haya quedado
        Assertions.assertNotNull(guardado);
    }

    @Test
    @Sql("classpath:TypeMedicalConsultations.sql")
    public void eliminarTypeMedicalConsultationTest(){
        TypeMedicalConsultation consult = typeMedicalConsultationRepo.findById(1).orElse(null);

        //Luego lo eliminamos
        typeMedicalConsultationRepo.delete(consult);

        //Por último, verificamos que si haya quedado borrado
        TypeMedicalConsultation buscado = typeMedicalConsultationRepo.findById(1).orElse(null);
        Assertions.assertNull(buscado);
    }

    @Test
    @Sql("classpath:TypeMedicalConsultations.sql")
    public void actualizarTypeMedicalConsultationTest(){
        //recuperamos el registro
        TypeMedicalConsultation guardado = typeMedicalConsultationRepo.findById(1).orElse(null);

        //Modificamos el nombre
        guardado.setDescription("rutina");

        //Con save guardamos el registro modificado
        typeMedicalConsultationRepo.save(guardado);

        //Por último, verificamos que si haya quedado actualizado
        TypeMedicalConsultation buscado = typeMedicalConsultationRepo.findById(1).orElse(null);
        Assertions.assertEquals("rutina", buscado.getDescription());
    }

    @Test
    @Sql("classpath:TypeMedicalConsultations.sql")
    public void listarTypeMedicalConsultationtest(){
        //Obtenemos la lista de todos los usuarios
        List<TypeMedicalConsultation> lista = typeMedicalConsultationRepo.findAll();

        System.out.println(lista);
    }
}