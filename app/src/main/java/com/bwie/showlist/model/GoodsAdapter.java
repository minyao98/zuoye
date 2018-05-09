package com.bwie.showlist.model;

import android.content.Context;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.showlist.R;
import com.bwie.showlist.bean.GoodsListBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import static android.R.id.list;

/**
 * Created by 暗夜 on 2018/5/9.
 */

public class GoodsAdapter extends RecyclerView.Adapter{

    public static final int TYPE_ONE_IMAGE = 0;
    public static final int TYPE_TWO_IMAGE = 1;
    private Context context;
    private List<GoodsListBean.DataBean> data = new ArrayList<>();

    public GoodsAdapter(Context context) {
        this.context = context;
    }

    //刷新列表数据
    public void updateList(List<GoodsListBean.DataBean> data) {
        this.data.clear();
        addList(data);
        notifyDataSetChanged();
    }

    //加载下一页数据
    public void addList(List<GoodsListBean.DataBean> data) {
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        RecyclerView.ViewHolder holder = null;
        switch (viewType) {
            case 0:
                view = View.inflate(context, R.layout.item_goods_list, null);
                holder = new GoodsViewHolder(view);
                break;
            case 1:
                view = View.inflate(context, R.layout.item_goods_twolist, null);
                holder = new GoodsTwoViewHolder(view);
        }
        return holder;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case 0:
                GoodsViewHolder holderOne = (GoodsViewHolder) holder;
                String image = data.get(position).getImages();

                String pic = image.split("\\|")[0];

                ((GoodsViewHolder) holder).img.setImageURI(pic);

                ((GoodsViewHolder) holder).title.setText(data.get(position).getTitle());
                break;
            case 1:
                GoodsTwoViewHolder holdertwo = (GoodsTwoViewHolder) holder;
                String images = data.get(position).getImages();

                String pic_url = images.split("\\|")[0];

                ((GoodsTwoViewHolder) holder).img.setImageURI(pic_url);

                ((GoodsTwoViewHolder) holder).title.setText(data.get(position).getTitle());






        }

    }

    @Override
    public int getItemViewType(int position) {


        if (position%2==0) {
            return TYPE_TWO_IMAGE;
        } else {
            return TYPE_ONE_IMAGE;
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class GoodsViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public SimpleDraweeView img;

        public GoodsViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tv);
            img = itemView.findViewById(R.id.img);
        }
    }

    class GoodsTwoViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public SimpleDraweeView img;

        public GoodsTwoViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tv);
            img = itemView.findViewById(R.id.img);
        }
    }

}
