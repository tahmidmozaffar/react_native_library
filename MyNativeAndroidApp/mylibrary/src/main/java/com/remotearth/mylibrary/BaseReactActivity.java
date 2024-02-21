package com.remotearth.mylibrary;

import com.facebook.react.ReactActivity;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactRootView;

public abstract class BaseReactActivity extends ReactActivity {

  public abstract ReactInstanceManager getInstanceManager();

  public abstract ReactRootView getRootView();

  @Override
  protected void onPause() {
    super.onPause();
    ReactInstanceManager mReactInstanceManager = getInstanceManager();
    if (mReactInstanceManager != null) {
      mReactInstanceManager.onHostPause(this);
    }
  }

  @Override
  protected void onResume() {
    super.onResume();
    ReactInstanceManager mReactInstanceManager = getInstanceManager();
    if (mReactInstanceManager != null) {
      mReactInstanceManager.onHostResume(this, this);
    }
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();

    ReactInstanceManager mReactInstanceManager = getInstanceManager();
    ReactRootView mReactRootView = getRootView();

    if (mReactInstanceManager != null) {
      mReactInstanceManager.onHostDestroy(this);
    }
    if (mReactRootView != null) {
      mReactRootView.unmountReactApplication();
    }
  }
}
