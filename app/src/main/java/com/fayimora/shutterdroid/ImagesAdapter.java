package com.fayimora.shutterdroid;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by fayimora on 19/03/2016.
 */
public class ImagesAdapter extends RecyclerView.Adapter<ImagesAdapter.ViewHolder> {
  public class ViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView;

    ViewHolder(View itemView){
      super(itemView);
      imageView = (ImageView) itemView;
    }
  }

  List<Image> images;
  Context context;

  ImagesAdapter(Context context, List<Image> images){
    this.images = images;
    this.context = context;
  }

  @Override
  public void onBindViewHolder(ViewHolder holder, int position) {
    Image image = images.get(position);
    Log.d("ASSET", image.getLargeThumbnail());
    Picasso.with(context).load(image.getLargeThumbnail()).into(holder.imageView);
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_image, parent, false);
    return new ViewHolder(v);
  }

  @Override
  public int getItemCount() {
    return images.size();
  }
}
