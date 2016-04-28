package com.android.framework.targets;

import android.app.Fragment;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.android.framework.R;


/**
 * Created by xuhuanchao on 2015/11/2.
 */
public class WidgetFragment extends Fragment {

    private static final String TAG = "com.android.framework.targets.WidgetFragment";
    private static final String PACKAGE_NAME = "com.android.framework.targets.widget.";

    View root = null;
    Resources resources = null;
    private String[] widgetFragments = null;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return root = inflater.inflate(R.layout.widgets_fragment_layout, container, false);
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
        initView();
    }



    private void initData(){
        resources = getResources();
        widgetFragments = resources.getStringArray(R.array.widgets_content);
    }

    private void initView(){
        LinearLayout widgets_container = (LinearLayout) root.findViewById(R.id.widgets_container);
        ListView lv_widgets = new ListView(getActivity());
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.widgets_title, android.R.layout.simple_list_item_1);
        lv_widgets.setAdapter(adapter);
        lv_widgets.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                getFragmentManager().beginTransaction()
                        .addToBackStack(null)
                        .replace(R.id.container, Fragment.instantiate(getActivity(), PACKAGE_NAME + widgetFragments[position]))
                        .commit();
            }
        });
        widgets_container.addView(lv_widgets);
    }

}
