package com.sampleretrofit.util.network;

import android.util.Log;

import java.lang.annotation.Annotation;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.concurrent.Callable;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;

import static android.content.ContentValues.TAG;


/**
 * Created by mohit on 28/12/16.
 */

public class RestProcess<T> implements Callback<T> {

    RestCallback callback;
    int serviceCode;

    public RestProcess(int serviceCode, RestCallback restCallback) {
        this.callback = restCallback;
        this.serviceCode = serviceCode;
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (call != null) {
            callback.onSuccess(call, response, serviceCode);
        }


    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        if (t instanceof SocketTimeoutException) {
            Log.e("SocketTimeoutException ", t.getMessage());
        } else if (t instanceof UnknownHostException) {
            Log.e("UnknownHostException ", t.getMessage());
        } else if (callback != null) {
            callback.onFailure(call, t, serviceCode);
        }


    }
}
