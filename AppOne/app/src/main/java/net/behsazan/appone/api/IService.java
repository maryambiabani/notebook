package net.behsazan.appone.api;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface IService {

//simple way to get api data ist to use ResponseBody as output
    @GET("/api/getStudent")
    Call<ResponseBody> getStudent();



}
