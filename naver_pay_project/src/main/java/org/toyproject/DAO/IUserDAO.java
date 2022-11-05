package org.example.overview.members.dao;


import org.toyproject.Entity.User;

import java.util.List;

public interface IUserDAO {

    List<User> search(String q);
    User select(String uId);
    List<User> selectAll();
    int insert(User user);
    int insertAll(List<User> users);
    int update(String uId, String uPw);
    int delete(String uId);
    int deleteAll();
}