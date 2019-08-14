package com.samuelbernard147.LocalFood;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

public class ItemClickSupport {
    private final RecyclerView mRecyclerView;
    private OnItemClickListener mOnItemClickListener;
    private OnItemLongClickListener mOnItemLongClickListener;

    private ItemClickSupport(RecyclerView recyclerView){
        mRecyclerView = recyclerView;
        mRecyclerView.setTag(R.id.item_click_support,this);
        mRecyclerView.addOnChildAttachStateChangeListener(mAttachListener);
    }
    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (mOnClickListener != null){
                RecyclerView.ViewHolder holder = mRecyclerView.getChildViewHolder(v);
                mOnItemClickListener.onItemClicked(mRecyclerView,holder.getAdapterPosition(),v);
            }

        }
    };
    private View.OnLongClickListener mOnLongClickListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            if (mOnItemLongClickListener != null){
                RecyclerView.ViewHolder holder = mRecyclerView.getChildViewHolder(v);
                return mOnItemLongClickListener.onItemLongClicked(mRecyclerView, holder.getAdapterPosition(), v);
            }
            return false;
        }
    };
    private RecyclerView.OnChildAttachStateChangeListener mAttachListener
            = new RecyclerView.OnChildAttachStateChangeListener() {
        @Override
        public void onChildViewAttachedToWindow(View v) {
            if (mOnItemClickListener != null){
                v.setOnClickListener(mOnClickListener);
            }
            if (mOnItemLongClickListener != null){
                v.setOnLongClickListener(mOnLongClickListener);
            }
        }

        @Override
        public void onChildViewDetachedFromWindow(View view) {

        }
    };
    public static ItemClickSupport addTo(RecyclerView v){
        ItemClickSupport support = (ItemClickSupport)v.getTag(R.id.item_click_support);
        if (support == null){
            support = new ItemClickSupport(v);
        }
        return support;
    }
    public static ItemClickSupport removeFrom(RecyclerView v){
        ItemClickSupport support = (ItemClickSupport)v.getTag(R.id.item_click_support);
        if (support != null){
            support.detach(v);
        }
        return support;
    }
    public ItemClickSupport setOnItemClickListener(OnItemClickListener listener){
        mOnItemClickListener = listener;
        return this;
    }
    public ItemClickSupport setOnItemLongClickListener(OnItemLongClickListener listener){
        mOnItemLongClickListener = listener;
        return this;
    }
    private void detach(RecyclerView v){
        v.removeOnChildAttachStateChangeListener(mAttachListener);
        v.setTag(R.id.item_click_support, null);
    }
    public interface OnItemClickListener{
        void onItemClicked(RecyclerView recyclerView, int position, View v);
    }
    public interface OnItemLongClickListener{
        boolean onItemLongClicked(RecyclerView recyclerView, int position, View v);
    }
}
