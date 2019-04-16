package com.example.stalkermode;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "stalkermode.db";
    public static final String ID = "ID";
    public static final String BLOEGROEP = "Bloedgroep";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table bloedgroep " + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, Bloedgroep TEXT) ");
        db.execSQL("create table land " + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, Land TEXT) ");
        db.execSQL("create table geslacht " + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, Geslacht TEXT) ");
        db.execSQL("create table seksuele_geaardheid " + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, Geaardheid TEXT) ");
        db.execSQL("create table lievelingskleur " + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, Lievelingskleur TEXT) ");
        db.execSQL("create table user " + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, Voornaam TEXT," +
                " Tussenvoeglse TEXT," +
                " Achternaam TEXT," +
                " email TEXT," +
                " Telefoonnummer TEXT," +
                " Land INT," +
                " Stad TEXT," +
                " Straat TEXT," +
                " Postcode TEXT," +
                " Huisnummer INT," +
                " Bloedgroep INT," +
                " Lievelingskleur INT," +
                " Geslacht INT," +
                " Gehuwd BOOLEAN," +
                " Kinderen INT," +
                " Seksuele_geaardheid INT," +
                " Brommerrijbewijs BOOLEAN," +
                " Motorrijwijs BOOLEAN," +
                " BSNNummer TEXT," +
                " Lengte FLOAT," +
                " Gewicht FLOAT," +
                " Facebook TEXT," +
                " Twitter TEXT," +
                " Discord TEXT," +
                " Snapchat TEXT," +
                " Instagram TEXT," +
                " Linkedin TEXT," +
                "FOREIGN KEY (Land) REFERENCES land(ID)," +
                "FOREIGN KEY (Bloedgroep) REFERENCES bloedgroep(ID)," +
                "FOREIGN KEY (Lievelingskleur) REFERENCES lievelingskleur(ID)," +
                "FOREIGN KEY (Geslacht) REFERENCES geslacht(id)," +
                "FOREIGN KEY (Seksuele_geaardheid) REFERENCES seksuele_geaardheid(ID)) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }
}
