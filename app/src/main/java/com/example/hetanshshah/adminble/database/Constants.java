package com.example.hetanshshah.adminble.database;

import android.net.Uri;

public class Constants {
    //these are very important.every database should have this
    public static final String CONTENT_PROTOCOL= "content://";
    public static final String AUTHORITY= "com.example.hetanshshah.adminble";
    public static final String PATH_PRODUCT= "_productdata";
    public static final String TABLE_PRODUCT= "tbl_user";

    //columns of table
    /**public static  String USERNAME= "userName";**/
    public static  String PRODUCT_NAME= "product_name";
    public static  String PRODUCT_DETAILS= "product_details";
    public static  String BEACON_ID= "beacons_id";

    //uri
    public static final Uri CONTENT_PRODUCT = Uri.parse(CONTENT_PROTOCOL+AUTHORITY+"/"+PATH_PRODUCT);

}
