package proyecto.test;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import proyecto.entidades.*;
import proyecto.repositorios.ChatRepo;
import proyecto.repositorios.MessageRepo;
import proyecto.repositorios.UserRepo;
import proyecto.repositorios.VeterinaryRepo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MessageTest {

@Autowired
private MessageRepo messageRepo;
    @Autowired
    private ChatRepo chatRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private VeterinaryRepo veterinaryRepo;


    @Test
    void registrarMessageTest(){

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

        Chat cht = new Chat();
        cht.setId(1);
        cht.setUser(usr);
        cht.setVeterinary(v);

        //Guardamos el registro
        Chat guardado = chatRepo.save(cht);

        Message m = new Message();
        m.setId(1);
        m.setDate(LocalDate.now());
        m.setContent("esto es un mensaje");
        m.setChat(guardado);
        Message m2=messageRepo.save(m);
        Assertions.assertNotNull(m2);
    }

    @Test
    @Sql("classpath:Message.sql")
    void eliminarMessageTest(){

        messageRepo.deleteById(1);
        Message m = messageRepo.findById(1).orElse(null);
        Assertions.assertNull(m);
    }

    @Test
    @Sql("classpath:Message.sql")
    void actualizarMessageTest() {

        Message m = messageRepo.findById(1).orElse(null);

        //Modificamos el nombre
        m.setContent("otro mensaje");

        //Con save guardamos el registro modificado
        messageRepo.save(m);

        //Por último, verificamos que si haya quedado actualizado
        Message m2 = messageRepo.findById(1).orElse(null);
        Assertions.assertEquals("otro mensaje", m2.getContent());
    }

    @Test
    @Sql("classpath:Message.sql")
    void listarMessageTestSql(){

        List<Message> listaMessage=messageRepo.findAll();

        //Imprimimos la lista
        for (Message consult : listaMessage)
        {
            System.out.println(
                    consult.getId()+"\n"+
                            consult.getContent()+"\n"+
                            consult.getDate());
        }
    }

}
