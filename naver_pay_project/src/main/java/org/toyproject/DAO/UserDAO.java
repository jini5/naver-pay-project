package org.toyproject.DAO;

import org.example.overview.members.dao.IUserDAO;
import org.springframework.stereotype.Repository;
import org.toyproject.DB.JDBCUsersMgr;
import org.toyproject.Entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
@Repository
public class UserDAO implements IUserDAO{

    private static UserDAO userDAO = null;

    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    private static final String USER_SEARCH = "select * from member where uId like ? or uEmail like ?";

    private static final String USER_SELECT_ALL = "select * from member";
    private static final String USER_SELECT = "select * from member where uId = ?";
    private static final String USER_INSERT = "insert into member values(?, ?, ?)";
    private static final String USER_PASSWORD_UPDATE = "update member set uPw = ? where uId = ?";
    private static final String USER_DELETE = "delete member where uId = ?";
    private static final String USER_DELETE_ALL = "delete member";

    // 싱글톤 패턴
    private UserDAO(){}
    public static UserDAO getInstance(){
        if(userDAO==null)
            userDAO=new UserDAO();
        return userDAO;
    }

    @Override
    public List<User> search(String q){
        List<User> userList = new LinkedList<>();

        try{
            conn = JDBCUsersMgr.getConnection();
            stmt = conn.prepareStatement(USER_SEARCH);
            stmt.setString(1, "%" + q + "%");
            stmt.setString(2, "%" + q + "%");

            rs = stmt.executeQuery();
            while (rs.next()) {
                String mId = rs.getString("uId");
                String uPw = rs.getString("uPw");
                String uEmail = rs.getString("uEmail");
                userList.add(new User(mId, uPw, uEmail));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUsersMgr.close(rs, stmt, conn);
        }
        return userList;
    }


    public User select(String uId) {
        User user = null;
        try {
            conn = JDBCUsersMgr.getConnection();
            stmt = conn.prepareStatement(USER_SELECT);
            stmt.setString(1, uId);

            rs = stmt.executeQuery();

            if (rs.next()) {
                String mId = rs.getString("uId");
                String mPw = rs.getString("uPw");
                String mEmail = rs.getString("uEmail");
                user = new User(mId, mPw, mEmail);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUsersMgr.close(rs, stmt, conn);
        }
        return user;
    }

    @Override
    public List<User> selectAll() {
        List<User> memberList = new LinkedList<>();
        try {
            conn = JDBCUsersMgr.getConnection();
            stmt = conn.prepareStatement(USER_SELECT_ALL);

            rs = stmt.executeQuery();
            while (rs.next()) {
                String uId = rs.getString("uId");
                String uPw = rs.getString("uPw");
                String uEmail = rs.getString("uEmail");

                memberList.add(new User(uId, uPw, uEmail));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUsersMgr.close(rs, stmt, conn);
        }
        return memberList;
    }

    @Override
    public int insert(User member) {
        int res = 0;
        try {
            conn = JDBCUsersMgr.getConnection();
            stmt = conn.prepareStatement(USER_INSERT);
            stmt.setString(1, member.getUser_id());
            stmt.setString(2, member.getPassword());
            stmt.setString(3, member.getuEmail());
            res = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUsersMgr.close(stmt, conn);
        }
        return res;
    }

    @Override
    public int insertAll(List<User> members) {
        return members.stream().map(m -> userDAO.insert(m)).collect(Collectors.toList()).stream().reduce((x, y) -> x + y).orElse(0);
    }

    @Override
    public int update(String uId, String uPw) {
        int res = 0;
        try {
            conn = JDBCUsersMgr.getConnection();
            stmt = conn.prepareStatement(USER_PASSWORD_UPDATE);
            stmt.setString(1, uPw);
            stmt.setString(2, uId);
            res = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUsersMgr.close(stmt, conn);
        }
        return res;
    }

    @Override
    public int delete(String uId) {
        int res = 0;
        try {
            conn = JDBCUsersMgr.getConnection();
            stmt = conn.prepareStatement(USER_DELETE);
            stmt.setString(1, uId);
            res = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUsersMgr.close(stmt, conn);
        }
        return res;
    }

    @Override
    public int deleteAll() {
        int res = 0;
        try {
            conn = JDBCUsersMgr.getConnection();
            stmt = conn.prepareStatement(USER_DELETE_ALL);
            res = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUsersMgr.close(stmt, conn);
        }
        return res;
    }

}
