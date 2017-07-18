package test.bqt.com.multitypetest.chat.msgtype;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import test.bqt.com.multitypetest.R;
import test.bqt.com.multitypetest.chat.frame.ContentHolder;
import test.bqt.com.multitypetest.chat.frame.ContentModel;
import test.bqt.com.multitypetest.chat.frame.ChatFrameBinder;

public class SimpleVoiceViewBinder extends ChatFrameBinder<SimpleVoice, SimpleVoiceViewBinder.ViewHolder> {

	public SimpleVoiceViewBinder(int sendType) {
		super(sendType);
	}

	@Override
	protected ContentHolder onCreateContentViewHolder(LayoutInflater inflater, ViewGroup parent) {
		View root;
		if (sendType == ContentModel.SEND_TYPE_OTHERS) root = inflater.inflate(R.layout.item_simple_voice_left, parent, false);
		else root = inflater.inflate(R.layout.item_simple_voice_right, parent, false);
		return new ViewHolder(root);
	}

	@Override
	protected void onBindContentViewHolder(ViewHolder holder, SimpleVoice item) {
		holder.tv_duration.setText(item.duration + "''");
		Glide.with(holder.iv_icon.getContext()).load(item.picPath).into(holder.iv_icon);
		holder.iv_icon.setOnClickListener(v -> Toast.makeText(holder.iv_icon.getContext(), "picPath=" + item.picPath, Toast.LENGTH_SHORT).show());
	}

	static class ViewHolder extends ContentHolder {
		private ImageView iv_icon;
		private TextView tv_duration;

		ViewHolder(View itemView) {
			super(itemView);
			iv_icon = (ImageView) itemView.findViewById(R.id.iv_icon);
			tv_duration = (TextView) itemView.findViewById(R.id.tv_duration);
		}
	}
}
