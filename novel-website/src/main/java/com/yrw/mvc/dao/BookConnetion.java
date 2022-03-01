package com.yrw.mvc.dao;

import com.yrw.mvc.bean.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BookConnetion {

    static public void addBook(Book book){
        String sql = "insert into book(name,author,category,profile) values(?,?,?,?)";
        //该语句为每个 IN 参数保留一个问号（“？”）作为占位符
        Connection conn = null;				//和数据库取得连接
        PreparedStatement pstmt = null;		//创建statement
        try{
            conn = getconnection.getConnection();
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, book.getName()); //给占位符赋值
            pstmt.setString(2, book.getAuthor()); //给占位符赋值
            pstmt.setString(3, book.getCategory()); //给占位符赋值
            pstmt.setString(4, book.getProfile()); //给占位符赋值
            pstmt.executeUpdate();			//执行
        }catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            closeResource.closeresource(conn,pstmt);
        }
    }

    //根据书名查找书籍
    static public List<Book> searchBookByAuthor(String author){
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet resultSet = null;
        List<Book> list = new ArrayList<>();
        try {
            String sql = "select name,category,profile from book where author = ?";
            conn=getconnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, author);

            resultSet = ps.executeQuery();

            while (resultSet.next())
            {
                String name=resultSet.getString("name");
                String category=resultSet.getString("category");
                String profile=resultSet.getString("profile");
                Book book = new Book(name,author,category,profile);
                list.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeResource.closeresource(conn,ps);
            return list;
        }
    }


    //根据书名查找书籍
    static public Book searchBookByName(String name){
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet resultSet = null;
        Book book = new Book();
        try {
            String sql = "select author,category,profile from book where name = ?";
            conn=getconnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);

            resultSet = ps.executeQuery();
            System.out.println(name);

            while (resultSet.next())
            {
                String author=resultSet.getString("author");
                String category=resultSet.getString("category");
                String profile=resultSet.getString("profile");
                book = new Book(name,author,category,profile);
                System.out.println(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeResource.closeresource(conn,ps);
            return book;
        }
    }
}
