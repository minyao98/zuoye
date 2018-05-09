package com.bwie.showlist.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;

import com.bwie.showlist.R;
import com.bwie.showlist.bean.GoodsListBean;
import com.bwie.showlist.model.GoodsAdapter;
import com.bwie.showlist.presenter.GoodsPresenter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements IView{

    private static final String TAG ="MainActivity----" ;
    private XRecyclerView xrcy;
    private GoodsPresenter goodsPresenter;
    private GoodsAdapter adapter;
    private int pscid = 1;
    private int page = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        xrcy = (XRecyclerView) findViewById(R.id.xrcy);

        adapter = new GoodsAdapter(MainActivity.this);
        xrcy.setAdapter(adapter);
        xrcy.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        goodsPresenter = new GoodsPresenter(this);
        goodsPresenter.getCarInfo("1",page+"");

        if (pscid > 0) {
            goodsPresenter.getCarInfo(pscid+"",page+"");
        }

        xrcy.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                page = 1;
                goodsPresenter.getCarInfo(pscid+"",page+"");
            }

            @Override
            public void onLoadMore() {
                page++;
                goodsPresenter.getCarInfo(pscid+"",page+"");
            }
        });

    }

    @Override
    public void showDataToView(List<GoodsListBean.DataBean> data) {
        Log.d(TAG, "showDataToView: "+data);
        xrcy.refreshComplete();
        xrcy.loadMoreComplete();
        if (page > 1) {
            //显示添加数据
            adapter.addList(data);
        } else {
            adapter.updateList(data);
        }






    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        goodsPresenter.onDestory();
    }
}
