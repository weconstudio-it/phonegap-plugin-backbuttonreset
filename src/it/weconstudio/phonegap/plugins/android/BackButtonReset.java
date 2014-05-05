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
import java.util.Date;

public class BackButtonReset extends CordovaPlugin {

    private static final String LOG_TAG = "BackButtonReset";

    private static Date dateLastBack = null;

    private static final int epsilonDoubleBack = 2000;
    
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);

        final CordovaActivity act = (CordovaActivity)this.cordova.getActivity();
        
        webView.setOnKeyListener(new OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP) {
                	//Log.d(LOG_TAG, "back");
                	
                	if(dateLastBack!=null){
                		//Log.d(LOG_TAG, "data not null");
                		Date now = new Date();
                		if(now.getTime() - dateLastBack.getTime() < epsilonDoubleBack){
                			//Log.d(LOG_TAG, "devo chiudermi");
                			act.finish();
                            System.exit(0);
                		}
                	}
                	
                	dateLastBack = new Date();
                	//Log.d(LOG_TAG, "data settata");
                	
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
