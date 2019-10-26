package com.example.planningpoker.Database.Model;

public class Vote {
    public static final String TABLE_NAME = "votes";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_USER_ID = "userID";
    public static final String COLUMN_QUESTION_ID = "questionID";
    public static final String COLUMN_VOTE_VALUE = "voteValue";
    public static final String COLUMN_TIMESTAMP = "timestamp";

    private int id;
    private int userID;
    private int questionID;
    private int voteValue;
    private String timestamp;


    // Create table SQL query
    public static final String CREATE_TABLE_VOTE=
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_USER_ID + " INTEGER,"
                    + COLUMN_QUESTION_ID + " INTEGER,"
                    + COLUMN_VOTE_VALUE + " INTEGER,"
                    + COLUMN_TIMESTAMP + " DATETIME DEFAULT CURRENT_TIMESTAMP"
                    + ")";

    public Vote() {
    }

    public Vote(int id, int userID, int questionID, int voteValue, String timestamp) {
        this.id = id;
        this.userID = userID;
        this.questionID = questionID;
        this.voteValue = voteValue;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    public int getVoteValue() {
        return voteValue;
    }

    public void setVoteValue(int voteValue) {
        this.voteValue = voteValue;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
