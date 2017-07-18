package test.bqt.com.multitypetest.listview;

// 封装每个条目的数据
public class Model2 {
	public static final int ITEM_FIRST = 0;//第一个样式
	public static final int ITEM_SECOND = 1;//第二个样式
	public int type;//记录是哪种样式
	public String title;//标题
	public int resId;//图片，仅第二个样式可以获取图片

	public Model2(int type, String str) {
		this.type = type;
		title = str;
	}

	public Model2(int type, String str, int resId) {
		this.type = type;
		title = str;
		this.resId = resId;
	}
}
