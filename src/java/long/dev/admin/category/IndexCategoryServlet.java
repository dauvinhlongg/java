/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package hoangg.dev.admin.category;

import hoangg.dev.admin.BaseAdminServlet;
import hoangg.dev.data.dao.CategoryDao;
import hoangg.dev.data.dao.DatabaseDao;
import hoangg.dev.data.model.Category;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Admin
 */
public class IndexCategoryServlet extends BaseAdminServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CategoryDao category = DatabaseDao.getInstance().getCategoryDao();
        List<Category> categoryList = category.findAll();

        request.setAttribute("categoryList", categoryList);
        request.getRequestDispatcher("admin/category/index.jsp").include(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
