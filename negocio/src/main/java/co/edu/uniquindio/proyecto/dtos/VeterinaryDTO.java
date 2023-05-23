package co.edu.uniquindio.proyecto.dtos;


import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class VeterinaryDTO implements Serializable {

    private String name;
    private String phoneNumber;
    private String identification;
    private String email;
    private Integer sex;
    private String password;
    private String numLicense;

}
