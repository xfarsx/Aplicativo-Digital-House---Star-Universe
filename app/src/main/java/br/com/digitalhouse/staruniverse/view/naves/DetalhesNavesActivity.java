package br.com.digitalhouse.staruniverse.view.naves;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import br.com.digitalhouse.staruniverse.R;
import br.com.digitalhouse.staruniverse.model.nave.Nave;

public class DetalhesNavesActivity extends AppCompatActivity {
    private TextView textViewDetalheNaveName;
    private TextView textViewDetalheNaveModel;
    private TextView textViewDetalheNaveManufacturer;
    private TextView textViewDetalheNaveCostInCredits;
    private TextView textViewDetalheNaveLength;
    private TextView textViewDetalheNaveMaxAtmospheringSpeed;
    private TextView textViewDetalheNaveCrew;
    private TextView textViewDetalheNavePassengers;
    private TextView textViewDetalheNaveCargoCapacity;
    private TextView textViewDetalheNaveConsumables;
    private TextView textViewDetalheNaveHyperdriveRating;
    private TextView textViewDetalheNaveMGLT;
    private TextView textViewDetalheNaveStarshipClass;
    private TextView textViewDetalheNaveCreated;
    private TextView textViewDetalheNaveEdited;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_naves);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        //Inicializa Views
        initViews();

        Nave nave = getIntent().getParcelableExtra("NAVE");

        if (nave != null) {
            toolbar.setTitle(nave.getName());

            textViewDetalheNaveName.setText(nave.getName());
            formatText(nave);

        }

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void formatText(Nave nave) {
        String a = textViewDetalheNaveModel.getContext().getString(R.string.ship_model_format, nave.getModel());
        String b = textViewDetalheNaveManufacturer.getContext().getString(R.string.ship_manufacturer_format, nave.getManufacturer());
        String c = textViewDetalheNaveCostInCredits.getContext().getString(R.string.ship_cost_in_credits_format, nave.getCostInCredits());
        String d = textViewDetalheNaveLength.getContext().getString(R.string.ship_length_format, nave.getLength());
        String e = textViewDetalheNaveMaxAtmospheringSpeed.getContext().getString(R.string.ship_model_format, nave.getMaxAtmospheringSpeed());
        String f = textViewDetalheNaveCrew.getContext().getString(R.string.ship_max_atmosphering_format, nave.getCrew());
        String g = textViewDetalheNavePassengers.getContext().getString(R.string.ship_passengers_format, nave.getPassengers());
        String h = textViewDetalheNaveCargoCapacity.getContext().getString(R.string.ship_cargo_capacity_format, nave.getCargoCapacity());
        String i = textViewDetalheNaveConsumables.getContext().getString(R.string.ship_consumables_format, nave.getConsumables());
        String j = textViewDetalheNaveHyperdriveRating.getContext().getString(R.string.ship_hyperdrive_rating_format, nave.getHyperdriveRating());
        String k = textViewDetalheNaveMGLT.getContext().getString(R.string.ship_mglt_format, nave.getMGLT());
        String l = textViewDetalheNaveStarshipClass.getContext().getString(R.string.ship_starship_class_format, nave.getStarshipClass());
        String m = textViewDetalheNaveCreated.getContext().getString(R.string.ship_created_format, nave.getCreated());
        String n = textViewDetalheNaveEdited.getContext().getString(R.string.ship_edited_format, nave.getEdited());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            textViewDetalheNaveModel.setText(Html.fromHtml(a, Html.FROM_HTML_MODE_COMPACT));
            textViewDetalheNaveManufacturer.setText(Html.fromHtml(b, Html.FROM_HTML_MODE_COMPACT));
            textViewDetalheNaveCostInCredits.setText(Html.fromHtml(c, Html.FROM_HTML_MODE_COMPACT));
            textViewDetalheNaveLength.setText(Html.fromHtml(d, Html.FROM_HTML_MODE_COMPACT));
            textViewDetalheNaveMaxAtmospheringSpeed.setText(Html.fromHtml(e, Html.FROM_HTML_MODE_COMPACT));
            textViewDetalheNaveCrew.setText(Html.fromHtml(f, Html.FROM_HTML_MODE_COMPACT));
            textViewDetalheNavePassengers.setText(Html.fromHtml(g, Html.FROM_HTML_MODE_COMPACT));
            textViewDetalheNaveCargoCapacity.setText(Html.fromHtml(h, Html.FROM_HTML_MODE_COMPACT));
            textViewDetalheNaveConsumables.setText(Html.fromHtml(i, Html.FROM_HTML_MODE_COMPACT));
            textViewDetalheNaveHyperdriveRating.setText(Html.fromHtml(j, Html.FROM_HTML_MODE_COMPACT));
            textViewDetalheNaveMGLT.setText(Html.fromHtml(k, Html.FROM_HTML_MODE_COMPACT));
            textViewDetalheNaveStarshipClass.setText(Html.fromHtml(l, Html.FROM_HTML_MODE_COMPACT));
            textViewDetalheNaveCreated.setText(Html.fromHtml(m, Html.FROM_HTML_MODE_COMPACT));
            textViewDetalheNaveEdited.setText(Html.fromHtml(n, Html.FROM_HTML_MODE_COMPACT));
        } else {
            textViewDetalheNaveModel.setText(Html.fromHtml(a));
            textViewDetalheNaveManufacturer.setText(Html.fromHtml(b));
            textViewDetalheNaveCostInCredits.setText(Html.fromHtml(c));
            textViewDetalheNaveLength.setText(Html.fromHtml(d));
            textViewDetalheNaveMaxAtmospheringSpeed.setText(Html.fromHtml(e));
            textViewDetalheNaveCrew.setText(Html.fromHtml(f));
            textViewDetalheNavePassengers.setText(Html.fromHtml(g));
            textViewDetalheNaveCargoCapacity.setText(Html.fromHtml(h));
            textViewDetalheNaveConsumables.setText(Html.fromHtml(i));
            textViewDetalheNaveHyperdriveRating.setText(Html.fromHtml(j));
            textViewDetalheNaveMGLT.setText(Html.fromHtml(k));
            textViewDetalheNaveStarshipClass.setText(Html.fromHtml(l));
            textViewDetalheNaveCreated.setText(Html.fromHtml(m));
            textViewDetalheNaveEdited.setText(Html.fromHtml(n));
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    public void initViews() {

        textViewDetalheNaveName = findViewById(R.id.textViewDetalheNaveName);
        textViewDetalheNaveModel = findViewById(R.id.textViewDetalheNaveModel);
        textViewDetalheNaveManufacturer = findViewById(R.id.textViewDetalheNaveManufacturer);
        textViewDetalheNaveCostInCredits = findViewById(R.id.textViewDetalheNaveCostInCredits);
        textViewDetalheNaveLength = findViewById(R.id.textViewDetalheNaveLength);
        textViewDetalheNaveMaxAtmospheringSpeed = findViewById(R.id.textViewDetalheNaveMaxAtmospheringSpeed);
        textViewDetalheNaveCrew = findViewById(R.id.textViewDetalheNaveCrew);
        textViewDetalheNavePassengers = findViewById(R.id.textViewDetalheNavePassengers);
        textViewDetalheNaveCargoCapacity = findViewById(R.id.textViewDetalheNaveCargoCapacity);
        textViewDetalheNaveConsumables = findViewById(R.id.textViewDetalheNaveConsumables);
        textViewDetalheNaveHyperdriveRating = findViewById(R.id.textViewDetalheNaveHyperdriveRating);
        textViewDetalheNaveMGLT = findViewById(R.id.textViewDetalheNaveMGLT);
        textViewDetalheNaveStarshipClass = findViewById(R.id.textViewDetalheNaveStarshipClass);
        textViewDetalheNaveCreated = findViewById(R.id.textViewDetalheNaveCreated);
        textViewDetalheNaveEdited = findViewById(R.id.textViewDetalheNaveEdited);

    }
}
