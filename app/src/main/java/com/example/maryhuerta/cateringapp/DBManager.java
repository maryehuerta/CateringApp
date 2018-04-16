package com.example.maryhuerta.cateringapp;

/**
 * Created by gustavojimenez on 4/16/18.
 */

class DBManager {
    private static final DBManager ourInstance = new DBManager();

    static DBManager getInstance() {
        return ourInstance;
    }

    private DBManager() {
    }
}
