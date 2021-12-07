package com.example.starbuzz;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ShareActionProvider;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.starbuzz.Fragments.PastaFragment;
import com.example.starbuzz.Fragments.PizzaFragment;
import com.example.starbuzz.Fragments.StoresFragment;
import com.example.starbuzz.Fragments.TopFragment;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private ShareActionProvider shareActionProvider; //Always use the androidx.appcompact one

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar(findViewById(R.id.tool_bar));

        //Attach the sectionPagerAdapter to the ViewPager
        SectionPagerAdapter sectionPagerAdapter = new SectionPagerAdapter(getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.pager);
        viewPager.setAdapter(sectionPagerAdapter);

        //Attach Viewpager to the TabLayout
        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        /*listView = findViewById(R.id.list_options);

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {  //Create the listener.
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {// Implement its onItemClick() method.
                if(position == 0) {
                    Intent intent = new Intent(MainActivity.this, DrinkCategoryActivity.class); //Launch DrinkCategoryActivity if the user clicks on the Drinks item.
                    startActivity(intent);
                }else if(position == 1){
                    Intent snacks = new Intent(MainActivity.this,SnacksActivity.class);
                    startActivity(snacks);
                }
            }
        };

        listView.setOnItemClickListener(itemClickListener);  Add the listener to the view
         */
    }

    private class SectionPagerAdapter extends FragmentPagerAdapter {

        public SectionPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) { //The getCount() method specifies 4 pages, so the getItem() method should only request the fragments for these 4 page positions.
            switch (position) {
                case 0:
                    return new TopFragment(); // We want to display TopFragment first, so we’ll return a new instance of it for position 0 of the ViewPager.
                case 1:
                    return new PizzaFragment();
                case 2:
                    return new PastaFragment();
                case 3:
                    return new StoresFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 4;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {  //This method adds the text to the tabs.
            switch (position) {
                case 0:
                    return getResources().getText(R.string.home_tab);
                case 1:
                    return getResources().getText(R.string.pizza_tab);
                case 2:
                    return getResources().getText(R.string.pasta_tab);
                case 3:
                    return getResources().getText(R.string.stores_tab);
            }
            return null;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        MenuItem menuItem = menu.findItem(R.id.action_share);
        shareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);
        setShareActionIntent("Want to join me for Pizza?");
        return super.onCreateOptionsMenu(menu);
    }

    private void setShareActionIntent(String text) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, text);
        shareActionProvider.setShareIntent(intent);  //This sets the default text in the share action provider.
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {    //This method gets called when an action on the app bar is clicked.
        switch (item.getItemId()) {
            case R.id.action_create_order:
                Intent order = new Intent(MainActivity.this, OrderActivity.class);
                startActivity(order);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}