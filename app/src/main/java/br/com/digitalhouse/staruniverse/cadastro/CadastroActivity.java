package br.com.digitalhouse.staruniverse.cadastro;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;

import br.com.digitalhouse.staruniverse.R;
import br.com.digitalhouse.staruniverse.home.HomeActivity;
import br.com.digitalhouse.staruniverse.model.usuarios.CadastroUsuario;
import br.com.digitalhouse.staruniverse.validadorFirebase.ValidarFirebase;

public class CadastroActivity extends AppCompatActivity {

    private TextInputEditText editTextNomeJedi;
    private TextInputEditText editTextEmail;
    private TextInputEditText editTextSenha;
    private TextInputEditText editTextConfirmarSenha;
    private MaterialButton btnCadastrar;
    private CadastroUsuario usuario;
    private FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);


        initViews();


        botaoCadastrar();

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

                    if (editTextNomeJedi.getText().toString().equals("")) {
                        Toast.makeText(CadastroActivity.this, "Digite seu nome Jedi!", Toast.LENGTH_SHORT).show();
                        editTextNomeJedi.requestFocus();
                        return;
                    }
                    if (editTextEmail.getText().toString().equals("") || !editTextEmail.getText().toString().contains("@") || !editTextEmail.getText().toString().contains(".")) {
                        Toast.makeText(CadastroActivity.this, "Digite um e-mail válido!", Toast.LENGTH_SHORT).show();
                        editTextEmail.requestFocus();
                        return;
                    }
                    if (editTextSenha.getText().toString().length() < 6) {
                        Toast.makeText(CadastroActivity.this, "Sua senha não pode ser menor que 6 caracteres!", Toast.LENGTH_SHORT).show();
                        editTextSenha.requestFocus();
                        return;
                    }

                    if (editTextSenha.getText().toString().equals("123456")) {
                        Toast.makeText(CadastroActivity.this, "Senha muito fraca!", Toast.LENGTH_SHORT).show();
                        editTextSenha.requestFocus();
                        return;
                    }

                    if (!editTextSenha.getText().toString().equals(editTextConfirmarSenha.getText().toString())) {
                        Toast.makeText(CadastroActivity.this, "As senhas não são iguais!", Toast.LENGTH_SHORT).show();
                        editTextConfirmarSenha.requestFocus();
                        return;
                    }
                usuario = new CadastroUsuario();
                usuario.setEmail(editTextEmail.getText().toString());
                usuario.setNomeJedi(editTextNomeJedi.getText().toString());
                usuario.setSenha(editTextSenha.getText().toString());
                usuario.setConfirmarSenha(editTextConfirmarSenha.getText().toString());


                auth = ValidarFirebase.getFirebaseAuth();
                auth.createUserWithEmailAndPassword(
                        usuario.getEmail(),
                        usuario.getSenha()
                ).addOnCompleteListener(CadastroActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {


                        if (task.isSuccessful()) {
                            Toast.makeText(CadastroActivity.this, "Usuário cadastrado", Toast.LENGTH_SHORT).show();

                            FirebaseUser usuarioFirebase = task.getResult().getUser();
                            usuario.setId(usuarioFirebase.getUid());
                            usuario.salvar();

                            auth.signOut();
                            finish();

                            Intent intent = new Intent(CadastroActivity.this, HomeActivity.class);
                            startActivity(intent);

                        } else {

                            String erroExcecao = "";

                            try {
                                throw task.getException();

                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                            try {
                                throw task.getException();
                            } catch ( FirebaseAuthWeakPasswordException e) {
                                erroExcecao = "Digite uma senha mais forte, Contendo pelo menos 8 caracteres com letras e números";
                            } catch (FirebaseAuthInvalidCredentialsException e) {
                                erroExcecao = "O email digitado é inválido";
                            } catch (FirebaseAuthUserCollisionException e) {
                                erroExcecao = "Email já cadastrado";
                            } catch (FirebaseAuthInvalidUserException e){
                                erroExcecao = "Usuário já cadastrado";
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            Toast.makeText(CadastroActivity.this, "Erro: " + erroExcecao, Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }

        });
    }
}




