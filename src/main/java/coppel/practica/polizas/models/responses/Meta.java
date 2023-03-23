package coppel.practica.polizas.models.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Meta {
    public String Status;

    public Meta(String status) {
        Status = status;
    }
}
