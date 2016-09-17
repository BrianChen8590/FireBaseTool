package com.brian.firebase.database;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * DataBase
 *
 * 1 . google-services
 * build.gradle {
 *     classpath 'com.google.gms:google-services:3.0.0'
 * }
 *
 * 2 . firebase core
 * app -> build.gradle
 * apply plugin: 'com.google.gms.google-services'
 * build.gradle{
 *     compile 'com.google.firebase:firebase-core:9.2.0'
 * }
 *
 * 3 . firebase database
 * build.gradle{
 *     compile 'com.google.firebase:firebase-database:9.2.0'
 * }
 *
 * Created by BluePC on 2016/8/25.
 */

public class FireBaseDataBaseTool {

    /**
     * retrive data method
     * if has mulit down , will write A/A'/A''
     * @param columnName
     * @param valueEventListener
     */
    public static void RetrieveDate(String columnName, ValueEventListener valueEventListener) {
        if(columnName != null) {
            FirebaseDatabase mFireBaseDatabase = FirebaseDatabase.getInstance();
            DatabaseReference databaseReference = mFireBaseDatabase.getReference(columnName);
            databaseReference.addValueEventListener(valueEventListener);
        }

    }

    /**
     * save data method
     * if has mulit down , will write A/A'/A''
     * @param columnName
     * @param value
     */
    public static void SaveDate(String columnName, String value) {
        if(columnName != null) {
            FirebaseDatabase mFireBaseDatabase = FirebaseDatabase.getInstance();
            DatabaseReference databaseReference = mFireBaseDatabase.getReference(columnName);
            databaseReference.child(columnName).setValue(value);
        }
    }

}
