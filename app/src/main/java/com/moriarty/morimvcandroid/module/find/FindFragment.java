package com.moriarty.morimvcandroid.module.find;


import android.view.View;

import com.moriarty.morimvcandroid.R;
import com.moriarty.morimvcandroid.base.BaseFragment;


public class FindFragment extends BaseFragment implements View.OnClickListener {

    @Override
    public void onClick(View v) {

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
