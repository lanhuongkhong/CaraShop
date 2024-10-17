/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package lan.dev.admin;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import lan.dev.data.dao.Database;
import lan.dev.data.dao.DatabaseDao;

/**
 *
 * @author PC
 */
public class BaseAdminServlet extends HttpServlet {
@Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        DatabaseDao.init(new Database());
    }
}