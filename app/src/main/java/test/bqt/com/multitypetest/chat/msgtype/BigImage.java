package test.bqt.com.multitypetest.chat.msgtype;

import test.bqt.com.multitypetest.chat.frame.ContentModel;
import test.bqt.com.multitypetest.chat.User;

public class BigImage extends ContentModel {

	public String imagePath;

	public BigImage(User user, int sendType, String imagePath) {
		super(user, ContentModel.MSG_TYPE_BIG_IMAGE, sendType);
		this.imagePath = imagePath;
	}
}