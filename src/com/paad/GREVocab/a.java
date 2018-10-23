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

public class a extends ListActivity
{
  ArrayList<String> items;
  String[] mean;
  TextView selection;
  public a()
  {
    ArrayList localArrayList = new ArrayList();
    this.items = localArrayList;
    String[] arrayOfString = mean;
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
          ArrayAdapter localArrayAdapter = new ArrayAdapter(this, R.layout.main, localArrayList1);
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
    case KeyEvent.KEYCODE_BACK:
	  Intent localIntent = new Intent("Complete");
      setResult(-1, localIntent);
      finish();
    case KeyEvent.KEYCODE_CAMERA:
      Toast.makeText(this, "Pressed Camera Button", 0).show();
      break;
    case KeyEvent.KEYCODE_ENDCALL:
	   finish();
    default:
       break;
    }
    return false;
  }

  public void onListItemClick(ListView paramListView, View paramView, int paramInt, long paramLong)
  {
    TextView localTextView = this.selection;
    String str = this.mean[paramInt];
    localTextView.setText(str);
    Animation localAnimation = AnimationUtils.loadAnimation(this, R.anim.animate);
    localAnimation.reset();
    this.selection.startAnimation(localAnimation);
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    case R.id.develop:
      Intent localIntent1 = new Intent(this, mydev.class);
      startActivity(localIntent1);
      break;
	case R.id.setting:
      Toast.makeText(this, "Enjoy The Colors!!!", 1).show();
	case R.id.submenu1:
      getListView().setBackgroundColor(0xfff00000);
      break;
	/*case R.id.submenu2:
      getListView().setBackgroundColor(FFFFAF);
      break;
	case R.id.submenu3:
	  getListView().setBackgroundColor(778899);
      break;
	case R.id.submenu4:
      getListView().setBackgroundColor(0000CD);
      break;
	case R.id.submenu5:
      getListView().setBackgroundColor(228B22);
      break;
	case R.id.submenu6:
      getListView().setBackgroundColor(2FOE6C);
      break;
	case R.id.submenu7:
      getListView().setBackgroundColor(8B4513);
      break;
	case R.id.submenu8:
      getListView().setBackgroundColor(8A2BE2);
      break;
	case R.id.submenu9:
      getListView().setBackgroundColor(3CB371);
      break;
	case R.id.submenu10:
      getListView().setBackgroundColor(FF6347);
      break;
	case R.id.submenu11:
      getListView().setBackgroundColor(9370DB);
      break;
	case R.id.submenu12:
      getListView().setBackgroundColor(838B83);
      break;
	case R.id.submenu13:
      getListView().setBackgroundColor(FFFFFF);
      break;
	case R.id.submenu14:
      getListView().setBackgroundColor(FF0000);
      break;*/
	case R.id.fact:
      AlertDialog.Builder localBuilder = new AlertDialog.Builder(this).setTitle("FAQs").setMessage
	  ("It's a Basic GRE Vocabulary software...\nBrowse Through The Words And Click To See its Meaning...");
      break;
    
	case R.id.quit:
	  finish();
      break;
   
    case R.id.inf:
	  Toast.makeText(this, "Program Size: 1024Kb \nDistribution Restricted", 1).show();
    
    case R.id.sub1:
	 Intent localIntent3 = new Intent(this, a.class);
      startActivity(localIntent3);
      break;
    case R.id.feedback:
	  Uri localUri = Uri.fromParts("sms", "09646864149", null);
      Intent localIntent4 = new Intent("android.intent.action.VIEW", localUri);
      startActivity(localIntent4);
    }
	return false;
  }
}