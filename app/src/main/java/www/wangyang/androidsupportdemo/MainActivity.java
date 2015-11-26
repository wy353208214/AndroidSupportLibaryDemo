package www.wangyang.androidsupportdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    //可浮动的bar
    private Snackbar snackbar;

    //可伸缩的toolbar，一般配合AppbarLayout + toolbar使用，一般使用了之后，toolbar的title就不起作用了
    private CollapsingToolbarLayout collapsingToolbarLayout;
    //谷歌开放的tab indicator，有点像PagerSlipTab，配合viewpager
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //设置顶部的Toolbar代替原来的Actionbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //打开Home按钮
//        getSupportActionBar().setDisplayShowHomeEnabled(true);
//        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
//        设置Logo
//        toolbar.setLogo(R.mipmap.ic_launcher);
//        toolbar.setNavigationIcon(android.R.drawable.ic_dialog_dialer);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        viewPager = (ViewPager) findViewById(R.id.vp);
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        //设置收缩起来的字体颜色
        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.GREEN);
        //设置折叠起来的颜色
        collapsingToolbarLayout.setExpandedTitleColor(Color.RED);

        //设置tab的数量
        TestViewPagerAdapter pagerAdapter = new TestViewPagerAdapter(getSupportFragmentManager(), getApplicationContext(),
                Arrays.asList(new String[]{"北京", "上海", "广州", "深圳", "武汉", "成都", "南京"}));
        viewPager.setAdapter(pagerAdapter);
        //TabLayout绑定viewpager，一定要先设置adapter再调用
        tabLayout.setupWithViewPager(viewPager);

        findViewById(R.id.fbt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (snackbar != null && snackbar.isShown()) {
                    snackbar.dismiss();
                    return;
                }
                snackbar = Snackbar.make(v, "设置", Snackbar.LENGTH_LONG)
                        .setAction("cancel", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //这里的单击事件代表点击消除Action后的响应事件

                            }
                        });
                snackbar.show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
            default:
        }
        return super.onOptionsItemSelected(item);
    }
}
