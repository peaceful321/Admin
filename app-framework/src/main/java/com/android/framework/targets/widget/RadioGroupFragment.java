package com.android.framework.targets.widget;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.android.framework.R;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ryan Xu on 2016/4/20.
 */
public class RadioGroupFragment extends Fragment {

    private View root;
    private RadioGroup rgGender;
    private Button sureBtn;
    private Map<String, String> gender = null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return root = inflater.inflate(R.layout.radiogroup_fragment_layout, container, false);
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initListener();
    }


    void initView() {
        gender = new HashMap<String, String>();
        rgGender = (RadioGroup) root.findViewById(R.id.rg_gender);
        sureBtn = (Button) root.findViewById(R.id.sureBtn);
    }

    void initListener() {

        rgGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = (RadioButton) root.findViewById(checkedId);
                gender.put("gender", String.valueOf(rb.getText()));
            }
        });

        sureBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "你的性别是：" + gender.get("gender"), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
