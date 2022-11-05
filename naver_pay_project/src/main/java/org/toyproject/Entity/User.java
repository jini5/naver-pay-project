package org.toyproject.Entity;

import org.toyproject.DTO.UserDTO;

public class User {
    private String user_id = "";
    private String password = "";
    private String uEmail = "";



    public User(){
    }
    public User(String user_id, String password) {
        this.user_id = user_id;
        this.password = password;
    }

    public User(String user_id, String password, String uEmail) {
        this.user_id = user_id;
        this.password = password;
        this.uEmail = uEmail;
    }

    public UserDTO toDTO() {
        return new UserDTO(user_id, password, uEmail, false);
    }

    public String getUser_id() {
        return user_id;
    }


    public String getPassword() {
        return password;
    }


    public String getuEmail() {
        return uEmail;
    }



}
