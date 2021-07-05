package io.muic.ooc.webapp.servlets;

import io.muic.ooc.webapp.security.User;
import io.muic.ooc.webapp.security.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class EditServlet extends AbstractRoutableHttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (securityService.isAuthorized(req)) { // user already login before aka have session
            if (req.getParameter("editUser") != null) {
                req.getSession().setAttribute("editUser", req.getParameter("editUser"));//save attribute into session
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/edit.jsp");
                requestDispatcher.include(req, resp);
            }
            else {
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/allUser.jsp");
                requestDispatcher.include(req, resp);
            }
        }
        else {
            resp.sendRedirect("/login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = securityService.getUserService();
        String editUser = (String) req.getSession().getAttribute("editUser");
        int editId = userService.getId(editUser);
        req.setAttribute("editUser", editUser);
        req.setAttribute("editId", editId);
        String newUsername = req.getParameter("changeUsername");
        String newPass = req.getParameter("changePass");
        String newName = req.getParameter("changeName");
        if (!userService.checkIfUserExists(newUsername)) {
            userService.editUser(editId, newUsername, newPass, newName);
            req.setAttribute("accountEditSucceeded", "Edit user info completed");
            resp.sendRedirect("/");
        }
        else {
            req.setAttribute("notUniqueUsername", "Username already exists. Please select a new username.");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/edit.jsp");
            requestDispatcher.include(req, resp);
        }
    }

    @Override
    public String getPattern() {
        return "/edit";
    }
}
