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

import com.bumptech.glide.Glide;
import com.example.zhaoseast.wechatmoments.R;
import com.example.zhaoseast.wechatmoments.adapter.WechatAddressAdapter;
import com.example.zhaoseast.wechatmoments.bean.WechatAddressBean;
import com.example.zhaoseast.wechatmoments.view.GlideCircleTransform;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
/**
 * @Description:通讯录
 * @Createdtime:2019/1/3 17:48
 * @Author:Zhaohd
 * @Version: V.1.0.0
 */
public class AddressFragment extends Fragment {

    @BindView(R.id.iv_bar_record)
    ImageView ivBarRecord;
    @BindView(R.id.txt_titlename)
    TextView txtTitlename;
    @BindView(R.id.iv_bar_back)
    ImageView ivBarBack;
    @BindView(R.id.rc_address)
    RecyclerView rcAddress;
    @BindView(R.id.img_logo)
    ImageView imgLogo;
    @BindView(R.id.img_star)
    ImageView imgStar;
    @BindView(R.id.img_index)
    ImageView imgIndex;
    @BindView(R.id.img_index1)
    ImageView imgIndex1;
    private Unbinder unbinder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_address, container, false);
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
        List<WechatAddressBean> addressBeans = new ArrayList<>();
        addressBeans.add(new WechatAddressBean("新的朋友", "1"));
        addressBeans.add(new WechatAddressBean("群聊", "2"));
        addressBeans.add(new WechatAddressBean("标签", "3"));
        addressBeans.add(new WechatAddressBean("公众号", "4"));
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        rcAddress.setLayoutManager(layoutManager);
        WechatAddressAdapter addressAdapter = new WechatAddressAdapter(getContext(), addressBeans);
        rcAddress.setAdapter(addressAdapter);
    }

    private void initTiles() {
        txtTitlename.setText("通讯录");
        ivBarBack.setBackgroundResource(R.drawable.icon_friend);
        Glide.with(getContext()).load(R.drawable.music_item04).bitmapTransform(new GlideCircleTransform(getContext())).into(imgLogo);
        Glide.with(getContext()).load(R.drawable.music_item06).bitmapTransform(new GlideCircleTransform(getContext())).into(imgStar);
        Glide.with(getContext()).load(R.drawable.music_item08).bitmapTransform(new GlideCircleTransform(getContext())).into(imgIndex);
        Glide.with(getContext()).load(R.drawable.music_item01).bitmapTransform(new GlideCircleTransform(getContext())).into(imgIndex1);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
