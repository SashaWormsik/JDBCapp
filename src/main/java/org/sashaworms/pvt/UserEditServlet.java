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

public class UserEditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String parameter = req.getParameter("number");
        User user = UserService.getUserService().getUser(Integer.parseInt(parameter));
        req.setAttribute("department", DepartmentService.getDepartmentService().getDepartments());
        req.setAttribute("user", user);
        getServletContext().getRequestDispatcher("/formEditUser.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            Department dept = DepartmentService.getDepartmentService().
                    getDepartment(req.getParameter("department"));
            if (dept.getDepId() == null) {
                getServletContext().getRequestDispatcher("/deptAdd").include(req, resp);
                dept = DepartmentService.getDepartmentService().
                        getDepartment(req.getParameter("department"));
            }
            UserService.getUserService().editUser(Integer.parseInt(req.getParameter("number")),
                    req.getParameter("firstName"),
                    req.getParameter("lastName"),
                    new SimpleDateFormat("yyy-MM-dd")
                            .parse(req.getParameter("birthdate")),
                    Boolean.parseBoolean(req.getParameter("male")),
                    dept,
                    Integer.parseInt(req.getParameter("salary")));
        } catch (ParseException | ServletException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/JDBCapp/tableUser");
    }
}
