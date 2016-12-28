package com.sampleretrofit.util.network;

import android.util.Log;

import com.sampleretrofit.util.Constants;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mohit on 28/12/16.
 */

public class RestConfig {


    private static RestApiInterface service;
    private static Retrofit retrofit;

    public RestConfig() {


        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .connectTimeout(15, TimeUnit.SECONDS)
                .build();


        retrofit = new Retrofit.Builder()
                .baseUrl(Constants.URL.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }


    //Singleton
    public static RestApiInterface getInstanse() {
        if (service == null) {
            service = retrofit.create(RestApiInterface.class);
            return service;
        }
        return service;
    }

}
