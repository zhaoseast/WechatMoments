package com.example.zhaoseast.wechatmoments.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.zhaoseast.wechatmoments.R;
import com.example.zhaoseast.wechatmoments.adapter.baseRecyclerview.CommonAdapter;
import com.example.zhaoseast.wechatmoments.adapter.baseRecyclerview.CommonViewHolder;
import com.example.zhaoseast.wechatmoments.bean.WechatMainBean;
import com.example.zhaoseast.wechatmoments.view.GlideRoundTransform;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @Description:微信主页适配器
 * @Createdtime:2019/1/4 20:39
 * @Author:Zhaohd
 * @Version: V.1.0.0
 */

public class WechatAdapter extends CommonAdapter<WechatMainBean> {

    @BindView(R.id.img_logo)
    ImageView imgLogo;
    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.txt_context)
    TextView txtContext;
    @BindView(R.id.txt_time)
    TextView txtTime;

    public WechatAdapter(Context mContext, List<WechatMainBean> mDatas) {
        super(mContext, mDatas);
    }

    @Override
    public void bindData(CommonViewHolder holder, WechatMainBean data, int position) {
        ButterKnife.bind(this, holder.itemView);
        txtTitle.setText(data.getTitlename());
        txtContext.setText(data.getContext());
        txtTime.setText(data.getTime());
        switch (data.getImageid()) {
            case "1":
                setImageResource(R.drawable.wechat_pay);
                break;
            case "2":
                setImageResource(R.drawable.wechat_dy);
                break;
            case "3":
                setImageResource(R.drawable.icon_wechat);
                break;
            case "4":
                setImageResource(R.drawable.music_item04);
                break;
            case "5":
                setImageResource(R.drawable.music_item05);
                break;
            case "6":
                setImageResource(R.drawable.music_item06);
                break;
            case "7":
                setImageResource(R.drawable.music_item07);
                break;
            case "8":
                setImageResource(R.drawable.music_item08);
                break;
            case "9":
                setImageResource(R.drawable.music_item09);
                break;
            case "10":
                setImageResource(R.drawable.music_item04);
                break;
        }
    }

    private void setImageResource(int imagelogo) {
        Glide.with(mContext).load(imagelogo).bitmapTransform(new GlideRoundTransform(mContext)).into(imgLogo);
    }

    @Override
    public int getLayoutId(int viewType) {
        return R.layout.rc_wechatmain_item;
    }
}
