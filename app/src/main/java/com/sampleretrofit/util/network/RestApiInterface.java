package com.sampleretrofit.util.network;

import com.sampleretrofit.model.MoviesResponse;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Query;


/**
 * Created by mohit on 28/12/16.
 */

public interface RestApiInterface {

    @GET("movie/top_rated")
    Call<MoviesResponse> getTopRatedMovies(@Query("api_key") String apiKey);


}
