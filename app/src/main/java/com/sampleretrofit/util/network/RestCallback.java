package com.sampleretrofit.util.network;


import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by navjot on 3/12/14.
 */
public interface RestCallback<T> {

    public void onFailure(Call<T> call, Throwable t,int serviceMode);

    public void onSuccess(Call<T> call, Response<T> model, int serviceMode);

}

