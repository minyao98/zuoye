package com.bwie.showlist.presenter;

/**
 * Created by 暗夜 on 2018/5/9.
 */

public interface IPresenter {
    void getCarInfo(String pscid,String page);
    void onSuccess(String json);
    void onFailed(String error);
    void onDestory();
}
