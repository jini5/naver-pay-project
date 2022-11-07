package org.toyproject.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.toyproject.DAO.UserDAO;
import org.toyproject.DTO.Password;
import org.toyproject.DTO.UserDTO;
import org.toyproject.Entity.UserEntity;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

    private UserDAO userDAO;

    @Autowired
    public UserService(UserDAO uerDAO) {
        this.userDAO = userDAO;
    }




    @Override
    public boolean autoLogin(String autoLogin, String cookieId) {
        if (autoLogin == null || cookieId == null) return false;

        if (autoLogin.equals("true")) {
            if (getByUserId(cookieId) != null) {
                UserDTO userDTO = login(cookieId);
                return userDTO != null;
            }
        }
        return false;
    }

    @Override
    public UserDTO login(String userId) {
        UserDTO userDTO = new UserDTO(userId);
        if (userDTO == null) return null;

        UserEntity user = userDAO.select(userDTO.getUserId());
        return user.toUserDTO();
    }

    @Override
    public UserDTO login(String userId, String uPw) {
        UserDTO userDTO = new UserDTO(userId, uPw, true);
        if (userDTO == null || userDTO.getuPwStr() == null) return null;

        UserEntity user = userDAO.select(userDTO.getUserId());
        if (user == null || user.getUserPassword() == null) return null;
        if (user.getUserPassword().equals(userDTO.getuPwStr())) {
            return userDTO;
        }
        return null;
    }

    @Override
    public boolean signup(String uId, String uPw, String uEmail) {
        UserDTO userDTO = new UserDTO(uId, uPw, uEmail, false);
        if (userDTO == null || userDTO.getuPwStr() == null) return false;

        int res = userDAO.insert(userDTO.toEntity());
        return res > 0;
    }

    @Override
    public UserDTO getByUserId(String uId) {
        if (uId == null) return null;

        UserEntity user = userDAO.select(uId);
        if (user == null) return null;

        return user.toDTO();
    }

    @Override
    public List<UserDTO> findByUserIdOrEmail(String q) {
        if (q == null) return null;

        List<Uesr> userList = userDAO.search(q);
        return userList.stream().map(m -> m.toDTO()).collect(Collectors.toList());
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> userList = userDAO.selectAll();
        return userList.stream().map(m -> m.toDTO()).collect(Collectors.toList());
    }

    @Override
    public boolean updateUserPassword(String uId, Password uPw, Password uNewPw) {
        if (uId == null || uPw == null || uNewPw == null) return false;

        UserEntity user = userDAO.select(uId);
        if (user == null || user.getuPw() == null) return false;
        if (!user.getUserPassword().equals(uPw.getuPw())) return false;
        if (user.getuPw().equals(uNewPw.getuPw())) return false; // DB PWD == New PWD

        int res = userDAO.update(uId, uNewPw.getuPw());
        return res > 0;
    }

    @Override
    public boolean checkPassword(String uId, Password uPw) {
        if (uId == null || uPw == null) return false;

        UserEntity user = userDAO.select(uId);
        if (user == null) return false;
        if (!user.getuPw().equals(uPw.getuPw())) return false;

        return true;
    }

    @Override
    public boolean checkNewPassword(String uId, Password uNewPw) {
        if (uId == null || uNewPw == null) return false;

        UserEntity user = userDAO.select(uId);
        if (user == null) return false;

        System.out.println(user.getuPw());
        System.out.println(uNewPw.getuPw());
        if (user.getuPw().equals(uNewPw.getuPw())) return false;

        return true;
    }



    @Override
    public boolean removeByUserId(String uId, Password uPw) {
        if (uId == null || uPw == null) return false;

        UserEntity user = userDAO.select(uId);
        if (user == null || user.getuPw() == null) return false;
        if (!user.getuPw().equals(uPw.getuPw())) return false;

        int res = userDAO.delete(uId);
        return res > 0;
    }

    @Override
    public boolean removeUsers() {
        int res = userDAO.deleteAll();
        return res > 0;
    }

}