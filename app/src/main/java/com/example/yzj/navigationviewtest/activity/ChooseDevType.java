package com.example.yzj.navigationviewtest.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.yzj.navigationviewtest.R;
import com.example.yzj.navigationviewtest.adapter.RecyclerAdapter;
import com.example.yzj.navigationviewtest.pojo.DeviceType;
import com.example.yzj.navigationviewtest.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yzj on 2018/2/1.
 */

public class ChooseDevType extends AppCompatActivity {

    public final static int Request_Code_Main = 100;
    public final static int Result_Code_Main = 101;

    private List<DeviceType> mDatas = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private RecyclerAdapter recyclerAdapter;
    private Toolbar toolbar;

    public static final int DEVICE_TYPE_LOCK = 1;
    public static final int DEVICE_TYPE_HUB = 2;
    public static final int DEVICE_TYPE_GENESIS = 3;
    public static final int DEVICE_TYPE_DOOR_LOCK = 4;
    public static final int DEVICE_TYPE_DOOR_SENSOR = 5;
    public static final int DEVICE_TYPE_DOOR_LOCK2 = 6;
    public static final int DEVICE_TYPE_MOTION_SENSOR = 7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_dev_type);
        initView();
        initData();

        setSupportActionBar(toolbar);

        recyclerAdapter = new RecyclerAdapter(this,mDatas);
        mRecyclerView.setAdapter(recyclerAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        recyclerAdapter.setOnMyItemClickListener(new RecyclerAdapter.OnMyItemClickListener() {
            @Override
            public void myClick(View v, int pos) {
                ToastUtil.showToast(getApplicationContext(), mDatas.get(pos).getName());
            }
        });

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(Result_Code_Main);
                finish();
            }
        });
    }

    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
    }

    private void initData() {
        DeviceType lock = new DeviceType(DEVICE_TYPE_LOCK, getString(R.string.safe_lock), R.drawable.img_safelocks);
        DeviceType hub = new DeviceType(DEVICE_TYPE_HUB, getString(R.string.HUB), R.drawable.img_hub);
        DeviceType genesis = new DeviceType(DEVICE_TYPE_GENESIS, getString(R.string.GENESIS), R.drawable.img_ds_doorlock_without_logo);
        DeviceType doorLock  = new DeviceType(DEVICE_TYPE_DOOR_LOCK, getString(R.string.door_lock), R.drawable.img_ds_dl);
        DeviceType doorLock2 = new DeviceType(DEVICE_TYPE_DOOR_LOCK2, getString(R.string.door_lock2), R.drawable.img_door_lock2);
        DeviceType doorSensor = new DeviceType(DEVICE_TYPE_DOOR_SENSOR, getString(R.string.door_sensor), R.drawable.img_ds_sensor_without_logo);
        DeviceType motionSensor = new DeviceType(DEVICE_TYPE_MOTION_SENSOR, getString(R.string.motion_sensor), R.drawable.img_motion_sensor);
        mDatas.add(lock);
        mDatas.add(hub);
        mDatas.add(genesis);
        mDatas.add(doorLock);
        mDatas.add(doorLock2);
        mDatas.add(doorSensor);
        mDatas.add(motionSensor);
        //recyclerAdapter.notifyDataSetChanged();
    }
}
