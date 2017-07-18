package test.bqt.com.multitypetest.chat.msgtype;

import test.bqt.com.multitypetest.chat.frame.ContentModel;
import test.bqt.com.multitypetest.chat.User;

public class SimpleImage extends ContentModel {

	public String imagePath;

	public SimpleImage(User user, int sendType, String imagePath) {
		super(user, ContentModel.MSG_TYPE_SIMPLE_IMAGE, sendType);
		this.imagePath = imagePath;
	}
}