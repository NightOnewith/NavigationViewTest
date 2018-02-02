package com.example.yzj.navigationviewtest.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yzj.navigationviewtest.R;
import com.example.yzj.navigationviewtest.utils.ToastUtil;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    private ImageView iv_user;
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
        accountName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToastUtil.showToast(getApplicationContext(), accountName.getText());
            }
        });

        iv_user = navigationView.getHeaderView(0).findViewById(R.id.iv_user);
        iv_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToastUtil.showToast(getApplicationContext(), accountName.getText());
            }
        });

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

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//
//        if (id == R.id.action_settings) {
//            ToastUtil.showToast(getApplicationContext(), "This is test settings!");
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_help) {
            ToastUtil.showToast(getApplicationContext(), "帮助与反馈");
        } else if (id == R.id.nav_sale_service) {
            ToastUtil.showToast(getApplicationContext(), "售后服务");
        } else if (id == R.id.nav_setting) {
            ToastUtil.showToast(getApplicationContext(), "设置");
        } else if (id == R.id.nav_add) {
            //Intent i = new Intent();
            //i.putExtra("count","1234");
            //setResult(MainActivity.Result_Code_Main, i);
            //finish();

            //ToastUtil.showToast(getApplicationContext(), "添加设备");

            Intent intent = new Intent(this, ChooseDevType.class);
            startActivityForResult(intent, ChooseDevType.Request_Code_Main);
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ChooseDevType.Request_Code_Main && resultCode == ChooseDevType.Result_Code_Main){
            //ToastUtil.showToast(getApplicationContext(), "返回主页");
        }
    }
}
