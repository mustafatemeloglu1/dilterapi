package com.dilterapi.app;
import android.app.*;import android.os.*;import android.webkit.*;import android.graphics.Color;import android.view.*;import android.speech.tts.TextToSpeech;import java.util.*;
public class MainActivity extends Activity{
 WebView w; TextToSpeech tts;
 @Override public void onCreate(Bundle b){super.onCreate(b);
  tts=new TextToSpeech(this,status->{ if(status==TextToSpeech.SUCCESS){tts.setLanguage(new Locale("tr","TR"));tts.setSpeechRate(.88f);} });
  w=new WebView(this); w.setBackgroundColor(Color.WHITE); WebSettings s=w.getSettings(); s.setJavaScriptEnabled(true); s.setDomStorageEnabled(true); s.setAllowFileAccess(true); s.setAllowContentAccess(true); s.setLoadsImagesAutomatically(true);
  w.addJavascriptInterface(new Object(){ @JavascriptInterface public void speak(String text){ if(tts!=null){tts.stop();tts.speak(text,TextToSpeech.QUEUE_FLUSH,null,"dilterapi");}} },"AndroidTTS");
  w.setOverScrollMode(View.OVER_SCROLL_NEVER); w.loadUrl("file:///android_asset/index.html"); setContentView(w);
 }
 @Override public void onDestroy(){if(tts!=null){tts.stop();tts.shutdown();}super.onDestroy();}
 @Override public void onBackPressed(){if(w.canGoBack())w.goBack();else super.onBackPressed();}
}
