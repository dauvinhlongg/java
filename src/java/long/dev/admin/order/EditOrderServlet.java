/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package hoangg.dev.admin.order;

import hoangg.dev.admin.BaseAdminServlet;
import hoangg.dev.data.dao.CategoryDao;
import hoangg.dev.data.dao.DatabaseDao;
import hoangg.dev.data.dao.OrderDao;
import hoangg.dev.data.model.Category;
import hoangg.dev.data.model.Order;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author Admin
 */
public class EditOrderServlet extends BaseAdminServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int orderId = Integer.parseInt(request.getParameter("orderId"));
        OrderDao orderDao = DatabaseDao.getInstance().getOrderDao();
        Order order = orderDao.find(orderId);
        
        request.setAttribute("order", order);
        request.getRequestDispatcher("admin/order/edit.jsp").include(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int orderId = Integer.parseInt(request.getParameter("orderId"));
        OrderDao orderDao = DatabaseDao.getInstance().getOrderDao();
        Order order = orderDao.find(orderId);
        
        String status = request.getParameter("status");
        order.setStatus(status);
        
        orderDao.update(order);
        response.sendRedirect("IndexOrderServlet");
    }
}
