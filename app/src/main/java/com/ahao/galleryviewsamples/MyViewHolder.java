package com.ahao.galleryviewsamples;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by Avalon on 2016/6/7.
 */
public class MyViewHolder extends RecyclerView.ViewHolder {
    private SparseArray<View> views;
    private int position;
    private View convertView;
    private Context context;
    private int layoutId;
    /**
     * 构造方法
     * @param context
     * @param itemView
     * @param parent
     * @param position
     */
    public MyViewHolder(Context context, View itemView, ViewGroup parent, int position) {
        super(itemView);
        this.context = context;
        this.convertView = itemView;
        this.position = position;
        views = new SparseArray<View>();
        this.convertView.setTag(this);
    }


    /**
     * 获取一个ViewHolder对象
     * @param context       上下文
     * @param convertView   子View
     * @param parent        父View
     * @param layoutId      子View的布局Id
     * @param position      子View的位置
     * @return
     */
    public static MyViewHolder get(Context context, View convertView,
                                 ViewGroup parent, int layoutId, int position){
        if(convertView == null){
            View itemView = LayoutInflater.from(context).inflate(layoutId, parent, false);
            MyViewHolder viewHolder = new MyViewHolder(context, itemView, parent, position);
            viewHolder.layoutId = layoutId;
            return viewHolder;
        } else {
            MyViewHolder viewHolder = (MyViewHolder) convertView.getTag();
            viewHolder.position = position;
            return viewHolder;
        }
    }

    /**
     * 根据id获取子View的控件
     * @param viewId    子view的控件的id
     * @param <T>       泛型
     * @return          返回子View的控件
     */
    public <T extends View> T getView(int viewId){
        View childView = views.get(viewId);
        if(childView == null){
            childView = convertView.findViewById(viewId);
            views.put(viewId, childView);
        }
        return (T) childView;
    }


    /**
     * 返回子View
     * @return
     */
    public View getConvertView() {
        return convertView;
    }

    public void updatePosition(int position)
    {
        this.position = position;
    }


    public MyViewHolder setText(int viewId, String text){
        TextView tv = getView(viewId);
        tv.setText(text);
        return this;
    }

    public MyViewHolder setImageResId(int viewId, int resId){
        Glide.with(context).load(resId).into((ImageView) getView(viewId));
        return this;
    }


    public MyViewHolder setOnClickListener(int viewId, View.OnClickListener listener){
        View view = getView(viewId);
        view.setEnabled(true);
        view.setOnClickListener(listener);
        return this;
    }

}
