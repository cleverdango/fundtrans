package com.mybank.fundtrans.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.omg.CORBA.PRIVATE_MEMBER;

import java.sql.PreparedStatement;

import com.mybank.fundtrans.domain.Fund;
import com.mybank.fundtrans.util.JDBCUtil;

public class FundDaoJDBCImpl implements FundDao {
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    @Override
    public List findAll() {
        conn = JDBCUtil.getConnection();
        String sql = "select * from fund";
        List<Fund> funds = new ArrayList<>();
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Integer id = rs.getInt("id");
                String name = rs.getString("name");
                String des = rs.getString("description");
                Double price = rs.getDouble("price");
                String status = rs.getString("status");
                Date createTime = rs.getDate("createTime");
                Fund fund = new Fund(id, name, des, price, status, createTime);
                funds.add(fund);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, pstmt, conn);
        }
        return funds;
    }

    @Override
    public void insert(Fund fund) {
        //1.获取链接
        conn = JDBCUtil.getConnection();
        //2.写sql语句
        String sql = "insert into fund(name,description,price,status,createTime) value(?,?,?,?,?)";
        try {
            //3.创建PreparedStatement
            //4.给sql变量赋值
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, fund.getName());
            pstmt.setString(2, fund.getDescription());
            pstmt.setDouble(3, fund.getPrice());
            pstmt.setString(4, fund.getStatus());
            java.sql.Date date = new java.sql.Date(fund.getCreateTime().getDate());
            pstmt.setDate(5, date);
            //5.发送更新sql语句
            int rus = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //7.关闭链接对象等
            JDBCUtil.close(rs, pstmt, conn);
        }
    }

    @Override
    public void delete(int fundNo) {
        conn = JDBCUtil.getConnection();
        String sql = "delete from fund where id=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, fundNo);
            int rus = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, pstmt, conn);
        }
    }

    @Override
    public void update(Fund fund) {
        conn = JDBCUtil.getConnection();
        String sql = "UPDATE fund SET name = ?,description= ? ,price= ? ,status= ?  WHERE id = ?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, fund.getName());
            pstmt.setString(2, fund.getDescription());
            pstmt.setDouble(3, fund.getPrice());
            pstmt.setString(4, fund.getStatus());
            //java.sql.Date date = new java.sql.Date(fund.getCreateTime().getDate());
            //pstmt.setDate(5, date);
            pstmt.setInt(5, fund.getId());
            int rus = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, pstmt, conn);
        }
    }

    @Override
    public Fund findById(int fundNo) {
        Fund fund = null;
        //1.获取链接
        conn = JDBCUtil.getConnection();
        //2.写sql语句
        String sql = "select * from fund where id=?";
        //3.创建PreparedStatement
        try {
            pstmt = conn.prepareStatement(sql);
            //4.给sql变量赋值
            pstmt.setInt(1, fundNo);
            //5.发送执行sql语句，得到结果集
            rs = pstmt.executeQuery();
            //6.对结果集进行遍历
            while (rs.next()) {
                Integer id = rs.getInt("id");
                String name = rs.getString("name");
                String des = rs.getString("description");
                Double price = rs.getDouble("price");
                String status = rs.getString("status");
                Date createTime = rs.getDate("createTime");
                fund = new Fund(id, name, des, price, status, createTime);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //7.关闭链接对象
            JDBCUtil.close(rs, pstmt, conn);
        }
        return fund;
    }
    public List findByPage(int pageNo, int pageSize) {
        // TODO Auto-generated method stub
        List funds = new ArrayList<Fund>();
        try {
            conn = JDBCUtil.getConnection();
            String sql = "select * from fund limit ?, ?"; //limit
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, (pageNo-1)*pageSize);
            pstmt.setInt(2, pageSize);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Fund fund = new Fund();
                fund.setId(rs.getInt("id"));
                fund.setName(rs.getString("name"));
                fund.setPrice(rs.getDouble("price"));
                fund.setDescription(rs.getString("description"));
                fund.setStatus(rs.getString("status"));
                fund.setCreateTime(rs.getDate("createtime"));
                funds.add(fund);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            //throw new DAOException(e.getMessage(), e);
        } finally {
            JDBCUtil.close(null, pstmt, conn);
        }
        return funds;
    }

    @Override
    public int findRowCount() {
        int count=0;
        // TODO Auto-generated method stub
        try {
            conn = JDBCUtil.getConnection();
            String sql = "select count(*) from fund";
            pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                count=rs.getInt(1);

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            //throw new DAOException(e.getMessage(), e);
        } finally {
            JDBCUtil.close(null, pstmt, conn);
        }
        return count;
    }

}
