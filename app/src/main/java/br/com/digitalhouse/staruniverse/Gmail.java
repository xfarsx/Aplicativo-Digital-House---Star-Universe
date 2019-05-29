package br.com.digitalhouse.staruniverse;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Gmail extends AppCompatActivity {

    private Button buttonBackGmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_gmail);

        buttonBackGmail = findViewById(R.id.btnBackGmail);

        buttonBackGmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Gmail.this,MainActivity.class));

            }
        });

    }

}
