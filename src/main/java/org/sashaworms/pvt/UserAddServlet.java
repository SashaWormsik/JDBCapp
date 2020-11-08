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
import java.util.List;

public class UserAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("department", DepartmentService.getDepartmentService().getDepartments());
        getServletContext().getRequestDispatcher("/formUser.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Department dept = DepartmentService.getDepartmentService().
                    getDepartment(req.getParameter("department"));
            if (dept.getDepId() == null) {
                getServletContext().getRequestDispatcher("/deptAdd").include(req, resp);
                dept = DepartmentService.getDepartmentService().
                        getDepartment(req.getParameter("department"));
            }
            User user = new User(null,
                    req.getParameter("firstName"),
                    req.getParameter("lastName"),
                    new SimpleDateFormat("yyy-MM-dd")
                            .parse(req.getParameter("birthdate")),
                    Boolean.parseBoolean(req.getParameter("male")),
                    dept,
                    Integer.parseInt(req.getParameter("salary")));
            UserService.getUserService().addUser(user);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/JDBCapp/tableUser");
    }
}

