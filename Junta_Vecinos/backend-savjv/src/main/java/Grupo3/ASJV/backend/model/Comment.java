package Grupo3.ASJV.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.Date;

@Document(collection = "Comment")
public class Comment {
    @Transient
    public static final String SEQUENCE_NAME = "comment_sequence";

    @Id
    private long id;

    private String content;
    private User user;
    private Date timestamp;

    @PersistenceConstructor
    public Comment(String content, User user) {
        this.content = content;
        this.user = user;
        //Time assigment
        Date now = Date.from(Instant.now());
        System.out.println("New comment: "+ now);
        this.timestamp = now;
    }

    public Comment(String content, User user, Date timestamp) {
        this.content = content;
        this.user = user;
        this.timestamp = timestamp;
    }

    public static String getSequenceName() {
        return SEQUENCE_NAME;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
}

