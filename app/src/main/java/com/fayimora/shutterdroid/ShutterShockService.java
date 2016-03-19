package com.fayimora.shutterdroid;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by fayimora on 19/03/2016.
 */
public interface ShutterShockService {
  @GET("/v2/images/search")
  Call<List<ShutterResponse>> search(@Query("query") String query);

  @GET("/v2/images/search")
  Call<ShutterResponse> getRecent(@Query("added_date_start") String date);

}
