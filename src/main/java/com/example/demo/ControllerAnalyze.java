package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
class ControllerAnalyze {
    @GetMapping("/")
    public String index() {
        return "redirect:/analyze";
    }

    @GetMapping("/analyze")
    public String analyze() {
        return "analyze";
    }

    @PostMapping("/analyze")
    public String analyze(String word, Model model) {
        if(word != null && !word.equals("")){
            String s = checker(word);
            model.addAttribute("show_res", s);
        }
        return "analyze";
    }

    private String checker(String word) {
        int countTemp = 0;
        String temp = null;

        int wordSize = word.length();
        for (int i = 0; i < wordSize; ++i ){
            String t = String.valueOf(word.charAt(i));
            int count = word.length() - word.replace(t, "").length();
            if(count >= countTemp){
                countTemp = count;
                temp = t;
            }
        }
        return temp +" "+countTemp;
    }
}
