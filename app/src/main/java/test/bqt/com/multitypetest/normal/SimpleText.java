package test.bqt.com.multitypetest.normal;

public class SimpleText extends ContentModel {
	public String text;

	public SimpleText(String text) {
		super(ContentModel.TYPE_SIMPLE_TEXT);
		this.text = text;
	}
}