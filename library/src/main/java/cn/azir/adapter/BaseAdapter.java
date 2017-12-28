package cn.azir.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.ArrayList;
import java.util.List;

import cn.azir.adapter.holder.BaseViewHolder;

/**
 * @author kongxiangshu
 *  adapter 扩展  {@link android.widget.BaseAdapter}
 *  简化adapter代码书写，封装了viewholder的复用流程
 */
public abstract class BaseAdapter<Data, Holder extends BaseViewHolder>
        extends android.widget.BaseAdapter {

    protected final Context mContext;

    protected List<Data> mData;

    protected final LayoutInflater mInflater;

    public BaseAdapter(Context context , List<Data> data) {
        this.mContext = context;
        this.mData = data;
        this.mInflater = LayoutInflater.from(context);
    }

    public BaseAdapter(Context context) {
        this(context,null);
    }

    /**
     *
     * @param data 重新设置数据源
     */
    public void setData(List<Data> data) {
        this.mData = data;
        this.notifyDataSetChanged();
    }

    public List<Data> getData(){
        return this.mData;
    }

    /**
     * 清空数据源
     */
    public void clear() {
        if (mData != null) {
            mData.clear();
        }
    }

    /**
     *
     * @param data 添加新的数据源到集合中
     */
    public void addData(List<Data> data) {
        if (this.mData == null) {
            this.mData = new ArrayList<>();
        }
        if (data != null) {
            this.mData.addAll(data);
        }
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mData == null ? 0 : mData.size();
    }

    @Override
    public final Data getItem(int position) {
        return mData.get(position);
    }

    @Override
    public final long getItemId(int position) {
        return position;
    }


    @Override
    public final View getView(int position, View convertView, ViewGroup parent) {

        Holder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(onGetLayoutId(position),null);
            holder = onCreateViewHolder(position,convertView);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }

        onBindData(position,convertView,holder,getItem(position));

        return convertView;
    }

    /**
     * @description
     * @param position
     * @return 获得 adapter 的item view id
     */
    protected abstract int onGetLayoutId(int position);

    /**
     * 返回一个viewholder实例
     * @param position
     * @param baseView
     * @return
     */
    protected abstract Holder onCreateViewHolder(/**should extends baseViewHolder*/int position, View baseView);

    /**
     * 进行数据的逻辑处理  比如 setText  ，load image 等
     * @param position
     * @param convertView
     * @param holder
     * @param item
     */
    protected abstract void onBindData(int position, View convertView, Holder holder, Data item);
}
