package com.c1.l3finalreview.jdnd.services;

import com.c1.l3finalreview.jdnd.model.ChatForm;
import com.c1.l3finalreview.jdnd.model.ChatMessage;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {
    private List<ChatMessage> chatMessage;

    @PostConstruct
    public void postConstruct(){
        System.out.println("Cerating msg service");
        this.chatMessage = new ArrayList<>();
    }

    public List<ChatMessage> getChatMessage() {
        return chatMessage;
    }
    public void addMessage(ChatForm chatForm){

        ChatMessage newMessage = new ChatMessage();
        newMessage.setUsername(chatForm.getUsername());
        switch (chatForm.getMessageType()) {
            case "Say":
                newMessage.setMessage(chatForm.getMessageText());
                break;
            case "Shout":
                newMessage.setMessage(chatForm.getMessageText().toUpperCase());
                break;
            case "Whisper":
                newMessage.setMessage(chatForm.getMessageText().toLowerCase());
                break;
        }
        this.chatMessage.add(newMessage);
    }

    }


