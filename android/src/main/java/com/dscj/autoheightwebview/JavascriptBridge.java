package com.dscj.autoheightwebview;


import android.webkit.JavascriptInterface;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.tencent.smtt.sdk.WebView;

class JavascriptBridge {
    private WebView webView;

    public JavascriptBridge(WebView webView) {
        this.webView = webView;
    }

    @JavascriptInterface
    public void send(String message) {
        WritableMap event = Arguments.createMap();
        event.putString("message", message);
        ReactContext reactContext = (ReactContext) this.webView.getContext();
        reactContext.getJSModule(RCTEventEmitter.class).receiveEvent(
                this.webView.getId(),
                "topChange",
                event);
    }
}