package gg.jte.generated.ondemand;
@SuppressWarnings("unchecked")
public final class JtetestGenerated {
	public static final String JTE_NAME = "test.jte";
	public static final int[] JTE_LINE_INFO = {5,5,5,5,5,5,5,55,55,55,55,55,55};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor) {
		jteOutput.writeContent("\n<!DOCTYPE html>\n<html lang=\"en\">\n<head>\n  <meta charset=\"UTF-8\">\n  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"> ");
		jteOutput.writeContent("\n\n  <link rel=\"icon\" type=\"image/png\" sizes=\"32x32\" href=\"./assets/images/favicon-32x32.png\">\n  <link rel=\"stylesheet\" href=\"/app.css\">\n  <link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\n  <link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\n  <link href=\"https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,700;1,400;1,800&display=swap\" rel=\"stylesheet\">\n  <script src=\"/htmx.js\" defer></script>\n  \n  <title>Age calculator app</title>\n</head>\n<body>\n<main class='flex column main-card'>\n<form class=\"flex column reactive-card\"\nhx-post='/input'\nhx-target='.display'\n>\n<div class=\"flex\">\n</div>\n<div class=\"button_container\">\n  <hr>\n  <button class=\"align_button\" type='submit'>\n<img src=\"assets/images/icon-arrow.svg\" alt=\"Calculate Age\">\n</button>\n</div>\n</form>\n\n<div class='display'>\n  <div id='year'><span>- -</span> years</div>\n  <div id='month'><span>- -</span> months</div>\n  <div id='day'><span>- -</span> days</div>\n</div>\n  \n  <div class=\"attribution\">\n    Challenge by <a href=\"https://www.frontendmentor.io?ref=challenge\" target=\"_blank\">Frontend Mentor</a>. \n    Coded by <a href=\"https://www.frontendmentor.io/profile/Ozzy-codes\">Ozzy-codes</a>.\n  </div>\n</main>\n\t<script>\n\t\tdocument.addEventListener(\"DOMContentLoaded\", event => {\n\t\t\tdocument.body.addEventListener('htmx:beforeSwap', function (evt) {\n\t\t\t\tif (evt.detail.xhr.status === 422) {\n\t\t\t\t\tevt.detail.shouldSwap = true;\n\t\t\t\t\tevt.detail.isError = false;\n\t\t\t\t}\n\t\t\t})\n\t\t})\n\t</script>\n</body>\n</html>\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		render(jteOutput, jteHtmlInterceptor);
	}
}
