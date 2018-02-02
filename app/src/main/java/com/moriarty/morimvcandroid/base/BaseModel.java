package com.moriarty.morimvcandroid.base;

import android.content.Context;

/**
 * 公共Model,所有Model继承自此类
 */
public abstract class BaseModel {
    Context mContext;

    public BaseModel(Context context) {
        mContext = context;
    }

    public Context getContext() {
        return mContext;
    }


}
