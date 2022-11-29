package com.fileupload.localPath;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="user")
public class User{
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String imageFile;

    public User() {

    }

    public int getId() {
        return id;
    }

    public String getImageFile() {
        return imageFile;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setImageFile(String imageFile) {
        this.imageFile = imageFile;
    }

    public User(int id, String imageFile) {
        this.id = id;
        this.imageFile = imageFile;
    }

}


