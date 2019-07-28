package br.com.digitalhouse.staruniverse.personagens;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import br.com.digitalhouse.staruniverse.R;
import br.com.digitalhouse.staruniverse.model.personagem.Character;

public class DetalhesPersonagensActivity extends AppCompatActivity {

    private TextView textViewDescricao;
    private TextView textViewHeight;
    private TextView textViewMass;
    private TextView textViewHairColor;
    private TextView textViewSkinColor;
    private TextView textViewEyeColor;
    private TextView textViewBirthYear;
    private TextView textViewGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_personagem);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        textViewDescricao = findViewById(R.id.textViewDescricaoPersonagem);
        textViewHeight = findViewById(R.id.textViewHeight);
        textViewMass = findViewById(R.id.textViewMass);
        textViewHairColor = findViewById(R.id.textViewHairColor);
        textViewSkinColor = findViewById(R.id.textViewSkinColor);
        textViewEyeColor = findViewById(R.id.textViewEyeColor);
        textViewBirthYear = findViewById(R.id.textViewBirthYear);
        textViewGender = findViewById(R.id.textViewGender);

        Character person = getIntent().getParcelableExtra("PERSONAGEM");


        if(person != null) {

            textViewDescricao.setText(person.getName());

            formatText(person);

            toolbar.setTitle(person.getName());
        }

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    private void formatText(Character person) {
        String a = textViewHeight.getContext().getString(R.string.height_format, person.getHeight());
        String b = textViewMass.getContext().getString(R.string.mass_format, person.getMass());
        String c = textViewHairColor.getContext().getString(R.string.hair_color_format, person.getHairColor());
        String d = textViewSkinColor.getContext().getString(R.string.skin_color_format, person.getSkinColor());
        String e = textViewEyeColor.getContext().getString(R.string.eye_color_format, person.getEyeColor());
        String f = textViewBirthYear.getContext().getString(R.string.birth_year_format, person.getBirthYear());
        String g = textViewGender.getContext().getString(R.string.gender_format, person.getGender());


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            textViewHeight.setText(Html.fromHtml(a, Html.FROM_HTML_MODE_COMPACT));
            textViewMass.setText(Html.fromHtml(b, Html.FROM_HTML_MODE_COMPACT));
            textViewHairColor.setText(Html.fromHtml(c, Html.FROM_HTML_MODE_COMPACT));
            textViewSkinColor.setText(Html.fromHtml(d, Html.FROM_HTML_MODE_COMPACT));
            textViewEyeColor.setText(Html.fromHtml(e, Html.FROM_HTML_MODE_COMPACT));
            textViewBirthYear.setText(Html.fromHtml(f, Html.FROM_HTML_MODE_COMPACT));
            textViewGender.setText(Html.fromHtml(g, Html.FROM_HTML_MODE_COMPACT));
        } else {
            textViewHeight.setText(Html.fromHtml(a));
            textViewMass.setText(Html.fromHtml(b));
            textViewHairColor.setText(Html.fromHtml(c));
            textViewSkinColor.setText(Html.fromHtml(d));
            textViewEyeColor.setText(Html.fromHtml(e));
            textViewBirthYear.setText(Html.fromHtml(f));
            textViewGender.setText(Html.fromHtml(g));
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}