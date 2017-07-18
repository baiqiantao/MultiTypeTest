package test.bqt.com.multitypetest.normal;

/**
 * 1、创建一个类，它将是你的数据类型或 Java bean / model. 对这个类的内容没有任何限制
 */
public abstract class ContentModel {
	public static final int TYPE_SIMPLE_TEXT = 0;
	public static final int TYPE_SIMPLE_IMAGE = 1;

	public int type;

	protected ContentModel(int type) {
		this.type = type;
	}
}