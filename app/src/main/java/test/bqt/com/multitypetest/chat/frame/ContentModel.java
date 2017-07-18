package test.bqt.com.multitypetest.chat.frame;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import test.bqt.com.multitypetest.chat.User;

/**
 * 各种消息类型的基类
 */
public abstract class ContentModel {
	//消息类型
	public static final int MSG_TYPE_SIMPLE_TEXT = 0;
	public static final int MSG_TYPE_SIMPLE_IMAGE = 1;
	public static final int MSG_TYPE_SIMPLE_VOICE = 2;
	public static final int MSG_TYPE_BIG_IMAGE = 3;

	//消息是谁发的
	public static final int SEND_TYPE_OTHERS = 0;
	public static final int SEND_TYPE_YOURSELF = 1;
	public static final int SEND_TYPE_YSTEM = 2;

	public int msgType;
	public int sendType;
	public String createTime;
	/**
	 * 所有信息都可以封装到user中
	 */
	public User user;

	protected ContentModel(User user, int msgType, int sendType) {
		this.user = user;
		this.msgType = msgType;
		this.sendType = sendType;
		this.createTime = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss SSS E", Locale.getDefault()).format(new Date());
	}
}