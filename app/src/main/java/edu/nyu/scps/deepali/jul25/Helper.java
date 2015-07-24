package edu.nyu.scps.deepali.jul25;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by 205263 on 7/24/15.
 */
public class Helper extends SQLiteOpenHelper  {

    public Helper(Context context, String databaseName) {
        super(context, databaseName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Java array of five Strings containing five SQLite statements.
        String[] statements = {
                "CREATE TABLE people ("
                        + "_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                        + "name TEXT"
                        + ");",

                "INSERT INTO people (_id, name) VALUES (NULL, 'Mark');",
                "INSERT INTO people (_id, name) VALUES (NULL, 'Asa');",
                "INSERT INTO people (_id, name) VALUES (NULL, 'Deepali');",
                "INSERT INTO people (_id, name) VALUES (NULL, 'Joe');"
        };

        for (String statement: statements) {
            db.execSQL(statement);
        }

}

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public Cursor getCursor() {
        SQLiteDatabase db = getReadableDatabase(); // the db passed to onCreate
        //can say "_id, name" instead of "*", but _id must be included.
        Cursor cursor = db.rawQuery("SELECT * FROM people ORDER BY name;", null);
        cursor.moveToFirst();
        return cursor;
    }
}
