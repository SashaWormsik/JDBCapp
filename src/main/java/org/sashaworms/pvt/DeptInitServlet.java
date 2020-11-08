package org.sashaworms.pvt;

import org.sashaworms.pvt.service.Department;
import org.sashaworms.pvt.service.DepartmentService;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class DeptInitServlet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Department> department = DepartmentService.getDepartmentService().getDepartments();
        req.setAttribute("department", department);
        getServletContext().getRequestDispatcher("/tableDept.jsp").forward(req, resp);
    }
}
