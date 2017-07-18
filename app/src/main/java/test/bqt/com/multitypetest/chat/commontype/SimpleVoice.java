package test.bqt.com.multitypetest.chat.commontype;

import test.bqt.com.multitypetest.chat.frame.ContentModel;
import test.bqt.com.multitypetest.chat.User;

public class SimpleVoice extends ContentModel {
	public String path;
	public int duration;

	public SimpleVoice(User user, int sendType, String path, int duration) {
		super(user, ContentModel.MSG_TYPE_SIMPLE_VOICE, sendType);
		this.path = path;
		this.duration = duration;
	}
}