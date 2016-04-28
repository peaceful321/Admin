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
 * Created by Ryan Xu on 2015/12/28.
 */
public class GridLayoutFragment extends Fragment {

    View root;
    Button zero, one, two, three, four, five, six, seven, eight, nine, add,
            subtract, queal, delete, clear, divide, multiply, dot;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return root = inflater.inflate(R.layout.grid_layout_fragment, container, false);
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }

    void initView() {
        one = (Button) root.findViewById(R.id.one);
        two = (Button) root.findViewById(R.id.two);
        three = (Button) root.findViewById(R.id.three);
        four = (Button) root.findViewById(R.id.four);
        five = (Button) root.findViewById(R.id.five);
        six = (Button) root.findViewById(R.id.six);
        seven = (Button) root.findViewById(R.id.seven);
        eight = (Button) root.findViewById(R.id.eight);
        nine = (Button) root.findViewById(R.id.nine);
        zero = (Button) root.findViewById(R.id.zero);
        add = (Button) root.findViewById(R.id.add);
        subtract = (Button) root.findViewById(R.id.subtract);
        multiply = (Button) root.findViewById(R.id.multiply);
        divide = (Button) root.findViewById(R.id.divide);
        queal = (Button) root.findViewById(R.id.queal);
        clear = (Button) root.findViewById(R.id.clear);
        delete = (Button) root.findViewById(R.id.delete);
        dot = (Button) root.findViewById(R.id.dot);
    }

    class OnBtnClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.one:
                    break;
                case R.id.two:
                    break;
                case R.id.three:
                    break;
                case R.id.four:
                    break;
                case R.id.five:
                    break;
                case R.id.six:
                    break;
                case R.id.seven:
                    break;
                case R.id.eight:
                    break;
                case R.id.nine:
                    break;
                case R.id.zero:
                    break;
                case R.id.clear:
                    break;
                case R.id.delete:
                    break;
                case R.id.add:
                    break;
                case R.id.subtract:
                    break;
                case R.id.divide:
                    break;
                case R.id.multiply:
                    break;
                case R.id.queal:
                    break;
                case R.id.dot:
                    break;
            }
        }
    }

}
