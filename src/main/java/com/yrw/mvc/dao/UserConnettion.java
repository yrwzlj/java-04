package com.yrw.mvc.dao;

import com.yrw.mvc.bean.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

import static com.yrw.mvc.dao.closeResource.closeresource;


public class UserConnettion {

    /**
     * 添加课程
     * @param user 用户
     */
    static public void addUser(User user){
        Connection conn=null;
        PreparedStatement ps=null;
        try {
            String sql = "insert into User(name,password) values(?,?)";
            conn=getconnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2,user.getPassword());

            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeResource.closeresource(conn,ps);
        }
    }

    //更改用户密码
    static  public void updateUser(User user){
        Connection conn=null;
        PreparedStatement ps=null;
        try {
            String sql = "update User set password =? where name=?";
            conn=getconnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getPassword());
            ps.setString(2,user.getUsername());

            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeResource.closeresource(conn,ps);
        }
    }

    //查找用户是否存在
    static public boolean searchUser(User user){
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet resultSet = null;
        boolean rs = false;
        try {
            String sql = "select name,password from user where name = ?";
            conn=getconnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUsername());

           resultSet = ps.executeQuery();

           while (resultSet.next())
           {
               String temppassword=resultSet.getString("password");
               if (Objects.equals(temppassword, user.getPassword()))
               {
                   rs=true;
                   break;
               }
           }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeResource.closeresource(conn,ps);
            return rs;
        }
    }
}
