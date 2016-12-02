package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

import viewholder.ViewHolder;

/**
 * Created by GaoXP on 2016/12/2.
 */

public abstract class CommonAdapter<T> extends BaseAdapter {

    protected LayoutInflater mInflater;
    protected Context mContext;
    protected List<T> mDatas;
    protected final int mItemLayoutId;

    public CommonAdapter(Context context, List<T> mDatas, int mItemLayoutId) {
        mInflater = LayoutInflater.from(context);
        this.mContext = context;
        this.mDatas = mDatas;
        this.mItemLayoutId = mItemLayoutId;
    }


    @Override

    public int getCount() {
        return mDatas.size();
    }

    @Override
    public Object getItem(int i) {
        return mDatas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final ViewHolder viewHolder = getViewHolder(i, view, viewGroup);
        convert(viewHolder, (T) getItem(i));
        setItemOnClickListener(viewHolder,viewHolder.getItemId());
        return viewHolder.getConvertView();
    }

    private ViewHolder getViewHolder(int i, View view, ViewGroup viewGroup) {
        return ViewHolder.get(mContext, view, viewGroup, mItemLayoutId, i);
    }

    public abstract void convert(ViewHolder helper, T item);

    public abstract void setItemOnClickListener(ViewHolder helper, int itemId);
}
