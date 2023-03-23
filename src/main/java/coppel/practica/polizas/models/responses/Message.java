package coppel.practica.polizas.models.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Message {
    public String Mensaje;

    public Message() {
    }

    public Message(String mensaje) {
        Mensaje = mensaje;
    }
}
