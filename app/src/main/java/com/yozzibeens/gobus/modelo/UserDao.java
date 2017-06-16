package com.yozzibeens.gobus.modelo;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

/**
 * Created by Antonio on 30/05/2017.
 */

public class UserDao extends AbstractDao<User, Long> {

    public static final String TABLENAME = "USER";

    /**
     * Properties of entity User.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property User_Id = new Property(1, String.class, "User_Id", false, "USER__ID");
        public final static Property Name = new Property(2, String.class, "Name", false, "NAME");
        public final static Property Email = new Property(3, String.class, "Email", false, "EMAIL");
    }

    public UserDao(DaoConfig config) {
        super(config);
    }

    public UserDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'USER' (" + //
                "'_id' INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "'USER__ID' TEXT," + // 1: User_Id
                "'NAME' TEXT," + // 2: Name
                "'EMAIL' TEXT,");// 3: Email
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'USER'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, User entity) {
        stmt.clearBindings();

        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }

        String Cabbie_Id = entity.getUser_Id();
        if (Cabbie_Id != null) {
            stmt.bindString(2, Cabbie_Id);
        }

        String Name = entity.getUser_Name();
        if (Name != null) {
            stmt.bindString(3, Name);
        }

        String Email = entity.getUser_Email();
        if (Email != null) {
            stmt.bindString(4, Email);
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }

    /** @inheritdoc */
    @Override
    public User readEntity(Cursor cursor, int offset) {
        User entity = new User( //
                cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
                cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // User_Id
                cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // Name
                cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3) // Email
        );
        return entity;
    }

    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, User entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setUser_Id(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setUser_Name(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setUser_Email(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
    }

    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(User entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }

    /** @inheritdoc */
    @Override
    public Long getKey(User entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override
    protected boolean isEntityUpdateable() {
        return true;
    }

}
