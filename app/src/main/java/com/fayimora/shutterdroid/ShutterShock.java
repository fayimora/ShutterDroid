package com.fayimora.shutterdroid;

import android.util.Base64;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by fayimora on 19/03/2016.
 */
public class ShutterShock {
  private static final String API_URL = "https://api.shutterstock.com/";
  private static HttpLoggingInterceptor logging = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.HEADERS);

  private static OkHttpClient.Builder httpClient =
      new OkHttpClient.Builder()
          .addNetworkInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
              String authInfo = "bfcf45b69b7d94bf515a:31e26f4b22e3205d3ca29de024a9f1e6b816f524";
              String auth = "Basic "+ Base64.encodeToString(authInfo.getBytes(), Base64.NO_WRAP);
              Request r = chain.request();
              r = r.newBuilder().addHeader("Authorization", auth).build();
              return chain.proceed(r);
            }
          }).addInterceptor(logging);

  private static Retrofit retrofit = new Retrofit.Builder()
      .baseUrl(API_URL)
      .addConverterFactory(GsonConverterFactory.create())
      .client(httpClient.build())
      .build();

  private static ShutterShockService service = retrofit.create(ShutterShockService.class);

  private ShutterShock() {}

  public static ShutterShockService getService() { return service; }

}
