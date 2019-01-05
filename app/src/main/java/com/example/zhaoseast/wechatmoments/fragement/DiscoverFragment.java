package com.example.zhaoseast.wechatmoments.fragement;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.zhaoseast.wechatmoments.R;
import com.example.zhaoseast.wechatmoments.activity.WeChatMomentsActivity;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @Description:微信时刻
 * @Createdtime:2019/1/3 17:48
 * @Author:Zhaohd
 * @Version: V.1.0.0
 */
public class DiscoverFragment extends Fragment implements OnRefreshListener {

    @BindView(R.id.iv_bar_record)
    ImageView ivBarRecord;
    @BindView(R.id.iv_bar_back)
    ImageView ivBarBack;
    @BindView(R.id.lyt_moment)
    LinearLayout lytMoment;
    @BindView(R.id.txt_titlename)
    TextView txtTitlename;
    private Unbinder unbinder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_discover, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        lytMoment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(WeChatMomentsActivity.getStartIntent(getContext()));
            }
        });
        initTiles();
    }

    private void initTiles() {
        txtTitlename.setText("发现");

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onRefresh(RefreshLayout refreshLayout) {
    }
}
