package com.romangarms;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;

public class ScreenOnHandler implements HttpHandler {


    @Override
    public void handle(HttpExchange exchange) throws IOException {
        System.out.println("Turning Screen On");
        Runtime.getRuntime().exec("vcgencmd display_power 1");
    }
}
