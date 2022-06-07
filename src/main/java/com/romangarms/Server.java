package com.romangarms;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Server {
public static final int PORT = 9000;

    public Server() throws IOException {

        HttpServer server = HttpServer.create(new InetSocketAddress(PORT), 0);
        System.out.println("server started at " + PORT);
        server.createContext("/TurnOnScreen", new ScreenOnHandler());
        server.createContext("/TurnOffScreen", new ScreenOffHandler());
        server.setExecutor(null);
        server.start();
    }

    public static void main(String[] args) throws IOException {
        new Server();
    }
}