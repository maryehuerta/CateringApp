package com.example.maryhuerta.cateringapp;

/**
 * Created by gustavojimenez on 4/16/18.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by mayur on 4/11/2018.
 */

public class DBManager extends SQLiteOpenHelper {

    private static final int Db_VERSION = 1;
    private static final String DB_NAME = "users_db";

    //strings for usermodel
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

    //strings for event
    private static final String TABLE_NAME1 = "event_data";
    private static final String EVENT_NAME = "event_name";
    private static final String EVENT_FNAME = "event_fname";
    private static final String EVENT_LNAME = "event_lname";
    private static final String EVENT_DATE = "event_date";
    private static final String EVENT_DURATION = "event_duration";
    private static final String EVENT_HALLNAME = "event_hallName";
    private static final String EVENT_ATTENDEES = "event_attendees";
    private static final String EVENT_FOODTYPE = "event_foodType";
    private static final String EVENT_FORMALITY = "event_formality";
    private static final String EVENT_DRINKTYPE = "event_drinkType";
    private static final String EVENT_RESERVED = "event_reserved";
    private static final String EVENT_SPECIALITEMS = "event_specialItems";

    public DBManager(Context context) {
        super(context, DB_NAME, null, Db_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TABLE_Q = "CREATE TABLE " + TABLE_NAME + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                + KEY_FNAME + " TEXT," + KEY_LNAME + " TEXT," + KEY_EMAIL + " TEXT," + KEY_PASS + " TEXT," + KEY_USERNAME + " TEXT,"
                + KEY_PHONENUMBER + " TEXT," + KEY_STREETADDRESS + " TEXT," + KEY_CITY + " TEXT," + KEY_ZIP + " TEXT," + KEY_STATE + " TEXT," + KEY_USERTYPE + " TEXT )";
        String CREATE_TABLE_R = "CREATE TABLE " + TABLE_NAME1 + "(" + EVENT_NAME + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                + EVENT_FNAME + " TEXT," + EVENT_LNAME + " TEXT," + EVENT_DATE + " TEXT," + EVENT_DURATION + " TEXT," + EVENT_HALLNAME + " TEXT,"
                + EVENT_ATTENDEES + " TEXT," + EVENT_FOODTYPE + " TEXT," + EVENT_FORMALITY + " TEXT," + EVENT_DRINKTYPE + " TEXT,"
                + EVENT_RESERVED + " TEXT," + EVENT_SPECIALITEMS + " TEXT )";
                sqLiteDatabase.execSQL(CREATE_TABLE_Q);
                sqLiteDatabase.execSQL(CREATE_TABLE_R);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME1);
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

    public void addNewEvent(EventModel event){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(EVENT_NAME, event.getEventName());
        values.put(EVENT_FNAME, event.getFirstName());
        values.put(EVENT_LNAME, event.getLastName());
        values.put(EVENT_DATE, event.getDate());
        values.put(EVENT_DURATION, event.getDuration());
        values.put(EVENT_HALLNAME, event.getHallName());
        values.put(EVENT_ATTENDEES, event.getAttendees());
        values.put(EVENT_FOODTYPE, event.getFoodType());
        values.put(EVENT_FORMALITY, event.getFormality());
        values.put(EVENT_DRINKTYPE, event.getDrinkType());
        values.put(EVENT_RESERVED, event.getReserved());
        values.put(EVENT_SPECIALITEMS, event.getSpecialItems());
        db.insert(TABLE_NAME1,null,values);
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