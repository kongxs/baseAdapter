package cn.azir.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import cn.azir.adapter.anno.ViewHolderInject;
import cn.azir.adapter.holder.AutoBindViewHolder;

/**
 * @author kongxiangshu
 *         create on 2017/12/28
 */

public class DemoAdapter extends BaseAdapter<String,DemoAdapter.DemoHolder> {


    public DemoAdapter(Context context) {
        super(context);
    }

    @Override
    protected int onGetLayoutId(int position) {
        return R.layout.view_list_item;
    }

    @Override
    protected DemoHolder onCreateViewHolder(int position, View baseView) {
        return new DemoHolder(baseView);
    }

    @Override
    protected void onBindData(int position, View convertView, DemoHolder holder, String item) {
        holder.name.setText(item);
    }

    public class DemoHolder extends AutoBindViewHolder{

        @ViewHolderInject(id = R.id.name)
        private TextView name;
        public DemoHolder(View baseView) {
            super(baseView);
        }
    }
}
