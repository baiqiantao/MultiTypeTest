package test.bqt.com.multitypetest.listview;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import test.bqt.com.multitypetest.R;

public class Activity1 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ListView listView = new ListView(this);

		List<Model1> mList = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			mList.add(new Model1(("包青天" + i), R.drawable.icon));
		}

		//给ListView添加头尾
		TextView mTextView = new TextView(this);
		mTextView.setText("我是头部\n必须在listview.setAdapter前添加");
		mTextView.setBackgroundColor(Color.YELLOW);
		listView.addHeaderView(mTextView);//必须在listview.setAdapter前添加。添加以后，listView的position=0的View是此View

		ImageView mImageView = new ImageView(this);
		mImageView.setImageResource(R.drawable.icon);
		mImageView.setLayoutParams(new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, 300));
		listView.addHeaderView(mImageView);
		listView.setHeaderDividersEnabled(new Random().nextBoolean());//控制头部是否显示分割线。默认为true

		View footerView = new View(this);
		footerView.setBackgroundColor(Color.GREEN);
		footerView.setLayoutParams(new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, 50));
		listView.addFooterView(footerView);
		listView.setFooterDividersEnabled(new Random().nextBoolean());

		listView.setAdapter(new MyAdapter1(this, mList));//addHeaderView要放在setAdapter之前，而addFooterView放在前后都可以
		listView.setDivider(new ColorDrawable(Color.RED));
		listView.setDividerHeight(2);//如果调用了setDivider，也需调用setDividerHeight才行
		listView.setOnItemClickListener((parent, view, position, id) -> Toast.makeText(this, "position=" + position, Toast.LENGTH_SHORT).show());

		setContentView(listView);
	}
}