package com.moriarty.morimvcandroid.module.me;

import com.moriarty.morimvcandroid.R;
import com.moriarty.morimvcandroid.base.BaseFragment;

public class MeFragment extends BaseFragment {


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