package com.mycompany.app;

import com.mycompany.app.Controller.AppController;
import io.javalin.Javalin;

public class App {

    public static void main(String[] args) {
        AppController appController = new AppController();
        Javalin app = appController.startAPI();
        app.start(3000);
    }
}
