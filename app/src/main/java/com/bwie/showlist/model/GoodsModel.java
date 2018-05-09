package com.bwie.showlist.model;

import com.bwie.showlist.presenter.IPresenter;
import com.bwie.showlist.utils.HttpConfig;
import com.bwie.showlist.utils.OkHttpUtils;
import com.bwie.showlist.utils.OnFinishListener;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 暗夜 on 2018/5/9.
 */

public class GoodsModel implements IModel {
    @Override
    public void getData(String pscid,String page, final IPresenter iPresenter) {
        Map<String,String> params=new HashMap<>();
        params.put("pscid",pscid);
        OkHttpUtils okHttpUtils= OkHttpUtils.getInstance();
        okHttpUtils.doPost(HttpConfig.GoodsListUrl, params, new OnFinishListener() {
            @Override
            public void onSuccess(String json) {
                iPresenter.onSuccess(json);

            }

            @Override
            public void onFailed(String error) {
                iPresenter.onFailed(error);

            }
        });

    }
}
