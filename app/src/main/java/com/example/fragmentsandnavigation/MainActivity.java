package com.example.fragmentsandnavigation;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.fragmentsandnavigation.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        if(drawerLayout == null){
            Toast.makeText(this, "Emohjwvkvkv", Toast.LENGTH_SHORT).show();
        }
        else {
            // Setting toolbar
            setSupportActionBar(toolbar);

            // Making it so it can be added to toggle the drawer
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

            // Adding listener to drawer and passing toggle
            drawerLayout.addDrawerListener(toggle);

            // Managing state of drawer open or close
            toggle.syncState();

            // Click listener for items in the drawer
            navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    int id = item.getItemId();
                    boolean chk = true;

                    if(!chk){
                        return true;
                    }

                    if(id == R.id.nav_quiz){
                        FragmentManager fm = getSupportFragmentManager();
                        FragmentTransaction ft = fm.beginTransaction();

                        ft.add(R.id.nav_host_fragment_content_main, new Quiz());
                        ft.commit();
                        chk = false;
                        drawerLayout.closeDrawer(GravityCompat.START);
                    }

                    if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                        // Close the drawer and return true to consume the event
                        drawerLayout.closeDrawers();
                        return true;
                    }
                    // return will be true to view the selection
                    return true;
                }
            });
        }




    }
}