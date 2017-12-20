package com.whatsappandroid.viniciusnunes.joiceapp.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Vinicius Nunes on 15/12/2017.
 */

public class DatabaseAdapter extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 2;
    protected static final String DATABASE_NAME = "JoiceApp.db";

    public DatabaseAdapter(Context context) {
        super(context, DATABASE_NAME , null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sqlUsuario = "CREATE TABLE usuario " +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nome TEXT, " +
                "telefone TEXT, " +
                "senha TEXT, tipoLogin TEXT ) ";

        db.execSQL(sqlUsuario);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String sqlUsuario = "DROP TABLE IF EXISTS usuario";
        db.execSQL(sqlUsuario);
        onCreate(db);
    }
}

