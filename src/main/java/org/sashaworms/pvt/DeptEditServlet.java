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
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DeptEditServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String parameter = req.getParameter("deptName");
        Department dept = DepartmentService.getDepartmentService().getDepartment(parameter);
        req.setAttribute("dept", dept);
        getServletContext().getRequestDispatcher("/formDept.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            DepartmentService.getDepartmentService().editDepartment(Integer.parseInt(req.getParameter("number")),
                    req.getParameter("department"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/JDBCapp/tableDepartment");
    }
}

