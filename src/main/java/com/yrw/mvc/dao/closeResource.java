package com.yrw.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class closeResource {

    static public void closeresource(Connection conn, PreparedStatement ps){
        try {
            conn.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
