package com.romangarms;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

public class ScreenOffHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String response = "<h1>Screen is off</h1>";
        exchange.sendResponseHeaders(200, response.length());
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();

        System.out.println("Turning Screen Off");

        // Set the environment variable WAYLAND_DISPLAY for the process
        ProcessBuilder pb = new ProcessBuilder("wlr-randr", "--output", "HDMI-A-1", "--off");

        // Set the environment variable
        Map<String, String> environment = pb.environment();
        environment.put("WAYLAND_DISPLAY", "wayland-1");

        // Run the command to turn off the screen
        pb.start();
    }

    public static void main(String[] args) throws IOException {
        // Run this command to disable the screen with the proper environment variable
        ProcessBuilder pb = new ProcessBuilder("wlr-randr", "--output", "HDMI-A-1", "--off");
        Map<String, String> environment = pb.environment();
        environment.put("WAYLAND_DISPLAY", "wayland-1");
        pb.start();
    }
}