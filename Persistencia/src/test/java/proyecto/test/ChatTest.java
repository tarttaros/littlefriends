package proyecto.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import proyecto.entidades.Chat;
import proyecto.entidades.User;
import proyecto.entidades.Veterinary;
import proyecto.repositorios.ChatRepo;
import proyecto.repositorios.UserRepo;
import proyecto.repositorios.VeterinaryRepo;

import java.time.LocalDateTime;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ChatTest {

    @Autowired
    private ChatRepo chatRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private VeterinaryRepo veterinaryRepo;

    @Test
    void registrarChatTest(){
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

        //Comprobamos que si haya quedado
        Assertions.assertNotNull(guardado);
    }
/*
    @Test
    @Sql("classpath:Chats.sql")
    void eliminarChatTest(){
        Chat consult = chatRepo.findById(1).orElse(null);

        //Luego lo eliminamos
        chatRepo.delete(consult);

        //Por último, verificamos que si haya quedado borrado
        Chat buscado = chatRepo.findById(1).orElse(null);
        Assertions.assertNull(buscado);
    }

    @Test
    @Sql("classpath:Chats.sql")
    void actualizarChatTest(){
        //recuperamos el registro
        Chat guardado = chatRepo.findById(1).orElse(null);

        User usr = userRepo.getByIdentification("160890980");

        //Modificamos el nombre
        guardado.setUser(usr);

        //Con save guardamos el registro modificado
        chatRepo.save(guardado);

        //Por último, verificamos que si haya quedado actualizado
        Chat buscado = chatRepo.findById(1).orElse(null);
        Assertions.assertEquals("pedro antonio", buscado.getUser().getName());
    }

    @Test
    @Sql("classpath:Chats.sql")
    void listarChatTest() {
        //Obtenemos la lista de todos los usuarios
        List<Chat> lista = chatRepo.findAll();

        //Imprimimos la lista
        for (Chat cht : lista)
        {
            System.out.println(
                    cht.getId()+"\n"+
                    cht.getUser().getName()+"\n"+
                    cht.getVeterinary().getName());
        }
    }

 */
}
