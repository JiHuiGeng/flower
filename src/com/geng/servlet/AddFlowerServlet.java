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

/**
 * AddFlowerServlet 新增花卉信息控制层
 */
@WebServlet("/insert")
public class AddFlowerServlet extends HttpServlet {

    private FlowerService flowerService = new FlowerServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决中文乱码问题
        req.setCharacterEncoding("utf-8");
        String name = req.getParameter("name");
        String price = req.getParameter("price");
        String production = req.getParameter("production");
        //实例化Flower对象
        Flower flower = new Flower();
        //将请求数据中获取的数据，放入Flower对象中
        flower.setName(name);
        flower.setPrice(Double.parseDouble(price));
        flower.setProduction(production);
        //根据数据，执行新增业务
        int index = flowerService.addFlower(flower);
        if (index > 0) {
            //只要返回值大于0，那么就是执行成功，将使用重定向，返回到显示所有花卉信息页面
            //这里使用重定向，是不携带参数的，为的是防止出现表单重复提交
            //在效率上，转发比重定向高，因为，转发是跳转一次，而重定向是跳转两次
            resp.sendRedirect("show");
        } else {
            //否则，返回添加页面或错误页面
            resp.sendRedirect("add.jsp");
        }
    }
}
