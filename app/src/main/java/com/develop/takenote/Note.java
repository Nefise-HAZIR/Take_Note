package com.develop.takenote;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "note_table")
public class Note {
    @PrimaryKey(autoGenerate = true)
    public  int id;

    public  String title;

    public  String describtion;

    public Note(String title, String describtion) {
        this.title = title;
        this.describtion = describtion;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescribtion() {
        return describtion;
    }

    public void setId(int id) {
        this.id = id;
    }
}
