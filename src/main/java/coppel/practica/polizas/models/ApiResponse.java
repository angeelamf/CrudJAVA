package coppel.practica.polizas.models;

import coppel.practica.polizas.models.responses.Meta;

public class ApiResponse<T> {
    public coppel.practica.polizas.models.responses.Meta Meta;
    public T Data;

    public ApiResponse() {
    }
    public ApiResponse(coppel.practica.polizas.models.responses.Meta meta, T data) {
        this.Meta = meta;
        this.Data = data;
    }
}
