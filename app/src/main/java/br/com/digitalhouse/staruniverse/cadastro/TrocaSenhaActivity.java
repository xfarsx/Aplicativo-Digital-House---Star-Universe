package br.com.digitalhouse.staruniverse.cadastro;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import br.com.digitalhouse.staruniverse.R;

public class TrocaSenhaActivity extends AppCompatActivity {

    private Button ok;
    private Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_troca_senha);

        ok = findViewById(R.id.buttonOkEmail);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        back = findViewById(R.id.buttonBackEmail);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
