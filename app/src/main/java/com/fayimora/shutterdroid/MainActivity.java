package com.fayimora.shutterdroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
  final String TAG = "MainActivity";
  List<Image> images;
  private ImagesAdapter imagesAdapter;
  private RecyclerView recyclerView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    images = new ArrayList<>();
    imagesAdapter = new ImagesAdapter(this, images);
    recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
    recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
    recyclerView.setAdapter(imagesAdapter);

    ShutterShockService service = ShutterShock.getService();
    service.search("person").enqueue(new Callback<ShutterResponse>() {
      @Override
      public void onResponse(Call<ShutterResponse> call, Response<ShutterResponse> response) {
        images.clear();
        images.addAll(response.body().data);
        imagesAdapter.notifyDataSetChanged();
      }

      @Override
      public void onFailure(Call<ShutterResponse> call, Throwable t) {
      }
    });
  }
}
