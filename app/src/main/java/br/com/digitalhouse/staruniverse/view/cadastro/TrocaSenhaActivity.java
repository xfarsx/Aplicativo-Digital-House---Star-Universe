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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import br.com.digitalhouse.staruniverse.R;
import br.com.digitalhouse.staruniverse.model.usuarios.CadastroUsuario;

public class TrocaSenhaActivity extends AppCompatActivity {

    private EditText editTextSenhaAntiga;
    private EditText editTextNovaSenha;
    private EditText editTextConfirmarNovaSenha;
    private Button btnConfirmarNovoPassword;
    private String userId;
     FirebaseAuth auth;
     FirebaseDatabase mFirebaseInstance;
    DatabaseReference mFirebaseDatabase;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_troca_senha);

        initViews();

        validarConta();

        btnConfirmarNovoPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                validarSenha(editTextSenhaAntiga,editTextNovaSenha,editTextConfirmarNovaSenha);
               //String novasenha = editTextNovaSenha.getText().toString();
               // updateUsuario(novasenha);
            }
        });
    }



   private void updateUsuario(String password) {
        mFirebaseDatabase.child(userId).child("senha").removeValue();
        mFirebaseDatabase.child(userId).child("senha").setValue(password);
        /* if(auth.getCurrentUser()!=null){
        auth.getCurrentUser().updatePassword(password);}
        else
            {
                sUToastShort("Não é possível mudar a senha!",16);
            }*/
        addUserChangeListener();


    }

    private void addUserChangeListener() {
        // User data change listener
        mFirebaseDatabase.child(userId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                CadastroUsuario user = dataSnapshot.getValue(CadastroUsuario.class);

                // Check for null
                if (user == null) {
                    sUToastShort("Não foi possível encontrar o usuário!",16);
                    return;
                }

                sUToastShort("Usuário atualizado!",16);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                sUToastShortException( "Erro ao acessar os dados", 16, error.toException());
            }
        });
    }

    public void validarSenha (EditText senhaA, EditText novaSenha, EditText confSenha)
    {
        if (senhaA.getText().toString().isEmpty() || novaSenha.getText().toString().isEmpty() ||
        confSenha.getText().toString().isEmpty()){
           sUToastShort ("Campo não foi preenchido", 16);
            senhaA.requestFocus();
            return;} if (novaSenha.getText().toString().isEmpty()){
           sUToastShort ("Campo não foi preenchido", 16);
            novaSenha.requestFocus();
            return;} if (confSenha.getText().toString().isEmpty()){
           sUToastShort ("Campo não foi preenchido" , 16);
            confSenha.requestFocus();
            return;}
        if (senhaA.getText().toString().equals(novaSenha.getText().toString()))
        {
           sUToastShort ("Nova senha deve ser diferente da anterior" , 16);
            novaSenha.requestFocus();
            return;
        }
        if(novaSenha.getText().toString().equals(123456) || novaSenha.getText().toString().length() < 6)
        {
           sUToastShort ("Senhas muito fraca!" , 16);
            novaSenha.requestFocus();
            return;
        }
        if (!novaSenha.getText().toString().equals(confSenha.getText().toString()))
        {
           sUToastShort ("Senhas não são iguais!" , 16);
            novaSenha.requestFocus();
            return;
        }
        startActivity (new Intent(getApplicationContext(), PerfilActivity.class));
    }


    public void initViews()
    {
        btnConfirmarNovoPassword = findViewById(R.id.btnConfimarNovaSenha);
        editTextSenhaAntiga = findViewById(R.id.edtOldPassword);
        editTextNovaSenha = findViewById(R.id.edtNewPassword);
        editTextConfirmarNovaSenha = findViewById(R.id.edtNewConfPassword);
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


    public  void validarConta()
    {
        mFirebaseInstance = FirebaseDatabase.getInstance();
    //  mFirebaseDatabase.push().getKey();
        mFirebaseDatabase = mFirebaseInstance.getReference("usuario");
       /* if(auth.getCurrentUser()!=null)
        {
            sUToastShort("usuário existe",16);
            userId = auth.getCurrentUser().getUid();
        }
        else {
            sUToastShort("Usuário não logado!",16);
        }*/

    }
}
