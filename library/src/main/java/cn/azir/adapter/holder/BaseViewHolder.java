package cn.azir.adapter.holder;

import android.view.View;

/**
 *
 * 基类 viewholder
 *
 * @author  kongxiangshu
 */
public abstract class BaseViewHolder {
    protected final View mBaseView;
    public BaseViewHolder(View baseView) {
        this.mBaseView = baseView;
        initView();
    }
    protected abstract void initView();
}
