package Grupo3.ASJV.backend.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Document(collection = "Post")
public class Post {
    //@Transient
    //public static final String SEQUENCE_NAME = "post_sequence";


    @Id
    @JsonSerialize(using= ToStringSerializer.class)
    private ObjectId _id = new ObjectId(); 

    private String title;
    private String description;
    private User user;
    private String category;
    private Date timestamp;
    private String price;
    private ArrayList<Comment> comments = new ArrayList<>();
    private ArrayList<Score> scores = new ArrayList<>();

    public Post(String title, String description, User user, String category, Date timestamp, String price) {
        this.title = title;
        this.description = description;
        this.user = user;
        this.category = category;
        this.timestamp = timestamp;
        this.price = price;
    }

    public void addComment(Comment comment){
        System.out.println("Se agregará comentario: " + comment.getContent());
        this.comments.add(comment);
        System.out.println("Comentario agregado");
        System.out.println("Mostrando los comentarios");
        System.out.println("Largo comentarios: "+ comments.size());
    }

    public void addScore(Score score){
        System.out.println("Se agregará puntuación: " + score.getPunctuation());
        this.scores.add(score);
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    public ObjectId getId() {
        return _id;
    }

    public void setId(ObjectId id) {
        this._id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}

