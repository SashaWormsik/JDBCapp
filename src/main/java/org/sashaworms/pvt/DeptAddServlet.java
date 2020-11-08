package org.sashaworms.pvt;

import org.sashaworms.pvt.service.Department;
import org.sashaworms.pvt.service.DepartmentService;
import org.sashaworms.pvt.service.User;
import org.sashaworms.pvt.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class DeptAddServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            DepartmentService.getDepartmentService().
                    addDepartment(new Department(null, req.getParameter("department")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/JDBCapp/tableDepartment");
    }

}
