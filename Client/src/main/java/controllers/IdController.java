package controllers;

import java.util.ArrayList;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import models.Id;
import views.IdTextView;

public class IdController {
    private Id myId;
    private ArrayList<Id> myIds = new ArrayList<Id>();
    private TransactionController transCtrl;

    public IdController(TransactionController transCtrl) {
        this.transCtrl = transCtrl;
        getIds();
    }

    public Id getMyId() {
        return myId;
    }

    public void setMyId(Id myId) {
        this.myId = myId;
    }

    public ArrayList<Id> getIds() {
        try {
            String response = transCtrl.makeURLCall("/ids", "GET", "");
            ObjectMapper mapper = new ObjectMapper();
            System.out.println(response);
            this.myIds = mapper.readValue(response, new TypeReference<ArrayList<Id>>() {
            });
            return this.myIds;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }


    public Id postId(Id id) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String idToPost = mapper.writeValueAsString(id);
            String response = transCtrl.makeURLCall("/ids", "POST", idToPost);
            getIds();
            return getIdByGitHubId(id.getGithubId());
//            for (int i = 0; i < myIds.size(); i++) {
//                if (id.getGithubId().equals(myIds.get(i).getGithubId())) {
//                    return myIds.get(i);
//                }

        } catch (JsonProcessingException e){
            e.printStackTrace();
        }
        return null;
    }

    public Id putId(String name, String githubId) {
        try {
            getIds();
            for(Id id: myIds){
                if (id.getGithubId().equals(githubId)){
                    id.setName(name);
                    ObjectMapper mapper = new ObjectMapper();                       //  Sets name and then has to change on the database
                    String JSONPayload = mapper.writeValueAsString(id);
                    transCtrl.makeURLCall("/ids", "PUT", JSONPayload);
                    getIds();
                    return getIdByGitHubId((id.getGithubId()));
                }
            }
        } catch (JsonProcessingException e){
            e.printStackTrace();
        }
        return null;
    }

    public Id getIdByGitHubId (String githubId){
        getIds();
        for (Id id : myIds){
            if(id.getGithubId().equals(githubId));
            return id;
        }
        return null;
    }
 
}