package test.bqt.com.multitypetest;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

import test.bqt.com.multitypetest.lv.Activity1;
import test.bqt.com.multitypetest.lv.Activity2;
import test.bqt.com.multitypetest.normal.NormalActivity;
import test.bqt.com.multitypetest.chat.ChatActivity;

public class MainActivity extends ListActivity {

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		String[] array = {"Lambda表达式测试",
				"方法一：addHeaderView和addFooterView",
				"方法一：使用不同的布局，getViewTypeCount、getItemViewType",
				"NormalActivity",
				"ChatActivity（有福利）",};
		setListAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, new ArrayList<>(Arrays.asList(array))));
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		switch (position) {
			case 0:
				startActivity(new Intent(this, LambdaTestActivity.class));
				break;
			case 1:
				startActivity(new Intent(this, Activity1.class));
				break;
			case 2:
				startActivity(new Intent(this, Activity2.class));
				break;
			case 3:
				startActivity(new Intent(this, NormalActivity.class));
				break;
			case 4:
				startActivity(new Intent(this, ChatActivity.class));
				break;
		}
	}
}