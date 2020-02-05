package com.geng.service;

import com.geng.pojo.Flower;

import java.util.List;

/**
 * flowerService
 */
public interface FlowerService {
    /**
     * 查询所有花卉信息
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
    int addFlower(Flower flower);
}
