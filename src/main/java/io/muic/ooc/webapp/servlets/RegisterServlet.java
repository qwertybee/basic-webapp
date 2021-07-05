package io.muic.ooc.webapp.servlets;

import io.muic.ooc.webapp.security.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends AbstractRoutableHttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (securityService.isAuthorized(req)) { // user already login before aka have session
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/register.jsp");
            requestDispatcher.include(req, resp);
        }
        else {
            resp.sendRedirect("/login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = securityService.getUserService();
        String newUsername = req.getParameter("newUsername");
        String newPass = req.getParameter("newPass");
        String newName = req.getParameter("newName");
        if (!userService.checkIfUserExists(newUsername)) {
            userService.addUser(newUsername, newPass, newName);
            req.setAttribute("registrationSucceeded", "New user created");
            resp.sendRedirect("/");
        }
        else {
            req.setAttribute("notUniqueUsername", "Username already exists. Please select a new username.");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/register.jsp");
            requestDispatcher.include(req, resp);
        }
    }

    @Override
    public String getPattern() {
        return "/register";
    }
}
