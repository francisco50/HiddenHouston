package com.example.hiddenhouston;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ShareActionProvider;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

//import android.widget.Toolbar;




public class MainActivity extends AppCompatActivity
{
    private ShareActionProvider shareActionProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        //assert actionBar != null;
        //actionBar.setDisplayHomeAsUpEnabled(true);
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        //inflate the menu; this adds items to the app bar
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem menuItem = menu.findItem(R.id.action_share);
        shareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);
        //get the reference to the action private variable. then call the setshareActionintent() method.
        setShareActionIntent("Want to join me tonight");
        return super.onCreateOptionsMenu(menu);
    }

    public void setShareActionIntent(String text)
    {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT,text);
        shareActionProvider.setShareIntent(intent);
        //we created this to create and intent, and passes it to the share action provider using its setShareIntent() method.
    }

    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.action_share:



            default: return super.onOptionsItemSelected(item);
        }
    }


    public void Option1(View view)
    {
        Intent intent = new Intent(this,Option1.class);
        startActivity(intent);
    }

    public void Option2(View view)
    {
        Intent intent = new Intent(this, Option2.class);
        startActivity(intent);
    }

    public void Option3(View view)
    {
        Intent intent = new Intent(this, Option3.class);
        startActivity(intent);
    }
}
