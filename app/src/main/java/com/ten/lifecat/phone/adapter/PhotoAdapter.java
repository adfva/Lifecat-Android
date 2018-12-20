package com.ten.lifecat.phone.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ten.lifecat.phone.bean.Photo;
import com.ten.lifecat.phone.R;

import java.util.List;

/**
 * 图片卡片适配器 adapter for recyclerView
 */
public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.ViewHolder> {

    private Context mContext;

    private List<Photo> mPhotoList;

    /**
     * 嵌套缓存类，直接从Holder中取item 无需findid重新加载
     */
    static class ViewHolder extends RecyclerView.ViewHolder {

        /* view点击事件 */
        CardView cardView;
        ImageView photoImage;
        TextView photoName;

        public ViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView;
            photoImage = itemView.findViewById(R.id.photo_image);
            photoName = itemView.findViewById(R.id.photo_name);
        }
    }

    public PhotoAdapter(List<Photo> photoList) {
        mPhotoList = photoList;
    }

    /**
     * 生成Holder实例
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.photo_item, parent, false);
        return new ViewHolder(view);
    }

    /**
     * 滚动到屏幕内时执行
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Photo photo = mPhotoList.get(position);

        holder.photoName.setText(photo.getName());

        /* 使用Glide加载图片 */
        Glide.with(mContext).load(photo.getImageId()).into(holder.photoImage);
    }

    /**
     * 返回item总的项数
     */
    @Override
    public int getItemCount() {
        return mPhotoList.size();
    }
}