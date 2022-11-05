package org.toyproject.VO;

import java.util.Objects;

public class UserVO {
    private String user_id = "";
    private String uEmail = "";

    public UserVO() {
    }

    public UserVO(String user_id, String uEmail) {
        this.user_id = user_id;
        this.uEmail = uEmail;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getuEmail() {
        return uEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserVO userVO = (UserVO) o;
        return Objects.equals(user_id, userVO.user_id) && Objects.equals(uEmail, userVO.uEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_id, uEmail);
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "uId='" + user_id + '\'' +
                ", uEmail='" + uEmail + '\'' +
                '}';
    }
}
