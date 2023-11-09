package org.codelab.softwaresol.model.entities.user;

public record LoginData(String username, String pass, String rol) {

    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return pass;
    }

    public String getRol(){
        return rol;
    }
}
