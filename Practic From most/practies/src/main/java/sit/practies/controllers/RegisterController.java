package sit.practies.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sit.practies.entitys.Profile;
import sit.practies.entitys.ResultCheckPrime;
import sit.practies.services.RegisterService;

import java.io.IOException;

@Controller
@RequestMapping("/mid_exam_065_war_exploded/065")
public class RegisterController {
    private RegisterService registerService;

    @Autowired
    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public void setProfile(Profile profile, HttpServletResponse response) throws IOException {
        registerService.setProfile(profile.getUsername(), profile.getEmail());
        response.sendRedirect("/mid_exam_065_war_exploded/065/isPrime");
    }

    @GetMapping("/isPrime")
    public String isPrime(ModelMap model) {
        model.addAttribute("profile", registerService.getProfile());
        return "is_prime";
    }

    @PostMapping("/isPrime")
    public String isCheckPrime(HttpServletRequest req, ModelMap model) {
        String input = req.getParameter("number");
        if (input.isEmpty()) {
            model.addAttribute("isCheckPrime", new ResultCheckPrime(false, "Empty is invalid input!!"));
            return "is_prime";
        }
        // ตรวจสอบว่าค่าเป็นตัวเลขจำนวนเต็มหรือไม่
        boolean isInteger = true;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (i == 0 && c == '-') continue; // อนุญาตให้มีเครื่องหมายลบเฉพาะตัวแรก
            if (c < '0' || c > '9') {
                isInteger = false;
                break;
            }
        }

        // ตรวจสอบว่า input เป็นจำนวนเต็มที่มากกว่า -2 หรือไม่
        if (!isInteger || Integer.parseInt(input) < -2) {
            model.addAttribute("isCheckPrime", new ResultCheckPrime(false, input + " is invalid input!!"));
            return "is_prime";
        }

        int num = Integer.parseInt(input);
        boolean flag = false;

        if (num == 0 || num == 1) {
            flag = true;
        }

        for (int i = 2; i <= num / 2; ++i) {
            // เงื่อนไขสำหรับจำนวนที่ไม่เป็นจำนวนเฉพาะ
            if (num % i == 0) {
                flag = true;
                break;
            }
        }

        String result = input;
        if (!flag)
            result += " is a prime number.";
        else
            result += " is not a prime number.";

        model.addAttribute("isCheckPrime", new ResultCheckPrime(true, result));
        model.addAttribute("profile", registerService.getProfile());
        return "is_prime";
    }

}
