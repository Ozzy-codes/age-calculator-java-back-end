package com.mycompany.app.Controller;

import io.javalin.Javalin;
import io.javalin.http.Context;

public class AppController {
  public Javalin startAPI() {
    Javalin app = Javalin.create();
    app.get("/", ctx -> {
      ctx.result("this works");
    });
    return app;
  }
}