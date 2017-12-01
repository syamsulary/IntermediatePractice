package com.intermediatepractice;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by SYAMSUL on 01/12/2017.
 */

public interface ApiRequestInterface {

    @GET("movie/popular")
    Call<MovieResponseDao> getMovieList(@Query("api_key") String api_key);
}
