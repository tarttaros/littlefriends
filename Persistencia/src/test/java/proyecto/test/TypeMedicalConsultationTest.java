package proyecto.test;

import org.junit.Assert;
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
class TypeMedicalConsultationTest {

    @Autowired
    private TypeMedicalConsultationRepo typeMedicalConsultationRepo;

    @Test
    void registrarTypeMedicalConsultationTest(){

        TypeMedicalConsultation tyMConsult = new TypeMedicalConsultation();
        tyMConsult.setId(1);
        tyMConsult.setDescription("rutina");

        //Guardamos el registro
        TypeMedicalConsultation guardado = typeMedicalConsultationRepo.save(tyMConsult);

        //Comprobamos que si haya quedado
        Assertions.assertNotNull(guardado);
    }
/*
    @Test
    @Sql("classpath:TypeMedicalConsultations.sql")
    void eliminarTypeMedicalConsultationTest(){
        TypeMedicalConsultation consult = typeMedicalConsultationRepo.findById(1).orElse(null);

        //Luego lo eliminamos
        typeMedicalConsultationRepo.delete(consult);

        //Por último, verificamos que si haya quedado borrado
        TypeMedicalConsultation buscado = typeMedicalConsultationRepo.findById(1).orElse(null);
        Assertions.assertNull(buscado);
    }

    @Test
    @Sql("classpath:TypeMedicalConsultations.sql")
    void actualizarTypeMedicalConsultationTest(){
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
    void listarTypeMedicalConsultationtest(){
        //Obtenemos la lista de todos los usuarios
        List<TypeMedicalConsultation> lista = typeMedicalConsultationRepo.findAll();

        // Verificamos que la lista no esté vacía
        Assert.assertFalse("La lista de tipos de consultas medicas está vacía", lista.isEmpty());

        System.out.println(lista);
    }

 */
}
