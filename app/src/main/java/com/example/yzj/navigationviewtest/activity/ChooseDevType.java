package com.example.yzj.navigationviewtest.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.yzj.navigationviewtest.R;
import com.example.yzj.navigationviewtest.adapter.RecyclerAdapter;
import com.example.yzj.navigationviewtest.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yzj on 2018/2/1.
 */

public class ChooseDevType extends AppCompatActivity {

    private List<String> mDatas = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private RecyclerAdapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_dev_type);
        initView();
        initData();

        recyclerAdapter = new RecyclerAdapter(this,mDatas);
        mRecyclerView.setAdapter(recyclerAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        recyclerAdapter.setOnMyItemClickListener(new RecyclerAdapter.OnMyItemClickListener() {
            @Override
            public void myClick(View v, int pos) {
                ToastUtil.showToast(getApplicationContext(), "onClick:第"+pos+"个item");
            }
        });
    }

    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
    }

    private void initData() {
        for (int i = 0; i < 30; i++) {
            mDatas.add("锁具: "+i);
        }
    }
}
