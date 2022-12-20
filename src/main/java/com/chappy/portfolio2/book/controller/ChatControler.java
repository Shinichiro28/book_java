package com.chappy.portfolio2.book.controller;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.chappy.portfolio2.book.model.Chat;
import com.chappy.portfolio2.book.repository.ChatRepository;

@Controller
public class ChatControler {

    //Chatクラスのフィールドをfinalにする
    private final ChatRepository repository;
    public ChatControler(ChatRepository repository){
        this.repository = repository;
    }
    
    @GetMapping("/chat")
    public String index(@ModelAttribute Chat chat, Model model){
        //一覧用データの用意
        model.addAttribute("chats", repository.findAll());
        return "chat/index";
    }

    @PostMapping("/create")
    public String create(@Validated @ModelAttribute Chat chat, BindingResult result, Model model){

        //バリデーションエラーがある場合はindex.htmlを表示
        if (result.hasErrors()) {
            model.addAttribute("chats", repository.findAll());
            return "chat/index";
        }
        repository.saveAndFlush(chat);
        return "redirect:/chat";
    }

    @GetMapping("/delete/{id}") //データの削除
    public String remove(@PathVariable long id){
        repository.deleteById(id);
        return "redirect:/chat";
    }

    //初期データの投入
    @PostConstruct
    public void dataInt(){
        Chat sauna = new Chat();
        sauna.setName("サウナ好き集まれ！");
        repository.saveAndFlush(sauna);
    }

}
