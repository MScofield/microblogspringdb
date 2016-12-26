package com.theironyard;

import javax.persistence.*;


/**
 * Created by scofieldservices on 12/21/16.
 */
@Entity
@Table(name = "microblog")
public class Message {
    @Id
    @GeneratedValue
        int messageId;

    @Column(nullable = false)
        String messageText;

    @Column(nullable = false)
        int userId;

    public Message (int i, String t){
        this.messageId = i;
        this.messageText = t;
    }

    public Message (String t){
        this.messageText = t;
    }

    public Message () {
    }
}



