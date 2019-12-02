package models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/*
 * POJO for an Message object
 */
public class Message {

    @JsonProperty("message")
    private String message;
    @JsonProperty("fromid")
    private String fromId;
    @JsonProperty("toid")
    private String toId;
    @JsonProperty("timestamp")
    private String timeStamp;
    @JsonProperty("sequence")
    private String sequence;


    public Message () {}

    public String getTimeStamp() {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMM dd, yyyy HH:mm:ss a");
//        LocalDate date = LocalDate.parse(timeStamp, formatter);
//        return String.valueOf(date);
//        java.sql.Timestamp ts = java.sql.Timestamp.valueOf(timeStamp);
////        return ts.toInstant().toString();
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    public Message (String message, String fromId, String toId, String timeStamp, String sequence) {
        this.message = message;
        this.fromId = fromId;
        this.toId = toId;
        this.timeStamp = timeStamp;
        this.sequence = sequence;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFromId() {
        return fromId;
    }

    public void setFromId(String fromId) {
        this.fromId = fromId;
    }

    public String getToId() {
        return toId;
    }

    public void setToId(String toId) {
        this.toId = toId;
    }
}
