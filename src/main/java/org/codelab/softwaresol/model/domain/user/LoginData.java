package org.codelab.softwaresol.model.domain.user;

public record LoginData(String username, String pass) {

    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return pass;
    }
}
