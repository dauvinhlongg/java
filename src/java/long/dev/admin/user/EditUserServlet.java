/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package hoangg.dev.admin.user;

import hoangg.dev.admin.BaseAdminServlet;
import hoangg.dev.data.dao.DatabaseDao;
import hoangg.dev.data.dao.UserDao;
import hoangg.dev.data.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author Admin
 */
public class EditUserServlet extends BaseAdminServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        UserDao userDao = DatabaseDao.getInstance().getUserDao();
        User user = userDao.find(userId);
        
        request.setAttribute("user", user);
        request.getRequestDispatcher("admin/user/edit.jsp").include(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        UserDao userDao = DatabaseDao.getInstance().getUserDao();
        User user = userDao.find(userId);
        
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        user.setEmail(email);
        user.setPassword(password);
        
        userDao.update(user);
        response.sendRedirect("IndexUserServlet");
    }
}
