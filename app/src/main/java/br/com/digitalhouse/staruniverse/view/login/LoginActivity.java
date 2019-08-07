package br.com.digitalhouse.staruniverse.view.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Base64;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.GoogleAuthProvider;

import br.com.digitalhouse.staruniverse.R;
import br.com.digitalhouse.staruniverse.view.cadastro.CadastroActivity;
import br.com.digitalhouse.staruniverse.view.home.HomeActivity;
import br.com.digitalhouse.staruniverse.model.usuarios.CadastroUsuario;
import br.com.digitalhouse.staruniverse.view.cadastro.validadorFirebase.ValidarFirebase;


public class LoginActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {

    private static final int RC_SIGN_IN = 9001 ;
    private EditText textInputEditTextLogin;
    private EditText textInputEditTextSenha;
    private Button buttonCadastrese;
    private MaterialButton buttonLogin;
    private MaterialButton buttonGmail;
    private CadastroUsuario usuario;
    private FirebaseAuth auth;
    private GoogleApiClient mGoogleApiClient;
    private String decriptarPassword;
    private String usuarioBundle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_login);

        iniciarViews();

        botaoCadastrar();

        auth = FirebaseAuth.getInstance();

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(LoginActivity.this,this)
                .addApi(Auth.GOOGLE_SIGN_IN_API,gso)
                .build();




        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!textInputEditTextLogin.getText().toString().isEmpty() && !textInputEditTextSenha.getText().toString().isEmpty()){
                    usuario = new CadastroUsuario();
                    usuario.setEmail(textInputEditTextLogin.getText().toString());
                usuario.setSenha(textInputEditTextSenha.getText().toString());
                    validarLogin();
                    sUToastLong("BEM VINDO!",24);
                }
                else
                    {
                        sUToastLong("BEM VINDO!",24);
                        Intent i = new Intent(LoginActivity.this, HomeActivity.class);
                        startActivity(i);
                    }

            }


        });

        botaoGmail();

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
        Intent signIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        startActivityForResult(signIntent,RC_SIGN_IN);
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
                    startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                    finish();
                }
                else{

                    Toast.makeText(getApplicationContext(),"Erro na autorização",Toast.LENGTH_SHORT).show();
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
        buttonGmail = findViewById(R.id.btnGmail);
        textInputEditTextLogin = findViewById(R.id.textInputLayoutEmailLogin);
        textInputEditTextSenha = findViewById(R.id.textInputLayoutSenhaLogin);
    }


    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Toast.makeText(getApplicationContext(),"Falha na conexão",Toast.LENGTH_SHORT).show();
    }
    private void preferences() {
        final SharedPreferences preferences = getSharedPreferences("APP_REGISTER", MODE_PRIVATE);

        decriptarPassword = decrypt(preferences.getString("PASSWORD", ""));
        usuarioBundle = preferences.getString("E-MAIL", "");

        textInputEditTextLogin.setText(preferences.getString("E-MAIL", ""));

    }
    public String decrypt(String input) {
        return new String(Base64.decode(input, Base64.DEFAULT));
    }


    public void sUToastLong (String texto, float tamanho)  {

        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast_layout,
                findViewById(R.id.toast_layout_root));

        TextView text = layout.findViewById(R.id.text);
        text.setTextSize(tamanho);
        text.setText(texto);

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.BOTTOM | Gravity.CENTER_VERTICAL, 0, 120);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }
    }





