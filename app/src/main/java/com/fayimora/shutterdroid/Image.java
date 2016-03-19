package com.fayimora.shutterdroid;

import com.google.gson.annotations.SerializedName;

/**
 * Created by fayimora on 19/03/2016.
 */
public class Image {
  @SerializedName("id")
  private String id;

  @SerializedName("description")
  private String description;

  @SerializedName("assets")
  private ImageAssets assets;

  private class ImageAssets {
    @SerializedName("preview")
    private Thumbnail preview;

    @SerializedName("small_thumb")
    private Thumbnail smallThumb;

    @SerializedName("large_thumb")
    private Thumbnail largeThumb;
  }

  private class Thumbnail {
    @SerializedName("url")
    private String url;
  }
}
