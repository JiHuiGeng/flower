package com.geng.dao.impl;

import com.geng.dao.FlowerDao;
import com.geng.pojo.Flower;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * flower数据访问层具体实现
 */
public class FlowerDaoImpl implements FlowerDao {
    private static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/ssm";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456";
    Connection connection = null;
    PreparedStatement statement = null;

    /**
     * 查询全部花卉信息具体实现
     *
     * @return list
     */
    @Override
    public List<Flower> selectAll() {
        String sql = "SELECT * FROM flower";
        List<Flower> list = new ArrayList<>();
        ResultSet rs = null;
        try {
            Class.forName(DRIVER_CLASS);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {
                list.add(new Flower(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getString(4)));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        return list;
    }

    /**
     * 新增花卉信息--数据访问层具体实现
     *
     * @param flower
     * @return int index
     */
    @Override
    public int insertFlower(Flower flower) {
        int index = 0;
        //占位符?，防止sql注入
        String sql = "INSERT INTO flower VALUES (DEFAULT,?,?,?)";
        try {
            Class.forName(DRIVER_CLASS);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            statement = connection.prepareStatement(sql);
            //分别获取name,price,production,id是默认自增
            statement.setObject(1, flower.getName());
            statement.setObject(2, flower.getPrice());
            statement.setObject(3, flower.getProduction());
            index = statement.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return index;
    }

    /**
     * 根据id删除花卉信息--数据访问层具体实现
     *
     * @param id
     * @return int index
     */
    @Override
    public int deleteFlowerById(int id) {
        int index = 0;
        try {
            String sql = "DELETE FROM flower WHERE id=?";
            Class.forName(DRIVER_CLASS);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            statement = connection.prepareStatement(sql);
            //分别获取name,price,production,id是默认自增
            statement.setObject(1, id);
            index = statement.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return index;
    }

    /**
     * 根据产地批量删除花卉信息--数据访问层具体实现
     *
     * @param production
     * @return int index
     */
    @Override
    public int deleteFlowerByProduction(String production) {
        int index = 0;
        try {
            String sql = "UPDATE FROM flower WHERE production=?";
            Class.forName(DRIVER_CLASS);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            statement = connection.prepareStatement(sql);
            //分别获取name,price,production,id是默认自增
            statement.setObject(1, production);
            index = statement.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return index;
    }

    /**
     * 更新花卉信息--数据访问层具体实现
     *
     * @param flower
     * @return int index
     */
    @Override
    public int updateFlower(Flower flower) {
        int index = 0;
        try {
            String sql = "DELETE  flower SET name =?,price=?,production=? where id=?";
            Class.forName(DRIVER_CLASS);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            statement = connection.prepareStatement(sql);
            //分别获取name,price,production,id是默认自增
            statement.setObject(1, flower.getName());
            statement.setObject(2, flower.getPrice());
            statement.setObject(3, flower.getProduction());
            statement.setObject(4, flower.getId());
            index = statement.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return index;
    }
}
