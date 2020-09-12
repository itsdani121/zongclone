package com.example.zongclone;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView navigationView;
    NavController controller;
    TextView titleTV;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        navigationView = findViewById(R.id.bottom_bar);
        controller = Navigation.findNavController(this, R.id.host_fragment);
        NavigationUI.setupWithNavController(navigationView, controller);

        showToolbar();
        click();

    }

    private void click() {
        controller.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {
                titleTV.setText(destination.getLabel());
                switch (destination.getId()){
                    case R.id.mainFragment:
                    case R.id.usageFragment: {
                        navigationView.setVisibility(View.VISIBLE);
                        break;
                    }
                    default:{
                        navigationView.setVisibility(View.GONE);
                        break;
                    }
                }
            }
        });
    }

    private void showToolbar() {
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setCustomView(R.layout.toolbar_layout);

        titleTV = actionBar.getCustomView().findViewById(R.id.customToolbar);
    }
}