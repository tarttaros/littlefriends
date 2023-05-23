package proyecto.entidades;

import jakarta.json.bind.annotation.JsonbProperty;

import java.io.Serializable;

public class ResponseMessage implements Serializable {
    @JsonbProperty("mensaje")
    private final String message;

    private ResponseMessage(String message) {
        this.message = message;
    }

    public static ResponseMessage of(String message) {
        return new ResponseMessage(message);
    }
}
