package org.toyproject.DTO;

import org.toyproject.Entity.User;
import org.toyproject.VO.UserVO;

public class UserDTO {

    private String uId = "";
    private Password uPw = null;
    private String uEmail = "";


    public UserDTO() {
    }
    public UserDTO(String uId) {
        this.uId = uId;
    }

    public UserDTO(String uId, String uPw, boolean needEncode) {
        this.uId = uId;
        this.uPw = needEncode ? Password.of(uPw, true) : Password.of(uPw, false);
    }
    public UserDTO(String uId, Password uPw) {
        this.uId = uId;
        this.uPw = uPw;
    }

    public UserDTO(String uId, String uPw, String uEmail, boolean needEncode) {
        this.uId = uId;
        this.uPw = needEncode ? Password.of(uPw, true) : Password.of(uPw, false);
        this.uEmail = uEmail;
    }

    public UserDTO(String uId, Password uPw, String uEmail) {
        this.uId = uId;
        this.uPw = uPw;
        this.uEmail = uEmail;
    }

    public User toEntity() {
        return new User(uId, getuPwStr(), uEmail);
    }



    public UserVO toVO() {
        return new UserVO(uId, uEmail);
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public Password getuPw() {
        return uPw;
    }

    public void setuPw(Password uPw) {
        this.uPw = uPw;
    }
    public String getuPwStr() {
        return uPw.getuPw();
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
                "uId='" + uId + '\'' +
                ", uPw=" + uPw +
                ", uEmail='" + uEmail + '\'' +
                '}';
    }
}
