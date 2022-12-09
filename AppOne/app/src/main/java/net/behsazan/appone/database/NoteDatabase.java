package net.behsazan.appone.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class NoteDatabase extends SQLiteOpenHelper {
    private static  final String DB_NAME="Note.db";
    public static  final String TABLE_NOTE="tbl_note";
    private static  final int VERSION=1;
    public static  final String KEY_ID="id";
    public static  final String KEY_TITLE="title";
    public static  final String KEY_DESCRIPTION="description";
    public static  final String KEY_DATE_NOTE="dateNote";
    public static  final String KEY_TIME_NOTE="timeNote";
    public static final String KEY_TYPE="type";

    public NoteDatabase(@Nullable Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "create table "+TABLE_NOTE+"("+KEY_ID+" Integer PRIMARY KEY AUTOINCREMENT,"+KEY_TITLE+" varchar(100) ," +
                " "+KEY_DESCRIPTION+" Text , "+KEY_DATE_NOTE+" varchar(50) ,  "+KEY_TIME_NOTE+" varchar(50) ,"+KEY_TYPE+" Integer)";

        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
