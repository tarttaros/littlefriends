package proyecto.test;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import proyecto.entidades.Product;
import proyecto.entidades.Purchase;
import proyecto.entidades.PurchaseDetail;
import proyecto.entidades.User;
import proyecto.repositorios.PurchaseRepo;
import proyecto.repositorios.UserRepo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class PurchaseTest {

    @Autowired
    private PurchaseRepo purchaseRepo;

    @Test
    void registrarPurchaseTest(){

        Purchase p =new Purchase();
        p.setBuyDate(LocalDateTime.now());
        p.setPaymentMethod("credito");
        Purchase p2=purchaseRepo.save(p);
        Assertions.assertNotNull(p2);
    }
    /*
    @Test
    @Sql("classpath:Purchases.sql")
    void eliminarPurchaseTest(){

        purchaseRepo.deleteById(1);
        Purchase p= purchaseRepo.findById(1).orElse(null);
        Assertions.assertNull(p);

    }

    @Test
    @Sql("classpath:Purchases.sql")
    void actualizarPurchaseTestSql(){

        Purchase p=purchaseRepo.findById(1).orElse(null);

        //se actualiza el nombre del Usuario
        p.setPaymentMethod("credito");
        purchaseRepo.save(p);

        //Se busca el usuario para confirmar la actualizacion
        Purchase purchaseBuscado=purchaseRepo.findById(1).orElse(null);
        Assertions.assertEquals("credito",purchaseBuscado.getPaymentMethod());

    }

    @Test
    @Sql("classpath:Purchases.sql")
    void listarPurchaseTestSql(){

        List<Purchase>listaPurchase=purchaseRepo.findAll();

        // Verificamos que la lista no esté vacía
        Assert.assertFalse("La lista de compras está vacía", listaPurchase.isEmpty());

        // for se usa para mostrar los datos guardados en la lista
        for(Purchase milistaPurchase:listaPurchase) {
            System.out.println(milistaPurchase);
        }
    }



     */
}
