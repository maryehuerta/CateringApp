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

import java.util.Vector;

/**
 * Created by mayur on 4/11/2018.
 */

public class DBManager extends SQLiteOpenHelper {

    private static final int Db_VERSION = 4;
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

    private static final String TABLE_STAFF = "staff_data";

    private static final String TABLE_NAME1 = "event_data";
    private static final String EVENT_NAME = "event_name";
    private static final String EVENT_FNAME = "event_fname";
    private static final String EVENT_LNAME = "event_lname";
    private static final String EVENT_DATE = "event_date";
    private static final String EVENT_TIMEOFEVENT = "timeOfEvent";
    private static final String EVENT_DURATION = "event_duration";
    private static final String EVENT_HALLNAME = "event_hallName";
    private static final String EVENT_ATTENDEES = "event_attendees";
    private static final String EVENT_FOODTYPE = "event_foodType";
    private static final String EVENT_FORMALITY = "event_formality";
    private static final String EVENT_MEALTYPE = "event_mealType";
    private static final String EVENT_RESERVED = "event_reserved";
    private static final String EVENT_SPECIALITEMS = "event_specialItems";

    //strings for Hall
    private static final String TABLE_HALL = "hall_data";
    private static final String HALL_NAME = "hall_name";
    private static final String HALL_CAPACITY = "hall_capacity";
    private static final String HALL_BUILDING = "hall_building";
    private static final String HALL_FLOOR = "hall_floor";

