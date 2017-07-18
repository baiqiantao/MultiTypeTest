package test.bqt.com.multitypetest;

import android.app.ListActivity;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LambdaTestActivity extends ListActivity {
	private ImageView iv;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		String[] array = {"没有参数",
				"没有参数，精简模式",
				"Runnable + runOnUiThread",
				"单一参数",
				"方法引用",
				"多个参数",
				"迭代，方法引用",};
		setListAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, new ArrayList<>(Arrays.asList(array))));
		iv = new ImageView(this);
		iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
		iv.setImageResource(R.drawable.icon);
		getListView().addFooterView(iv);
	}

	@RequiresApi(api = Build.VERSION_CODES.N)
	@Override
	protected void onListItemClick(ListView listView, View view, int position, long id) {
		switch (position) {
			case 0:
				new Thread(() -> {
					Log.i("bqt", "包青天");
				}).start();
				break;
			case 1:
				new Thread(() -> Log.i("bqt", "白乾涛")).start();
				break;
			case 2:
				new Thread(() -> {
					//Lambda 主体中的 this、super 引用与封闭上下文中一样，因为 lambda 表达式不会引入新的作用域，这与匿名类不同。
					runOnUiThread(() -> Toast.makeText(this, "包青天", Toast.LENGTH_SHORT).show());
				}).start();
				break;
			case 3:
				iv.setOnClickListener(v -> Toast.makeText(this, "包青天：" + (v == iv), Toast.LENGTH_SHORT).show());
				iv.performClick();
				break;
			case 4:
				iv.setOnClickListener(System.out::println);//方法引用。适用条件：①功能接口方法中的参数是要传到引用方法中作为参数 ②没有返回值
				iv.performClick();
				break;
			case 5:
				iv.setOnFocusChangeListener((v, hasFocus) -> Toast.makeText(this, "hasFocus:" + hasFocus, Toast.LENGTH_SHORT).show());
				iv.performClick();
				break;
			case 6:
				List<String> list = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
				list.forEach(s -> Log.i("bqt", s));//@RequiresApi(api = Build.VERSION_CODES.N)
				break;
		}
	}
}