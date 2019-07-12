package br.com.digitalhouse.staruniverse.cadastro;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import br.com.digitalhouse.staruniverse.R;

public class TrocaEmailActivity extends AppCompatActivity {

    private Button ok;
    private Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_troca_email);

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
