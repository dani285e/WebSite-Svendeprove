package webapp.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class TaskFocusServlet extends HttpServlet {



    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        HttpSession session = httpServletRequest.getSession(false);
        if (session != null){
            session.invalidate();
            httpServletRequest.getRequestDispatcher("/WEB-INF/views/login/loginPage.jsp").forward(httpServletRequest, httpServletResponse);
            return;
        }


        super.doPost(httpServletRequest, httpServletResponse);
    }


}
