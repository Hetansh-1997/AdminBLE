package com.example.hetanshshah.adminble.database;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.widget.Toast;

import static com.example.hetanshshah.adminble.database.Constants.*;

public class userContentProvider extends ContentProvider {
    private static final int CODE_USER = 1;
    private MyDbHelper help;
    private SQLiteDatabase database;
    private UriMatcher matches;
    public boolean  onCreate(){
        help = new MyDbHelper(getContext());
        database = help.getWritableDatabase();
        matches = new UriMatcher(UriMatcher.NO_MATCH);
        matches.addURI(AUTHORITY, PATH_PRODUCT, CODE_USER);
        return false;
    }
    public Cursor query (Uri uri,String[] projection,String selection,String[] selectionArgs,String sortOrder){
        if(uri.getAuthority()==null){}else{
            int code=matches.match(uri);
            Cursor cursor=null;
            if(code == CODE_USER){
                cursor = database.query(TABLE_PRODUCT,projection,selection,null,null,null,null);
            }
            return cursor;
        }
        return null;
    }
    public String getType(Uri uri){
        return null;
    }
    public Uri insert(Uri uri,ContentValues values){
        int code=matches.match(uri);
        if(code == CODE_USER){
            database.insert(TABLE_PRODUCT,null,values);
        }
        return null;
    }
    public int delete(Uri uri,String where,String[] whereargs){
        int code =matches.match(uri);
        int delete  = 0;
        if(code == CODE_USER){
            delete = database.delete(TABLE_PRODUCT,where,whereargs);
        }
        return delete;
    }
    public int update(Uri uri,ContentValues values,String selection , String[] selectionArgs){
        int code= matches.match(uri);
        int row= 0;
        if(code == CODE_USER){
            row = database.update(TABLE_PRODUCT,values,selection,selectionArgs);
            Toast.makeText(getContext(), ""+row, Toast.LENGTH_SHORT).show();
        }
        return row;
    }
}
