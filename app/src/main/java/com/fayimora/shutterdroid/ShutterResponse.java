package com.fayimora.shutterdroid;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by fayimora on 19/03/2016.
 */
public class ShutterResponse {
  @SerializedName("data")
  List<Image> data;

  @SerializedName("total_count")
  int totalCount;
}
