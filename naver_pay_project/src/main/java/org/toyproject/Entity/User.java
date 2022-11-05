package org.toyproject.Entity;

import org.toyproject.DTO.UserDTO;

public class User {
    private String uId = "";
    private String uPw = "";
    private String uEmail = "";

    public User(){
    }
    public User(String uId, String uPw) {
        this.uId = uId;
        this.uPw = uPw;
    }

    public User(String uId, String uPw, String uEmail) {
        this.uId = uId;
        this.uPw = uPw;
        this.uEmail = uEmail;
    }

    public UserDTO toDTO() {
        return new UserDTO(uId, uPw, uEmail, false);
    }

    public String getuId() {
        return uId;
    }


    public String getuPw() {
        return uPw;
    }


    public String getuEmail() {
        return uEmail;
    }



}
