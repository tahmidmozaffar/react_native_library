package com.remotearth;

import android.os.Bundle;
import android.os.Parcelable;

import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactRootView;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.soloader.SoLoader;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class CustomListViewActivity extends BaseReactActivity {


  private ReactRootView mReactRootView;
  private ReactInstanceManager mReactInstanceManager;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    SoLoader.init(this, false);

    mReactRootView = new ReactRootView(this);
//    List<ReactPackage> packages = new PackageList(getApplication()).getPackages();
    // Packages that cannot be autolinked yet can be added manually here, for example:
    // packages.add(new MyReactNativePackage());
    // Remember to include them in `settings.gradle` and `app/build.gradle` too.

    mReactInstanceManager = ReactInstanceManagerProvider.getReactInstanceManager(getApplication(), this);
    // The string here (e.g. "IntegratedApp") has to match
    // the string in AppRegistry.registerComponent() in index.js
    Bundle bundle = new Bundle();
    bundle.putBoolean("isFromNativeApp", true);
    bundle.putBundle("navigation", null);

    ArrayList<ItemData> ll = new ArrayList<>();
    ll.add(new ItemData("1", "Test 1"));
    ll.add(new ItemData("2", "Test 2"));
    ll.add(new ItemData("3", "Test 3"));
    ll.add(new ItemData("4", "Test 4"));
    ll.add(new ItemData("5", "Test 5"));
    ll.add(new ItemData("6", "Test 6"));
    ll.add(new ItemData("7", "Test 7"));
    Gson gson = new Gson();
    String array = gson.toJson(ll);

    bundle.putString("data", array);

    mReactRootView.startReactApplication(mReactInstanceManager, "CustomListView", bundle);

    setContentView(mReactRootView);
  }

  @Override
  public ReactInstanceManager getInstanceManager() {
    return mReactInstanceManager;
  }

  @Override
  public ReactRootView getRootView() {
    return mReactRootView;
  }
}
