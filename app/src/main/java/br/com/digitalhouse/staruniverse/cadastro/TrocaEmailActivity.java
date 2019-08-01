package br.com.digitalhouse.staruniverse.cadastro;

import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import br.com.digitalhouse.staruniverse.R;

public class TrocaEmailActivity extends AppCompatActivity {

    private Button btnConfirmarEmail;
    private EditText editTextEmailAntigo;
    private EditText editTextNovoEmail;
    private EditText editTextConfirmarEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_troca_email);

        initViews();

        btnConfirmarEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                validarEmail(editTextEmailAntigo,editTextNovoEmail,editTextConfirmarEmail);

            }
        });

    }



    public void validarEmail(EditText emailV, EditText emailN, EditText emailNC)
    {
        String emailAntigo = emailV.getText().toString();
        String emailNovo = emailN.getText().toString();
        String emailNovoConfirmar = emailNC.getText().toString();

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(emailAntigo).matches()) {
            emailV.setError("E-mail não válido!");
            emailV.requestFocus();
            return;
        }
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(emailNovo).matches()) {
            emailN.setError("E-mail não válido!");
            emailN.requestFocus();
            return;
        }
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(emailNovoConfirmar).matches()) {
            emailNC.setError("E-mail não válido!");
            emailNC.requestFocus();
            return;
        }
        if (emailAntigo == emailNovo )
        {
            Toast.makeText(TrocaEmailActivity.this,"E-mails são iguais",Toast.LENGTH_SHORT).show();
            emailN.requestFocus();
            return;
        }
        if (emailNovo != emailNovoConfirmar)
        {
            Toast.makeText(TrocaEmailActivity.this,"E-mails não conferem",Toast.LENGTH_SHORT).show();
            emailN.requestFocus();
            return;
        }

    }

    public void initViews()
    {
        btnConfirmarEmail = findViewById(R.id.btnConfimarNovoEmail);
        editTextEmailAntigo = findViewById(R.id.edtOldEmail);
        editTextNovoEmail = findViewById(R.id.edtNewEmail);
        editTextConfirmarEmail = findViewById(R.id.edtNewConfEmail);
    }
}
