package test.bqt.com.multitypetest.chat.commontype;

import test.bqt.com.multitypetest.chat.frame.ContentModel;
import test.bqt.com.multitypetest.chat.User;

public class SimpleText extends ContentModel {
	public String text;

	public SimpleText(User user, int sendType, String text) {
		super(user, ContentModel.MSG_TYPE_SIMPLE_TEXT, sendType);
		this.text = text;
	}
}