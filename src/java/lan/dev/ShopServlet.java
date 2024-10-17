/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package lan.dev;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import lan.dev.data.dao.DatabaseDao;
import lan.dev.data.dao.ProductDao;
import lan.dev.data.model.Product;
import lan.dev.util.Constants;

/**
 *
 * @author Admin
 */
public class ShopServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        super.doGet(request, response);
        ProductDao productDao = DatabaseDao.getInstance().getProductDao();
        List<Product> productList = productDao.findAll();

        if (request.getParameter("page") != null) {
            int page = Integer.parseInt(request.getParameter("page"));
            int total = productList.size();
            int numberPage = (int) Math.ceil((double) total / Constants.PER_PAGE);

            productList = productDao.getProducts((page - 1) * Constants.PER_PAGE, Constants.PER_PAGE);

            request.setAttribute("total", total);
            request.setAttribute("page", page);
            request.setAttribute("numberPage", numberPage);
            
        }

        request.setAttribute("productList", productList);
        request.getRequestDispatcher("shop.jsp").include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}