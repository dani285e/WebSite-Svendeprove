package webapp.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import webapp.WebAppHelper;
import webapp.service.UserValidationService;
import webapp.utils.LoginDto;
import webapp.utils.UserDto;

import javax.persistence.Entity;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import static webapp.WebAppHelper.*;


@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {

    private UserValidationService service = new UserValidationService();


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/WEB-INF/views/login/loginPage.jsp").forward(request, response);
    }


    protected void doPost(HttpServletRequest servletRequest, HttpServletResponse servletResponse) throws ServletException, IOException {
        String username = servletRequest.getParameter("username");
        String password = servletRequest.getParameter("password");

        boolean isUserValid = service.isUserValid(username, password);
        if (!isUserValid)
            return;


        LoginDto loginDto = new LoginDto(username, password);

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonInputString = objectMapper.writeValueAsString(loginDto);

        OkHttpClient client = new OkHttpClient();

        MediaType JSON = MediaType.parse("application/json; charset=utf-8");


        RequestBody body = RequestBody.create(JSON, jsonInputString);
        Request request = new Request.Builder()
                .url(RestApiUrl + RestApiSecurity + RestApiUser)
                .post(body)
                .build();

        Response response = null;
        try {
            response = client.newCall(request).execute();
            UserDto user = objectMapper.readValue(response.body().string(), UserDto.class);
            System.out.println(user);
            servletRequest.getRequestDispatcher("/WEB-INF/views/task/taskOverviewPage.jsp").forward(servletRequest, servletResponse);
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }

}