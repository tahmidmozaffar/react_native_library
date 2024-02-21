package com.remotearth.mylibrary;

import android.app.Activity;
import android.app.Application;

import com.facebook.hermes.reactexecutor.HermesExecutorFactory;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactPackage;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.shell.MainReactPackage;

import java.util.ArrayList;
import java.util.List;

public class ReactInstanceManagerProvider {

  public static ReactInstanceManager getReactInstanceManager(Application application, Activity activity){

    List<ReactPackage> pp = new ArrayList<>();
    pp.add(new MainReactPackage());
    pp.add(new RemotearthPackage());

    return ReactInstanceManager.builder()
      .setApplication(application)
      .setCurrentActivity(activity)
      .setBundleAssetName("index.android.bundle")
      .setJSMainModulePath("index")
      .addPackages(pp)
      .setJavaScriptExecutorFactory(new HermesExecutorFactory())
      .setUseDeveloperSupport(BuildConfig.DEBUG)
      .setInitialLifecycleState(LifecycleState.RESUMED)
      .build();
  }
}
