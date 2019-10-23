package com.example.planningpoker;

public class Question {
    public static final String TABLE_NAME = "questions";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_USER = "question";
    public static final String COLUMN_TIMESTAMP = "timestamp";

    private int id;
    private String question;
    private String timestamp;


    // Create table SQL query
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_USER + " TEXT,"
                    + COLUMN_TIMESTAMP + " DATETIME DEFAULT CURRENT_TIMESTAMP"
                    + ")";

    public Question() {
    }

    public Question(int id, String question, String timestamp) {
        this.id = id;
        this.question = question;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
