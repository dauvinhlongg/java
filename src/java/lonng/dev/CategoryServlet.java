/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package lonng.dev;

import hoangg.dev.data.dao.CategoryDao;
import hoangg.dev.data.dao.DatabaseDao;
import hoangg.dev.data.dao.ProductDao;
import hoangg.dev.data.model.Category;
import hoangg.dev.data.model.Product;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class CategoryServlet extends BaseServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        super.doGet(request, response);
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        ProductDao productDao = DatabaseDao.getInstance().getProductDao();
        List<Product> ProductList = new ArrayList<>();
        if (request.getParameter("property") != null && request.getParameter("order") != null) {
            String property = request.getParameter("property"); 
            String order = request.getParameter("order");
            ProductList = productDao.filter(categoryId, property, order);
        } else {
            ProductList = productDao.findByCategory(categoryId);
        }

        CategoryDao categoryDao = DatabaseDao.getInstance().getCategoryDao();
        Category category = categoryDao.find(categoryId);

        request.setAttribute("productList", ProductList);
        request.setAttribute("category", category);
        request.getRequestDispatcher("category.jsp").include(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
