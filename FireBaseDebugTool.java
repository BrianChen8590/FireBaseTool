package com.brian.firebase.database;

import android.content.Context;
import android.os.Bundle;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crash.FirebaseCrash;

/**
 * Anayltics
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
 *     compile 'com.google.firebase:firebase-crash:9.2.0'
 * }
 *
 * Created by BluePC on 2016/8/25.
 */

public class FireBaseDebugTool {

    /**
     * You can send bug message by the method
     * @param excetptionMessage
     */
    public static void anayEvent(String excetptionMessage) {
        FirebaseCrash.log(excetptionMessage);
    }

}
