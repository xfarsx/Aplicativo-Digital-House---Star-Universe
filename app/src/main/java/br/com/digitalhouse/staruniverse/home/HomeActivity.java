package br.com.digitalhouse.staruniverse.home;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import br.com.digitalhouse.staruniverse.R;
import br.com.digitalhouse.staruniverse.bottom.BottomActivity;
import br.com.digitalhouse.staruniverse.cadastro.PerfilActivity;
import br.com.digitalhouse.staruniverse.favoritos.FavoritosActivity;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private ImageView btnFavoritos, btnPersonagens, btnQuiz, btnNaves, btnFilmes,btnRanking;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = iniciarAsViews();

        botaoFilmes();

        botaoFavoritos();

        botaoPersonagens();

        botaoQuiz();

        botaoRanking();

        botaoNaves();

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

    }
    private void botaoRanking() {
        btnRanking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeActivity.this, BottomActivity.class);
                i.putExtra("POSITION", "RANKING");
                startActivity(i);
            }
        });
    }

    private void botaoNaves() {
        btnNaves.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeActivity.this, BottomActivity.class);
                i.putExtra("POSITION", "NAVES");
                startActivity(i);
            }
        });
    }

    private void botaoQuiz() {
        btnQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeActivity.this, BottomActivity.class);
                i.putExtra("POSITION", "QUIZ");
                startActivity(i);
            }
        });
    }

    private void botaoPersonagens() {
        btnPersonagens.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeActivity.this, BottomActivity.class);
                i.putExtra("POSITION", "PERSON");
                startActivity(i);

            }
        });
    }

    private void botaoFavoritos() {
        btnFavoritos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeActivity.this, FavoritosActivity.class);
                startActivity(i);

            }
        });
    }

    private void botaoFilmes() {
        btnFilmes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeActivity.this, BottomActivity.class);
                i.putExtra("POSITION", "FILMES");
                startActivity(i);
            }
        });
    }

    private Toolbar iniciarAsViews() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        btnFavoritos = findViewById(R.id.btn_favoritos);
        btnFilmes = findViewById(R.id.btn_filmes);
        btnPersonagens = findViewById(R.id.btn_personagens);
        btnNaves = findViewById(R.id.btn_naves);
        btnQuiz = findViewById(R.id.btn_quiz);
        btnRanking = findViewById(R.id.btn_ranking);
        return toolbar;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_profile) {
            Intent intent = new Intent(this, PerfilActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_menu) {
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_avalie) {
            //vai para loja avaliação
            Toast.makeText(HomeActivity.this, "Avalie - Vai para a loja", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_indique) {
            //abre whatsapp com link
            Toast.makeText(HomeActivity.this, "Indique um amigo - Vai para WhatsApp", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_end) {
            finishAffinity();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
