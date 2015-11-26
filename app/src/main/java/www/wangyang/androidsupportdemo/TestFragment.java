package www.wangyang.androidsupportdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pc on 2015/11/25.
 */
public class TestFragment extends Fragment {

    private View contentView;
    private RecyclerView recyclerView;
    private List<String> datas = new ArrayList<String>();

    public static TestFragment getInstance(Bundle bundle) {
        TestFragment testFragment = new TestFragment();
        testFragment.setArguments(bundle);
        return testFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        contentView = inflater.inflate(R.layout.fragment_test, container, false);
        recyclerView = (RecyclerView) contentView.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration());
        MyRecyclerViewAdapter viewAdapter = new MyRecyclerViewAdapter(datas, getContext());
        recyclerView.setAdapter(viewAdapter);

        String string = getArguments().getString("text");
        for (int i = 0; i < 30; i++) {
            datas.add(string + "-" + i);
        }
        viewAdapter.notifyDataSetChanged();

        return contentView;
    }


}
