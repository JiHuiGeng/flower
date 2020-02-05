package com.geng.dao;

import com.geng.pojo.Flower;

import java.util.List;

/**
 * @Auth Gary
 */
public interface FlowerDao {

    /**
     * 查询全部花卉信息
     *
     * @return list
     */
    List<Flower> selectAll();

    /**
     * 新增花卉信息
     *
     * @param flower
     * @return int
     */
    int insertFlower(Flower flower);
}
