package io.muic.ooc.webapp.servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HomeServlet extends AbstractRoutableHttpServlet {
// cannot be accessed if user is not logged in, just print username

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        Object usernameObject = session.getAttribute("username");
        if (securityService.isAuthorized(request)) { // user already login before aka have session
            String username = securityService.getCurrentUsername(request);
            request.setAttribute("username", username);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/home.jsp");
            requestDispatcher.include(request, response);
        }
        else {
            response.sendRedirect("/login");
        }

    }

    @Override
    public String getPattern() {
        return "/index.jsp";
    }
}
