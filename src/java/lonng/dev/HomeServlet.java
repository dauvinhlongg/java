/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package lonng.dev;

import hoangg.dev.data.dao.DatabaseDao;
import hoangg.dev.data.dao.ProductDao;
import java.io.IOException;
import hoangg.dev.data.model.Product;
import hoangg.dev.util.Constants;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author Admin
 */
public class HomeServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        super.doGet(request, response);
        ProductDao productDao = DatabaseDao.getInstance().getProductDao();
        List<Product> hotProductList = productDao.hot(Constants.NUMBER_LIMIT);
        List<Product> newsProductList = productDao.news(Constants.NUMBER_LIMIT);
        
        request.setAttribute("hotProductList", hotProductList);
        request.setAttribute("newsProductList", newsProductList);
        
        request.getRequestDispatcher("/home.jsp").include(request, response);
//        List<Product> newssProductList = productDao;
        }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

}
}
