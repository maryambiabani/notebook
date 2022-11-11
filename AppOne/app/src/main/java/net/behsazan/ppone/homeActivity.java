package net.behsazan.ppone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class homeActivity extends AppCompatActivity {
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Log.e("LifeCycle","onCreate");
        toolbar=findViewById(R.id.toolbarHome);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_about:
                Toast.makeText(getApplicationContext(),"About Us",Toast.LENGTH_LONG).show();
            break;
            case R.id.item_contact:

                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("tel:02122828299"));
           //     Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("sms:02122828299"));
                startActivity(intent);
                break;
            case R.id.item_exit:
                finish();
                //finishAffinity();
                break;
            case R.id.item_web:
                Intent intent1=new Intent(Intent.ACTION_VIEW,Uri.parse("https://bankmellat.ir/default.aspx"));
                        startActivity(intent1);
                        break;
        }
        return super.onOptionsItemSelected(item);
    }
}