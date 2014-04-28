package it.weconstudio.phonegap.plugins.android;

import org.apache.cordova.CordovaInterface;
import android.util.Log;
import android.os.Build;

import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaActivity;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.KeyEvent;
import android.view.KeyEvent.Callback;


public class BackButtonReset extends CordovaPlugin {

    private static final String LOG_TAG = "BackButtonReset";


    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);

        final CordovaActivity act = (CordovaActivity)this.cordova.getActivity();
        
        webView.setOnKeyListener(new OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP) {
                    // Do Here whatever you want 
                	// Log.d(LOG_TAG, "back");
                	
                	
                	act.showWebPage("file:///android_asset/www/index.html", false, true, null);
                	
                    return true;
                }
//                Log.d(LOG_TAG, "key down");
                return false;
                //return onKey(v,keyCode,event); //onKeyDown(keyCode, event); 
            } 
        });
        
        
        
        
        Log.d(LOG_TAG, "BackButtonReset: TRUE");

    }
}
