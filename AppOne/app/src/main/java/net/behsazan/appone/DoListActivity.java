package net.behsazan.appone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabLayout;

import net.behsazan.appone.adapter.TabsAdapter;
import net.behsazan.ppone.R;
import net.behsazan.ppone.databinding.ActivityDoListBinding;
import net.behsazan.ppone.databinding.ActivityFirstBinding;

public class DoListActivity extends AppCompatActivity {
ActivityDoListBinding binding;
TabsAdapter tabsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDoListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), FirstActivity.class);
                startActivity(intent);
            }
        });
        binding.btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
tabsAdapter=new TabsAdapter(getSupportFragmentManager());
binding.viewPager.setAdapter(tabsAdapter);
binding.tabLayout.setupWithViewPager(binding.viewPager);


    }
}