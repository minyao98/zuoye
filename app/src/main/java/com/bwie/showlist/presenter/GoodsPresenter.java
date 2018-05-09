package com.bwie.showlist.presenter;

import android.util.Log;

import com.bwie.showlist.bean.GoodsListBean;
import com.bwie.showlist.model.GoodsModel;
import com.bwie.showlist.view.IView;
import com.bwie.showlist.view.MainActivity;
import com.google.gson.Gson;

import java.util.List;

/**
 * Created by 暗夜 on 2018/5/9.
 */

public class GoodsPresenter implements IPresenter {

    private static final String TAG = "GoodsPresenter----";
    private IView iView;
    private GoodsModel goodsModel;

    public GoodsPresenter(IView iView) {
        this.iView = iView;
        goodsModel=new GoodsModel();
    }

    @Override
    public void getCarInfo(String pscid,String page) {
       goodsModel.getData(pscid,page,this);
    }

    @Override
    public void onSuccess(String json) {

        Log.d(TAG, "onSuccess: "+json);
        if(null!=iView){
            Gson gson=new Gson();
            GoodsListBean goodsListBean = gson.fromJson(json, GoodsListBean.class);
            List<GoodsListBean.DataBean> data = goodsListBean.getData();

            Log.d(TAG, "onSuccess: "+data);
            iView.showDataToView(data);
        }

    }

    @Override
    public void onFailed(String error) {
            if(null!=iView ){

                Log.d(TAG, "onFailed: "+error);

        }
    }

    @Override
    public void onDestory() {
        if(null!=iView){
            iView=null;
        }

    }
}
