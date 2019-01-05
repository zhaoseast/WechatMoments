package com.example.zhaoseast.wechatmoments.fragement;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.zhaoseast.wechatmoments.R;
import com.example.zhaoseast.wechatmoments.bean.WechatSender;
import com.example.zhaoseast.wechatmoments.model.HttpCallBack;
import com.example.zhaoseast.wechatmoments.model.WechatMomentsModel;
import com.example.zhaoseast.wechatmoments.view.GlideRoundTransform;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @Description:微信主界面
 * @Createdtime:2019/1/4 20:34
 * @Author:Zhaohd
 * @Version: V.1.0.0
 */
public class MineFragment extends Fragment {

    @BindView(R.id.iv_bar_record)
    ImageView ivBarRecord;
    @BindView(R.id.txt_titlename)
    TextView txtTitlename;
    @BindView(R.id.iv_bar_back)
    ImageView ivBarBack;
    @BindView(R.id.user_logo)
    ImageView userLogo;
    @BindView(R.id.user_name)
    TextView userName;
    private Unbinder unbinder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initTiles();
        initUserDatas();
    }

    /**
     * 初始化用户信息
     */
    private void initUserDatas() {
        WechatMomentsModel wechatMomentsModel = new WechatMomentsModel(getActivity());
        wechatMomentsModel.getUserDatasToWeb(new HttpCallBack() {
            @Override
            public void onSucess(Object response) {
                WechatSender wechatSender = (WechatSender) response;
                if (wechatSender != null) {
                    userName.setText(wechatSender.getNick());
                    Glide.with(getContext()).load(wechatSender.getAvatar()).bitmapTransform(new GlideRoundTransform(getContext())).error(R.drawable.music_item04).into(userLogo);
                }else {
                    Glide.with(getContext()).load(R.drawable.music_item08).bitmapTransform(new GlideRoundTransform(getContext())).into(userLogo);
                }
            }

            @Override
            public void onError(Object localData) {

            }
        });
    }


    private void initTiles() {
        txtTitlename.setText("");
        ivBarBack.setBackgroundResource(R.drawable.icon_xj);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
