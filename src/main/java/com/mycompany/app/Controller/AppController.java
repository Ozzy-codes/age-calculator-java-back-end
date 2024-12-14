package com.mycompany.app.Controller;

import java.util.HashMap;
import java.util.Map;

import com.mycompany.app.model.CalculatedBirthday;
import com.mycompany.app.model.ValidateResultObject;
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
    Map<String, Object> model = new HashMap<>(
        Map.of("inputDayValue", formDay, "inputMonthValue", formMonth, "inputYearValue", formYear));

    Map<String, ValidateResultObject> resultMap = is.validate(formDay, formMonth, formYear);
    model.put("dayResult", resultMap.get("dayResultObject"));
    model.put("monthResult", resultMap.get("monthResultObject"));
    model.put("yearResult", resultMap.get("yearResultObject"));

    if (!resultMap.get("dayResultObject").isPassing() || !resultMap.get("monthResultObject").isPassing()
        || !resultMap.get("yearResultObject").isPassing()) {
      ctx.header("hx-reswap", "none");
      ctx.status(422);
      ctx.render("FailValidation.jte", model);
      return;
    }

    CalculatedBirthday birthday = is.getAge(formDay, formMonth, formYear);
    model.put("birthday", birthday);

    ctx.render("PassValidation.jte", model);
  }
}
