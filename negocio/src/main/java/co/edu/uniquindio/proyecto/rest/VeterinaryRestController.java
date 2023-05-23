package co.edu.uniquindio.proyecto.rest;


import co.edu.uniquindio.proyecto.dtos.VeterinaryDTO;
import co.edu.uniquindio.proyecto.entidades.Veterinary;
import co.edu.uniquindio.proyecto.segurity.Hash;
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


    @PostMapping("/vet")
    public ResponseEntity<Veterinary> saveVeterinary(@RequestBody VeterinaryDTO veterinary) throws  Exception{
        try {
            Veterinary v = veterinaryService.createVeterinary(new Veterinary(veterinary.getName(),veterinary.getPhoneNumber(),veterinary.getIdentification(),veterinary.getEmail(),"",veterinary.getSex(), Hash.factory().toSha1(veterinary.getPassword()), LocalDateTime.now(),veterinary.getNumLicense()));
            return ResponseEntity.ok(v);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
}
