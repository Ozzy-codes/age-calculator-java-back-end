package com.mycompany.app.Controller;

import com.mycompany.app.service.InputService;

import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.rendering.template.JavalinJte;

public class AppController {
  InputService is = new InputService();

  public Javalin startAPI() {

    Javalin app = Javalin.create(config -> {
      config.fileRenderer(new JavalinJte());
      config.staticFiles.add("/static");
    });
    app.get("/", this::renderHome);
    app.post("/input", this::handleInputForm);

    return app;
  }

  private void renderHome(Context ctx) {
    ctx.render("HomePage.jte");
  }

  private void handleInputForm(Context ctx) {
    String formDay = ctx.formParam("DD");
    String formMonth = ctx.formParam("MM");
    String formYear = ctx.formParam("YYYY");

    is.validate(formDay, formMonth, formYear);
    ctx.result("post sucessful");
  }
}
