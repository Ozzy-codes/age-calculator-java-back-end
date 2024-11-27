package com.mycompany.app.Controller;

import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.rendering.template.JavalinJte;

public class AppController {
  public Javalin startAPI() {

    Javalin app = Javalin.create(config -> {
      config.fileRenderer(new JavalinJte());
    });
    app.get("/", this::test);

    return app;
  }

  private void test(Context ctx) {
    ctx.render("test.jte");
  }
}