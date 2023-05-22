package proyecto.test;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import proyecto.entidades.Examination;
import proyecto.repositorios.ExaminationRepo;

import java.util.List;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ExaminationTest {
    @Autowired
    private ExaminationRepo examinationRepo;

    @Test
    public void registrarPurchaseDetailTest(){

        Examination e = new Examination();
        e.setId_examination(1);
        e.setDescriptionexamination("esto es algo");
        e.setResults("otra cosa");
        e.setSpecialization("trdrdr");

        Examination e2=examinationRepo.save(e);
        Assertions.assertNotNull(e2);
    }
    @Test
    @Sql("classpath:Examinations.sql")
    public void eliminarExaminationTest(){

        examinationRepo.deleteById(1);
        Examination ex= examinationRepo.findById(1).orElse(null);
        Assertions.assertNull(ex);
    }

    @Test
    @Sql("classpath:Examinations.sql")
    public void actualizarPurchseDetailTestSql(){

        Examination ex=examinationRepo.findById(1).orElse(null);

        //se actualiza el nombre del Usuario
        ex.setResults("holi");
        examinationRepo.save(ex);

        //Se busca el usuario para confirmar la actualizacion
        Examination examinationBuscado=examinationRepo.findById(1).orElse(null);
        Assertions.assertEquals("holi",examinationBuscado.getResults());

    }

    @Test
    @Sql("classpath:Examinations.sql")
    public void listarPurchaseTestSql(){

        List<Examination> listaExamination=examinationRepo.findAll();


        //Imprimimos la lista
        for (Examination consult : listaExamination)
        {
            System.out.println(
                    consult.getId_examination()+"\n"+
                            consult.getResults()+"\n"+
                            consult.getDescriptionexamination());
        }
    }
}
