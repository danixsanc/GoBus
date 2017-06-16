package com.yozzibeens.gobus.controlador;

import android.content.Context;
import android.util.Log;

import com.yozzibeens.gobus.modelo.DaoSession;
import com.yozzibeens.gobus.modelo.User;
import com.yozzibeens.gobus.modelo.UserDao;
import com.yozzibeens.gobus.modelo.goBusDB;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Antonio on 30/05/2017.
 */

public class UserController {

    private static final String TAG = "User";
    private Context context;

    public UserController(Context prContext){
        this.context = prContext;
    }

    public boolean guardarUser(User prUser){
        try {
            DaoSession oGoBusDB = goBusDB.getInstance().openDatabase(context);
            UserDao oUserDao = oGoBusDB.getUserDao();
            oUserDao.insert(prUser);
            return true;
        }
        catch (Exception error){
            Log.e(TAG, error.getMessage());
            return false;
        }
        finally {
            goBusDB.getInstance().closeDatabase();
        }
    }

    public boolean guardarOActualizarUser(User prCabbie){
        try {
            DaoSession oGoBusDB = goBusDB.getInstance().openDatabase(context);
            UserDao oUserDao = oGoBusDB.getUserDao();
            oUserDao.insertOrReplace(prCabbie);
            return true;
        }
        catch (Exception error){
            Log.e(TAG, error.getMessage());
            return false;
        }
        finally {
            goBusDB.getInstance().closeDatabase();
        }
    }

    public boolean guardarOActualizarUser(ArrayList<User> prCabbies){
        try {
            DaoSession oGoBusDB = goBusDB.getInstance().openDatabase(context);
            UserDao oUserDao = oGoBusDB.getUserDao();
            oUserDao.insertOrReplaceInTx(prCabbies);
            return true;
        }
        catch (Exception error){
            Log.e(TAG, error.getMessage());
            return false;
        }
        finally {
            goBusDB.getInstance().closeDatabase();
        }
    }

    public boolean eliminarUser(User prCabbie){
        try {
            DaoSession oGoBusDB = goBusDB.getInstance().openDatabase(context);
            UserDao oUserDao = oGoBusDB.getUserDao();
            oUserDao.delete(prCabbie);
            return true;
        }
        catch (Exception error){
            Log.e(TAG, error.getMessage());
            return false;
        }
        finally {
            goBusDB.getInstance().closeDatabase();
        }
    }

    public boolean eliminarTodo(){
        try {
            DaoSession oGoBusDB = goBusDB.getInstance().openDatabase(context);
            UserDao oUserDao = oGoBusDB.getUserDao();
            oUserDao.deleteAll();
            return true;
        }
        catch (Exception error){
            Log.e(TAG, error.getMessage());
            return false;
        }
        finally {
            goBusDB.getInstance().closeDatabase();
        }
    }

    public List<User> obtenerUser(){
        try {
            DaoSession oGoBusDB = goBusDB.getInstance().openDatabase(context);
            UserDao oUserDao = oGoBusDB.getUserDao();
            return oUserDao.loadAll();
        }
        catch (Exception error){
            Log.e(TAG, error.getMessage());
            return null;
        }
        finally {
            goBusDB.getInstance().closeDatabase();
        }
    }

    public User obtenerUser(Long prKey){
        try {
            DaoSession oGoBusDB = goBusDB.getInstance().openDatabase(context);
            UserDao oUserDao = oGoBusDB.getUserDao();
            return oUserDao.load(prKey);
        }
        catch (Exception error){
            Log.e(TAG, error.getMessage());
            return null;
        }
        finally {
            goBusDB.getInstance().closeDatabase();
        }
    }

    public User obtenerUserPorUserId(String userId){
        try {
            DaoSession oGoBusDB = goBusDB.getInstance().openDatabase(context);
            UserDao oUserDao = oGoBusDB.getUserDao();

            return oUserDao.queryBuilder().where(UserDao.Properties.User_Id.eq(userId)).unique();
        }
        catch (Exception error){
            Log.e(TAG, error.getMessage());
            return null;
        }
        finally {
            goBusDB.getInstance().closeDatabase();
        }
    }
}
