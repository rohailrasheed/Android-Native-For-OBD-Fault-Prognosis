package com.example.its_fyp;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.example.its_fyp.fragments.AssistanceFragment;
import com.example.its_fyp.fragments.CarFragment;
import com.example.its_fyp.fragments.DiagnosticsFragment;
import com.example.its_fyp.fragments.DriveFragment;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

/* loaded from: classes6.dex */
public class MainActivity extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener, NavigationView.OnNavigationItemSelectedListener {
    public ActionBarDrawerToggle actionBarDrawerToggle;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.drawerLayout = (DrawerLayout) findViewById(R.id.my_drawer_layout);
        this.navigationView = (NavigationView) findViewById(R.id.nav_darwer);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, this.drawerLayout, R.string.nav_open, R.string.nav_close);
        this.actionBarDrawerToggle = actionBarDrawerToggle;
        this.drawerLayout.addDrawerListener(actionBarDrawerToggle);
        this.actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() { // from class: com.example.its_fyp.MainActivity$$ExternalSyntheticLambda0
            @Override // com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener
            public final boolean onNavigationItemSelected(MenuItem menuItem) {
                return MainActivity.this.onNavigationItemSelected(menuItem);
            }
        });
        attachCarFragment();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem item) {
        if (this.actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override // com.google.android.material.navigation.NavigationBarView.OnItemSelectedListener, com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener
    public boolean onNavigationItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.nav_my_car) {
            attachCarFragment();
            closeDrawer();
            return true;
        } else if (item.getItemId() == R.id.nav_drive) {
            attachDriveFragment();
            closeDrawer();
            return false;
        } else if (item.getItemId() == R.id.nav_diagnostics) {
            attachDiagnosticsFragment();
            closeDrawer();
            return false;
        } else if (item.getItemId() == R.id.nav_assistance) {
            attachAssistanceFragment();
            closeDrawer();
            return false;
        } else {
            return false;
        }
    }

    private void attachAssistanceFragment() {
        AssistanceFragment assistanceFragment = new AssistanceFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_continer, assistanceFragment).commit();
    }

    private void attachDiagnosticsFragment() {
        DiagnosticsFragment diagnosticsFragment = new DiagnosticsFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_continer, diagnosticsFragment).commit();
    }

    private void attachDriveFragment() {
        DriveFragment driveFragment = new DriveFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_continer, driveFragment).commit();
    }

    private void closeDrawer() {
        this.drawerLayout.closeDrawer(GravityCompat.START, false);
    }

    private void attachCarFragment() {
        CarFragment carFragment = new CarFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_continer, carFragment).commit();
    }
}