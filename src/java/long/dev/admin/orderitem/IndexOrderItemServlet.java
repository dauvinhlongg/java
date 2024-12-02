/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package hoangg.dev.admin.orderitem;

import hoangg.dev.admin.BaseAdminServlet;
import hoangg.dev.data.dao.DatabaseDao;
import hoangg.dev.data.dao.OrderDao;
import hoangg.dev.data.dao.OrderItemDao;
import hoangg.dev.data.model.Order;
import hoangg.dev.data.model.OrderItem;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Admin
 */
public class IndexOrderItemServlet extends BaseAdminServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int orderId = Integer.parseInt(request.getParameter("orderId"));
        OrderDao orderDao = DatabaseDao.getInstance().getOrderDao();
        Order order = orderDao.find(orderId);
        
        OrderItemDao orderItemDao = DatabaseDao.getInstance().getOrderItemDao();
        List<OrderItem> orderItemList = orderItemDao.findByOder(orderId);

        request.setAttribute("order", order);
        request.setAttribute("orderItemList", orderItemList);
        request.getRequestDispatcher("admin/orderitem/index.jsp").include(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
