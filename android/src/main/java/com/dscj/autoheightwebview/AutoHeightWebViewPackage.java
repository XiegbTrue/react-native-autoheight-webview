package com.dscj.autoheightwebview;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AutoHeightWebViewPackage implements ReactPackage {


    private RNWebViewModule module;
    private AutoHeightWebViewManager viewManager;
    @Override
    public List<NativeModule> createNativeModules(ReactApplicationContext reactApplicationContext) {
        module = new RNWebViewModule(reactApplicationContext);
        module.setPackage(this);

        List<NativeModule> modules = new ArrayList<>();
        modules.add(module);

        return modules;
    }

    @Override
    public List<ViewManager> createViewManagers(ReactApplicationContext reactApplicationContext) {
        viewManager = new AutoHeightWebViewManager();
        viewManager.setPackage(this);
        return Arrays.<ViewManager>asList(
                new AutoHeightWebViewManager()
        );
    }
    public RNWebViewModule getModule() {
        return module;
    }

    public AutoHeightWebViewManager getViewManager() {
        return viewManager;
    }
}