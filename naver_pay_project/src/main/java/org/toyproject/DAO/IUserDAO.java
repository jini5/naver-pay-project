package org.example.overview.members.dao;


import org.toyproject.Entity.User;

import java.util.List;

public interface IUserDAO {

    List<User> search(String q);
    User select(String uer_id);
    List<User> selectAll();
    int insert(User user);
    int insertAll(List<User> users);
    int update(String user_id, String password);
    int delete(String user_id);
    int deleteAll();
}