package com.example.fragmentmasterclass;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.fragmentmasterclass.fragment.BasketFragment;
import com.example.fragmentmasterclass.fragment.CatalogFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navigationView = findViewById(R.id.bnv_main);
        navigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment)
                        .getChildFragmentManager().getFragments().get(0);
                switch(item.getItemId()){
                    case(R.id.navigation_basket):
                        if(!currentFragment.getClass().equals(BasketFragment.class))
                            NavHostFragment.findNavController(currentFragment).navigate(R.id.action_catalogFragment_to_basketFragment);
                        return true;
                    case(R.id.navigation_catalog):
                        if(!currentFragment.getClass().equals(CatalogFragment.class))
                            NavHostFragment.findNavController(currentFragment)
                                    .navigate(R.id.action_basketFragment_to_catalogFragment);
                        return true;
                }
                return false;
            }
        });
    }
}