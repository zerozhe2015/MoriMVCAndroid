package com.moriarty.morimvcandroid.module.start;




public class SplashPresenterImpl implements SplashPresenter, SplashInteractor.OnEnterIntoFinishListener {
    private SplashView mSplashView;
    private SplashInteractor mSplashInteractor;

    public SplashPresenterImpl(SplashView mSplashView) {
        this.mSplashView = mSplashView;
        mSplashInteractor = new SplashInteractorImpl();
    }

    @Override
    public void isFirstOpen(boolean isFirstOpen) {
        mSplashInteractor.enterInto(isFirstOpen, this);
    }

    @Override
    public void onDestroy() {
        mSplashView = null;
    }

    @Override
    public void isFirstOpen() {
        SplashActivityPermissionsDispatcher.startWelcomeGuideActivityWithCheck((SplashActivity) mSplashView);
    }

    @Override
    public void isNotFirstOpen() {
        mSplashView.startHomeActivity();
    }

    @Override
    public void showContentView() {
        mSplashView.initContentView();
    }
}
