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

    /**
     * 根据id删除花卉信息
     *
     * @param id
     * @return
     */
    int deleteFlowerById(int id);

    /**
     * 根据产地，批量删除花卉信息
     *
     * @param production
     * @return
     */
    int deleteFlowerByProduction(String production);

    /**
     * 更新花卉信息
     *
     * @param flower
     * @return
     */
    int updateFlower(Flower flower);
}
