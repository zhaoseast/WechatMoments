package com.example.zhaoseast.wechatmoments;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.example.zhaoseast.wechatmoments.activity.baseActivity.WeChatBaseActivity;
import com.example.zhaoseast.wechatmoments.fragement.AddressFragment;
import com.example.zhaoseast.wechatmoments.fragement.DiscoverFragment;
import com.example.zhaoseast.wechatmoments.fragement.MineFragment;
import com.example.zhaoseast.wechatmoments.fragement.WechatFragment;
import com.example.zhaoseast.wechatmoments.view.BottomTabView;

import java.util.ArrayList;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @Description:主页界面
 * @Createdtime:2019/1/3 17:46
 * @Author:Zhaohd
 * @Version: V.1.0.0
 */
public class MainActivity extends WeChatBaseActivity {

    @BindString(R.string.menu_wechat)
    String WeChatString;

    @BindString(R.string.menu_address)
    String AddressString;

    @BindString(R.string.menu_discover)
    String DiscoverString;

    @BindString(R.string.menu_mine)
    String MineString;

    @BindView(R.id.id_main_bottomtabview)
    BottomTabView idMainBottomtabview;
    @BindView(R.id.activity_main)
    LinearLayout activityMain;
    @BindView(R.id.id_main_viewpager)
    FrameLayout idMainViewpager;
    private ArrayList<BottomTabView.TabItemView> itemViewList;
    private BottomTabView.TabItemView discovertabItemView;
    private BottomTabView.TabItemView wechatItemView;
    private BottomTabView.TabItemView minetabItemView;
    private BottomTabView.TabItemView addressItemView;
    private WechatFragment wechatFragment = null;
    private AddressFragment addressFragment = null;
    private DiscoverFragment discoverFragment = null;
    private MineFragment mineFragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setBottomTabView();
        bindEvents();
        selectFragment(0);
    }

    public void selectFragment(int number) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        hideFragment(beginTransaction);
        switch (number) {
            case 0:
                if (wechatFragment == null) {
                    wechatFragment = new WechatFragment();
                    beginTransaction.add(R.id.id_main_viewpager, wechatFragment);
                } else {
                    //设置fragment可见时加载
                    wechatFragment.setUserVisibleHint(true);
                    beginTransaction.show(wechatFragment);
                }
                break;
            case 1:
                if (addressFragment == null) {
                    addressFragment = new AddressFragment();
                    beginTransaction.add(R.id.id_main_viewpager, addressFragment);
                } else {
                    beginTransaction.show(addressFragment);
                }
                break;
            case 2:
                if (discoverFragment == null) {
                    discoverFragment = new DiscoverFragment();
                    beginTransaction.add(R.id.id_main_viewpager, discoverFragment);
                } else {
                    beginTransaction.show(discoverFragment);
                }
                break;
            case 3:
                if (mineFragment == null) {
                    mineFragment = new MineFragment();
                    beginTransaction.add(R.id.id_main_viewpager, mineFragment);
                } else {
                    beginTransaction.show(mineFragment);
                }
                break;
            default:
                break;
        }
        beginTransaction.commit();
    }

    private void hideFragment(FragmentTransaction transaction) {
        // TODO Auto-generated method stub
        if (wechatFragment != null) {
            wechatFragment.setUserVisibleHint(false);
            transaction.hide(wechatFragment);
        }
        if (addressFragment != null) {
            transaction.hide(addressFragment);
        }
        if (discoverFragment != null) {
            transaction.hide(discoverFragment);
        }
        if (mineFragment != null) {
            transaction.hide(mineFragment);
        }
    }

    private void bindEvents() {
        idMainBottomtabview.setOnTabItemSelectListener(new BottomTabView.OnTabItemSelectListener() {
            @Override
            public void onTabItemSelect(int position) {
                selectFragment(position);
            }
        });
    }

    private void setBottomTabView() {
        itemViewList = new ArrayList<>();
        wechatItemView = new BottomTabView.TabItemView(this, WeChatString, R.color.color_before, R.color.color_txtafter, R.drawable.before_wechat, R.drawable.after_wechat);
        addressItemView = new BottomTabView.TabItemView(this, AddressString, R.color.color_before, R.color.color_txtafter, R.drawable.before_address, R.drawable.after_address);
        discovertabItemView = new BottomTabView.TabItemView(this, DiscoverString, R.color.color_before, R.color.color_txtafter, R.drawable.before_discover, R.drawable.after_discover);
        minetabItemView = new BottomTabView.TabItemView(this, MineString, R.color.color_before, R.color.color_txtafter, R.drawable.before_mine, R.drawable.after_mine);
        itemViewList.add(wechatItemView);
        itemViewList.add(addressItemView);
        itemViewList.add(discovertabItemView);
        itemViewList.add(minetabItemView);
        idMainBottomtabview.setTabItemViews(itemViewList);
    }
}
