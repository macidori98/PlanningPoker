package com.example.planningpoker.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.planningpoker.Database.Model.Question;
import com.example.planningpoker.Database.Model.User;
import com.example.planningpoker.Database.Model.Vote;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    //MARK: - PROPERTIES

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "planning_poker_db";



    //MARK: - INIT
    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Question.CREATE_TABLE_QUESTION);
        sqLiteDatabase.execSQL(User.CREATE_TABLE_USER);
        sqLiteDatabase.execSQL(Vote.CREATE_TABLE_VOTE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Question.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Vote.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + User.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }



    //MARK:- PUBLIC

    public Question getQuestion(long id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(Question.TABLE_NAME,
                new String[]{Question.COLUMN_ID, Question.COLUMN_QUESTION, Question.COLUMN_TIMESTAMP},
                Question.COLUMN_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        Question question = new Question(
                cursor.getInt(cursor.getColumnIndex(Question.COLUMN_ID)),
                cursor.getString(cursor.getColumnIndex(Question.COLUMN_QUESTION)),
                cursor.getString(cursor.getColumnIndex(Question.COLUMN_TIMESTAMP)));
        cursor.close();
        return question;
    }

    public Question getQuestion(String id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(Question.TABLE_NAME,
                new String[]{Question.COLUMN_ID, Question.COLUMN_QUESTION, Question.COLUMN_TIMESTAMP},
                Question.COLUMN_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        Question question = new Question(
                cursor.getInt(cursor.getColumnIndex(Question.COLUMN_ID)),
                cursor.getString(cursor.getColumnIndex(Question.COLUMN_QUESTION)),
                cursor.getString(cursor.getColumnIndex(Question.COLUMN_TIMESTAMP)));
        cursor.close();
        return question;
    }

    public User getUser(long id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(User.TABLE_NAME,
                new String[]{User.COLUMN_ID, User.COLUMN_USER, User.COLUMN_TIMESTAMP},
                User.COLUMN_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        User user = new User(
                cursor.getInt(cursor.getColumnIndex(User.COLUMN_ID)),
                cursor.getString(cursor.getColumnIndex(User.COLUMN_USER)),
                cursor.getString(cursor.getColumnIndex(User.COLUMN_TIMESTAMP)));
        cursor.close();
        return user;
    }

    public User getUser(String name) {
        // get readable database as we are not inserting anything
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(User.TABLE_NAME,
                new String[]{User.COLUMN_ID, User.COLUMN_USER, User.COLUMN_TIMESTAMP},
                User.COLUMN_USER + "=?",
                new String[]{name}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        // prepare hobby object
        User user = new User(
                cursor.getInt(cursor.getColumnIndex(User.COLUMN_ID)),
                cursor.getString(cursor.getColumnIndex(User.COLUMN_USER)),
                cursor.getString(cursor.getColumnIndex(User.COLUMN_TIMESTAMP)));
        // close the db connection
        cursor.close();
        return user;
    }

    public List<Vote> getVotes(long userID) {
        List<Vote> votes = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + Vote.TABLE_NAME + " WHERE userID = " + userID +" ORDER BY " +
                Vote.COLUMN_TIMESTAMP + " DESC";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Vote vote = new Vote();
                vote.setId(cursor.getInt(cursor.getColumnIndex(Vote.COLUMN_ID)));
                vote.setQuestionID(cursor.getInt(cursor.getColumnIndex(Vote.COLUMN_QUESTION_ID)));
                vote.setTimestamp(cursor.getString(cursor.getColumnIndex(Vote.COLUMN_TIMESTAMP)));
                vote.setUserID(cursor.getInt(cursor.getColumnIndex(Vote.COLUMN_USER_ID)));
                vote.setVoteValue(cursor.getInt(cursor.getColumnIndex(Vote.COLUMN_VOTE_VALUE)));
                votes.add(vote);
            } while (cursor.moveToNext());
        }
        db.close();
        return votes;
    }

    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + User.TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                User user = new User();
                user.setId(cursor.getInt(cursor.getColumnIndex(User.COLUMN_ID)));
                user.setUserName(cursor.getString(cursor.getColumnIndex(User.COLUMN_USER)));
                user.setTimestamp(cursor.getString(cursor.getColumnIndex(User.COLUMN_TIMESTAMP)));
                users.add(user);
            } while (cursor.moveToNext());
        }
        db.close();
        return users;
    }

    public long insertQuestion(String question) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Question.COLUMN_QUESTION, question);
        long id = db.insert(Question.TABLE_NAME, null, values);
        db.close();
        return id;
    }

    public long insertUser(String user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(User.COLUMN_USER, user);
        long id = db.insert(User.TABLE_NAME, null, values);
        db.close();
        return id;
    }

    public long insertVote(int userID, int questionID, int voteValue) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Vote.COLUMN_USER_ID, userID);
        values.put(Vote.COLUMN_QUESTION_ID,questionID);
        values.put(Vote.COLUMN_VOTE_VALUE,voteValue);
        long id = db.insert(Vote.TABLE_NAME, null, values);
        db.close();
        return id;
    }

//    public void deleteUsers(){
//        SQLiteDatabase db = this.getReadableDatabase();
//        db.execSQL("DROP TABLE IF EXISTS " + User.TABLE_NAME);
//        db.execSQL(User.CREATE_TABLE_USER);//
//    }
}
