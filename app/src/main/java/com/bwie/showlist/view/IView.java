package com.bwie.showlist.view;

import com.bwie.showlist.bean.GoodsListBean;

import java.util.List;

/**
 * Created by 暗夜 on 2018/5/9.
 */

public interface IView {
    void showDataToView(List<GoodsListBean.DataBean> data);
}
