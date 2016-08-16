package com.ahao.galleryviewsamples;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Avalon on 2016/6/7.
 */
public abstract class MyAdapter<T> extends RecyclerView.Adapter<MyViewHolder> {
    private final static String className = MyAdapter.class.getSimpleName();

    protected Context context;
    protected List<T> datas;
    protected int layoutId;
    protected LayoutInflater inflater;

    public MyAdapter(Context context, List<T> datas, int layoutId){
        this.context = context;
        this.datas = datas;
        this.layoutId = layoutId;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder viewHolder = MyViewHolder.get(context, null, parent, layoutId, -1);
        return viewHolder;
    }

    @Override
    public int getItemCount() {
        return datas==null?0:datas.size();
    }
    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.updatePosition(position);
        convert(holder, datas.get(position));
    }



    protected abstract void convert(MyViewHolder holder, T t);
}
