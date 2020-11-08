package org.sashaworms.pvt;

import org.sashaworms.pvt.service.User;
import org.sashaworms.pvt.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class UserInitialServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = UserService.getUserService().getUsers();
        req.setAttribute("users", users);
        getServletContext().getRequestDispatcher("/tableUser.jsp").forward(req, resp);
    }
}
