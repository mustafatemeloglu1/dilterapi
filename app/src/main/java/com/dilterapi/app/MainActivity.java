package com.dilterapi.app;
import android.app.*;import android.os.*;import android.webkit.*;import android.graphics.Color;import android.view.*;
public class MainActivity extends Activity{
 WebView w;
 @Override public void onCreate(Bundle b){super.onCreate(b);w=new WebView(this);w.setBackgroundColor(Color.WHITE);w.getSettings().setJavaScriptEnabled(true);w.getSettings().setDomStorageEnabled(true);w.getSettings().setAllowFileAccess(true);w.setOverScrollMode(View.OVER_SCROLL_NEVER);w.loadUrl("file:///android_asset/index.html");setContentView(w);}
 @Override public void onBackPressed(){if(w.canGoBack())w.goBack();else super.onBackPressed();}
}
