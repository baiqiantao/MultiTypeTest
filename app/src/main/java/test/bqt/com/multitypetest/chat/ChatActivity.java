package test.bqt.com.multitypetest.chat;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import me.drakeet.multitype.MultiTypeAdapter;
import test.bqt.com.multitypetest.R;
import test.bqt.com.multitypetest.chat.commontype.SimpleImage;
import test.bqt.com.multitypetest.chat.commontype.SimpleImageViewBinder;
import test.bqt.com.multitypetest.chat.commontype.SimpleText;
import test.bqt.com.multitypetest.chat.commontype.SimpleTextViewBinder;
import test.bqt.com.multitypetest.chat.commontype.SimpleVoice;
import test.bqt.com.multitypetest.chat.commontype.SimpleVoiceViewBinder;
import test.bqt.com.multitypetest.chat.frame.ContentModel;
import test.bqt.com.multitypetest.chat.othertype.BigImage;
import test.bqt.com.multitypetest.chat.othertype.BigImageViewBinder;

import static me.drakeet.multitype.MultiTypeAsserts.assertAllRegistered;
import static me.drakeet.multitype.MultiTypeAsserts.assertHasTheSameAdapter;

public class ChatActivity extends Activity {
	private static final String TEXT = "不懂左右逢源，不喜趋炎附势，不会随波逐流，不狡辩，不恭维，不把妹，我就是你心目中最想要的那位 Android 工程师";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		RecyclerView recyclerView = new RecyclerView(this);
		MultiTypeAdapter adapter = new MultiTypeAdapter();

		//一对多，都有相同的父框架结构（头像、昵称、时间……等）
		adapter.register(ContentModel.class).to(
				new SimpleTextViewBinder(ContentModel.SEND_TYPE_OTHERS),//左边的布局（别人发的消息）
				new SimpleTextViewBinder(ContentModel.SEND_TYPE_YOURSELF),//右边的布局（自己发的消息）
				new SimpleImageViewBinder(ContentModel.SEND_TYPE_OTHERS),
				new SimpleImageViewBinder(ContentModel.SEND_TYPE_YOURSELF),
				new SimpleVoiceViewBinder(ContentModel.SEND_TYPE_OTHERS),
				new SimpleVoiceViewBinder(ContentModel.SEND_TYPE_YOURSELF)
		).withLinker(model -> {
			if (model.msgType == ContentModel.MSG_TYPE_SIMPLE_TEXT
					&& model.sendType == ContentModel.SEND_TYPE_OTHERS) return 0;
			else if (model.msgType == ContentModel.MSG_TYPE_SIMPLE_TEXT
					&& model.sendType == ContentModel.SEND_TYPE_YOURSELF) return 1;
			else if (model.msgType == ContentModel.MSG_TYPE_SIMPLE_IMAGE
					&& model.sendType == ContentModel.SEND_TYPE_OTHERS) return 2;
			else if (model.msgType == ContentModel.MSG_TYPE_SIMPLE_IMAGE
					&& model.sendType == ContentModel.SEND_TYPE_YOURSELF) return 3;
			else if (model.msgType == ContentModel.MSG_TYPE_SIMPLE_VOICE
					&& model.sendType == ContentModel.SEND_TYPE_OTHERS) return 4;
			else if (model.msgType == ContentModel.MSG_TYPE_SIMPLE_VOICE
					&& model.sendType == ContentModel.SEND_TYPE_YOURSELF) return 5;
			return 0;
		});
		//一个独立的结构，没有父框架结构
		adapter.register(BigImage.class, new BigImageViewBinder());

		recyclerView.setLayoutManager(new LinearLayoutManager(this));
		recyclerView.setAdapter(adapter);
		//断言 recyclerView 使用的是正确的 adapter，必须在 setAdapter(adapter) 之后使用，可选择性使用
		assertHasTheSameAdapter(recyclerView, adapter);

		User user = new User("包青天", R.drawable.icon);
		List<ContentModel> items = new ArrayList<>();
		for (int i = 0; i < 50; i++) {
			int random = new Random().nextInt(4);
			int sendType = new Random().nextBoolean() ? ContentModel.SEND_TYPE_OTHERS : ContentModel.SEND_TYPE_YOURSELF;
			if (random == 0) items.add(new SimpleText(user, sendType, i + "、" + TEXT));
			else if (random == 1) items.add(new SimpleImage(user, sendType, R.drawable.icon));
			else items.add(new SimpleVoice(user, sendType, "https://github.com/baiqiantao", new Random().nextInt(60)));
		}
		items.add(new BigImage(user, ContentModel.SEND_TYPE_OTHERS, "http://img.mmjpg.com/2015/74/33.jpg"));
		items.add(new BigImage(user, ContentModel.SEND_TYPE_OTHERS, "http://img.mmjpg.com/2015/74/34.jpg"));
		items.add(new BigImage(user, ContentModel.SEND_TYPE_OTHERS, "http://img.mmjpg.com/2015/74/35.jpg"));

		adapter.setItems(items);
		adapter.notifyDataSetChanged();

		//断言所有使用的类型都已注册，需要在加载或更新数据之后调用，可选择性使用
		assertAllRegistered(adapter, items);

		setContentView(recyclerView);
	}
}