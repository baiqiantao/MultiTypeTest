package test.bqt.com.multitypetest.chat.frame;

import android.view.View;

public class ContentHolder {

	public ChatFrameBinder.FrameHolder frameHolder;

	public final View itemView;

	public ContentHolder(final View itemView) {
		this.itemView = itemView;
	}

	public ChatFrameBinder.FrameHolder getParent() {
		return frameHolder;
	}

	public final int getAdapterPosition() {
		return getParent().getAdapterPosition();
	}

	public final int getLayoutPosition() {
		return getParent().getLayoutPosition();
	}

	public final int getOldPosition() {
		return getParent().getOldPosition();
	}

	public final boolean isRecyclable() {
		return getParent().isRecyclable();
	}

	public final void setIsRecyclable(boolean recyclable) {
		getParent().setIsRecyclable(recyclable);
	}
}