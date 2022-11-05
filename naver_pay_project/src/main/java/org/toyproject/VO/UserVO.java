package org.toyproject.VO;

import java.util.Objects;

public class UserVO {
    private String uId = "";
    private String uEmail = "";

    public UserVO() {
    }

    public UserVO(String uId, String uEmail) {
        this.uId = uId;
        this.uEmail = uEmail;
    }

    public String getuId() {
        return uId;
    }

    public String getuEmail() {
        return uEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserVO userVO = (UserVO) o;
        return Objects.equals(uId, userVO.uId) && Objects.equals(uEmail, userVO.uEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uId, uEmail);
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "uId='" + uId + '\'' +
                ", uEmail='" + uEmail + '\'' +
                '}';
    }
}
