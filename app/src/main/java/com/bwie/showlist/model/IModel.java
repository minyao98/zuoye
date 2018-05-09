package com.bwie.showlist.model;

import com.bwie.showlist.presenter.IPresenter;

/**
 * Created by 暗夜 on 2018/5/9.
 */

public interface IModel {
    void getData(String pscid,String page, IPresenter iPresenter);
}
