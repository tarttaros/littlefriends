package proyecto.test;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import proyecto.entidades.PurchaseDetail;
import proyecto.repositorios.PurchaseDetailRepo;


import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PurchaseDetailTest {

    @Autowired
    private PurchaseDetailRepo purchaseDetailRepo;

    @Test
    public void registrarPurchaseDetailTest(){

        PurchaseDetail pd=new PurchaseDetail();
        pd.setId(1);
        pd.setPrice(25000.0);
        pd.setUnits(25);

        PurchaseDetail pd2 = purchaseDetailRepo.save(pd);
        Assertions.assertNotNull(pd2);
    }

    @Test
    @Sql("classpath:PurchaseDetails.sql")
    public void eliminarPurchaseDetailTest(){

        purchaseDetailRepo.deleteById(1);
        PurchaseDetail pd= purchaseDetailRepo.findById(1).orElse(null);
        Assertions.assertNull(pd);

    }

    @Test
    @Sql("classpath:PurchaseDetails.sql")
    public void actualizarPurchseDetailTestSql(){

        PurchaseDetail pd=purchaseDetailRepo.findById(1).orElse(null);

        //se actualiza el nombre del Usuario
        pd.setUnits(80);
        purchaseDetailRepo.save(pd);

        //Se busca el usuario para confirmar la actualizacion
        PurchaseDetail purchaseDetilBuscado=purchaseDetailRepo.findById(1).orElse(null);
        Assertions.assertEquals(80,purchaseDetilBuscado.getUnits());

    }

    @Test
    @Sql("classpath:PurchaseDetails.sql")
    public void listarPurchaseDetailTestSql(){

        List<PurchaseDetail> listaPurchaseDetails=purchaseDetailRepo.findAll();

        //Imprimimos la lista
        for (PurchaseDetail consult : listaPurchaseDetails)
        {
            System.out.println(
                    consult.getId()+"\n"+
                            consult.getUnits()+"\n"+
                            consult.getPrice());
}
    }
}
