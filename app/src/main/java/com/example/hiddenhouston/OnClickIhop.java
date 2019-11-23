package com.example.hiddenhouston;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ShareActionProvider;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.tabs.TabLayout;

public class OnClickIhop extends AppCompatActivity
{

   private ShareActionProvider shareActionProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_click_ihop);

        //Toolbar
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Appbar
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);

        //Attach the selectionsPPager to the Viewpager
        SectionsPagerAdapter pagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(pagerAdapter);

        //Attach the Viewpager to the TabLayout
        TabLayout tabLayout = (TabLayout)findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(pager);

        //Attach the add ( plus ) button



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


    private class SectionsPagerAdapter extends FragmentPagerAdapter {
        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new Breakfast();
                case 1:
                    return new Burgers();
                case 2:
                    return new Beverages();
                case 3:
                    return new Menu_1();
            }
            return null;
        }


        //To add the text to each of the tabs, you need to implement the fragment pager adapter’s getPageTitle() method.
        // This takes one parameter, an int for the tab’s position, and needs to return the text that should appear on that tab.
        @Override
        public CharSequence getPageTitle(int position)
        {
            switch (position)
            {
                case 0:
                    return getResources().getText(R.string.breakfast_tab);
                case 1:
                    return getResources().getText(R.string.lunch_tab);
                case 2:
                    return getResources().getText(R.string.beverages_tab);
                case 3:
                    return getResources().getText(R.string.snacks_tab);

            }
            return null;
        }
    }
}
