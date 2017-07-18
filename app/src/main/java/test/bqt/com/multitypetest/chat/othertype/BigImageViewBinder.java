package test.bqt.com.multitypetest.chat.othertype;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import me.drakeet.multitype.ItemViewBinder;
import test.bqt.com.multitypetest.R;

public class BigImageViewBinder extends ItemViewBinder<BigImage, BigImageViewBinder.ViewHolder> {
	
	@NonNull
	@Override
	protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
		View root = inflater.inflate(R.layout.item_big_image, parent, false);
		return new ViewHolder(root);
	}
	
	@Override
	protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull BigImage bigImage) {
		Glide.with(holder.iv_pic.getContext()).load(bigImage.path).into(holder.iv_pic);
		holder.tv_path.setText(bigImage.path);
	}
	
	static class ViewHolder extends RecyclerView.ViewHolder {
		private ImageView iv_pic;
		private TextView tv_path;

		ViewHolder(View itemView) {
			super(itemView);
			iv_pic = (ImageView) itemView.findViewById(R.id.iv_pic);
			tv_path = (TextView) itemView.findViewById(R.id.tv_path);
		}
	}
}
