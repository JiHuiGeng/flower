package com.geng.service.impl;

import com.geng.dao.FlowerDao;
import com.geng.dao.impl.FlowerDaoImpl;
import com.geng.pojo.Flower;
import com.geng.service.FlowerService;

import java.util.List;

/**
 * FlowerServiceImpl业务逻辑实现层
 */
public class FlowerServiceImpl implements FlowerService {

    private FlowerDao flowerDao = new FlowerDaoImpl();

    /**
     * 查询全部花卉信息具体业务逻辑实现
     *
     * @return list
     */
    @Override
    public List<Flower> selectAll() {
        return flowerDao.selectAll();
    }

    /**
     * 新增花卉信息
     *
     * @param flower
     * @return int
     */
    @Override
    public int addFlower(Flower flower) {

        return flowerDao.insertFlower(flower);
    }

    @Override
    public int deleteFlowerById(int id) {
        return flowerDao.deleteFlowerById(id);
    }

    @Override
    public int deleteFlowerByProduction(String production) {
        return flowerDao.deleteFlowerByProduction(production);
    }

    @Override
    public int updateFlower(Flower flower) {
        return flowerDao.updateFlower(flower);
    }
}
