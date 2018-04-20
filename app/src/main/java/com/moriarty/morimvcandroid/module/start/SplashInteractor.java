package com.moriarty.morimvcandroid.module.start;




public interface SplashInteractor {

    public interface OnEnterIntoFinishListener{
        void isFirstOpen();

        void isNotFirstOpen();

        void showContentView();

    }

    void enterInto(boolean isFirstOpen, OnEnterIntoFinishListener listener);
}
