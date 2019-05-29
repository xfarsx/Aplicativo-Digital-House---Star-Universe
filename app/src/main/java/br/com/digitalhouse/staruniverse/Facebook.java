package br.com.digitalhouse.staruniverse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Facebook extends AppCompatActivity {

    private Button buttonBackFacebook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facebook);

        buttonBackFacebook = findViewById(R.id.btnBackGmail);

        buttonBackFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Facebook.this,MainActivity.class));

            }
        });
    }
}