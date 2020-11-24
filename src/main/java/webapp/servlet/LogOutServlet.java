package webapp.servlet;

import webapp.service.UserValidationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import static webapp.WebAppHelper.*;

@WebServlet(urlPatterns = "/logout.do")
public class LogOutServlet extends HttpServlet {

    protected void doPost(HttpServletRequest servletRequest, HttpServletResponse servletResponse) throws ServletException, IOException {
        HttpSession session = servletRequest.getSession(true);
        servletRequest.getRequestDispatcher("/WEB-INF/views/login/loginPage.jsp").forward(servletRequest, servletResponse);
    }
}