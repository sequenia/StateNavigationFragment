package com.example.statenavigationfragment.activities;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.Navigator;

import com.example.statenavigationfragment.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

@Navigator.Name("state_fragment")
public class MainActivity extends AppCompatActivity {

    /**
     * контроллер для нижней навигации
     * управляет только стеком нижнего уровня
     */
    private NavController mainController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mainController = Navigation.findNavController(this,
                R.id.main_controller);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                        mainController.popBackStack();
                        mainController.navigate(menuItem.getItemId());
                        return true;
                    }
                });
    }
}
