package com.remotearth.mylibrary;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;


public class ItemData implements Parcelable {

  String id;
  String title;

  public ItemData() {
  }

  public ItemData(String id, String title) {
    this.id = id;
    this.title = title;
  }

  protected ItemData(Parcel in) {
    id = in.readString();
    title = in.readString();
  }

  public static final Creator<ItemData> CREATOR = new Creator<ItemData>() {
    @Override
    public ItemData createFromParcel(Parcel in) {
      return new ItemData(in);
    }

    @Override
    public ItemData[] newArray(int size) {
      return new ItemData[size];
    }
  };

  public String getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(@NonNull Parcel parcel, int i) {
    parcel.writeString(id);
    parcel.writeString(title);
  }
}
