package webapp.utils;

import netscape.javascript.JSObject;
import webapp.WebAppHelper;

import java.io.IOException;
import java.net.HttpURLConnection;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


public class HttpUrlConnection {
    URL url = new URL(WebAppHelper.RestApiUrl);
    URLConnection con = url.openConnection();
    HttpURLConnection http = (HttpURLConnection)con;
    http.setRequestMethod("POST"); // PUT is another valid option
    http.setDoOutput(true);


    private  HttpUrlConnection() throws IOException {



    }

    private getRequest(String url, JSObject object){


        return;
    }
}
