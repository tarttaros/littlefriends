package co.edu.uniquindio.proyecto.rest;

import co.edu.uniquindio.proyecto.dtos.UserDTO;
import co.edu.uniquindio.proyecto.entidades.*;
import co.edu.uniquindio.proyecto.segurity.Hash;
import co.edu.uniquindio.proyecto.servicios.AdminService;
import co.edu.uniquindio.proyecto.servicios.TokenService;
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
    private TokenService tokenService;

    @Autowired
    private UserService userService;

    @Autowired
    private VeterinaryService veterinaryService;

    @Autowired
    private AdminService adminService;


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

    @PostMapping(value = "/login-admin")
    public ResponseEntity<?> createAuthenticationTokenAdmin(@RequestBody Credential authenticationRequest) throws Exception {
        final Admin admin = authenticateAdmin(authenticationRequest);
        Token token = new Token(admin.getEmail());
        if(tokenService.findByPK(authenticationRequest.getEmail()) == null)
        {
            return ResponseEntity.ok(tokenService.inserToken(token));
        }
        else {
            tokenService.setToken(token.getEmail(),token.getExpirationDate(),token.getToken());
            return ResponseEntity.ok(tokenService.findByPK(authenticationRequest.getEmail()));
        }
    }

    @PostMapping(value = "/login-vet")
    public ResponseEntity<?> createAuthenticationTokenVet(@RequestBody Credential authenticationRequest) throws Exception {
        final Veterinary vet = authenticateVet(authenticationRequest);
        Token token = new Token(vet.getEmail());
        if(tokenService.findByPK(authenticationRequest.getEmail()) == null)
        {
            return ResponseEntity.ok(tokenService.inserToken(token));
        }
        else {
            tokenService.setToken(token.getEmail(),token.getExpirationDate(),token.getToken());
            return ResponseEntity.ok(tokenService.findByPK(authenticationRequest.getEmail()));
        }
    }

    private User authenticate(Credential request) throws Exception {
        User user = null;
        try {
            user = userService.getByEmailAndPassword(request.getEmail(), Hash.factory().toSha1(request.getPassword()));
        } catch (Exception e) {
            throw new Exception("USER_NOT_FOUND", e);
        }
        return user;
    }

    private Admin authenticateAdmin(Credential request) throws Exception {
        Admin admin = null;
        try {
            admin = adminService.findByEmailAndPassword(request.getEmail(), Hash.factory().toSha1(request.getPassword()));
        } catch (Exception e) {
            throw new Exception("ADMIN_NOT_FOUND", e);
        }
        return admin;
    }

    private Veterinary authenticateVet(Credential request) throws Exception {
        Veterinary vet = null;
        try {
            vet = veterinaryService.findByEmailAndPassword(request.getEmail(), Hash.factory().toSha1(request.getPassword()));
        } catch (Exception e) {
            throw new Exception("VET_NOT_FOUND", e);
        }
        return vet;
    }



}





