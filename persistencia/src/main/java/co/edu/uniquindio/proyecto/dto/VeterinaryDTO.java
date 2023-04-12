package co.edu.uniquindio.proyecto.dto;


import lombok.*;

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
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
    private String num_license;

}
