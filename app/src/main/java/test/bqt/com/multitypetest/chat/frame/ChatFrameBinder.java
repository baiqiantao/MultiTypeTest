package test.bqt.com.multitypetest.chat.frame;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import me.drakeet.multitype.ItemViewBinder;
import test.bqt.com.multitypetest.R;

import static android.widget.Toast.LENGTH_SHORT;

/**
 * 此种方式非常适合聊天页面。
 * 对于聊天页面，left和right的元素基本是完全相同的，唯一（会最大）的不同就是元素放置的位置不同
 */
public abstract class ChatFrameBinder<T extends ContentModel, H extends ContentHolder>
		extends ItemViewBinder<ContentModel, ChatFrameBinder.FrameHolder> {
	protected int sendType;

	public ChatFrameBinder(int sendType) {
		super();
		this.sendType = sendType;
	}

	protected abstract ContentHolder onCreateContentViewHolder(LayoutInflater inflater, ViewGroup parent);

	protected abstract void onBindContentViewHolder(H holder, T content);

	@NonNull
	@Override
	protected FrameHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
		View root;
		if (sendType == ContentModel.SEND_TYPE_OTHERS) root = inflater.inflate(R.layout.item_frame_left, parent, false);
		else root = inflater.inflate(R.layout.item_frame_right, parent, false);
		ContentHolder subViewHolder = onCreateContentViewHolder(inflater, parent);
		return new FrameHolder(root, subViewHolder);
	}

	@Override
	@SuppressWarnings("unchecked")
	protected void onBindViewHolder(@NonNull FrameHolder holder, @NonNull ContentModel model) {
		Glide.with(holder.avatar.getContext()).load(model.user.avatar).into(holder.avatar);
		holder.username.setText(model.user.name);
		holder.createTime.setText(model.createTime);
		onBindContentViewHolder((H) holder.subViewHolder, (T) model);
	}

	public static class FrameHolder extends RecyclerView.ViewHolder {

		private ImageView avatar;
		private TextView username;
		private FrameLayout container;
		private TextView createTime;
		private ContentHolder subViewHolder;

		FrameHolder(View itemView, final ContentHolder subViewHolder) {
			super(itemView);
			avatar = (ImageView) itemView.findViewById(R.id.avatar);
			username = (TextView) itemView.findViewById(R.id.username);
			container = (FrameLayout) itemView.findViewById(R.id.container);
			createTime = (TextView) itemView.findViewById(R.id.create_time);

			container.addView(subViewHolder.itemView);
			this.subViewHolder = subViewHolder;
			this.subViewHolder.frameHolder = this;

			itemView.setOnClickListener(v -> Toast.makeText(v.getContext(), "Position=" + getAdapterPosition(), LENGTH_SHORT).show());
		}
	}
}