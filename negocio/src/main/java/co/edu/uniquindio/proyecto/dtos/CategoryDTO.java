package co.edu.uniquindio.proyecto.dtos;

import lombok.*;
import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO implements Serializable {

    private Integer id;
    private String description;
}