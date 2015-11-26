package www.wangyang.androidsupportdemo;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.SparseArray;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by pc on 2015/11/25.
 */
public class TestViewPagerAdapter extends FragmentPagerAdapter {

    private Context context;
    private List<String> datalList;

    private SparseArray<Fragment> fragmentSparseArray = new SparseArray<Fragment>();

    public TestViewPagerAdapter(FragmentManager fm, Context context, List<String> datalList) {
        super(fm);
        this.context = context;
        this.datalList = datalList;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment tempFragment = fragmentSparseArray.get(position);
        if (null == tempFragment) {
            Bundle bundle = new Bundle();
            bundle.putString("text", datalList.get(position));
            tempFragment = TestFragment.getInstance(bundle);
            fragmentSparseArray.put(position, tempFragment);
        }
        return tempFragment;
    }

    @Override
    public int getCount() {
        return datalList.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        return super.instantiateItem(container, position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return datalList.get(position);
    }
}
