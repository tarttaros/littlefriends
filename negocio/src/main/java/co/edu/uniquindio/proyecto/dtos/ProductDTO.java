package co.edu.uniquindio.proyecto.dtos;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@ToString
public class ProductDTO implements Serializable {

    private String nameProduct;
    private String description;
    private Integer quantityProduct;
    private double price;

}
