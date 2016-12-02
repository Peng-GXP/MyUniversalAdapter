package viewholder;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Created by GaoXP on 2016/12/2.
 */

public class ViewHolder {

    private final SparseArray<View> mView;
    private View mConvertView;
    private int mPosition;
    private int itemId;


    public ViewHolder(Context context, ViewGroup parent, int layoutId, int position) {
        this.mPosition = position;
        this.mView = new SparseArray<>();
        mConvertView = LayoutInflater.from(context).inflate(layoutId, parent, false);
        mConvertView.setTag(this);
    }

    public View getConvertView() {
        return mConvertView;
    }

    public int getPosition() {
        return mPosition;
    }


    public int getItemId() {
        return itemId;
    }


    /**
     * 拿到一个ViewHolder实例化对象
     *
     * @param context
     * @param convertView
     * @param parent
     * @param layoutId
     * @param position
     * @return
     */
    public static ViewHolder get(Context context, View convertView, ViewGroup parent, int layoutId, int position) {

        if (convertView == null) {
            return new ViewHolder(context, parent, layoutId, position);
        }
        return (ViewHolder) convertView.getTag();
    }

    /**
     * 通过控件的Id获取对于的控件，如果没有则加入views
     *
     * @param viewId
     * @param <T>
     * @return
     */
    public <T extends View> T getView(int viewId) {
        View view = mView.get(viewId);
        if (view == null) {
            view = mConvertView.findViewById(viewId);
            mView.put(viewId, view);
        }
        return (T) view;
    }


    /**
     * TextView 设置文字
     *
     * @param itemId
     * @param text
     * @return
     */
    public ViewHolder setText(int itemId, String text) {
        TextView textView = getView(itemId);
        textView.setText(text);
        this.itemId = itemId;
        return this;
    }


    /**
     * ImageView 设置图片
     *
     * @param itemId
     * @param bitmap
     * @return
     */
    public ViewHolder setImage(int itemId, Bitmap bitmap) {
        ImageView imageView = getView(itemId);
        imageView.setImageBitmap(bitmap);
        this.itemId = itemId;
        return this;

    }

}
