package com.mybank.fundtrans.dao;

import com.mybank.fundtrans.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by yazawanico on 2017/3/20.
 */
public class UserDaoJDBCImpl implements UserDao {
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    @Override
    public boolean validate(String userName, String password) {
        boolean flag = false;
        //1.获取链接
        conn = JDBCUtil.getConnection();
        //2.写sql语句
        String sql = "select * from user where name = ? and password = ?";
        //3创建preparedStatement对象
        try {
            PreparedStatement preparedStatement = pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userName);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();
            if (rs.next()){
                flag=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(rs,pstmt,conn);
        }


        return flag;
    }
}
