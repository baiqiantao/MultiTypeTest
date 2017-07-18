package test.bqt.com.multitypetest.lv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import test.bqt.com.multitypetest.R;

public class MyAdapter1 extends BaseAdapter {
	private Context mContext;
	private List<Model1> mList;

	public MyAdapter1(Context context, List<Model1> list) {
		this.mContext = context;
		this.mList = list;
	}

	@Override
	public int getCount() {
		return mList.size();
	}

	@Override
	public Object getItem(int position) {
		return mList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder mViewHolder;
		if (convertView != null) {
			mViewHolder = (ViewHolder) convertView.getTag();
		} else {
			convertView = LayoutInflater.from(mContext).inflate(R.layout.item, parent, false);
			mViewHolder = new ViewHolder();
			mViewHolder.iv_head = (ImageView) convertView.findViewById(R.id.holder2_iv);
			mViewHolder.tv_name = (TextView) convertView.findViewById(R.id.holder2_title);
			convertView.setTag(mViewHolder);
		}
		Model1 mBean = mList.get(position);
		mViewHolder.iv_head.setImageResource(mBean.resId);
		mViewHolder.tv_name.setText(mBean.name + "  position=" + position);
		return convertView;
	}

	public static class ViewHolder {
		public ImageView iv_head;// 头像
		public TextView tv_name;// 名字
	}
}