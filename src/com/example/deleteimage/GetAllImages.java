package com.example.deleteimage;

import java.util.LinkedList;
import java.util.List;

import android.app.Activity;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.provider.MediaStore.MediaColumns;
import android.util.Log;

public class GetAllImages {
  
  public static final String TAG = "GetAllImages";
  
  public static List<String> getAllImages(Activity activity) {
    List<String> external = getImagePaths(activity, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
    List<String> internal = getImagePaths(activity, android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI);
    external.addAll(internal);
    return external;
  }
  
  private static List<String> getImagePaths(Activity activity, Uri imgUri) {
    List<String> ret = new LinkedList<String>();
    String[] projection = {MediaColumns.DATA, MediaStore.Images.Media.BUCKET_DISPLAY_NAME};
    Cursor cursor = activity.getContentResolver().query(imgUri, projection, null, null, null);
    int absPathIdx = cursor.getColumnIndexOrThrow(MediaColumns.DATA);
    while (cursor.moveToNext()) {
      ret.add(cursor.getString(absPathIdx));
      Log.e(TAG, cursor.getString(absPathIdx));
    }
    return ret;
  }
}
