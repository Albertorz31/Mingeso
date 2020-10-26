package Grupo3.ASJV.backend.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.Date;

@Document(collection = "Score")
public class Score {
    //@Transient
    //public static final String SEQUENCE_NAME = "comment_sequence";

    @Id
    private ObjectId id;

    private User user;
    private Date timestamp;
    private int punctuation;

    @PersistenceConstructor
    public Score(int punctuation, User user) {
        this.punctuation = punctuation;
        this.user = user;
        //Time assigment
        Date now = Date.from(Instant.now());
        System.out.println("New punctuation: " + now);
        this.timestamp = now;
    }

    public Score(int punctuation, User user, Date timestamp) {
        this.punctuation = punctuation;
        this.user = user;
        this.timestamp = timestamp;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public int getPunctuation() {
        return punctuation;
    }

    public void setPunctuation(int punctuation) {
        this.punctuation = punctuation;
    }
}

