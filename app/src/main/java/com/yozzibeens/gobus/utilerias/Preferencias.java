package com.yozzibeens.gobus.utilerias;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Antonio on 04/11/2016.
 */
public class Preferencias {

    private final String SHARED_PREFS_FILE = "HMPrefs";
    private final String TUTORIAL = "tutorial";
    private final String SESION = "sesion";
    private final String USERID = "userid";
    private final String GCMID = "gcmid";

    public int s;
    private Context mContext;

    public Preferencias(Context context){
        mContext = context;
    }

    private SharedPreferences getSettings(){
        return mContext.getSharedPreferences(SHARED_PREFS_FILE, 0);
    }

    public void setTutorial(boolean prSave){
        SharedPreferences.Editor editor = getSettings().edit();
        editor.putBoolean(TUTORIAL, prSave);
        editor.commit();
    }

    public boolean getTutorial() {
        return getSettings().getBoolean(TUTORIAL, true);
    }

    public void setSesion(boolean prSave2){
        SharedPreferences.Editor editor = getSettings().edit();
        editor.putBoolean(SESION, prSave2);
        editor.commit();
    }

    public boolean getSesion(){
        return getSettings().getBoolean(SESION, true);
    }

    public String getUser_Id(){
        return getSettings().getString(USERID, USERID);
    }

    public void setUser_Id(String prSave){
        SharedPreferences.Editor editor = getSettings().edit();
        editor.putString(USERID, prSave);
        editor.commit();
    }


    public String getGcm_Id(){
        return getSettings().getString(GCMID, GCMID);
    }

    public void setGcm_Id(String prSave){
        SharedPreferences.Editor editor = getSettings().edit();
        editor.putString(GCMID, prSave);
        editor.commit();
    }

}
