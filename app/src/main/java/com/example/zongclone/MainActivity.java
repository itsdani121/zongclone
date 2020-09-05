package com.example.zongclone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    public CardView wifi_card, call_card, sms_card;
    FrameLayout frameLayout;
BottomNavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        showToolbar();
        addFrag();
        addFragment(new mainFragment());
    }


    private void addFrag() {
        frameLayout = findViewById(R.id.frag_cont);
        navigationView=findViewById(R.id.bottom_bar);
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
               switch (item.getItemId()){
                   case R.id.home:
                       addFragment(new mainFragment());
                       break;
                   case R.id.usage:
                       break;
                   case R.id.bundle:
                       break;
                   case R.id.latest:
                       break;
                   case R.id.more:
                       break;
               }
                return false;
            }
        });
    }

    private void addFragment(mainFragment mainFragment) {
    getSupportFragmentManager().beginTransaction().replace(R.id.frag_cont,mainFragment).commit();
    }

    private void showToolbar() {
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setCustomView(R.layout.toolbar_layout);
    }
}