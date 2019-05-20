import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");
        String layout = "templates/layout.vtl";
   get("/", (request, response)->{
       Map<String, Object> model = new HashMap<String, Object>();

       model.put("template", "templates/index.vtl");
       return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());

   get("heroes/new",(request, response) -> {
       Map<String, Object> model = new HashMap<String, Object>();
       model.put("template", "templates/hero-form.vtl");
       return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());

   get("/heroes",(request, response) -> {
       Map<String, Object> model = new HashMap<String, Object>();
       model.put("heroes", Hero.all());
       model.put("template", "templates/heroes.vtl");
       return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());


    post("/heroes",(request,response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
        String name= request.queryParams("name");
        Integer age = Integer.parseInt(request.queryParams("9"));
        String power = request.queryParams("power");
        String weakness = request.queryParams("weakness");

            Hero newHero = new Hero("Mathew",9,"fit","poor");
            model.put("template", "templates/success.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        post("/heroes", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();

            ArrayList<Hero> heroes = request.session().attribute("Heroes");
            if(heroes == null) {
                heroes = new ArrayList<Hero>();
                request.session().attribute("heroes", heroes);
            }
            String name= request.queryParams("name");
            Integer age = Integer.parseInt(request.queryParams("9"));
            String power = request.queryParams("power");
            String weakness = request.queryParams("weakness");

            Hero newHero = new Hero(name,age,power,weakness);
            request.session().attribute("hero", newHero);


            model.put("template", "templates/success.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/", (request, response) ->{
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("heroes", request.session().attribute("hero"));
            model.put("template", "templates/index.vtl");
            return new ModelAndView(model, layout);
        },new VelocityTemplateEngine());
    }

}