package com.moriarty.morimvcandroid.module.start;

import android.os.Handler;



public class SplashInteractorImpl implements SplashInteractor{
    @Override
    public void enterInto(boolean isFirstOpen, final OnEnterIntoFinishListener listener) {
        if (!isFirstOpen){
            listener.isFirstOpen();
        }else {
            listener.showContentView();
            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    listener.isNotFirstOpen();
                }
            }, 2000);
        }
    }
}
