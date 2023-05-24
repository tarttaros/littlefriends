package co.edu.uniquindio.proyecto.rest;


import co.edu.uniquindio.proyecto.dtos.VeterinaryDTO;
import co.edu.uniquindio.proyecto.entidades.Credential;
import co.edu.uniquindio.proyecto.entidades.Token;
import co.edu.uniquindio.proyecto.entidades.Veterinary;
import co.edu.uniquindio.proyecto.segurity.Hash;
import co.edu.uniquindio.proyecto.servicios.TokenService;
import co.edu.uniquindio.proyecto.servicios.VeterinaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class VeterinaryRestController {

    @Autowired
    private VeterinaryService veterinaryService;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/vet")
    public ResponseEntity saveVeterinary(@RequestBody Veterinary veterinary) throws  Exception{
        try {
            Veterinary v = veterinaryService.createVeterinary(new Veterinary(veterinary.getName(),veterinary.getPhoneNumber(),veterinary.getIdentification(),veterinary.getEmail(),"",veterinary.getSex(), Hash.factory().toSha1(veterinary.getPassword()), LocalDateTime.now(),veterinary.getNum_license()));
            return ResponseEntity.ok(v);
        }catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<String>(HttpStatus.EXPECTATION_FAILED);
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
