package controllers;

import java.util.ArrayList;
import java.util.HashSet;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Id;
import models.Message;

public class MessageController {
    TransactionController transCtrl;
    IdController idCtrl;
    private ArrayList<Message> myMessages = new ArrayList<Message>();

    public MessageController(TransactionController transCtrl, IdController idCtrl) {
        this.transCtrl = transCtrl;
        this.idCtrl = idCtrl;
    }

    private HashSet<Message> messagesSeen;
    // why a HashSet??

    public ArrayList<Message> getMessages() {

        try {
            String response = transCtrl.makeURLCall("/messages", "GET", "");
            ObjectMapper mapper = new ObjectMapper();
            //System.out.println(response);
            this.myMessages = mapper.readValue(response, new TypeReference<ArrayList<Message>>() {
            });
            return this.myMessages;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Message> getMessagesForId(Id Id) {
        return null;
    }
    public Message getMessageForSequence(String seq) {
        return null;
    }
    public ArrayList<Message> getMessagesFromFriend(Id myId, Id friendId) {
        return null;
    }

    public Message postMessage(Id myId, Id toId, Message msg) {
        return null;
    }
 
}