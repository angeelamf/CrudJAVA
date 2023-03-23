package coppel.practica.polizas.models;

public class Credenciales {
    private String user;
    private char[] pass;

    public Credenciales() {
        super();
    }

    public Credenciales(String user, char[] pass) {
        this.user = user;
        this.pass = pass;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public char[] getPass() {
        return pass;
    }

    public void setPass(char[] pass) {
        this.pass = pass;
    }
}
