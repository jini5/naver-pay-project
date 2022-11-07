package org.toyproject.Service;


import org.toyproject.DTO.Password;
import org.toyproject.DTO.UserDTO;

import java.util.List;

public interface IUserService {

    List<UserDTO> findByUserIdOrEmail(String q);
    
    boolean autoLogin(String autoLogin, String cookieId);

    UserDTO login(String uId);
    UserDTO login(String uId, String uPw);

    boolean signup(String uId, String uPw, String uEmail);

    UserDTO getByUserId(String uId);

    List<UserDTO> getAllUsers();

    boolean updateUserPassword(String userID, Password password, Password uNewPw);

    boolean checkPassword(String userID, Password password);

    boolean checkNewPassword(String userID, Password uNewPw);

    boolean removeByUserId(String userID, Password uPw);

    boolean removeUsers();

}
