package sit.int202.demo.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//Send Request To Home Page in View Home.html
@Controller
public class AppController {
    @RequestMapping("/home")
    public String homepage() { // define name
        return "home";
    }
    @GetMapping("/office1")// send Req to
    public String office1() {
        return "office1";
    }

}
