package co.edu.uniquindio.proyecto.dtos;

import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@ToString
public class ReportProductDTO implements Serializable {

    public ReportProductDTO(String productName, Integer cantSell, double totalPrice, Integer cantAvailable) {
        this.productName = productName;
        this.cantSell = cantSell;
        this.totalPrice = totalPrice;
        this.cantAvailable = cantAvailable;
    }

    private String productName;

    private Integer cantSell;

    private double totalPrice;

    private Integer cantAvailable;

}