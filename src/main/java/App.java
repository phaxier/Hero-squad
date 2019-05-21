import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

import org.apache.velocity.app.Velocity;
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

        get("/heroes/:id", (request, response)->{
            HashMap<String, Object> model = new HashMap<String, Object>();
            Hero hero = Hero.find(Integer.parseInt(request.params(":id")));
            model.put("hero", hero);
            model.put("template", "templates/hero.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get ("/squads/new", (request, response)->{
            Map <String, Object> model = new HashMap<String, Object>();
            model.put("template", "templates/squad-form.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        post("/squads", (request, response)->{
            Map<String, Object> model = new HashMap<String, Object>();
            String name = request.queryParams("name");
            String cause = request.queryParams("cause");
            String max = request.queryParams("max");

            Squad newSquad = new Squad(name,cause,max);
            model.put("template", "templates/squad-success.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/ squads", (request, response)->{
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("squads", Squad.all());
            model.put("template", "templates/squads.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/Squads/:id", (request, response)->{
            Map<String, Object> model = new HashMap<String, Object>();
            Squad squad = Squad.find(Integer.parseInt(request.params(":id")));
            model.put("squad", squad);
            model.put("template", "templates/squad.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get ("/squads/:id/heroes/new", (request, response)->{
            Map<String, Object> model = new HashMap<String, Object>();
            Squad squad = Squad.find(Integer.parseInt(request.params(":id")));
            model.put("squad", squad);
            model.put("template", "templates/squad-hero-form.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        post("/squads", (request, response)->{
            Map<String, Object> model = new HashMap<String, Object>();
            String name = request.queryParams("name");
            String cause = request.queryParams("cause");
            String max = request.queryParams("max");
            Squad squad = new Squad(name, cause, max);
            model.put("template", "templates/squads-success.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());







    }

}