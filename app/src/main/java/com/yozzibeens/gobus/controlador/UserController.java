package com.yozzibeens.gobus.controlador;

import android.content.Context;
import android.util.Log;

import com.yozzibeens.gobus.modelo.User;
import com.yozzibeens.gobus.modelo.UserDao;
import com.yozzibeens.gobus.modelo.DaoSession;
import com.yozzibeens.gobus.modelo.GoBusDB;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by savidsalazar
 */
public class UserController {

    private static final String TAG = "User";

    private Context context;

    public UserController(Context prContext){
        this.context = prContext;
    }

    public boolean guardarUser(User prUser){
        try {
            DaoSession oGoBusDB = GoBusDB.getInstance().openDatabase(context);
            UserDao oUserDao = oGoBusDB.getUserDao();
            oUserDao.insert(prUser);
            return true;
        }
        catch (Exception error){
            Log.e(TAG, error.getMessage());
            return false;
        }
        finally {
            GoBusDB.getInstance().closeDatabase();
        }
    }
    
    public boolean guardarOActualizarUser(User prUser){
        try {
            DaoSession oGoBusDB = GoBusDB.getInstance().openDatabase(context);
            UserDao oUserDao = oGoBusDB.getUserDao();
            oUserDao.insertOrReplace(prUser);
            return true;
        }
        catch (Exception error){
            Log.e(TAG, error.getMessage());
            return false;
        }
        finally {
            GoBusDB.getInstance().closeDatabase();
        }
    }

    public boolean guardarOActualizarUser(ArrayList<User> prUsers){
        try {
            DaoSession oGoBusDB = GoBusDB.getInstance().openDatabase(context);
            UserDao oUserDao = oGoBusDB.getUserDao();
            oUserDao.insertOrReplaceInTx(prUsers);
            return true;
        }
        catch (Exception error){
            Log.e(TAG, error.getMessage());
            return false;
        }
        finally {
            GoBusDB.getInstance().closeDatabase();
        }
    }

    public boolean eliminarUser(User prUser){
        try {
            DaoSession oGoBusDB = GoBusDB.getInstance().openDatabase(context);
            UserDao oUserDao = oGoBusDB.getUserDao();
            oUserDao.delete(prUser);
            return true;
        }
        catch (Exception error){
            Log.e(TAG, error.getMessage());
            return false;
        }
        finally {
            GoBusDB.getInstance().closeDatabase();
        }
    }

    public boolean eliminarTodo(){
        try {
            DaoSession oGoBusDB = GoBusDB.getInstance().openDatabase(context);
            UserDao oUserDao = oGoBusDB.getUserDao();
            oUserDao.deleteAll();
            return true;
        }
        catch (Exception error){
            Log.e(TAG, error.getMessage());
            return false;
        }
        finally {
            GoBusDB.getInstance().closeDatabase();
        }
    }

    public List<User> obtenerUser(){
        try {
            DaoSession oGoBusDB = GoBusDB.getInstance().openDatabase(context);
            UserDao oUserDao = oGoBusDB.getUserDao();
            return oUserDao.loadAll();
        }
        catch (Exception error){
            Log.e(TAG, error.getMessage());
            return null;
        }
        finally {
           GoBusDB.getInstance().closeDatabase();
        }
    }

    public User obtenerUser(Long prKey){
        try {
            DaoSession oGoBusDB = GoBusDB.getInstance().openDatabase(context);
            UserDao oUserDao = oGoBusDB.getUserDao();
            return oUserDao.load(prKey);
        }
        catch (Exception error){
            Log.e(TAG, error.getMessage());
            return null;
        }
        finally {
            GoBusDB.getInstance().closeDatabase();
        }
    }
}