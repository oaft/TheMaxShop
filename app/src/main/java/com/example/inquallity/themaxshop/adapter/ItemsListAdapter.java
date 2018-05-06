package com.example.inquallity.themaxshop.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.inquallity.themaxshop.R;
import com.example.inquallity.themaxshop.loader.AssetLoader;
import com.example.inquallity.themaxshop.model.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Olga Aleksandrova on 03.02.2018.
 */

public class ItemsListAdapter extends RecyclerView.Adapter<ItemViewHolder> {

    private OnCardClickListener mListener;
    private List<Item> mItemList = new ArrayList<>();
    private AssetLoader mAssetLoader;

    public ItemsListAdapter(Context context) {
       mAssetLoader = new AssetLoader(context);
    }

    public void setOnCardClickListener(OnCardClickListener listener) {
        mListener = listener;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.li_item, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ItemViewHolder holder, int position) {
        holder.setOnCardClickListener(mListener);
        final Item item = mItemList.get(position);
        holder.bindItem(item);


        Bitmap bitmap = mAssetLoader.loadImage(item.getImageUrl());
        holder.bindImage(bitmap);

//        try {
//            Bitmap bitmap = new AssetLoader().loadImage(item.getImageUrl(), mAssetManager);
//            holder.bindImage(bitmap);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


//        InputStream is = null;
//        try {
//            is = mAssetManager.open(item.getImageUrl().trim());
//            final Bitmap bitmap = BitmapFactory.decodeStream(is);
//            holder.bindImage(bitmap);
//        } catch (IOException e) {
//            //log
//        } finally {
//            if (is != null){
//                try {
//                    is.close();
//                } catch (IOException e) {
//                    //log
//                }
//            }
//        }
    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }

    public void changeItems(List<Item> items) {
        if (items!= null && !items.isEmpty()) {
            mItemList = items;
        }
        notifyDataSetChanged();
    }

    public interface OnCardClickListener {
        void onCardClick(View view, String title, String imageUrl, String price);
    }
}
