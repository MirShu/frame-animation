package com.example.frame_animation;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.andview.refreshview.callback.IHeaderCallBack;

/**
 * Created by jiuxian on 2016/6/18.
 */
public class MyygRefreshHeader extends LinearLayout implements IHeaderCallBack {
    private final static String TAG = MyygRefreshHeader.class.getSimpleName();

    private Context mContext;
    private ImageView iv_default;
    private ImageView iv_refresh;
    private ImageView iv_default2;
    private ImageView iv_refresh2;
    private ImageView iv_default3;
    private ImageView iv_refresh3;
    private AnimationDrawable anim;

    public MyygRefreshHeader(Context context) {
        super(context);
        this.mContext = context;
        this.initView();
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(R.layout.view_myyg_refresh_header, this);
        this.iv_default = (ImageView) this.findViewById(R.id.iv_default);
        this.iv_refresh = (ImageView) this.findViewById(R.id.iv_refresh);
        this.iv_default2 = (ImageView) this.findViewById(R.id.iv_default2);
        this.iv_refresh2 = (ImageView) this.findViewById(R.id.iv_refresh2);
        this.iv_default3 = (ImageView) this.findViewById(R.id.iv_default3);
        this.iv_refresh3 = (ImageView) this.findViewById(R.id.iv_refresh3);
        this.anim = (AnimationDrawable) this.iv_refresh.getBackground();
        this.anim = (AnimationDrawable) this.iv_refresh2.getBackground();
    }

    @Override
    public void onStateNormal() {
        this.iv_default.setVisibility(VISIBLE);
        this.iv_refresh.setVisibility(GONE);
        this.iv_default2.setVisibility(VISIBLE);
        this.iv_refresh2.setVisibility(GONE);
        this.iv_default3.setVisibility(VISIBLE);
        this.iv_refresh3.setVisibility(GONE);
    }

    @Override
    public void onStateReady() {

    }

    @Override
    public void onStateRefreshing() {
        this.iv_default.setVisibility(GONE);
        this.iv_refresh.setVisibility(VISIBLE);
        this.iv_default2.setVisibility(GONE);
        this.iv_refresh2.setVisibility(VISIBLE);
        this.iv_default3.setVisibility(GONE);
        this.iv_refresh3.setVisibility(VISIBLE);
        this.anim.start();
    }

    @Override
    public void onStateFinish() {

        //this.anim.stop();
    }

    @Override
    public void onHeaderMove(double offset, int offsetY, int deltaY) {
        if (offsetY >= this.getHeaderHeight()) {
            this.iv_default.setImageResource(R.mipmap.ic_anim_0024);
            this.iv_default2.setImageResource(R.mipmap.ic_anim_0024);
            this.iv_default3.setImageResource(R.mipmap.ic_anim_0024);
        }
        if (offsetY < this.getHeaderHeight()) {
            this.iv_default.setImageResource(R.mipmap.ic_anim_0023);
            this.iv_default2.setImageResource(R.mipmap.ic_anim_0023);
            this.iv_default3.setImageResource(R.mipmap.ic_anim_0023);
        }
    }

    @Override
    public void setRefreshTime(long lastRefreshTime) {

    }

    @Override
    public void hide() {
        //this.setVisibility(View.GONE);
    }

    @Override
    public void show() {
        this.setVisibility(View.VISIBLE);
    }

    @Override
    public int getHeaderHeight() {
        return getMeasuredHeight();
    }
}
