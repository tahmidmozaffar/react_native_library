package com.remotearth.mylibrary;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.google.gson.Gson;

@ReactModule(name = RemotearthModule.NAME)
public class RemotearthModule extends ReactContextBaseJavaModule {
  public static final String NAME = "Remotearth";
  Gson gson = new Gson();

  public RemotearthModule(ReactApplicationContext reactContext) {
    super(reactContext);
  }

  @Override
  @NonNull
  public String getName() {
    return NAME;
  }


  //  // Example method
//  // See https://reactnative.dev/docs/native-modules-android
  @ReactMethod
  public void multiply(double a, double b, Promise promise) {
    promise.resolve(a * b);
  }

  @ReactMethod
  public void openDetailsPage(ReadableMap info, Promise promise) {
    System.out.println(info);
//    WritableMap map = Arguments.createMap();
//    map.putArray();
    Intent intent = new Intent(getCurrentActivity(), DetailsActivity.class);
    Bundle bundle = new Bundle();
    ItemData item = new ItemData(info.getString("id"), info.getString("title"));
    Route route = new Route(new Params(item));
    String json = gson.toJson(route);
    bundle.putString("route", json);
    bundle.putBoolean("isFromNativeApp", true);

    intent.putExtra("bundle", bundle);
    getCurrentActivity().startActivity(intent);
  }


}

