package com.yozzibeens.gobus.modelo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Antonio on 30/05/2017.
 */

public class goBusDB {
    private AtomicInteger mOpenCounter = new AtomicInteger();

    private static goBusDB instance;
    private static DaoMaster.DevOpenHelper mDatabaseHelper;
    private SQLiteDatabase mDatabase;
    private DaoSession daoSession;

    public static synchronized void initializeInstance() {
        if (instance == null) {
            instance = new goBusDB();
        }
    }

    public static synchronized goBusDB getInstance() {
        if (instance == null) {
            throw new IllegalStateException(goBusDB.class.getSimpleName() +
                    " is not initialized, call initializeInstance(..) method first.");
        }
        return instance;
    }

    public synchronized DaoSession getSession()
    {
        DaoMaster daoMaster = new DaoMaster(mDatabase);
        daoSession = daoMaster.newSession();
        return daoSession;
    }

    public synchronized DaoSession openDatabase(Context context) {
        if(mOpenCounter.incrementAndGet() == 1) {
            // Opening new database
            mDatabaseHelper = new DaoMaster.DevOpenHelper(context, "GoBus-db", null);
            mDatabase = mDatabaseHelper.getWritableDatabase();
            DaoMaster daoMaster = new DaoMaster(mDatabase);
            daoSession = daoMaster.newSession();
        }
        return daoSession;
    }

    public synchronized void closeDatabase() {
        if(mOpenCounter.decrementAndGet() == 0) {
            // Closing database
            mDatabase.close();
            daoSession.clear();

        }
    }
}
