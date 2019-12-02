package views;

import models.Id;
import models.Message;

import java.time.LocalDate;
import java.util.ArrayList;

public class MessageTextView {
    private Message msgToDisplay;
    //private Id idToDisplay;

    public MessageTextView () {}


    public MessageTextView(Message msgToDisplay) {
        this.msgToDisplay = msgToDisplay;

    }


    @Override public String toString() {

        return String.format("TimeStamp: %s\nFrom ID: %s\nTo ID: %s\nMessage: %s\n\n", msgToDisplay.getTimeStamp(), msgToDisplay.getFromId(), msgToDisplay.getToId(), msgToDisplay.getMessage());

    }
    public static String printMessages(ArrayList<Message> messages){
        String output = "";
        for (Message msgToDisplay: messages) {
            output += new MessageTextView(msgToDisplay).toString();
        }
        return output;
    }

}
