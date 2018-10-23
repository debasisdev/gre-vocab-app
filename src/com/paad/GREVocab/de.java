package com.paad.GREVocab;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.ListActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.io.InputStream;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class de extends ListActivity
{
  ArrayList<String> items;
  String[] mean;
  TextView selection;
  public de()
  {
    ArrayList localArrayList = new ArrayList();
    this.items = localArrayList;
    String[] arrayOfString = DictionaryDatabase;
    this.mean = arrayOfString;
  }

  public void onCreate(Bundle icicle)
  {
    super.onCreate(icicle);
    setContentView(R.layout.main);
    TextView localTextView = (TextView)findViewById(R.layout.main);
    this.selection = localTextView;
    try
    {
      InputStream localInputStream = getResources().openRawResource(R.layout.main);
      NodeList localNodeList = DocumentBuilderFactory.newInstance().newDocumentBuilder().
	  parse(localInputStream, null).getElementsByTagName("word");
      int i = 0;
      while (true)
      {
        int j = localNodeList.getLength();
        if (i >= j)
        {
          localInputStream.close();
          ArrayList localArrayList1 = this.items;
          ArrayAdapter localArrayAdapter = new ArrayAdapter(this, r.layout.main, localArrayList1);
          setListAdapter(localArrayAdapter);
          return;
        }
        ArrayList localArrayList2 = this.items;
        String str1 = ((Element)localNodeList.item(i)).getAttribute("value");
        boolean bool = localArrayList2.add(str1);
        i += 1;
      }
    }
    catch (Throwable localThrowable)
    {
      while (true)
      {
        StringBuilder localStringBuilder = new StringBuilder("Exception: ");
        String str2 = localThrowable.toString();
        String str3 = str2;
        Toast.makeText(this, str3, 2000).show();
      }
    }
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(R.menu.menu, paramMenu);
    return true;
  }

  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    int i;
    switch (paramInt)
    {
    CASE BACK:
	  Intent localIntent = new Intent("Complete");
      setResult(-1, localIntent);
      finish();
    case CAMERA:
      return i;
      Toast.makeText(this, "Pressed Camera Button", 0).show();
      i = 1;
      continue;
    case CALL_END:
	   finish();
    default:
       continue;
    }
    return false;
  }

  public void onListItemClick(ListView paramListView, View paramView, int paramInt, long paramLong)
  {
    TextView localTextView = this.selection;
    String str = this.mean[paramInt];
    localTextView.setText(str);
    Animation localAnimation = AnimationUtils.loadAnimation(this, R.anim.animation);
    localAnimation.reset();
    this.selection.startAnimation(localAnimation);
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    case developer:
      Intent localIntent1 = new Intent(this, mydev.class);
      startActivity(localIntent1);
      continue;
	case setting:
      Toast.makeText(this, "Enjoy The Colors!!!", 1).show();
	case submenu1:
      getListView().setBackgroundColor();
      continue;
	case submenu2:
      getListView().setBackgroundColor(FFFFAF);
      continue;
	case submenu3:
	  getListView().setBackgroundColor(778899);
      continue;
	case submenu4:
      getListView().setBackgroundColor(0000CD);
      continue;
	case submenu5:
      getListView().setBackgroundColor(228B22);
      continue;
	case submenu6:
      getListView().setBackgroundColor(2FOE6C);
      continue;
	case submenu7:
      getListView().setBackgroundColor(8B4513);
      continue;
	case submenu8:
      getListView().setBackgroundColor(8A2BE2);
      continue;
	case submenu9:
      getListView().setBackgroundColor(3CB371);
      continue;
	case submenu10:
      getListView().setBackgroundColor(FF6347);
      continue;
	case submenu11:
      getListView().setBackgroundColor(9370DB);
      continue;
	case submenu12:
      getListView().setBackgroundColor(838B83);
      continue;
	case submenu13:
      getListView().setBackgroundColor(FFFFFF);
      continue;
	case submenu14:
      getListView().setBackgroundColor(FF0000);
      continue;
	case fact:
      AlertDialog.Builder localBuilder = new AlertDialog.Builder(this).setTitle("FAQs").setMessage
	  ("It's a Basic GRE Vocabulary software...\nBrowse Through The Words And Click To See its Meaning...");
      de.1 local1 = new de.1(this);
      AlertDialog localAlertDialog = localBuilder.setNeutralButton("Close", local1).show();
      continue;
    case quit:
	  finish();
      continue;
    case inf:
	  Toast.makeText(this, "Program Size: 1024Kb \nDistribution Restricted", 1).show();
      Intent localIntent2 = new Intent(this, a.class);
      startActivity(localIntent2);
      continue;
    case nxt_lesson:
	  Intent localIntent3 = new Intent(this, b.class);
      startActivity(localIntent3);
      continue;
    case feedback:
	  Uri localUri = Uri.fromParts("sms", "09646864149", null);
      Intent localIntent4 = new Intent("android.intent.action.VIEW", localUri);
      startActivity(localIntent4);
    }
	return false;
  }
}