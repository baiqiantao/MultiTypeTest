package test.bqt.com.multitypetest.normal;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import me.drakeet.multitype.ItemViewBinder;
import test.bqt.com.multitypetest.R;

public class SimpleTextViewBinder extends ItemViewBinder<SimpleText, SimpleTextViewBinder.ViewHolder> {

	@NonNull
	@Override
	protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
		View contentView = inflater.inflate(R.layout.item_simple_text_left, parent, false);
		return new ViewHolder(contentView);
	}

	@Override
	protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull SimpleText item) {
		String info = "adapterPosition: " + holder.getAdapterPosition()
				+ "  layoutPosition: " + holder.getLayoutPosition()
				+ "  oldPosition: " + holder.getOldPosition()
				+ "\n是否可回收：isRecyclable【" + holder.isRecyclable() + "】";
		holder.simpleText.setText("类型：" + item.type + "\n内容：" + item.text + "\n信息：" + info + "\n");
	}

	static class ViewHolder extends RecyclerView.ViewHolder {

		private TextView simpleText;

		ViewHolder(View itemView) {
			super(itemView);
			simpleText = (TextView) itemView.findViewById(R.id.simple_text);
		}
	}
}