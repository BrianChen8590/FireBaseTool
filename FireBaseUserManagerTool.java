package com.brian.firebase.database;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

/**
 * User
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
 *     compile 'com.google.firebase:firebase-auth:9.2.0'
 * }
 *
 * Created by BluePC on 2016/8/25.
 */

public class FireBaseUserManagerTool {

    private FirebaseAuth mFirebaseAuth;

    FireBaseUserManagerTool() {
        mFirebaseAuth = FirebaseAuth.getInstance();
    }

    public void RegisterUser(String email, String password
            , OnCompleteListener<AuthResult> completeListener) {
        mFirebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(completeListener);
    }

    /**
     * onStart
     * @param authStateListener
     */
    public void addUserState(FirebaseAuth.AuthStateListener authStateListener) {
        mFirebaseAuth.addAuthStateListener(authStateListener);
    }

    /**
     * onStop
     * @param authStateListener
     */
    public void removeUserState(FirebaseAuth.AuthStateListener authStateListener) {
        if (authStateListener != null) {
            mFirebaseAuth.removeAuthStateListener(authStateListener);
        }
    }

    /**
     * user logout
     */
    public void logout() {
        mFirebaseAuth.signOut();
    }

}
