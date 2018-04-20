package com.example.maryhuerta.cateringapp;

/**
 * Created by gustavojimenez on 4/16/18.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by mayur on 4/11/2018.
 */

public class DBManager extends SQLiteOpenHelper {

    private static final int Db_VERSION = 1;
    private static final String DB_NAME = "users_db";
    private static final String TABLE_NAME = "users_data";

    private static final String KEY_ID = "user_id";
    private static final String KEY_FNAME = "user_fname";
    private static final String KEY_LNAME = "user_lname";
    private static final String KEY_EMAIL = "user_email";
    private static final String KEY_PASS = "user_pass";
    private static final String KEY_USERNAME = "user_username";
    private static final String KEY_PHONENUMBER = "user_phoneNumber";
    private static final String KEY_STREETADDRESS = "user_streetAddress";
    private static final String KEY_CITY = "user_city";
    private static final String KEY_ZIP = "user_zipcode";
    private static final String KEY_STATE = "user_state";
    private static final String KEY_USERTYPE = "user_type";

    //now i need to add a add

    public DBManager(Context context) {
        super(context, DB_NAME, null, Db_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TABLE_Q = "CREATE TABLE " + TABLE_NAME + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                + KEY_FNAME + " TEXT," + KEY_LNAME + " TEXT," + KEY_EMAIL + " TEXT," + KEY_PASS + " TEXT," + KEY_USERNAME + " TEXT,"
                + KEY_PHONENUMBER + " TEXT," + KEY_STREETADDRESS + " TEXT," + KEY_CITY + " TEXT," + KEY_ZIP + " TEXT," + KEY_STATE + " TEXT," + KEY_USERTYPE + " TEXT )";
        sqLiteDatabase.execSQL(CREATE_TABLE_Q);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public void addNewUser(UserModel user){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_ID, user.getId());
        values.put(KEY_FNAME, user.getUserFName());
        values.put(KEY_LNAME, user.getUserLName());
        values.put(KEY_EMAIL, user.getUserEmail());
        values.put(KEY_PASS, user.getUserPassword());
        values.put(KEY_USERNAME, user.getUsername());
        values.put(KEY_PHONENUMBER, user.getPhoneNum());
        values.put(KEY_STREETADDRESS, user.getStreetAddress());
        values.put(KEY_CITY, user.getCity());
        values.put(KEY_ZIP, user.getZipcode());
        values.put(KEY_STATE, user.getState());
        values.put(KEY_USERTYPE, user.getUsertype());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public UserModel retrieveUser(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();

        String query = "SELECT * from " + TABLE_NAME + " WHERE " + KEY_USERNAME + " = \""
                + username + "\" AND " + KEY_PASS + " = \"" + password + "\";";
        Cursor cursor = db.rawQuery(query, null);

        UserModel model = new UserModel();

        if (cursor.moveToFirst()) {
            model.setId(cursor.getString(cursor.getColumnIndex(KEY_ID)));
            model.setUserFName(cursor.getString(cursor.getColumnIndex(KEY_FNAME)));
            model.setUserLName(cursor.getString(cursor.getColumnIndex(KEY_LNAME)));
            model.setUserEmail(cursor.getString(cursor.getColumnIndex(KEY_EMAIL)));
            model.setUserPassword(cursor.getString(cursor.getColumnIndex(KEY_PASS)));
            model.setStreetAddress(cursor.getString(cursor.getColumnIndex(KEY_STREETADDRESS)));
            model.setCity(cursor.getString(cursor.getColumnIndex(KEY_CITY)));
            model.setState(cursor.getString(cursor.getColumnIndex(KEY_STATE)));
            model.setZipcode(cursor.getString(cursor.getColumnIndex(KEY_ZIP)));
            model.setUsertype(cursor.getString(cursor.getColumnIndex(KEY_USERTYPE)));
        } else {
            model = null;
        }
        return model;
    }
}