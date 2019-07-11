package br.com.digitalhouse.staruniverse.bottom;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import br.com.digitalhouse.staruniverse.R;
import br.com.digitalhouse.staruniverse.filmes.FilmesFragment;
import br.com.digitalhouse.staruniverse.home.HomeActivity;
import br.com.digitalhouse.staruniverse.personagens.PersonagensFragment;
import br.com.digitalhouse.staruniverse.quiz.QuizFragment;
import br.com.digitalhouse.staruniverse.ranking.RankingReciclerViewMain;

public class BottomActivity extends AppCompatActivity {
    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Intent i = new Intent( BottomActivity.this,HomeActivity.class);
                    startActivity(i);
                    return true;
                case R.id.navigation_filmes:
                    replaceFragment(new FilmesFragment());
                    return true;
                case R.id.navigation_personagens:
                    replaceFragment(new PersonagensFragment());
                    return true;
                case R.id.navigation_quiz:
                    replaceFragment(new QuizFragment());
                    return true;
                case R.id.navigation_noticias:
                    mTextMessage.setText(R.string.title_news);

            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        mTextMessage = findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        if (getIntent() != null && getIntent().getStringExtra("POSITION") != null){
            if (getIntent().getStringExtra("POSITION").equals("PERSON")){

                replaceFragment(new PersonagensFragment());
            }
            if (getIntent().getStringExtra("POSITION").equals("QUIZ")){

                replaceFragment(new QuizFragment());
            }
            if (getIntent().getStringExtra("POSITION").equals("RANKING")){

                replaceFragment(new RankingReciclerViewMain());

            }
            if (getIntent().getStringExtra("POSITION").equals("FILMES")){

                replaceFragment(new FilmesFragment());

            }
        }
    }

    public void replaceFragment(Fragment fragment){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.containerFragments, fragment);
        transaction.commit();
    }

}
