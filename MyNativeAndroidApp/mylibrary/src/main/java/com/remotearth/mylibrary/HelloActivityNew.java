package com.remotearth.mylibrary;

import android.app.Activity;
import android.os.Bundle;

import com.facebook.hermes.reactexecutor.HermesExecutorFactory;
import com.facebook.react.ReactActivity;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactRootView;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.facebook.react.shell.MainReactPackage;
import com.facebook.soloader.SoLoader;

public class HelloActivityNew extends ReactActivity implements DefaultHardwareBackBtnHandler {
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

    if (mReactInstanceManager == null) {
      mReactInstanceManager = ReactInstanceManager.builder()
        .setApplication(getApplication())
        .setCurrentActivity(this)
        .setBundleAssetName("index.android.bundle")
        .setJSMainModulePath("index")
        .addPackage(new MainReactPackage())
        .setJavaScriptExecutorFactory(new HermesExecutorFactory())
//      .addPackages(packages)
        .setUseDeveloperSupport(BuildConfig.DEBUG)
        .setInitialLifecycleState(LifecycleState.RESUMED)
        .build();
    }

    // The string here (e.g. "IntegratedApp") has to match
    // the string in AppRegistry.registerComponent() in index.js
    mReactRootView.startReactApplication(mReactInstanceManager, "HelloPageNew", null);

    setContentView(mReactRootView);
  }

}