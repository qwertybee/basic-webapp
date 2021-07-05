package io.muic.ooc.webapp.servlets;

import io.muic.ooc.webapp.security.User;
import io.muic.ooc.webapp.security.UserService;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HomeServlet extends AbstractRoutableHttpServlet {
// cannot be accessed if user is not logged in, just print username

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (securityService.isAuthorized(request)) { // user already login before aka have session
            ArrayList<User> allUsers = (ArrayList<User>) securityService.getUserService().getAllUsers();
            request.setAttribute("allUsers", allUsers);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/allUser.jsp");
            requestDispatcher.include(request, response);
        }
        else {
            response.sendRedirect("/login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        UserService userService = securityService.getUserService();
        String username = (String) session.getAttribute("username");
        String password = (String) session.getAttribute("password");
        String editUser = req.getParameter("editUser");
        String deleteUser = req.getParameter("deleteUser");
        if (userService.authenticatedUser(username, password)) {
            if (deleteUser != null && deleteUser.equals(username)) {
                req.setAttribute("deletionDenied", "Cannot delete your own account");
            }
            else {
                userService.removeUser(deleteUser);
                req.setAttribute("deletionSucceeded", "Account deletion completed");
            }
            if (editUser != null) {
                resp.sendRedirect("/edit");
            }
        }
        doGet(req, resp);
    }

    @Override
    public String getPattern() {
        return "/index.jsp";
    }
}
