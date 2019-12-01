package youareell;

import com.fasterxml.jackson.core.JsonProcessingException;
import controllers.*;
import models.Id;
import models.Message;
import views.IdTextView;

public class YouAreEll {
    //Can be used an kind of an overlord controller.  And then simple shell won't have so much code.
    //Transaction controller sends and receives not translate.
    private MessageController msgCtrl;
    private IdController idCtrl;
    private TransactionController transCtrl;

    public YouAreEll() {
        // used j because i seems awkward
        this.transCtrl = new TransactionController();
        this.idCtrl = new IdController(transCtrl);
        this.msgCtrl = new MessageController(transCtrl, idCtrl);
    }

    public String get_ids()  {
        return new IdTextView().printIds(this.idCtrl.getIds());
    }

    public String putOrPost_ids(String name, String githubId) {
        for (Id id : this.idCtrl.getIds()) {
            if (id.getGithubId().equals(githubId))
                idCtrl.putId(name, githubId);
            return new IdTextView(id).toString();
        }
        Id newId = new Id (name, githubId);
        idCtrl.postId(newId);
        return new IdTextView(newId).toString();
    }

    public String get_messages() {
        return "";
    }
}

