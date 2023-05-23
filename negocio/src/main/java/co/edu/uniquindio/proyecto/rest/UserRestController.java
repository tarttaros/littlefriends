package co.edu.uniquindio.proyecto.rest;

import co.edu.uniquindio.proyecto.dtos.UserDTO;
import co.edu.uniquindio.proyecto.entidades.Person;
import co.edu.uniquindio.proyecto.entidades.User;
import co.edu.uniquindio.proyecto.segurity.Hash;
import co.edu.uniquindio.proyecto.servicios.UserService;
import co.edu.uniquindio.proyecto.servicios.VeterinaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@RestController
public class UserRestController {

    @Autowired
    private UserService userService;

    @Autowired
    private VeterinaryService veterinaryService;

    @PostMapping("/user")
    public ResponseEntity<User> saveUser(@RequestBody Person user) throws Exception {
        try {
            User u = userService.createUser(new User(user.getName(), user.getPhoneNumber(), user.getIdentification(), user.getEmail(),"",user.getSex(), Hash.factory().toSha1(user.getPassword()), LocalDateTime.now()));
            return ResponseEntity.ok(u);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping("/user")
    public ResponseEntity<List<User>> listUser() throws Exception {
        try {
            List<User> u = userService.listUsers();
            return ResponseEntity.ok(u);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }



}





