package com.example.yzj.navigationviewtest.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.yzj.navigationviewtest.R;

import java.util.List;

/**
 * Created by yzj on 2018/2/1.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private List<String> mDatas;
    private Context mContext;
    private LayoutInflater mInflater;

    private OnMyItemClickListener listener;

    public RecyclerAdapter(Context mContext, List<String> mDatas) {
        this.mDatas = mDatas;
        this.mContext = mContext;
        mInflater = LayoutInflater.from(mContext);
    }

    /**
     * 绑定布局文件，返回一个viewHolder
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_dev_type,null);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    /**
     * 填充onCreaterViewHolder方法中返回对holder中对控件
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.textView.setText(mDatas.get(position));
        if (listener!=null) {
            holder.textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.myClick(v,position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public interface OnMyItemClickListener{
        void myClick(View v, int pos);
        //void mLongClick(View v,int pos);
    }

    public void setOnMyItemClickListener(OnMyItemClickListener listener){
        this.listener = listener;
    }
}

/**
 * 在Holder中对控件findviewbyid
 */
class MyViewHolder extends RecyclerView.ViewHolder{

    TextView textView;

    public MyViewHolder(View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.type_name);
    }
}
