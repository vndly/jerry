package com.mauriciotogneri.testapp.app;

import com.mauriciotogneri.jerry.Jerry;

public class Main extends Jerry
{
    public static void main(String[] args) throws Exception
    {
        int port = Integer.parseInt(System.getenv("PORT"));
        String packages = "com.mauriciotogneri.testapp";

        Main main = new Main();
        main.start(port, packages);
    }
}