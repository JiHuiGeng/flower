package com.geng.servlet;

import com.geng.pojo.Flower;
import com.geng.service.FlowerService;
import com.geng.service.impl.FlowerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * SelectFlowerServlet 控制层
 */
@WebServlet("/show")
public class SelectFlowerServlet extends HttpServlet {

    private FlowerService flowerService = new FlowerServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //调用业务层查询方法
        List<Flower> list = flowerService.selectAll();
        //将返回值放入作用域
        req.setAttribute("list", list);
        //重定向到index.jsp，并携带参数
        req.getRequestDispatcher("index.jsp").forward(req, res);
    }
}
