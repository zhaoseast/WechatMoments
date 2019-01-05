package com.example.zhaoseast.wechatmoments.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.zhaoseast.wechatmoments.R;
import com.example.zhaoseast.wechatmoments.adapter.baseRecyclerview.CommonAdapter;
import com.example.zhaoseast.wechatmoments.adapter.baseRecyclerview.CommonViewHolder;
import com.example.zhaoseast.wechatmoments.bean.WechatImages;
import com.example.zhaoseast.wechatmoments.view.GlideRoundTransform;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @Description:图片九宫格加载
 * @Createdtime:2019/1/5 15:44
 * @Author:Zhaohd
 * @Version: V.1.0.0
 */

public class MomentsImageAdapter extends CommonAdapter<WechatImages> {

    @BindView(R.id.img_mine)
    ImageView imgMine;

    public MomentsImageAdapter(Context mContext, List<WechatImages> mDatas) {
        super(mContext, mDatas);
    }

    @Override
    public void bindData(CommonViewHolder holder, WechatImages data, int position) {
        ButterKnife.bind(this, holder.itemView);
        setImageResource(data);
    }

    @Override
    public int getLayoutId(int viewType) {
        return R.layout.rc_images_item;
    }

    private void setImageResource(WechatImages data) {
        Glide.with(mContext).load(data.getUrl()).bitmapTransform(new GlideRoundTransform(mContext)).error(R.drawable.music_item04).into(imgMine);
    }
}
