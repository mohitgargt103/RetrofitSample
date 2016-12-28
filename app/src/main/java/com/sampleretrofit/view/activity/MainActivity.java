package com.sampleretrofit.view.activity;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.sampleretrofit.R;
import com.sampleretrofit.model.MoviesResponse;
import com.sampleretrofit.util.network.RestCallback;
import com.sampleretrofit.util.network.RestConfig;
import com.sampleretrofit.util.network.RestProcess;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

public class MainActivity extends Activity implements RestCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<MoviesResponse> call = RestConfig.getInstanse().getTopRatedMovies("7e8f60e325cd06e164799af1e317d7a7");
                call.enqueue(new RestProcess<MoviesResponse>(1, MainActivity.this));
            }
        });
    }


    @Override
    public void onFailure(Call call, Throwable t, int serviceMode) {

    }

    @Override
    public void onSuccess(Call call, Response model, int serviceMode) {
        MoviesResponse response = (MoviesResponse) model.body();
        Log.e("Result ", new Gson().toJson(response));
    }
}
