package br.com.digitalhouse.staruniverse.cadastro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import br.com.digitalhouse.staruniverse.R;
import br.com.digitalhouse.staruniverse.login.LoginActivity;

public class Gmail extends AppCompatActivity {

    private Button buttonBackGmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gmail);

        buttonBackGmail = findViewById(R.id.btnBackGmail);

        buttonBackGmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Gmail.this, LoginActivity.class));

            }
        });

    }

}
