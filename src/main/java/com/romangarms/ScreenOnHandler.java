package com.romangarms;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class ScreenOnHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String response = "<h1>Screen is on</h1>";
        exchange.sendResponseHeaders(200, response.length());
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();

        System.out.println("Turning Screen On");

        //run this command to reenable the screen
        Runtime.getRuntime().exec("sh home/romangarms/screenOn.sh");

        //Runtime.getRuntime().exec("DISPLAY=:0 xset dpms force on");
    }
}
