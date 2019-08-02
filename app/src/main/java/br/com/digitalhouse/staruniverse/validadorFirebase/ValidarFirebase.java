package br.com.digitalhouse.staruniverse.validadorFirebase;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ValidarFirebase {

    private static DatabaseReference referenceFirebase;
    private static FirebaseAuth auth;

    public static DatabaseReference getFirebase() {

        if (referenceFirebase == null) {

            referenceFirebase = FirebaseDatabase.getInstance().getReference();
        }

        return referenceFirebase;
    }

    public static FirebaseAuth getFirebaseAuth() {

        if (auth == null) {
            auth = FirebaseAuth.getInstance();
        }
        return auth;

    }

}

