package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// controller 우선, 그 다음 static을 확인함
@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "home";
    }
}
