package br.com.digitalhouse.staruniverse.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.GoogleAuthProvider;

import br.com.digitalhouse.staruniverse.R;
import br.com.digitalhouse.staruniverse.cadastro.CadastroActivity;
import br.com.digitalhouse.staruniverse.home.HomeActivity;
import br.com.digitalhouse.staruniverse.model.usuarios.CadastroUsuario;
import br.com.digitalhouse.staruniverse.validadorFirebase.ValidarFirebase;


public class LoginActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {

    private static final int RC_SIGN_IN = 9001 ;
    private TextInputEditText textInputEditTextLogin;
    private TextInputEditText textInputEditTextSenha;
    private Button buttonCadastrese;
    private Button buttonLogin;
    private Button buttonFacebook;
    private Button buttonGmail;
    private CadastroUsuario usuario;
    private FirebaseAuth auth;
    private GoogleApiClient mGoogleApiClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_login);




        auth = FirebaseAuth.getInstance();


        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(LoginActivity.this,this)
                .addApi(Auth.GOOGLE_SIGN_IN_API,gso)
                .build();



        iniciarViews();


        botaoCadastrar();

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                usuario = new CadastroUsuario();
                usuario.setEmail(textInputEditTextLogin.getText().toString());
                usuario.setSenha(textInputEditTextSenha.getText().toString());
                validarLogin();
            }
        });


        botaoGmail();

        botaoFacebook();

    }

    private void botaoFacebook() {
        buttonFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //startActivity(new Intent(LoginActivity.this, FacebookActivity.class));
                Toast.makeText(LoginActivity.this, "View ainda em construção! Aguarde!", Toast.LENGTH_SHORT).show();


            }
        });
    }

    private void botaoGmail() {
       buttonGmail.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent signIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
               startActivityForResult(signIntent,RC_SIGN_IN);
           }
       });

        if(auth.getCurrentUser()!=null){
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        }
    }

    private void signIn() {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==RC_SIGN_IN){
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            if(result.isSuccess()){
                GoogleSignInAccount account = result.getSignInAccount();
                authWithGoogle(account);
            }
        }
    }

    private void authWithGoogle(GoogleSignInAccount account) {
        AuthCredential credential = GoogleAuthProvider.getCredential(account.getIdToken(),null);
        auth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    startActivity(new Intent(getApplicationContext(),LoginActivity.class));
                    finish();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Auth Error",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void validarLogin() {
        auth = ValidarFirebase.getFirebaseAuth();
        auth.signInWithEmailAndPassword(
                usuario.getEmail(),
                usuario.getSenha()
        ).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                goHome();
                Toast.makeText(LoginActivity.this, "Sucesso ao fazer Login", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(LoginActivity.this, "Erro ao efetuar Login", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void goHome() {
        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
        startActivity(intent);
        finish();
    }

    private void botaoCadastrar() {
        buttonCadastrese.setOnClickListener(v -> startActivity(new Intent(LoginActivity.this, CadastroActivity.class)));
    }

    private void iniciarViews() {
        buttonCadastrese = findViewById(R.id.btnCadastrese);
        buttonLogin = findViewById(R.id.btnLogar);
        buttonFacebook = findViewById(R.id.btnFace);
        buttonGmail = findViewById(R.id.btnGmail);
        //textInputEditTextLogin = findViewById(R.id.textInputLayoutEmailLogin);
        //textInputEditTextSenha = findViewById(R.id.textInputLayoutSenhaLogin);
    }


    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Toast.makeText(getApplicationContext(),"Falha na conexão",Toast.LENGTH_SHORT).show();
    }

}




