package test.bqt.com.multitypetest.chat.othertype;

import test.bqt.com.multitypetest.chat.frame.ContentModel;
import test.bqt.com.multitypetest.chat.User;

public class BigImage extends ContentModel {

	public String path;

	public BigImage(User user, int sendType, String path) {
		super(user, ContentModel.MSG_TYPE_BIG_IMAGE, sendType);
		this.path = path;
	}
}