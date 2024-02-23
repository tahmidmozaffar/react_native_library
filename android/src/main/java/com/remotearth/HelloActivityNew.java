package com.remotearth;

import android.os.Bundle;

import com.facebook.react.ReactActivity;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactRootView;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.facebook.soloader.SoLoader;

public class HelloActivityNew extends BaseReactActivity {
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


      mReactInstanceManager = ReactInstanceManagerProvider.getReactInstanceManager(getApplication(),this);

    // The string here (e.g. "IntegratedApp") has to match
    // the string in AppRegistry.registerComponent() in index.js
    mReactRootView.startReactApplication(mReactInstanceManager, "HelloPageNew", null);

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
