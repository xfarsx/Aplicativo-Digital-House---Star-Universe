package br.com.digitalhouse.staruniverse.personagens;

import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import br.com.digitalhouse.staruniverse.R;
import br.com.digitalhouse.staruniverse.model.Character;

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

            String height = textViewHeight.getContext().getString(R.string.height_format, person.getHeight());
            String mass = textViewMass.getContext().getString(R.string.mass_format, person.getMass());
            String hair = textViewHairColor.getContext().getString(R.string.hair_color_format, person.getHairColor());
            String skin = textViewSkinColor.getContext().getString(R.string.skin_color_format, person.getSkinColor());
            String eye = textViewEyeColor.getContext().getString(R.string.eye_color_format, person.getEyeColor());
            String birth = textViewBirthYear.getContext().getString(R.string.birth_year_format, person.getBirthYear());
            String gender = textViewGender.getContext().getString(R.string.gender_format, person.getGender());


            textViewDescricao.setText(person.getName());

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                textViewHeight.setText(Html.fromHtml(height, Html.FROM_HTML_MODE_COMPACT));
                textViewMass.setText(Html.fromHtml(mass, Html.FROM_HTML_MODE_COMPACT));
                textViewHairColor.setText(Html.fromHtml(hair, Html.FROM_HTML_MODE_COMPACT));
                textViewSkinColor.setText(Html.fromHtml(skin, Html.FROM_HTML_MODE_COMPACT));
                textViewEyeColor.setText(Html.fromHtml(eye, Html.FROM_HTML_MODE_COMPACT));
                textViewBirthYear.setText(Html.fromHtml(birth, Html.FROM_HTML_MODE_COMPACT));
                textViewGender.setText(Html.fromHtml(gender, Html.FROM_HTML_MODE_COMPACT));
            } else {
                textViewHeight.setText(Html.fromHtml(height));
                textViewMass.setText(Html.fromHtml(mass));
                textViewHairColor.setText(Html.fromHtml(hair));
                textViewSkinColor.setText(Html.fromHtml(skin));
                textViewEyeColor.setText(Html.fromHtml(eye));
                textViewBirthYear.setText(Html.fromHtml(birth));
                textViewGender.setText(Html.fromHtml(gender));
            }

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