    public DBManager(Context context) {
        super(context, DB_NAME, null, Db_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TABLE_Q = "CREATE TABLE " + TABLE_NAME + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                + KEY_FNAME + " TEXT," + KEY_LNAME + " TEXT," + KEY_EMAIL + " TEXT," + KEY_PASS + " TEXT," + KEY_USERNAME + " TEXT,"
                + KEY_PHONENUMBER + " TEXT," + KEY_STREETADDRESS + " TEXT," + KEY_CITY + " TEXT," + KEY_ZIP + " TEXT," + KEY_STATE + " TEXT," + KEY_USERTYPE + " TEXT )";
        String CREATE_TABLE_R = "CREATE TABLE " + TABLE_NAME1 + "(" + EVENT_NAME + " TEXT PRIMARY KEY NOT NULL,"
                + EVENT_FNAME + " TEXT," + EVENT_LNAME + " TEXT," + EVENT_DATE + " TEXT," + EVENT_TIMEOFEVENT + " TEXT," + EVENT_DURATION + " TEXT," + EVENT_HALLNAME + " TEXT,"
                + EVENT_ATTENDEES + " TEXT," + EVENT_FOODTYPE + " TEXT," + EVENT_FORMALITY + " TEXT," + EVENT_MEALTYPE + " TEXT,"
                + EVENT_RESERVED + " TEXT," + EVENT_SPECIALITEMS + " TEXT )";
        String CREATE_TABLE_H = "CREATE TABLE " + TABLE_HALL + "(" + HALL_NAME + " TEXT PRIMARY KEY NOT NULL,"
                + HALL_CAPACITY + " TEXT)";

        String CREATE_TABLE_S = "CREATE TABLE " + TABLE_STAFF + "(" + EVENT_NAME + " TEXT," + KEY_ID + " TEXT )";

                sqLiteDatabase.execSQL(CREATE_TABLE_Q);
                sqLiteDatabase.execSQL(CREATE_TABLE_R);
                sqLiteDatabase.execSQL(CREATE_TABLE_H);
                sqLiteDatabase.execSQL(CREATE_TABLE_S);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME1);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_HALL);
        onCreate(sqLiteDatabase);
    }

    @Override
    public void onDowngrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME1);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_HALL);

        onCreate(sqLiteDatabase);
    }

    public Vector<EventModel> getReservedEvents(){
        SQLiteDatabase db = this.getWritableDatabase();
        Vector<EventModel> ReservedList = new Vector<>();
        String query = "SELECT " + EVENT_DATE + ", " + EVENT_DURATION + ", " + EVENT_TIMEOFEVENT + ", " + " EVENT_HALLNAME " + " from " + TABLE_NAME1 + " WHERE "
                + EVENT_RESERVED + "='yes'";
        Cursor cursor = db.rawQuery(query,null);

        System.out.println(query);

        while (cursor.moveToNext()){
            String dateP = cursor.getString(cursor.getColumnIndex(EVENT_DATE));
            int hours = Integer.parseInt(cursor.getString(cursor.getColumnIndex(EVENT_DURATION)));
            int StartTime = Integer.parseInt(cursor.getString(cursor.getColumnIndex(EVENT_TIMEOFEVENT)));
            String Hallname = cursor.getString(cursor.getColumnIndex(EVENT_HALLNAME));

            String [] date = dateP.split("/");
            int year = Integer.parseInt(date[2]);
            int month = Integer.parseInt(date[0]);
            int day = Integer.parseInt(date[1]);
            long intDate = 1000000*year + 10000*month + 100*day + StartTime;
            long maxDate = intDate + hours;
            while (maxDate > intDate){
                EventModel event = new EventModel();
                event.setDate(String.valueOf(intDate));
                event.setHallName(Hallname);
                ReservedList.add(event);
                intDate++;
            }
        }
        System.out.println("HERERE: "+ ReservedList.size());
        return ReservedList;
    }

    public Vector<HallModel> getAllHalls(){

        SQLiteDatabase db = this.getWritableDatabase();
        Vector<HallModel> hallList = new Vector<>();
        String query = "SELECT * from " + TABLE_HALL;
        Cursor cursor = db.rawQuery(query,null);

        while (cursor.moveToNext()){
            HallModel hall = new HallModel();
            hall.setHallName(cursor.getString(cursor.getColumnIndex(HALL_NAME)));
            hall.setHallCapacity(cursor.getString(cursor.getColumnIndex(HALL_CAPACITY)));
            //hall.setHallBuiling(cursor.getString(cursor.getColumnIndex(HALL_BUILDING)));
            //hall.setHallFloor(cursor.getString(cursor.getColumnIndex(HALL_FLOOR)));

            hallList.add(hall);
        }

        return hallList;
    }

    public void addNewHall(HallModel hall) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(HALL_NAME, hall.getHallName());
        //values.put(HALL_BUILDING, hall.getHallBuiling());
        values.put(HALL_CAPACITY, hall.getHallCapacity());
        //values.put(HALL_FLOOR, hall.getHallFloor());

        db.insert(TABLE_HALL, null, values);
        db.close();
    }

    public void approveSelectedUserrequest(String eventName){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE event_data SET event_reserved='yes' WHERE event_name=\"" + eventName + "\"");
    }


    public void cancelSelectedCatererEvent(String eventName){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE event_data SET event_reserved='no' WHERE event_name=\"" + eventName + "\"");
    }

    public void cancelSelectedUserEvent(String eventName){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM event_data WHERE event_name=\"" + eventName + "\"");

    }

    public void addResources(String eventName, String FoodVenue, String MealTypeText, String DrinkTypeText, String entertainmentItemsText) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE event_data SET event_specialItems=\"" + entertainmentItemsText + "\"," +
                " event_foodType=\"" + FoodVenue + "\", " +
                "event_mealType=\"" + MealTypeText + "\" WHERE event_name=\"" + eventName + "\"");


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

    public void AddStaffToEvent(String StaffID, String EventName) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(EVENT_NAME, EventName);
        values.put(KEY_ID, StaffID);
        db.insert(TABLE_STAFF, null, values);
        db.close();
    }

    public void addNewEvent(EventModel event) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(EVENT_NAME, event.getEventName());
        values.put(EVENT_FNAME, event.getFirstName());
        values.put(EVENT_LNAME, event.getLastName());
        values.put(EVENT_DATE, event.getDate());
        values.put(EVENT_TIMEOFEVENT, event.getTimeOfEvent());
        values.put(EVENT_DURATION, event.getDuration());
        values.put(EVENT_HALLNAME, event.getHallName());
        values.put(EVENT_ATTENDEES, event.getAttendees());
        values.put(EVENT_FOODTYPE, event.getFoodType());
        values.put(EVENT_FORMALITY, event.getFormality());
        values.put(EVENT_MEALTYPE, event.getMealType());
        values.put(EVENT_RESERVED, event.getReserved());
        values.put(EVENT_SPECIALITEMS, event.getSpecialItems());
        db.insert(TABLE_NAME1, null, values);
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

    public EventModel retrieveEvent(String firstName) {
        //not working right now, trying to debug will try again after work
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * from " + TABLE_NAME1 + " WHERE " + EVENT_FNAME + " = \""
                + firstName + "\";";
        Cursor cursor = db.rawQuery(query, null);

        EventModel event = new EventModel();
        if (cursor.moveToFirst()) {
            event.setEventName(cursor.getString(cursor.getColumnIndex(EVENT_NAME)));
            event.setFirstName(cursor.getString(cursor.getColumnIndex(EVENT_FNAME)));
            event.setLastName(cursor.getString(cursor.getColumnIndex(EVENT_LNAME)));
            event.setDate(cursor.getString(cursor.getColumnIndex(EVENT_DATE)));
            event.setDuration(cursor.getString(cursor.getColumnIndex(EVENT_DURATION)));
            event.setTimeOfEvent(cursor.getString(cursor.getColumnIndex(EVENT_TIMEOFEVENT)));
            event.setHallName(cursor.getString(cursor.getColumnIndex(EVENT_HALLNAME)));
            event.setAttendees(cursor.getString(cursor.getColumnIndex(EVENT_ATTENDEES)));
            event.setFoodType(cursor.getString(cursor.getColumnIndex(EVENT_FOODTYPE)));
            event.setFormality(cursor.getString(cursor.getColumnIndex(EVENT_FORMALITY)));
            event.setMealType(cursor.getString(cursor.getColumnIndex(EVENT_MEALTYPE)));
            event.setReserved(cursor.getString(cursor.getColumnIndex(EVENT_RESERVED)));
            event.setSpecialItems(cursor.getString(cursor.getColumnIndex(EVENT_SPECIALITEMS)));
        } else
            event = null;
        return event;
    }

    public Cursor retrieveAllEventsByFullName(String firstName) {//tried doing this not working i think
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME1 + " WHERE " + EVENT_FNAME + " = \""
                + firstName + "\";", null);
        return res;
    }

    public Vector<EventModel> getAllEvents() {

        SQLiteDatabase db = this.getWritableDatabase();
        Vector<EventModel> eventList = new Vector<>();
        String query = "SELECT * from " + TABLE_NAME1;
        Cursor cursor = db.rawQuery(query, null);

        while (cursor.moveToNext()){
            EventModel event = new EventModel();
            event.setEventName(cursor.getString(cursor.getColumnIndex(EVENT_NAME)));
            event.setFirstName(cursor.getString(cursor.getColumnIndex(EVENT_FNAME)));
            event.setLastName(cursor.getString(cursor.getColumnIndex(EVENT_LNAME)));
            event.setDate(cursor.getString(cursor.getColumnIndex(EVENT_DATE)));
            event.setDuration(cursor.getString(cursor.getColumnIndex(EVENT_DURATION)));
            event.setTimeOfEvent(cursor.getString(cursor.getColumnIndex(EVENT_TIMEOFEVENT)));
            event.setHallName(cursor.getString(cursor.getColumnIndex(EVENT_HALLNAME)));
            event.setAttendees(cursor.getString(cursor.getColumnIndex(EVENT_ATTENDEES)));
            event.setFoodType(cursor.getString(cursor.getColumnIndex(EVENT_FOODTYPE)));
            event.setFormality(cursor.getString(cursor.getColumnIndex(EVENT_FORMALITY)));
            event.setMealType(cursor.getString(cursor.getColumnIndex(EVENT_MEALTYPE)));
            event.setReserved(cursor.getString(cursor.getColumnIndex(EVENT_RESERVED)));
            event.setSpecialItems(cursor.getString(cursor.getColumnIndex(EVENT_SPECIALITEMS)));
            eventList.add(event);
        }
        return eventList;
    }

    public Vector<UserModel> getAllStaff() {

        SQLiteDatabase db = this.getWritableDatabase();
        Vector<UserModel> StaffList = new Vector<>();
        String query = "SELECT * from " + TABLE_NAME + " WHERE " + KEY_USERTYPE + "='Staff';";
        Cursor cursor = db.rawQuery(query, null);

        while (cursor.moveToNext()) {
            UserModel model = new UserModel();
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
            StaffList.add(model);
        }
        return StaffList;

    }
}