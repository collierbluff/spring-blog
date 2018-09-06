package com.blog.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@Controller
public class MathController {

    @GetMapping("/add/{a}/and/{b}")
    @ResponseBody
    private int add(@PathVariable int a, @PathVariable int b){
        return a + b;
    }

    @GetMapping("/subtract/{a}/from/{b}")
    @ResponseBody
    private int subtract(@PathVariable int a, @PathVariable int b){
        return b - a;
    }

    @GetMapping("/multiply/{a}/and/{b}")
    @ResponseBody
    private int multiply(@PathVariable int a, @PathVariable int b){
        return a * b;
    }

    @GetMapping("/divide/{a}/by/{b}")
    @ResponseBody
    private double divide(@PathVariable double a, @PathVariable double b){
        return a / b;
    }


    @GetMapping("/roll-dice")
    public String getRoll(Model model){
        return "roll";
    }

    @GetMapping("/roll-dice/{guess}")
    @ResponseBody
    private String rolling(@PathVariable String guess){

        int rollNum = new Random().nextInt(6) + 1;

        return "Your guess was: " + guess + "<br> The result of the roll was: " + rollNum + "<br> Which means your guess was: " + (Integer.parseInt(guess) == rollNum ? "correct!" : "wrong!");
    }

}
