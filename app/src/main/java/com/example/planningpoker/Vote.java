package com.example.planningpoker;

public class Vote {
    public static final String TABLE_NAME = "votes";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_USER_ID = "userID";
    public static final String COLUMN_QUESTION_ID = "questionID";
    public static final String COLUMN_VOTE_VALUE = "voteValue";
    public static final String COLUMN_TIMESTAMP = "timestamp";

    private int id;
    private String userName;
    private String timestamp;


    // Create table SQL query
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_USER_ID + " INTEGER,"
                    + COLUMN_QUESTION_ID + " INTEGER,"
                    + COLUMN_VOTE_VALUE + " INTEGER,"
                    + COLUMN_TIMESTAMP + " DATETIME DEFAULT CURRENT_TIMESTAMP"
                    + ")";

    public Vote() {
    }

    public Vote(int id, String userName, String timestamp) {
        this.id = id;
        this.userName = userName;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
