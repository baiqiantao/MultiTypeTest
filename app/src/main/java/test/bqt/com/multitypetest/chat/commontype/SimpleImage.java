package test.bqt.com.multitypetest.chat.commontype;

import test.bqt.com.multitypetest.chat.frame.ContentModel;
import test.bqt.com.multitypetest.chat.User;

public class SimpleImage extends ContentModel {

	public int resId;

	public SimpleImage(User user, int sendType, int resId) {
		super(user, ContentModel.MSG_TYPE_SIMPLE_IMAGE, sendType);
		this.resId = resId;
	}
}