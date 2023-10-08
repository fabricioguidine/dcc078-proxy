package org.example;
public class Administrador {
    private String login;
    private boolean valido;
    public Administrador(String login, boolean valido) {
        this.login = login;
        this.valido = valido;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public boolean isValido() {
        return valido;
    }
    public void setValido(boolean valido) {
        this.valido = valido;
    }
}