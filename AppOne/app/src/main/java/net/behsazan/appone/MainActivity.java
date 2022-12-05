package net.behsazan.appone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import net.behsazan.ppone.R;

public class MainActivity extends AppCompatActivity {
    private AppCompatEditText user;
    private AppCompatEditText pass;
    private AppCompatButton submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    onClickSubmit();
    }

    public void onClickSubmit(){
        user=findViewById(R.id.et_userName);
        pass=findViewById(R.id.et_Password);
        submit=findViewById(R.id.btn_submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (user.getText().toString().equals("maryam")&& pass.getText().toString().equals("1234")){
                    Toast.makeText(getApplicationContext(),"success",Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(getApplicationContext(), FirstActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(getApplicationContext(),"please enter correct username & pass",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}