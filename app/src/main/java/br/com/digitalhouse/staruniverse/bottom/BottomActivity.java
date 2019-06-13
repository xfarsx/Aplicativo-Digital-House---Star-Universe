package br.com.digitalhouse.staruniverse.bottom;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.widget.TextView;

import br.com.digitalhouse.staruniverse.R;
import br.com.digitalhouse.staruniverse.personagens.Personagens;

public class BottomActivity extends AppCompatActivity {
    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_filmes:
                    mTextMessage.setText(R.string.title_movies);
                    return true;
                case R.id.navigation_personagens:
                    replaceFragment(new Personagens());
                    return true;
                case R.id.navigation_quiz:
                    mTextMessage.setText(R.string.title_quiz);
                    return true;
                case R.id.navigation_noticias:
                    mTextMessage.setText(R.string.title_news);
                    return true;
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

                replaceFragment(new Personagens());
            }
        }
    }

    public void replaceFragment(Fragment fragment){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.nav_view, fragment);
        transaction.commit();
    }

}
