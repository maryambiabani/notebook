package net.behsazan.appone.database;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import net.behsazan.appone.model.Note;

import java.util.ArrayList;
import java.util.List;

public class NoteDBAdapter extends NoteDatabase{
    public NoteDBAdapter(@Nullable Context context) {
        super(context);
    }
    //insert
    public long insert(Note note) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NoteDatabase.KEY_TITLE, note.getTitle());
        contentValues.put(NoteDatabase.KEY_DESCRIPTION, note.getDescription());
        contentValues.put(NoteDatabase.KEY_DATE_NOTE, note.getDate());
        contentValues.put(NoteDatabase.KEY_TIME_NOTE, note.getTime());
        contentValues.put(NoteDatabase.KEY_TYPE,note.getType());

        return db.insert(NoteDatabase.TABLE_NOTE, null, contentValues);


    }

    @SuppressLint("Range")
    public List<Note> getNotesList() {

        SQLiteDatabase db = getReadableDatabase();
        List<Note> noteList = new ArrayList<>();

        Cursor cursor = db.rawQuery("select * from " + NoteDatabase.TABLE_NOTE+ " where "+NoteDatabase.KEY_TYPE+ " = ? " , new String[]{String.valueOf(1)});
        while (cursor.moveToNext()) {
            Note note = new Note();
            note.setTitle(cursor.getString(cursor.getColumnIndex(NoteDatabase.KEY_TITLE)));
            note.setId(cursor.getInt(0));
            note.setDate(cursor.getString(cursor.getColumnIndex(NoteDatabase.KEY_DATE_NOTE)));
            note.setTime(cursor.getString(cursor.getColumnIndex(NoteDatabase.KEY_TIME_NOTE)));
            note.setDescription(cursor.getString(cursor.getColumnIndex(NoteDatabase.KEY_DESCRIPTION)));
            note.setType(cursor.getInt(5));
            noteList.add(note);
        }

        return noteList;
    }
public List<Note> getToDoList(){
    return null;
}
    public List<Note> getDoingList(){
        return null;
    }
    public List<Note> getDoneList(){
        return null;
    }

    public int deleteAllNotes() {
        SQLiteDatabase db = getWritableDatabase();
        return db.delete(NoteDatabase.TABLE_NOTE, null, null);
    }

    public int deleteNoteById(int noteId) {

        SQLiteDatabase db = getWritableDatabase();
        return db.delete(NoteDatabase.TABLE_NOTE, "id=?",
                new String[]{String.valueOf(noteId)});
    }

}
