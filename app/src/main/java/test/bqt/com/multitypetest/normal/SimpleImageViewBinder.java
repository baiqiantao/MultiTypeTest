package test.bqt.com.multitypetest.normal;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import me.drakeet.multitype.ItemViewBinder;
import test.bqt.com.multitypetest.R;

/**
 * 2、创建一个类 继承 ItemViewBinder
 */
public class SimpleImageViewBinder extends ItemViewBinder<SimpleImage, SimpleImageViewBinder.ViewHolder> {

	@NonNull
	@Override
	protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
		View contentView = inflater.inflate(R.layout.item_simple_image_left, parent, false);
		return new ViewHolder(contentView);
	}

	@Override
	protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull SimpleImage item) {
		holder.simpleImage.setImageResource(item.resId);
	}

	static class ViewHolder extends RecyclerView.ViewHolder {

		private ImageView simpleImage;

		ViewHolder(View itemView) {
			super(itemView);
			simpleImage = (ImageView) itemView.findViewById(R.id.simple_image);
		}
	}
}