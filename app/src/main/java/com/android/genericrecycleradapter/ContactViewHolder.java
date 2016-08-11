package com.android.genericrecycleradapter;

import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by ln-170 on 11/8/16.
 */
public class ContactViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private OnClickListener mOnClickListener;
    private AppCompatTextView mAppCompatTextView;
    private LinearLayout mLinearLayout;

    public ContactViewHolder(View itemView) {
        super(itemView);
        mAppCompatTextView = (AppCompatTextView) itemView.findViewById(R.id.actv);
        mLinearLayout = (LinearLayout) itemView.findViewById(R.id.ll);
        mLinearLayout.setOnClickListener(this);
    }

    public LinearLayout getmLinearLayout() {
        return mLinearLayout;
    }

    public AppCompatTextView getmAppCompatTextView() {
        return mAppCompatTextView;
    }

    @Override
    public void onClick(View view) {
        mOnClickListener.onClick(view.getTag());
    }

    public void setmOnClickListener(OnClickListener mOnClickListener) {
        this.mOnClickListener = mOnClickListener;
    }

    public interface OnClickListener {
        void onClick(Object tag);
    }
}
