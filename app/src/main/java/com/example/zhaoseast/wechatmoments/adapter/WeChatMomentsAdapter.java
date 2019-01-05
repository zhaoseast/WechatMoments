package com.example.zhaoseast.wechatmoments.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.zhaoseast.wechatmoments.R;
import com.example.zhaoseast.wechatmoments.adapter.baseRecyclerview.CommonAdapter;
import com.example.zhaoseast.wechatmoments.adapter.baseRecyclerview.CommonViewHolder;
import com.example.zhaoseast.wechatmoments.bean.WechatComments;
import com.example.zhaoseast.wechatmoments.bean.WechatContent;
import com.example.zhaoseast.wechatmoments.bean.WechatImages;
import com.example.zhaoseast.wechatmoments.bean.WechatSender;
import com.example.zhaoseast.wechatmoments.model.WechatMomentsModel;
import com.example.zhaoseast.wechatmoments.view.GlideRoundTransform;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @Description:微信朋友圈适配器
 * @Createdtime:2019/1/4 15:54
 * @Author:Zhaohd
 * @Version: V.1.0.0
 */

public class WeChatMomentsAdapter extends CommonAdapter<WechatSender> {

    private final WechatMomentsModel wechatMomentsModel;
    @BindView(R.id.txt_username)
    TextView txtUsername;
    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.rc_images)
    RecyclerView rcImages;
    @BindView(R.id.txt_address)
    TextView txtAddress;
    @BindView(R.id.txt_cratedate)
    TextView txtCratedate;
    @BindView(R.id.rc_like)
    RecyclerView rcLike;
    @BindView(R.id.rc_comments)
    RecyclerView rcComments;
    @BindView(R.id.user_logo)
    ImageView userLogo;
    @BindView(R.id.image_comments)
    ImageView imageComments;
    @BindView(R.id.lyt_comments)
    LinearLayout lytComments;

    public WeChatMomentsAdapter(Context mContext, List<WechatSender> mDatas) {
        super(mContext, mDatas);
        wechatMomentsModel = new WechatMomentsModel((Activity) mContext);
    }

    @Override
    public void bindData(CommonViewHolder holder, WechatSender data, int position) {
        ButterKnife.bind(this, holder.itemView);
        if (data != null) {
            txtUsername.setText(data.getNick());
            Glide.with(mContext).load(data.getAvatar()).bitmapTransform(new GlideRoundTransform(mContext)).error(R.drawable.music_item01).into(userLogo);
            //获取当前主题信息
            WechatContent contentdata = wechatMomentsModel.getLocalContents(data.getId());
            if (contentdata != null) {
                txtTitle.setText(contentdata.getTitle());
                //通过当前主题ID获取图片信息
                List<WechatImages> wechatImagesList = wechatMomentsModel.getLocalImages(contentdata.getId());
                initImageRcAdapter(wechatImagesList);
                //通过主题ID获取评论内容
                List<WechatComments> commentsList = wechatMomentsModel.getLocalMoments(contentdata.getId());
                if (commentsList!=null && commentsList.size()>0){
                    initCommentsRcAdapter(commentsList);
                }else {
                    lytComments.setVisibility(View.GONE);
                }
            }
        }
//        if (data.getSender()!=null){
//            txtUsername.setText(data.getSender().getUsername());
////            Glide.with(mContext).load(data.getSender().getAvatar()).bitmapTransform(new GlideRoundTransform(mContext)).into(userLogo);
//            Glide.with(mContext).load(R.drawable.music_item01).bitmapTransform(new GlideRoundTransform(mContext)).into(userLogo);
//        }
//        if (data.getContent()!= null){
//            txtTitle.setText(data.getContent());
//        }

    }

    private void initCommentsRcAdapter(List<WechatComments> commentsList) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
        rcComments.setLayoutManager(linearLayoutManager);
        WechatCommentsAdapter commentsAdapter = new WechatCommentsAdapter(mContext,commentsList);
        rcComments.setAdapter(commentsAdapter);
    }

    private void initImageRcAdapter(List<WechatImages> wechatImagesList) {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 3);
        rcImages.setLayoutManager(gridLayoutManager);
        MomentsImageAdapter imageAdapter = new MomentsImageAdapter(mContext, wechatImagesList);
        rcImages.setAdapter(imageAdapter);
    }

    @Override
    public int getLayoutId(int viewType) {
        return R.layout.rc_moments_item;
    }
}
