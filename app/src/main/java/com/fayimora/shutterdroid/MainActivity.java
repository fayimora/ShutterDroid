package com.fayimora.shutterdroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
  final String TAG = "MainActivity";
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ShutterShockService service = ShutterShock.getService();
    service.search("person").enqueue(new Callback<List<ShutterResponse>>() {
      @Override
      public void onResponse(Call<List<ShutterResponse>> call, Response<List<ShutterResponse>> response) {
      }

      @Override
      public void onFailure(Call<List<ShutterResponse>> call, Throwable t) {
      }
    });
  }
}
