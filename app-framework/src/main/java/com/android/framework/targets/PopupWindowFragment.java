package com.android.framework.targets;

import android.app.Fragment;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.android.framework.R;
import com.android.framework.adapter.ImageAdapter;


/**
 * Created by xuhuanchao on 2015/11/18.
 */
public class PopupWindowFragment extends Fragment {

    private View root;
    private int[] resArray = null;
    private String[] title = null;
    private PopupWindow popupWindow = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return root = inflater.inflate(R.layout.popup_window_fragment_layout, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
        initView();
    }

    void initData(){
        title = new String[]{"添加", "信息", "搜索", "查看"};
        resArray = new int[]{
                R.drawable.add,
                R.drawable.unread,
                R.drawable.search,
                R.drawable.content_read
        };
    }

    void initView(){
        LinearLayout layout = (LinearLayout) root.findViewById(R.id.layout);
        layout.addView(createBtn());
    }

    Button createBtn(){
        Button btn = new Button(getActivity());
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        btn.setText("show PopupWindow");
        btn.setTextSize(25);
        btn.setTextColor(Color.BLUE);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupWindow();
            }
        });
        return btn;
    }

    void showPopupWindow(){
        if (popupWindow != null) {
            if (popupWindow.isShowing()) {
                //关闭弹出窗口
                popupWindow.dismiss();
            }
            else {
                //在指定位置弹出窗口
                popupWindow.showAtLocation(root.findViewById(R.id.hello), Gravity.CENTER, 0, 300);
            }
        } else {
            LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.menu_popup_window, null);
            GridView gridView = (GridView) view.findViewById(R.id.menuGridChange);
            gridView.setAdapter(new ImageAdapter(getActivity(), resArray, title));
            popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            popupWindow.showAtLocation(root.findViewById(R.id.hello), Gravity.CENTER, 0, 300);
        }
    }

}
