package com.example.mynotepad;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static List<User> usersList = new ArrayList<>();

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
        initDrawer(toolbar);
    }

    private void initDrawer(Toolbar toolbar) {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this
                , drawer
                , toolbar
                , R.string.navigation_drawer_open
                , R.string.navigation_drawer_close
        );

        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(item -> {
            int id = item.getItemId();
            switch (id) {
                case R.id.drawer_sitings:
                case R.id.drawer_photos:
                    drawer.close();
                    return true;
                case R.id.drawer_about:
                    showAboutFragment(new AboutFragment());
                    drawer.close();
                    return true;
            }
            return false;
        });
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
                showAboutFragment(new AboutFragment());
                return true;
            case R.id.menu_login:
                showAboutFragment(new LoginFragment());
                return true;
            case R.id.exit:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showAboutFragment(Fragment frag) {
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        boolean isAboutShow = false;
        for (Fragment fragment : fragments) {
            if (fragment instanceof AboutFragment && fragment.isVisible()) {
                isAboutShow = true;
            }
        }
        if (!isAboutShow) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, frag)
                    .addToBackStack(null)
                    .commit();
        }
    }
}