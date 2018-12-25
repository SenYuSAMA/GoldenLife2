package com.senyu.gdut.goledentwo;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TableLayout;
import android.widget.TextView;

import com.senyu.gdut.goledentwo.bean.FinanceBean;
import com.senyu.gdut.goledentwo.ui.AboutFragment;
import com.senyu.gdut.goledentwo.ui.MarKetFragment;
import com.senyu.gdut.goledentwo.ui.NewsFragment;
import com.senyu.gdut.goledentwo.util.JsonUtil;
import com.senyu.gdut.goledentwo.util.OkHttp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Request;

public class MainActivity extends AppCompatActivity {
    private TabLayout mTabLayout = null;
    private TextView mTitleText;
    private MyFragmentAdapter myFragmentAdapter;
    private ViewPager mViewPager;
    final List<Fragment> fragmentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        bindViews();
        initTabs();
    }
    private void initFragment() {
        MarKetFragment marKetFragment = new MarKetFragment();
        NewsFragment newsFragment = new NewsFragment();
        AboutFragment aboutFragment = new AboutFragment();

        List<String> titleList = new ArrayList<>();
        titleList.add("行情");
        titleList.add("资讯");
        titleList.add("关于");
        fragmentList.add(marKetFragment);
        fragmentList.add(newsFragment);
        fragmentList.add(aboutFragment);
         myFragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager(),fragmentList,titleList);
         mViewPager.setAdapter(myFragmentAdapter);

    }

    private void bindViews() {
        mTitleText = findViewById(R.id.title_tv);
        mTabLayout = findViewById(R.id.tab_layout);
        mViewPager = findViewById(R.id.viewpager);
    }


    private void initTabs(){

        TabLayout.Tab tab1 = mTabLayout.newTab().setText("行情").setIcon(R.mipmap.market4242);
        TabLayout.Tab tab2 = mTabLayout.newTab().setText("资讯").setIcon(R.mipmap.news4444);
        TabLayout.Tab tab3 = mTabLayout.newTab().setText("关于").setIcon(R.mipmap.about3643);
        mTabLayout.addTab(tab1,true);
        mTabLayout.addTab(tab2,false);
        mTabLayout.addTab(tab3,false);

        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0:
                        tab.setIcon(R.mipmap.market4242_blue);
                        mTabLayout.setTabTextColors(Color.parseColor("#9f9ea3"),Color.parseColor("#FF1478de"));
                        mTitleText.setText("行情");
                        break;
                    case 1:
                        tab.setIcon(R.mipmap.news4444_blue);
                        mTabLayout.setTabTextColors(Color.parseColor("#9f9ea3"),Color.parseColor("#FF1478de"));
                        mTitleText.setText("资讯");
                        break;
                    case 2:
                        tab.setIcon(R.mipmap.about3643_blue);
                        mTabLayout.setTabTextColors(Color.parseColor("#9f9ea3"),Color.parseColor("#FF1478de"));
                        mTitleText.setText("关于");
                        break;
                        default:
                            break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0:
                        tab.setIcon(R.mipmap.market4242);
                        mTabLayout.setTabTextColors(Color.parseColor("#9f9ea3"),Color.parseColor("#FF1478de"));
                        break;
                    case 1:
                        tab.setIcon(R.mipmap.news4444);
                        mTabLayout.setTabTextColors(Color.parseColor("#9f9ea3"),Color.parseColor("#FF1478de"));
                        break;
                    case 2:
                        tab.setIcon(R.mipmap.about3643);
                        mTabLayout.setTabTextColors(Color.parseColor("#9f9ea3"),Color.parseColor("#FF1478de"));
                        break;
                        default:
                            break;
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0:
                        tab.setIcon(R.mipmap.market4242_blue);
                        mTabLayout.setTabTextColors(Color.parseColor("#9f9ea3"),Color.parseColor("#FF1478de"));
                        break;
                    case 1:
                        tab.setIcon(R.mipmap.news4444_blue);
                        mTabLayout.setTabTextColors(Color.parseColor("#9f9ea3"),Color.parseColor("#FF1478de"));
                        break;
                    case 2:
                        tab.setIcon(R.mipmap.about3643_blue);
                        mTabLayout.setTabTextColors(Color.parseColor("#9f9ea3"),Color.parseColor("#FF1478de"));
                        break;
                    default:
                        break;
                }
            }
        });
        initFragment();
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.getTabAt(2).select();
        mTabLayout.getTabAt(1).select();
        mTabLayout.getTabAt(0).select();
    }
}
