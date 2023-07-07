package com.romangarms;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class ScreenOffHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String response = "<h1>Screen is off</h1>";
        exchange.sendResponseHeaders(200, response.length());
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();

        System.out.println("Turning Screen Off");

        //run this command to disable the screen
        Runtime.getRuntime().exec("export DISPLAY=:0 && xset dpms force suspend");
    }
}
