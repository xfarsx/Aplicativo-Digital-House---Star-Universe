package br.com.digitalhouse.staruniverse.cadastro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.com.digitalhouse.staruniverse.R;
import br.com.digitalhouse.staruniverse.login.LoginActivity;

public class FacebookActivity extends AppCompatActivity {

    private Button buttonBackFacebook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facebook);

        buttonBackFacebook = findViewById(R.id.btnBackGmail);

        buttonBackFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(FacebookActivity.this, LoginActivity.class));

            }
        });
    }
}
