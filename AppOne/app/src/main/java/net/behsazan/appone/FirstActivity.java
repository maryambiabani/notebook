package net.behsazan.appone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;


import com.google.android.material.navigation.NavigationView;

import net.behsazan.ppone.R;
import net.behsazan.ppone.databinding.ActivityFirstBinding;

public class FirstActivity extends AppCompatActivity {
ActivityFirstBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFirstBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbarFirst);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(FirstActivity.this,binding.drawer
                ,binding.toolbarFirst ,R.string.open , R.string.close );


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            toggle.getDrawerArrowDrawable().setColor(getColor(R.color.white));
        } else {
            toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));
        }


        toggle.syncState();

       binding.navMenu.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){

                    case R.id.item_add:

                        Intent intent = new Intent(getApplicationContext() , HomeActivity.class);
                        startActivity(intent);

                        break;

                    case R.id.item_logout:


                        Intent intent1 = new Intent(getApplicationContext() , MainActivity.class);
                        startActivity(intent1);


                        break;


                }

                return false;
            }
        });
        binding.btnToDoList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), DoListActivity.class);
                startActivity(intent);
            }
        });
        binding.btnReminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),ReminderActivity.class);
                startActivity(intent);
            }
        });
        binding.btnNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), NoteActivity.class);
                startActivity(intent);
            }
        });
        binding.btnGetName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), ApiActivity.class);
                startActivity(intent);
            }
        });
    }
}