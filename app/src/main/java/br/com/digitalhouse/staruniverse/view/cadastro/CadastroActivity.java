package br.com.digitalhouse.staruniverse.view.cadastro;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Base64;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import br.com.digitalhouse.staruniverse.R;
import br.com.digitalhouse.staruniverse.model.usuarios.CadastroUsuario;
import br.com.digitalhouse.staruniverse.view.cadastro.validadorFirebase.ValidarFirebase;
import br.com.digitalhouse.staruniverse.view.home.HomeActivity;
import br.com.digitalhouse.staruniverse.view.login.LoginActivity;

public class CadastroActivity extends AppCompatActivity {

    private EditText editTextNomeJedi;
    private EditText editTextEmail;
    private EditText editTextSenha;
    private EditText editTextConfirmarSenha;
    private SharedPreferences preferences;
    private MaterialButton btnCadastrar;
    private CadastroUsuario usuario;
    private FirebaseAuth auth;

    public CadastroActivity (){
        this.preferences = preferences;
    }

    public SharedPreferences getPreferences() {
        return preferences;
    }

    public void setPreferences(SharedPreferences preferences) {
        this.preferences = preferences;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        initViews();

        botaoCadastrar();

        preferences = getSharedPreferences("APP_REGISTER", MODE_PRIVATE);


    }

    private void initViews() {
        btnCadastrar = findViewById(R.id.btnCadastro);
        editTextEmail = findViewById(R.id.Email);
        editTextNomeJedi = findViewById(R.id.Jedi);
        editTextSenha = findViewById(R.id.Senha);
        editTextConfirmarSenha = findViewById(R.id.ConfirmarSenha);
    }



    private void botaoCadastrar() {
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                validarCamposDoCadastroeCadastrar();

               }
         });
    }

    public void validarCamposDoCadastroeCadastrar()
    {

        if (editTextNomeJedi.getText().toString().isEmpty()) {
            sUToastShort("Digite seu nome Jedi!",16);
            editTextNomeJedi.requestFocus();
            return;
        }
        if (editTextEmail.getText().toString().isEmpty()) {
            sUToastShort("Digite seu e-mail!",16);
            editTextEmail.requestFocus();
            return;
        }
        if (editTextSenha.getText().toString().isEmpty()) {
            sUToastShort("Digite sua senha!",16);
            editTextSenha.requestFocus();
            return;
        }
        if (editTextConfirmarSenha.getText().toString().isEmpty()) {
            sUToastShort("Confirme sua senha!",16);
            editTextConfirmarSenha.requestFocus();
            return;
        }
        if (!editTextEmail.getText().toString().contains("@") || !editTextEmail.getText().toString().contains(".")) {
            sUToastShort("Digite um e-mail válido!",16);
            editTextEmail.requestFocus();
            return;
        }

        if (editTextSenha.getText().toString().length() < 6) {
            sUToastShort("Sua senha não pode ser menor que 6 caracteres!",16);
            editTextSenha.requestFocus();
            return;
        }

        if (editTextSenha.getText().toString().equals("123456")) {
            sUToastShort("Senha muito fraca!",16);
            editTextSenha.requestFocus();
            return;
        }

        if (!editTextSenha.getText().toString().equals(editTextConfirmarSenha.getText().toString())) {
            sUToastShort("As senhas não são iguais!",16);
            editTextConfirmarSenha.requestFocus();
            return;
        }


        preferences.edit().putString("EMAIL",editTextEmail.getText().toString()).apply();
        preferences.edit().putString("USER",editTextNomeJedi.getText().toString()).apply();
        preferences.edit().putString("PASSWORD",encrypt(editTextSenha.getText().toString())).apply();

        AutenticarCadastroFirenbase();

        startActivity(new Intent(getApplicationContext(), HomeActivity.class));

    }
    public String encrypt(String input) {
        return Base64.encodeToString(input.getBytes(), Base64.DEFAULT);
    }

    public void AutenticarCadastroFirenbase()
    {
        usuario = new CadastroUsuario();
        usuario.setEmail(editTextEmail.getText().toString());
        usuario.setNomeJedi(editTextNomeJedi.getText().toString());
        usuario.setSenha(editTextSenha.getText().toString());


        auth = ValidarFirebase.getFirebaseAuth();
        auth.createUserWithEmailAndPassword(
                usuario.getEmail(),
                usuario.getSenha()
        ).addOnCompleteListener(CadastroActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {


                if (task.isSuccessful()) {
                    sUToastShort("Usuário cadastrado",16);

                    FirebaseUser usuarioFirebase = task.getResult().getUser();
                    usuario.setId(usuarioFirebase.getUid());
                    usuario.salvar();

                    auth.signOut();
                    finish();

                    startActivity(new Intent(getApplicationContext(), LoginActivity.class));

                } else {

                    String erroExcecao = "";

                    try {
                        throw task.getException();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    sUToastShort("Usuário já cadastrado!" + erroExcecao, 16);
                }
            }
        });
    }
    public void sUToastShort (String texto, float tamanho)  {

        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast_layout,
                findViewById(R.id.toast_layout_root));

        TextView text = layout.findViewById(R.id.text);
        text.setText(texto);

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.BOTTOM | Gravity.CENTER, 12, 120);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }

}




