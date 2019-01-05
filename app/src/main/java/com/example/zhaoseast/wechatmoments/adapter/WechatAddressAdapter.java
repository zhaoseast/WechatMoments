package com.example.zhaoseast.wechatmoments.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.zhaoseast.wechatmoments.R;
import com.example.zhaoseast.wechatmoments.adapter.baseRecyclerview.CommonAdapter;
import com.example.zhaoseast.wechatmoments.adapter.baseRecyclerview.CommonViewHolder;
import com.example.zhaoseast.wechatmoments.bean.WechatAddressBean;
import com.example.zhaoseast.wechatmoments.view.GlideRoundTransform;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @Description:通讯录适配器
 * @Createdtime:2019/1/4 21:15
 * @Author:Zhaohd
 * @Version: V.1.0.0
 */

public class WechatAddressAdapter extends CommonAdapter<WechatAddressBean> {

    @BindView(R.id.img_logo)
    ImageView imgLogo;
    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.lyt_bc)
    LinearLayout lytBc;

    public WechatAddressAdapter(Context mContext, List<WechatAddressBean> mDatas) {
        super(mContext, mDatas);
    }

    @Override
    public void bindData(CommonViewHolder holder, WechatAddressBean data, int position) {
        ButterKnife.bind(this, holder.itemView);
        txtTitle.setText(data.getTitle());
        switch (data.getImageid()) {
            case "1":
                lytBc.setBackgroundResource(R.drawable.address_shape_yellow);
                imgLogo.setBackgroundResource(R.drawable.address_friend);
                break;
            case "2":
                lytBc.setBackgroundResource(R.drawable.address_shape_ql);
                imgLogo.setBackgroundResource(R.drawable.icon_ql);
                break;
            case "3":
                lytBc.setBackgroundResource(R.drawable.address_shape_blue);
                imgLogo.setBackgroundResource(R.drawable.icon_remark);
                break;
            case "4":
                lytBc.setBackgroundResource(R.drawable.address_shape_blue);
                imgLogo.setBackgroundResource(R.drawable.icon_all);
                break;
        }
    }

    @Override
    public int getLayoutId(int viewType) {
        return R.layout.rc_address_item;
    }
}
