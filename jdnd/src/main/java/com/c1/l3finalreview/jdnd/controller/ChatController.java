package com.c1.l3finalreview.jdnd.controller;

import com.c1.l3finalreview.jdnd.model.ChatForm;
import com.c1.l3finalreview.jdnd.services.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chat")
public class ChatController {
    private MessageService messageService;

    public ChatController(MessageService messageService){
        this.messageService = messageService;
    }
    @GetMapping
    public String getChatPage(ChatForm chatform, Model model){
        model.addAttribute("chatMessages",this.messageService.getChatMessage());
        return "chat";
    }
    @PostMapping
    public String postChatMessage(ChatForm chatform, Model model){
        this.messageService.addMessage(chatform);
        chatform.setMessageText("");
        model.addAttribute("chatMessage",this.messageService.getChatMessage());
        return "chat";
    }
    @ModelAttribute("messages")
    public String[] allMessageType(){
        return new String[]{"Say", "Shout","Whisper"};
    }
}
