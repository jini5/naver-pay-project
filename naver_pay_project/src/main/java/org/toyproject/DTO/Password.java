package org.toyproject.DTO;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

public class Password {
    private String password = "";

    private Password() {}

    private Password(String password) {
        password = sha256(password);
    }


    public static Password of(String uPw) {
        Password password = new Password();
        password.setPassword(password.sha256(uPw));

        return password;
    }

    public static Password of(String uPw, boolean needEncode) {
        Password password = new Password();

        if (needEncode) {
            password.setPassword(password.sha256(uPw));
        } else {
            password.setPassword(uPw);
        }
        return password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * SHA-256으로 해싱하는 메소드
     * */
    private String sha256(String password) {
        if (password == null || password.equals("")) return null;

        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        // 바이트를 16진수로 변환
        messageDigest.update(password.getBytes());
        return String.format("%064x", new BigInteger(1, messageDigest.digest()));

    }

    /**
     * SHA-512으로 해싱하는 메소드
     * */
    private String sha512(String password) {
        if (password == null || password.equals("")) return null;

        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("SHA-512");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        // 바이트를 16진수로 변환
        messageDigest.update(password.getBytes());
        return String.format("%0128x", new BigInteger(1, messageDigest.digest()));

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Password password = (Password) o;
        return this.password.equals(password.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(password);
    }

    @Override
    public String toString() {
        return "Password{" +
                "uPw='" + password + '\'' +
                '}';
    }
}
