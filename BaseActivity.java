import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
* Created by BrianHome on 2016/9/15.
*/

public class BaseActivity extends AppCompatActivity{

   private FirebaseAuth mAuth;
   private DatabaseReference mDatabase;
   private final String TAG = "BaseActivity";
   private boolean hasAuth = false;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);

       mAuth = FirebaseAuth.getInstance();
       mDatabase = FirebaseDatabase.getInstance().getReference();
   }

   @Override
   public void onStart() {
       super.onStart();
       mAuth.addAuthStateListener(mAuthListener);
   }

   @Override
   public void onStop() {
       super.onStop();
       if (mAuthListener != null) {
           mAuth.removeAuthStateListener(mAuthListener);
       }
   }

   /**
    * Isn't user auth.
    * @return
    */
   public boolean isHasAuth() {
       return hasAuth;
   }

   /**
    * Create user.
    * @param account
    * @param password
    * @param completeListener
    */
   public void createUser(String account, String password, OnCompleteListener<AuthResult> completeListener) {
       mAuth.createUserWithEmailAndPassword(account, password).addOnCompleteListener(this, completeListener);

   }

   /**
    * User email and password login.
    * @param account
    * @param password
    * @param completeListener
    */
   public void userLogin(String account, String password, OnCompleteListener<AuthResult> completeListener) {
       mAuth.signInWithEmailAndPassword(account, password).addOnCompleteListener(this, completeListener);
   }

   /**
    * User signout.
    */
   public void userSignout() {
       FirebaseAuth.getInstance().signOut();
   }

   /**
    * Firebase database value event listener.
    * @param child
    * @param valueEventListener
    */
   public void dataBaseValueEvent(String child, ValueEventListener valueEventListener){
       mDatabase.child(child).addValueEventListener(valueEventListener);
   }

   /**
    * Firebase database child event listener.
    * @param child
    * @param childEventListener
    */
   public void dataBaseChildEvent(String child, ChildEventListener childEventListener){
       mDatabase.child(child).addChildEventListener(childEventListener);
   }

   FirebaseAuth.AuthStateListener mAuthListener = new FirebaseAuth.AuthStateListener() {
       @Override
       public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
           FirebaseUser user = firebaseAuth.getCurrentUser();
           if (user != null) {
               // User is signed in
               hasAuth = true;
               Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
           } else {
               // User is signed out
               hasAuth = false;
               Log.d(TAG, "onAuthStateChanged:signed_out");
           }
       }
   };

}