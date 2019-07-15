package br.com.digitalhouse.staruniverse.naves;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.digitalhouse.staruniverse.R;
import br.com.digitalhouse.staruniverse.model.nave.Nave;

public class DetalhesNavesActivity extends AppCompatActivity {

    private ImageView imageViewImgDetalheNave;
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
            textViewDetalheNaveModel.setText(nave.getModel());
            textViewDetalheNaveManufacturer.setText(nave.getManufacturer());
            textViewDetalheNaveCostInCredits.setText(nave.getCostInCredits());
            textViewDetalheNaveLength.setText(nave.getLength());
            textViewDetalheNaveMaxAtmospheringSpeed.setText(nave.getMaxAtmospheringSpeed());
            textViewDetalheNaveCrew.setText(nave.getCrew());
            textViewDetalheNavePassengers.setText(nave.getPassengers());
            textViewDetalheNaveCargoCapacity.setText(nave.getCargoCapacity());
            textViewDetalheNaveConsumables.setText(nave.getConsumables());
            textViewDetalheNaveHyperdriveRating.setText(nave.getHyperdriveRating());
            textViewDetalheNaveMGLT.setText(nave.getMGLT());
            textViewDetalheNaveStarshipClass.setText(nave.getStarshipClass());
            textViewDetalheNaveCreated.setText(nave.getCreated());
            textViewDetalheNaveEdited.setText(nave.getEdited());

        }

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    public void initViews() {

        imageViewImgDetalheNave = findViewById(R.id.imageViewImgDetalheNave);
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
