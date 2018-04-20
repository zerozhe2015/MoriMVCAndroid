package com.moriarty.morimvcandroid.module.wechat;

import com.moriarty.morimvcandroid.R;
import com.moriarty.morimvcandroid.base.BaseFragment;
import com.moriarty.morimvcandroid.module.find.FindFragment;

public class WechatFragment extends BaseFragment {


    public WechatFragment() {
    }

    public static WechatFragment newInstance() {
        WechatFragment fragment = new WechatFragment();
        return fragment;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {

    }

    @Override
    protected void managerArguments() {

    }

    @Override
    public String getUmengFragmentName() {
        return getContext().getClass().getSimpleName() + "-"
                + this.getClass().getSimpleName();
    }
}
