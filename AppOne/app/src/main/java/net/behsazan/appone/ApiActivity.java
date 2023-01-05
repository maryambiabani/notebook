package net.behsazan.appone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import net.behsazan.appone.api.ApiClient;
import net.behsazan.appone.api.IService;
import net.behsazan.ppone.R;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api);

        IService iService= ApiClient.getRetrofit().create(IService.class);
        iService.getStudent().enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.e("","");
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
Log.e("","");
            }
        });
    }
}