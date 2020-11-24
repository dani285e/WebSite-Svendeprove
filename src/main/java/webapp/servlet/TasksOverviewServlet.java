package webapp.servlet;


import javax.servlet.ServletException;
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

public class TasksOverviewServlet extends HttpServlet {



    protected void doPost(HttpServletRequest servletRequest, HttpServletResponse servletResponse) throws ServletException, IOException {
        HttpSession session = servletRequest.getSession(false);
        if (session != null){
            session.invalidate();
            servletRequest.getRequestDispatcher("/WEB-INF/views/login/loginPage.jsp").forward(servletRequest, servletResponse);
            return;
        }

            URL url = new URL(RestApiUrl + RestApiTasks + RestApiGetTaskList);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("POST");


            con.setRequestProperty("Content-Type", "application/json; utf-8");
            con.setRequestProperty("Accept", "application/json");
            con.setDoOutput(true);


            String jsonInputString = "{\"username\"}";
            System.out.println(jsonInputString);

            try(OutputStream os = con.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int code = con.getResponseCode();
            System.out.println(code);

            try(BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))){
                StringBuilder response = new StringBuilder();
                String responseLine = null;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                System.out.println(response.toString());

                servletRequest.getRequestDispatcher("/WEB-INF/views/task/taskOverviewPage.jsp").forward(servletRequest, servletResponse);
            }

        }


    }

