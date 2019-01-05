package com.example.zhaoseast.wechatmoments.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.zhaoseast.wechatmoments.R;
import com.example.zhaoseast.wechatmoments.activity.baseActivity.WeChatBaseActivity;
import com.example.zhaoseast.wechatmoments.adapter.WeChatMomentsAdapter;
import com.example.zhaoseast.wechatmoments.bean.WechatSender;
import com.example.zhaoseast.wechatmoments.model.HttpCallBack;
import com.example.zhaoseast.wechatmoments.model.WechatMomentsModel;
import com.example.zhaoseast.wechatmoments.utils.ToastUtil;
import com.example.zhaoseast.wechatmoments.vo.JsonRootBean;
import com.example.zhaoseast.wechatmoments.vo.Sender;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @Description:朋友圈列表
 * @Createdtime:2019/1/4 15:23
 * @Author:Zhaohd
 * @Version: V.1.0.0
 */
public class WeChatMomentsActivity extends WeChatBaseActivity implements OnRefreshListener, OnLoadMoreListener {

    @BindView(R.id.iv_bar_record)
    ImageView ivBarRecord;
    @BindView(R.id.iv_bar_back)
    ImageView ivBarBack;
    @BindView(R.id.rc_moments)
    RecyclerView rcMoments;
    @BindView(R.id.refresh_moments)
    SmartRefreshLayout refreshMoments;
    private WechatMomentsModel momentsModel;
    private List<WechatSender> wechatSenders;
    public static final int PAGE_NUM = 5; //分页大小
    public int pageNO = 1; //分页号
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_we_chat_moments);
        ButterKnife.bind(this);
        ininViews();
    }

    private void initRCAdapter( List<WechatSender> wechatSenders) {
        WeChatMomentsAdapter momentsAdapter = new WeChatMomentsAdapter(this,wechatSenders);
        rcMoments.setAdapter(momentsAdapter);
    }

    private void ininViews() {
        ivBarRecord.setBackgroundResource(R.drawable.icon_left);
        ivBarBack.setBackgroundResource(R.drawable.icon_xj);
        momentsModel = new WechatMomentsModel(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcMoments.setLayoutManager(linearLayoutManager);
        refreshMoments.setOnRefreshListener(this);
        refreshMoments.setOnLoadMoreListener(this);
        refreshMoments.autoRefresh();
        refreshMoments.setEnableLoadMore(true);
        refreshMoments.finishLoadMore(2000);
        ivBarBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    /**
     * 启动此activity需要的intent
     *
     * @param context
     * @return
     */
    public static Intent getStartIntent(Context context) {
        Intent startIntent = new Intent(context, WeChatMomentsActivity.class);
        return startIntent;
    }

    /**
     * 下拉刷新
     * @param refreshLayout
     */
    @Override
    public void onRefresh(final RefreshLayout refreshLayout) {
        List<WechatSender> wechatSenders = momentsModel.getAllSenders();
        if (wechatSenders.size() == 0 || wechatSenders == null){ //第一次从网络将在所有推文信息
            //初始化朋友圈信息
            momentsModel.getTeetstoWeb(pageNO,PAGE_NUM, new HttpCallBack() {
                @Override
                public void onSucess(Object response) {
                    setRcAdapter(response, (SmartRefreshLayout) refreshLayout);
                    ToastUtil.showLongToast(WeChatMomentsActivity.this,"数据加载成功!!!");
                }
                @Override
                public void onError(Object localData) {
                    setRcAdapter(localData, (SmartRefreshLayout) refreshLayout);
                    ToastUtil.showLongToast(WeChatMomentsActivity.this,"数据加载失败!!!");
                }
            });
        }else {
            initRCAdapter(momentsModel.getLocalSendersByLimit(1,PAGE_NUM));
            refreshLayout.finishRefresh();
            pageNO = 2;
        }
    }

    private void setRcAdapter(Object response,  SmartRefreshLayout refreshLayout) {
        List<WechatSender> wechatSenders = (List<WechatSender>) response;
        responseAdapter(refreshLayout, wechatSenders);
    }

    /**
     * 初始化加载数据
     * @param refreshLayout
     * @param wechatSenders
     */
    private void responseAdapter(SmartRefreshLayout refreshLayout, List<WechatSender> wechatSenders) {
        if (wechatSenders!=null && wechatSenders.size()>0){
            initRCAdapter(wechatSenders);
            refreshLayout.finishLoadMore();
            refreshLayout.finishRefresh();
            pageNO++;
        }else {
            refreshLayout.finishRefresh();
            refreshLayout.finishLoadMore();
        }
    }

    /**
     * 上拉加载
     * @param refreshLayout
     */
    @Override
    public void onLoadMore(RefreshLayout refreshLayout) {
        List<WechatSender> wechatSenders = momentsModel.getLocalSendersByLimit(pageNO,PAGE_NUM);
        responseAdapter((SmartRefreshLayout) refreshLayout, wechatSenders);
    }
}
