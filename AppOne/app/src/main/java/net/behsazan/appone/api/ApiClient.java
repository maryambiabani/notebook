package net.behsazan.appone.api;

import retrofit2.Retrofit;

public class ApiClient {
   private static Retrofit retrofit=null;
   private ApiClient(){}
    public static Retrofit getRetrofit(){
       if (retrofit==null){
           retrofit=new Retrofit.Builder()
                   // in upper than 9 version android refused http protocol need turn trueTraffic on
                   .baseUrl("http://localhost:8081/api/")
                   //for solving localhost Connection fail using local ip
//                   .baseUrl("http://192.168......:8081/")
                   .build();
       }
       return retrofit;
    }
}
