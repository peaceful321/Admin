package com.android.framework.targets.widget;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.android.framework.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ryan Xu on 2016/4/20.
 */
public class CheckBoxFragment extends Fragment {

    private static final String TAG = "CheckBoxFragment";

    private View root;
    private CheckBox basketBall, footBall, pingpangBall;
    private Button sureBtn;
    private List<String> list = null;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return root = inflater.inflate(R.layout.checkbox_fragment_layout, container, false);
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initListener();
    }


    void initView() {
        list = new ArrayList<String>();
        sureBtn = (Button) root.findViewById(R.id.sureBtn);
        basketBall = (CheckBox) root.findViewById(R.id.basketBall);
        footBall = (CheckBox) root.findViewById(R.id.footBall);
        pingpangBall = (CheckBox) root.findViewById(R.id.pingpangBall);
    }

    void initListener() {
        sureBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuffer sb = new StringBuffer("");
                for (String s : list) {
                    Log.e(TAG, s);
                    if ("".equals(sb.toString())) {
                        sb.append(s);
                    } else {
                        sb.append("、" + s);
                    }
                }
                Toast.makeText(getActivity(), "你选择的兴趣爱好是：" + sb.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        basketBall.setOnCheckedChangeListener(new OnCheckedChangedListener());
        footBall.setOnCheckedChangeListener(new OnCheckedChangedListener());
        pingpangBall.setOnCheckedChangeListener(new OnCheckedChangedListener());
    }

    class OnCheckedChangedListener implements CompoundButton.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                list.add(buttonView.getText().toString());
            } else {
                list.remove(buttonView.getText().toString());
            }
        }
    }
}
