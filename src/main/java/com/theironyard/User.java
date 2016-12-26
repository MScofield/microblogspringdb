package com.theironyard;

import javax.persistence.*;

/**
 * Created by scofieldservices on 12/21/16.
 */
@Entity
@Table(name = "microblogUsers")
public class User {
    @Id
    @GeneratedValue
            int userId;

    @Column(nullable = false)
        String userName;

    public User (int i, String u){
        this.userId = i;
        this.userName = u;
    }

    public User (int i){
        this.userId = i;
    }

    public User () {

    }
}
