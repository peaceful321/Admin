package com.android.framework.targets.widget;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.android.framework.R;

/**
 * Created by xuhuanchao on 2015/11/3.
 */
public class ButtonFragment extends Fragment {

    private View root;
    private Button pressedChangeBtn;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return root = inflater.inflate(R.layout.button_fragment_layout, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }

    void initView() {
        pressedChangeBtn = (Button) root.findViewById(R.id.pressedChangeBtn);
    }



}
