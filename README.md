# baseAdapter
封装 android  baseAdapter，简化代码书写，封装 adapter复用流程 ..

# 如何使用
    adapter 继承 cn.azir.adapter 重写模板方法 
  
    1. protected int onGetLayoutId(int position)
       返回一个布局文件id

   
    2. protected DemoHolder onCreateViewHolder(int position, View baseView) 
    
       返回viewHolder ，并且viewholder要继承自 BaseViewHolder
       
    3. protected void onBindData(int position, View convertView, DemoHolder holder, String item)
       设置数据
