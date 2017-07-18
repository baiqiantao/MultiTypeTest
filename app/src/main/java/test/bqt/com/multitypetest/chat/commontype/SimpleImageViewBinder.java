package test.bqt.com.multitypetest.chat.commontype;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import test.bqt.com.multitypetest.R;
import test.bqt.com.multitypetest.chat.frame.ContentHolder;
import test.bqt.com.multitypetest.chat.frame.ChatFrameBinder;
import test.bqt.com.multitypetest.chat.frame.ContentModel;

public class SimpleImageViewBinder extends ChatFrameBinder<SimpleImage, SimpleImageViewBinder.ViewHolder> {

	public SimpleImageViewBinder(int sendType) {
		super(sendType);
	}

	@Override
	protected ContentHolder onCreateContentViewHolder(LayoutInflater inflater, ViewGroup parent) {
		View root;
		if (sendType == ContentModel.SEND_TYPE_OTHERS) root = inflater.inflate(R.layout.item_simple_image_left, parent, false);
		else root = inflater.inflate(R.layout.item_simple_image_right, parent, false);
		return new SimpleVoiceViewBinder.ViewHolder(root);
	}

	@Override
	protected void onBindContentViewHolder(ViewHolder holder, SimpleImage simpleImage) {
		holder.simpleImage.setImageResource(simpleImage.resId);
	}

	static class ViewHolder extends ContentHolder {

		private ImageView simpleImage;

		ViewHolder(View itemView) {
			super(itemView);
			simpleImage = (ImageView) itemView.findViewById(R.id.simple_image);
		}
	}
}