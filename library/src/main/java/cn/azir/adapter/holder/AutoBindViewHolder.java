package cn.azir.adapter.holder;

import android.view.View;

import java.lang.reflect.Field;

import cn.azir.adapter.anno.ViewHolderInject;

/**
 * @author kongxiangshu
 * 通过反射和注解的方式动态绑定view，规避了findViewById 的书写
 *  只需要 在 子类viewholder 的 view  加上 @Jdbindview注解 即可
 *  用法如下
 * <code>
 *
 *     private class CouponViewHolder extends AutoBindViewHolder {
 *          @BaseHolderViewInject(id=R.id.couponDetailShopItemName)
 *          private TextView mTvName;
 *          @BaseHolderViewInject(id=R.id.couponDetailShopItemDesc)
 *          private TextView mTvDesc;
 *          public CouponViewHolder(View baseView) {
 *              super(baseView);
 *          }
 *      }
 *
 *
 * </code>
 *
         */
public class AutoBindViewHolder extends BaseViewHolder {
    public AutoBindViewHolder(View baseView) {
        super(baseView);
    }
    @Override
    protected final void initView() {
        Field[] fields = this.getClass().getDeclaredFields();
        if (fields != null && fields.length > 0) {
            for (Field field : fields) {
                ViewHolderInject viewInject = field.getAnnotation(ViewHolderInject.class);
                if (viewInject != null) {
                    int id = viewInject.id();
                    field.setAccessible(true);
                    try {
                        field.set(this,this.mBaseView.findViewById(id));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
