package br.com.digitalhouse.staruniverse.personagens;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;


import br.com.digitalhouse.staruniverse.R;
import br.com.digitalhouse.staruniverse.model.PersonagemModel;

public class DetalhesPersonagensActivity extends AppCompatActivity {

    private TextView textViewDescricao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_personagem);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);


        textViewDescricao = findViewById(R.id.textViewDescricaoPersonagem);

        PersonagemModel person = getIntent().getParcelableExtra("PERSONAGEM");

        if(person != null) {
            textViewDescricao.setText(person.getDescricao());
            toolbar.setTitle(person.getNome());
        }

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
