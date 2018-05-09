package com.bwie.showlist.utils;

/**
 * Created by 暗夜 on 2018/5/9.
 */

public interface OnFinishListener {
    void onSuccess(String json);
    void onFailed(String error);
}
