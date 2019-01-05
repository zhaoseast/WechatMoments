package com.example.zhaoseast.wechatmoments.fragement;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zhaoseast.wechatmoments.R;
import com.example.zhaoseast.wechatmoments.adapter.WechatAdapter;
import com.example.zhaoseast.wechatmoments.bean.WechatMainBean;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @Description:微信主页
 * @Createdtime:2019/1/4 18:49
 * @Author:Zhaohd
 * @Version: V.1.0.0
 */
public class WechatFragment extends Fragment {

    @BindView(R.id.iv_bar_record)
    ImageView ivBarRecord;
    @BindView(R.id.txt_titlename)
    TextView txtTitlename;
    @BindView(R.id.iv_bar_back)
    ImageView ivBarBack;
    @BindView(R.id.rc_wechat)
    RecyclerView rcWechat;
    @BindView(R.id.refresh_moments)
    SmartRefreshLayout refreshMoments;
    private Unbinder unbinder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_wechat, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initTiles();
        initRCAdapter();
    }

    private void initRCAdapter() {
        List<WechatMainBean> wechatMainBeans = new ArrayList<>();
        wechatMainBeans.add(new WechatMainBean("微信支付", "1", "微信支付凭证","15:30"));
        wechatMainBeans.add(new WechatMainBean("订阅好消息", "2", "Welcome to the WeChat moment of the world","16:20"));
        wechatMainBeans.add(new WechatMainBean("微信运动", "3", "[应用消息]","19:24"));
        wechatMainBeans.add(new WechatMainBean("Joe Portman", "4", "Hello","20:30"));
        wechatMainBeans.add(new WechatMainBean("Super hero ", "5", "Welcome to the WeChat moment of the world","21:15"));
        wechatMainBeans.add(new WechatMainBean("Doggy Over", "6", "Welcome to the WeChat moment of the world","22:00"));
        wechatMainBeans.add(new WechatMainBean("Coolzzz", "7", "Welcome to the WeChat moment of the world","22:10"));
        wechatMainBeans.add(new WechatMainBean("snowman", "8", "Welcome to the WeChat moment of the world","22:20"));
        wechatMainBeans.add(new WechatMainBean("Rebecca", "9", "Welcome to the WeChat moment of the world","22:30"));
        wechatMainBeans.add(new WechatMainBean("Joe Huang", "10", "Welcome to the WeChat moment of the world","22:40"));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        rcWechat.setLayoutManager(linearLayoutManager);
        WechatAdapter wechatAdapter = new WechatAdapter(getContext(),wechatMainBeans);
        rcWechat.setAdapter(wechatAdapter);

    }

    private void initTiles() {
        txtTitlename.setText("微信");
        ivBarBack.setBackgroundResource(R.drawable.icon_add);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
