package test.bqt.com.multitypetest.listview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import test.bqt.com.multitypetest.R;

public class Activity2 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ListView listView = new ListView(this);
		List<Model2> mList = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			if (new Random().nextBoolean()) mList.add(new Model2(Model2.ITEM_FIRST, "第一种样式 " + i));
			else mList.add(new Model2(Model2.ITEM_SECOND, "第二种样式 " + i, R.drawable.icon));
		}

		listView.setAdapter(new MyAdapter2(this, mList));
		listView.setOnItemClickListener((parent, view, position, id) -> Toast.makeText(this, "position=" + position, Toast.LENGTH_SHORT).show());
		setContentView(listView);
	}
}
