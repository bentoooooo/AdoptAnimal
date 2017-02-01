package pt.ipbeja.adoptanimal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bento on 31/01/2017.
 */

public class DBHelper extends SQLiteOpenHelper {

    //--------------------------------- TABLES ---------------------------------//
    private static final int I_ANIMALS = 0;
    private static final String[] TableNames = {
            "animals"
    };

    //--------------------------------- ANIMALS TABLE ---------------------------------//
    private static final String T_ANIMALS_ID = "_id_animal";
    private static final String T_ANIMALS_NAME = "name_animal";
    private static final String T_ANIMALS_CONTENT = "content_animal";
    private static final String T_ANIMALS_PHOTO = "photo_animal";
    private static final String T_ANIMALS_GPS = "gps_animal";
    private static final String T_ANIMALS_PHONE = "phone_animal";

    private static final String T_CREATE_ANIMALS =
            "CREATE TABLE " + TableNames[I_ANIMALS] + "(" +
                    T_ANIMALS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    T_ANIMALS_NAME + " TEXT , " +
                    T_ANIMALS_CONTENT + " TEXT, " +
                    T_ANIMALS_PHOTO + " TEXT , " +
                    T_ANIMALS_GPS + " TEXT , " +
                    T_ANIMALS_PHONE + " TEXT)";

    //--------------------------------- CREATE TABLES ---------------------------------//
    private static final String[] T_CREATE = {
            T_CREATE_ANIMALS};

    //-------------------------------------- END --------------------------------------//


    private static final String DB_FILENAME = "Animals.db";
    private static final int DB_VERSION = 9;
    private static final SQLiteDatabase.CursorFactory factory = null;

    public DBHelper(Context context) {
        super(context, DB_FILENAME, factory, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        for (String createTable : T_CREATE) {
            db.execSQL(createTable);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        for (String TableName : TableNames) {
            db.execSQL("DROP TABLE IF EXISTS " + TableName);
        }
        onCreate(db);
    }

    //--------------------------------- Animals ---------------------------------//

    public void insertAnimals(String name, String content, String photo, String gps, String phone) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(T_ANIMALS_NAME, name);
        contentValues.put(T_ANIMALS_CONTENT, content);
        contentValues.put(T_ANIMALS_PHOTO, photo);
        contentValues.put(T_ANIMALS_GPS, gps);
        contentValues.put(T_ANIMALS_PHONE, phone);

        db.insert(TableNames[I_ANIMALS], null, contentValues);
    }

    public List<String> getAllNames() {
        List<String> res = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT " + T_ANIMALS_NAME + " FROM " + TableNames[I_ANIMALS];

        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            do {
                String id = cursor.getString(cursor.getColumnIndex(T_ANIMALS_NAME));
                res.add(id);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return res;
    }

    public List<String> getAllContent() {
        List<String> res = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT " + T_ANIMALS_CONTENT + " FROM " + TableNames[I_ANIMALS];

        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            do {
                String id = cursor.getString(cursor.getColumnIndex(T_ANIMALS_CONTENT));
                res.add(id);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return res;
    }

    public List<String> getAllPhoto() {
        List<String> res = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT " + T_ANIMALS_PHOTO + " FROM " + TableNames[I_ANIMALS];

        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            do {
                String id = cursor.getString(cursor.getColumnIndex(T_ANIMALS_PHOTO));
                res.add(id);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return res;
    }

    public List<String> getAllGPS() {
        List<String> res = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT " + T_ANIMALS_GPS + " FROM " + TableNames[I_ANIMALS];

        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            do {
                String id = cursor.getString(cursor.getColumnIndex(T_ANIMALS_GPS));
                res.add(id);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return res;
    }

    public List<String> getAllPhone() {
        List<String> res = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT " + T_ANIMALS_PHONE + " FROM " + TableNames[I_ANIMALS];

        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            do {
                String id = cursor.getString(cursor.getColumnIndex(T_ANIMALS_PHONE));
                res.add(id);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return res;
    }
}