package coral.co.coralin;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Toast;

public class MainScreenActivity extends AppCompatActivity
{
    //Defining Variables
    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        // Initializing Toolbar and setting it as the actionbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Initializing NavigationView
        navigationView = (NavigationView) findViewById(R.id.navigation_view);

        //Setting Navigation View Item Selected Listener to handle the item click of the navigation menu
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener()
        {
            // This method will trigger on item Click of navigation menu
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem)
            {
                //Checking if the item is in checked state or not, if not make it in checked state
                if (menuItem.isChecked()) menuItem.setChecked(false);
                else menuItem.setChecked(true);

                //Closing drawer on item click
                drawerLayout.closeDrawers();

                //Check to see which item was being clicked and perform appropriate action
                switch (menuItem.getItemId())
                {
                    //Replacing the main content with ContentFragment Which is our My Progress View;
                    case R.id.item_navigation_drawer_my_progress:
                        Toast.makeText(getApplicationContext(), "My Progress Selected", Toast.LENGTH_SHORT).show();
                        ContentFragment fragment = new ContentFragment();
                        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.frame, fragment);
                        fragmentTransaction.commit();
                        return true;

                    // For rest of the options we just show a toast on click
                    case R.id.item_navigation_drawer_my_courses:
                        Toast.makeText(getApplicationContext(), "My Courses Selected", Toast.LENGTH_SHORT).show();
                        MyCoursesFragment fragmentMyCourses = new MyCoursesFragment();
                        android.support.v4.app.FragmentTransaction fragmentTransactionMyCourses = getSupportFragmentManager().beginTransaction();
                        fragmentTransactionMyCourses.replace(R.id.frame, fragmentMyCourses);
                        fragmentTransactionMyCourses.commit();
                        return true;

                    case R.id.item_navigation_drawer_courses:
                        Toast.makeText(getApplicationContext(), "Courses Selected", Toast.LENGTH_SHORT).show();
                        CoursesFragment fragmentCourses = new CoursesFragment();
                        android.support.v4.app.FragmentTransaction fragmentTransactionCourses = getSupportFragmentManager().beginTransaction();
                        fragmentTransactionCourses.replace(R.id.frame, fragmentCourses);
                        fragmentTransactionCourses.commit();
                        return true;

                    case R.id.item_navigation_drawer_other_resources:
                        Toast.makeText(getApplicationContext(), "Other Resources Selected", Toast.LENGTH_SHORT).show();
                        OtherResourcesFragment fragmentOtherResources = new OtherResourcesFragment();
                        android.support.v4.app.FragmentTransaction fragmentTransactionOtherResources = getSupportFragmentManager().beginTransaction();
                        fragmentTransactionOtherResources.replace(R.id.frame, fragmentOtherResources);
                        fragmentTransactionOtherResources.commit();
                        return true;

                    case R.id.item_navigation_drawer_my_downloaded_games:
                        Toast.makeText(getApplicationContext(), "My Downloaded Games Selected", Toast.LENGTH_SHORT).show();
                        MyDownloadedGamesFragment fragmentMyDownloadedGames = new MyDownloadedGamesFragment();
                        android.support.v4.app.FragmentTransaction fragmentTransactionMyDownloadedGames = getSupportFragmentManager().beginTransaction();
                        fragmentTransactionMyDownloadedGames.replace(R.id.frame, fragmentMyDownloadedGames);
                        fragmentTransactionMyDownloadedGames.commit();
                        return true;

                    case R.id.item_navigation_drawer_notifications:
                        Toast.makeText(getApplicationContext(), "Notifications Selected", Toast.LENGTH_SHORT).show();
                        NotificationsFragment fragmentNotifications = new NotificationsFragment();
                        android.support.v4.app.FragmentTransaction fragmentTransactionNotifications = getSupportFragmentManager().beginTransaction();
                        fragmentTransactionNotifications.replace(R.id.frame, fragmentNotifications);
                        fragmentTransactionNotifications.commit();
                        return true;

                    case R.id.item_navigation_drawer_settings:
                        Toast.makeText(getApplicationContext(), "Settings Selected", Toast.LENGTH_SHORT).show();
                        SettingsFragment fragmentSettings = new SettingsFragment();
                        android.support.v4.app.FragmentTransaction fragmentTransactionSettings = getSupportFragmentManager().beginTransaction();
                        fragmentTransactionSettings.replace(R.id.frame, fragmentSettings);
                        fragmentTransactionSettings.commit();
                        return true;

                    case R.id.item_navigation_drawer_signout:
                        Toast.makeText(getApplicationContext(), "Sign Out Selected", Toast.LENGTH_SHORT).show();
                        Intent signOut = new Intent(MainScreenActivity.this, LoginActivity.class);
                        finish();
                        startActivity(signOut);
                        return true;

                    default:
                        Toast.makeText(getApplicationContext(), "Somethings Wrong", Toast.LENGTH_SHORT).show();
                        return true;
                }
            }
        });

        // Initializing Drawer Layout and ActionBarToggle
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.openDrawer, R.string.closeDrawer)
        {
            @Override
            public void onDrawerClosed(View drawerView)
            {
                // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView)
            {
                // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank
                super.onDrawerOpened(drawerView);
            }
        };

        //Setting the actionbarToggle to drawer layout
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        //drawerLayout.setDrawerListener(actionBarDrawerToggle);

        //calling sync state is necessay or else your hamburger icon wont show up
        actionBarDrawerToggle.syncState();

        ContentFragment fragment = new ContentFragment();
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame, fragment);
        fragmentTransaction.commit();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.item_navigation_drawer_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {}

}