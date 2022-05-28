package com.example.mynotepad;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initActionBar();

        MainFragment mainFragment = new MainFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, mainFragment)
                .commit();
    }

    private void initActionBar() {
        Toolbar toolbar = findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about:
                showAboutFragment();
                return true;
            case R.id.exit:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showAboutFragment() {
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        boolean isAboutShow = false;
        for (Fragment fragment : fragments) {
            if (fragment instanceof AboutFragment && fragment.isVisible()) {
                isAboutShow = true;
            }
        }
        if (!isAboutShow) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new AboutFragment())
                    .addToBackStack(null)
                    .commit();
        }
    }
}