package test.bqt.com.multitypetest.listview;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import test.bqt.com.multitypetest.R;

public class MyAdapter2 extends BaseAdapter {
	
	private Context context;
	private List<Model2> mList;
	
	public MyAdapter2(Context context, List<Model2> list) {
		this.context = context;
		mList = list;
	}
	
	//**************************************************************************************************************************
	@Override
	public int getCount() {
		return mList.size();
	}
	
	@Override
	public Object getItem(int position) {
		return mList.get(position);
	}
	
	//重写方法一：返回值代表的是某一个样式的 Type（是一个需要我们自己定义的，用于区分不同样式的int类型的值）
	@Override
	public int getItemViewType(int position) {
		return mList.get(position).type;
	}
	
	//重写方法一：返回的是你有几种类型的样式
	@Override
	public int getViewTypeCount() {
		return 2;
	}
	
	@Override
	public long getItemId(int paramInt) {
		return paramInt;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		int type = getItemViewType(position);
		//要使用不同类型的ViewHolder
		Holder1 holder1 = null;
		Holder2 holder2 = null;

		//************************************************初始化和复用******************************************
		if (convertView != null) {
			switch (type) {
				case Model2.ITEM_FIRST:
					holder1 = (Holder1) convertView.getTag();
					Log.i("bqt", position + "  复用  " + type);
					break;
				case Model2.ITEM_SECOND:
					holder2 = (Holder2) convertView.getTag();
					Log.i("bqt", position + "  复用  " + type);
					break;
			}
		} else {
			switch (type) {
				case Model2.ITEM_FIRST:
					convertView = View.inflate(context, R.layout.head, null);
					holder1 = new Holder1();
					holder1.holder1_title = (TextView) convertView.findViewById(R.id.holder1_title);
					holder1.holder1_time = (TextView) convertView.findViewById(R.id.holder1_time);
					convertView.setTag(holder1);
					Log.i("bqt", position + "  初始化  " + type);
					break;
				case Model2.ITEM_SECOND:
					convertView = View.inflate(context, R.layout.item, null);
					holder2 = new Holder2();
					holder2.holder2_title = (TextView) convertView.findViewById(R.id.holder2_title);
					holder2.holder2_iv = (ImageView) convertView.findViewById(R.id.holder2_iv);
					convertView.setTag(holder2);
					Log.i("bqt", position + "  初始化  " + type);
					break;
			}
		}

		//*************************************************填充数据*****************************************
		switch (type) {
			case Model2.ITEM_FIRST:
				if (holder1 != null) {
					holder1.holder1_title.setText(mList.get(position).title);
					holder1.holder1_time.setText(new SimpleDateFormat("yyyy.MM.dd HH:mm:ss", Locale.getDefault()).format(new Date()));
				}
				break;
			case Model2.ITEM_SECOND:
				if (holder2 != null) {
					holder2.holder2_title.setText(mList.get(position).title);
					holder2.holder2_iv.setImageResource(mList.get(position).resId);
				}
				break;
		}
		return convertView;
	}
	
	//**************************************************************************************************************************
	private class Holder1 {
		TextView holder1_title;
		TextView holder1_time;
	}
	
	private class Holder2 {
		TextView holder2_title;
		ImageView holder2_iv;
	}
}