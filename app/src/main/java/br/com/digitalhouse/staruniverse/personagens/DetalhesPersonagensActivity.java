package br.com.digitalhouse.staruniverse.personagens;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import br.com.digitalhouse.staruniverse.R;
import br.com.digitalhouse.staruniverse.model.Character;

public class DetalhesPersonagensActivity extends AppCompatActivity {

    private TextView textViewDescricao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_personagem);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        textViewDescricao = findViewById(R.id.textViewDescricaoPersonagem);

        Character person = getIntent().getParcelableExtra("PERSONAGEM");

        if(person != null) {
            textViewDescricao.setText(person.getName());
            toolbar.setTitle(person.getBirthYear());
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
