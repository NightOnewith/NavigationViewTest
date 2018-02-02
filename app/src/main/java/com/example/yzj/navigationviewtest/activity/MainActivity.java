package com.example.yzj.navigationviewtest.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.example.yzj.navigationviewtest.R;
import com.example.yzj.navigationviewtest.utils.ToastUtil;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    private TextView accountName;
    //private TextView account;
    private Button btn_add_device;

    public final static int Request_Code_Main = 100;
    //public final static int Result_Code_Main = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        accountName = navigationView.getHeaderView(0).findViewById(R.id.accoutName);
        //account = navigationView.getHeaderView(0).findViewById(R.id.account);
        btn_add_device = (Button) findViewById(R.id.btn_add_device);
        btn_add_device.setOnClickListener(this);

        Intent intent = getIntent();
        String email = intent.getStringExtra("email");
        String[] strings = email.split("@");
        accountName.setText(strings[0]);
        //account.setText(email);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            ToastUtil.showToast(getApplicationContext(), "This is test settings!");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            ToastUtil.showToast(getApplicationContext(), "This is test camera!");
        } else if (id == R.id.nav_gallery) {
            ToastUtil.showToast(getApplicationContext(), "This is test gallery!");
        } else if (id == R.id.nav_slideshow) {
            ToastUtil.showToast(getApplicationContext(), "This is test slideshow!");
        } else if (id == R.id.nav_manage) {
            ToastUtil.showToast(getApplicationContext(), "This is test manage!");
        } else if (id == R.id.nav_close) {
            //Intent i = new Intent();
            //i.putExtra("count","1234");
            //setResult(MainActivity.Result_Code_Main, i);
            finish();
        } else if (id == R.id.nav_sign_out) {
            finish();
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_add_device:
                //ToastUtil.showToast(getApplicationContext(), "开始添加设备");
                Intent intent = new Intent(getApplicationContext(), ChooseDevType.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
