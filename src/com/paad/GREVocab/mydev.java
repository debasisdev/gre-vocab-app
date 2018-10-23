package com.paad.GREVocab;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

public class mydev extends Activity
{
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(R.layout.screen2);
    Button localButton = (Button)findViewById(btnClick2);
    mydev.1 local1 = new mydev.1(this);
    localButton.setOnClickListener(local1);
  }
}
