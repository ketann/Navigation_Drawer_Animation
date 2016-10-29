package com.gurukrupa.navigation_drawer_animation;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.gurukrupa.navigation_drawer_animation.fragment.FragmentEclair;
import com.gurukrupa.navigation_drawer_animation.fragment.FragmentFroyo;
import com.gurukrupa.navigation_drawer_animation.fragment.FragmentGingerbread;
import com.gurukrupa.navigation_drawer_animation.fragment.FragmentHoneycomb;
import com.gurukrupa.navigation_drawer_animation.fragment.NavigationDrawer;

public class MainActivity extends AppCompatActivity implements NavigationDrawer.NavigationDrawerCallbacks {

    private NavigationDrawer mNavigationDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNavigationDrawer = (NavigationDrawer)getSupportFragmentManager().findFragmentById(R.id.navigration_drawer);

        // Set a toolbar which will replace the action bar.
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Set up the drawer.
        mNavigationDrawer.setUp(
                R.id.navigration_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);

        // Load Fragment1 when the app starts
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, new FragmentEclair())
                .commit();
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mNavigationDrawer.getDrawerToggle().syncState();
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {

        FragmentManager fragmentManager = getSupportFragmentManager();

        switch (position) {
            case 0:

                fragmentManager.beginTransaction()
                        .replace(R.id.container, new FragmentEclair())
                        .commit();
                break;
            case 1:

                fragmentManager.beginTransaction()
                        .replace(R.id.container, new FragmentFroyo())
                        .commit();
                break;

            case 2:
                fragmentManager.beginTransaction()
                        .replace(R.id.container, new FragmentGingerbread())
                        .commit();
                break;
            case 3:
                fragmentManager.beginTransaction()
                        .replace(R.id.container, new FragmentHoneycomb())
                        .commit();
                break;
        }

    }
}
