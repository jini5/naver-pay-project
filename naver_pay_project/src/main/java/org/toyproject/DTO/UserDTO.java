package org.toyproject.DTO;

import org.toyproject.Entity.User;
import org.toyproject.VO.UserVO;

public class UserDTO {

    private String user_id = "";
    private Password password = null;
    private String uEmail = "";


    public UserDTO() {
    }
    public UserDTO(String user_id) {
        this.user_id = user_id;
    }

    public UserDTO(String user_id, String password, boolean needEncode) {
        this.user_id = user_id;
        this.password = needEncode ? Password.of(password, true) : Password.of(password, false);
    }
    public UserDTO(String user_id, Password password) {
        this.user_id = user_id;
        this.password = password;
    }

    public UserDTO(String user_id, String password, String uEmail, boolean needEncode) {
        this.user_id = user_id;
        this.password = needEncode ? Password.of(password, true) : Password.of(password, false);
        this.uEmail = uEmail;
    }

    public UserDTO(String user_id, Password password, String uEmail) {
        this.user_id = user_id;
        this.password = password;
        this.uEmail = uEmail;
    }

    public User toEntity() {
        return new User(user_id, getuPwStr(), uEmail);
    }



    public UserVO toVO() {
        return new UserVO(user_id, uEmail);
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public Password getPassword() {
        return password;
    }

    public void setPassword(Password password) {
        this.password = password;
    }
    public String getuPwStr() {
        return password.getPassword();
    }

    public String getuEmail() {
        return uEmail;
    }

    public void setuEmail(String uEmail) {
        this.uEmail = uEmail;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "uId='" + user_id + '\'' +
                ", uPw=" + password +
                ", uEmail='" + uEmail + '\'' +
                '}';
    }
}
