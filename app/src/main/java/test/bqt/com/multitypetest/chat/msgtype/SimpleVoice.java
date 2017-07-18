package test.bqt.com.multitypetest.chat.msgtype;

import test.bqt.com.multitypetest.chat.frame.ContentModel;
import test.bqt.com.multitypetest.chat.User;

public class SimpleVoice extends ContentModel {
	public String picPath;
	public int duration;

	public SimpleVoice(User user, int sendType, String picPath, int duration) {
		super(user, ContentModel.MSG_TYPE_SIMPLE_VOICE, sendType);
		this.picPath = picPath;
		this.duration = duration;
	}
}