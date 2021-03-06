package br.com.digitalhouse.staruniverse.view.cadastro;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import br.com.digitalhouse.staruniverse.R;
import br.com.digitalhouse.staruniverse.model.usuarios.CadastroUsuario;

public class TrocaEmailActivity extends AppCompatActivity {

    private Button btnConfirmarEmail;
    private EditText editTextEmailAntigo;
    private EditText editTextNovoEmail;
    private EditText editTextConfirmarEmail;
    private DatabaseReference mFirebaseDatabase;
    private FirebaseDatabase mFirebaseInstance;
    private String userId;
    private FirebaseAuth usuario;
    FirebaseUser usuarioLogado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_troca_email);

        initViews();

       // validarconta();
        mFirebaseInstance = FirebaseDatabase.getInstance();
        mFirebaseDatabase = mFirebaseInstance.getReference("usuario");



        btnConfirmarEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                validarEmail(editTextEmailAntigo,editTextNovoEmail,editTextConfirmarEmail);
                //String novasenha = editTextNovoEmail.getText().toString();
               // updateUsuario(novasenha);

            }
        });

    }

   /* private void updateUsuario(String password) {
        // updating the user via child nodes
        if (!TextUtils.isEmpty(password));{
            mFirebaseDatabase.child(userId).child("email").removeValue();
            mFirebaseDatabase.child(userId).child("email").setValue(password);
        }
        addUserChangeListener();
    }*/

    private void addUserChangeListener() {
        mFirebaseDatabase.child(userId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                CadastroUsuario usuario = dataSnapshot.getValue(CadastroUsuario.class);

                if (usuario == null) {
                    sUToastShort("Usuário não existe!",16);
                    return;
                }
                sUToastShort("e-mail alterado com sucesso!",16);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                sUToastShortException("Falha na leitura do usuário!",16, error.toException());
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
        if (emailV.getText().toString().equals(emailN.getText().toString()))
        {
            sUToastShort ("E-mail antigo e novo e-email são idênticos.",16);
            emailN.requestFocus();
            return;
        }
        if (!emailN.getText().toString().equals(emailNC.getText().toString()))
        {
            sUToastShort ("E-mails não conferem.",16);
            emailN.requestFocus();
            return;
        }
        startActivity(new Intent(getApplicationContext(),PerfilActivity.class));

    }

    public void initViews()
    {
        btnConfirmarEmail = findViewById(R.id.btnConfimarNovoEmail);
        editTextEmailAntigo = findViewById(R.id.edtOldEmail);
        editTextNovoEmail = findViewById(R.id.edtNewEmail);
        editTextConfirmarEmail = findViewById(R.id.edtNewConfEmail);
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

    public void sUToastShortException (String texto, float tamanho, Exception e)  {

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
   /* public void validarconta()
    {
        mFirebaseInstance = FirebaseDatabase.getInstance();
        mFirebaseDatabase = mFirebaseInstance.getReference("usuario");
        usuario = FirebaseAuth.getInstance();
        usuario = ValidarFirebase.getFirebaseAuth();


    }*/
}
