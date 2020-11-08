package org.sashaworms.pvt;

import org.sashaworms.pvt.service.DepartmentService;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeptDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String parameter = req.getParameter("number");
        DepartmentService.getDepartmentService().deleteDepartment(Integer.valueOf(parameter));
        resp.sendRedirect("/JDBCapp/tableDepartment");
    }

}
