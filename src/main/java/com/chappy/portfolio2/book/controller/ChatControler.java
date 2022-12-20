package com.chappy.portfolio2.book.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.chappy.portfolio2.book.model.Chat;

@Controller
public class ChatControler {
    
    @GetMapping("/chat")
    public String index(@ModelAttribute Chat chat){
        return "chat/index";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Chat chat){
        return "chat/create";
    }

}
