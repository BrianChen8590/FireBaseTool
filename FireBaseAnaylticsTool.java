package com.brian.firebase.database;

import android.content.Context;
import android.os.Bundle;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

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
 *
 * Created by BluePC on 2016/8/25.
 */

public class FireBaseAnaylticsTool {

    private FirebaseAnalytics mFirebaseAnalytics;

    /**
     * Init
     * @param context
     */
    public FireBaseAnaylticsTool(Context context) {
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(context);
    }

    /**
     * send event
     *
     * FirebaseAnalytics.Param :
     * https://firebase.google.com/docs/reference/android/com/google/firebase/analytics/FirebaseAnalytics.Param
     *
     * FirebaseAnalytics.Event
     * https://firebase.google.com/docs/reference/android/com/google/firebase/analytics/FirebaseAnalytics.Event
     *
     * you can change send type and value
     * @param id
     * @param name
     * @param type
     */
    public void anayEvent(String id, String name, String type) {
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, id);
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, name);
        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, type);
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
    }

}
