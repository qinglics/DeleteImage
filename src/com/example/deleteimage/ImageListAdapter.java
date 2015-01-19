package com.example.deleteimage;

import java.io.File;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class ImageListAdapter extends BaseAdapter {
  
  private List<String> images = null;
  private Activity activity = null;
  
  public ImageListAdapter(Activity activity, List<String> images) {
    this.activity = activity;
    this.images = images;
  }
  @Override
  public int getCount() {
    return this.images.size();
  }
  @Override
  public Object getItem(int position) {
    return this.images.get(position);
  }
  @Override
  public long getItemId(int position) {
    return position;
  }
  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    LayoutInflater inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    if (null == convertView)
      convertView = inflater.inflate(R.layout.image_row, null);
    ImageView imageView = (ImageView)convertView.findViewById(R.id.imageView);
    Bitmap myBitmap;
    try {
      myBitmap = BitmapFactory.decodeFile(this.images.get(position));
      imageView.setImageBitmap(Bitmap.createScaledBitmap(myBitmap, 100, 200, true));
      myBitmap.recycle();
      myBitmap = null;
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    return convertView;
  }

  

}
