package com.example.frame_animation;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.andview.refreshview.XRefreshView;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

public class MainActivity extends Activity {
    private RecyclerView rv_address;

    private XRefreshView xRefreshView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.xRefreshView = (XRefreshView) findViewById(R.id.xRefreshView);
        this.rv_address = (RecyclerView) findViewById(R.id.rv_address);
        this.bindLikeRecycleView();
        showData();

    }

    private void showData() {
        String url = "http://www.imooc.com/api/teacher?type=4&num=30";
        HttpUtils http = new HttpUtils();
        http.send(HttpRequest.HttpMethod.GET, url, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                return;

            }

            @Override
            public void onFailure(HttpException e, String s) {
                xRefreshView.stopLoadMore();
            }
        });
    }

    private void bindLikeRecycleView() {
        this.xRefreshView.setPullLoadEnable(true);
        MyygRefreshHeader header = new MyygRefreshHeader(MainActivity.this);
        this.xRefreshView.setCustomHeaderView(header);
//        CustomGifHeader header = new CustomGifHeader(MyReceiptAddressActivity.this);
//        this.xRefreshView.setCustomHeaderView(header);
//        this.xRefreshView.setPinnedTime(1000);
        this.xRefreshView.setMoveForHorizontal(true);
        this.xRefreshView.setAutoLoadMore(true);
        this.rv_address.setHasFixedSize(true);
        this.rv_address.setLayoutManager(new GridLayoutManager(MainActivity.this, 1, LinearLayoutManager.VERTICAL, false));
        this.xRefreshView.setXRefreshViewListener(new XRefreshView.SimpleXRefreshListener() {
            @Override
            public void onRefresh() {

            }
        });
    }

}
