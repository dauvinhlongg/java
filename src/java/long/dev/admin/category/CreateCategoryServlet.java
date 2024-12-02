/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package longg.dev.admin.category;

import hoangg.dev.admin.BaseAdminServlet;
import hoangg.dev.data.dao.CategoryDao;
import hoangg.dev.data.dao.DatabaseDao;
import hoangg.dev.data.model.Category;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

/**
 *
 * @author Admin
 */
public class CreateCategoryServlet extends BaseAdminServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("admin/category/create.jsp").include(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String thumbnail = request.getParameter("thumbnail");
        HttpSession session = request.getSession();
        CategoryDao categoryDao = DatabaseDao.getInstance().getCategoryDao();

        if (name.isEmpty() || thumbnail.isEmpty()) {
            session.setAttribute("error", "Vui long dien day du thong tin");
            request.getRequestDispatcher("admin/category/create.jsp").include(request, response);
        } else {
            Category category = new Category(name, thumbnail);
            categoryDao.insert(category);
            response.sendRedirect("IndexCategoryServlet");
        }
    }
}
