package com.example.zhaoseast.wechatmoments.adapter;

import android.app.Activity;
import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.zhaoseast.wechatmoments.R;
import com.example.zhaoseast.wechatmoments.adapter.baseRecyclerview.CommonAdapter;
import com.example.zhaoseast.wechatmoments.adapter.baseRecyclerview.CommonViewHolder;
import com.example.zhaoseast.wechatmoments.bean.WechatComments;
import com.example.zhaoseast.wechatmoments.bean.WechatMainBean;
import com.example.zhaoseast.wechatmoments.bean.WechatSender;
import com.example.zhaoseast.wechatmoments.model.WechatMomentsModel;
import com.example.zhaoseast.wechatmoments.view.GlideRoundTransform;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @Description:评论加载列表
 * @Createdtime:2019/1/5 15:46
 * @Author:Zhaohd
 * @Version: V.1.0.0
 */
public class WechatCommentsAdapter extends CommonAdapter<WechatComments> {

    private final WechatMomentsModel wechatMomentsModel;
    @BindView(R.id.img_logo)
    ImageView imgLogo;
    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.txt_context)
    TextView txtContext;
    @BindView(R.id.txt_time)
    TextView txtTime;

    public WechatCommentsAdapter(Context mContext, List<WechatComments> mDatas) {
        super(mContext, mDatas);
        wechatMomentsModel = new WechatMomentsModel((Activity) mContext);
    }

    @Override
    public void bindData(CommonViewHolder holder, WechatComments data, int position) {
        ButterKnife.bind(this, holder.itemView);
        txtContext.setText(data.getContent());
        //通过评论表获取用户信息
        WechatSender wechatSender = wechatMomentsModel.getSenderInfo(data.getUserid());
        if (wechatSender!=null){
            txtTitle.setText(wechatSender.getNick());
            setImageResource(wechatSender.getAvatar());
        }
        txtTime.setText("15:52");
    }

    private void setImageResource(String url) {
        Glide.with(mContext).load(url).bitmapTransform(new GlideRoundTransform(mContext)).error(R.drawable.music_item06).into(imgLogo);
    }

    @Override
    public int getLayoutId(int viewType) {
        return R.layout.rc_wechatcomments_item;
    }
}
