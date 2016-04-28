package com.android.framework.targets;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.android.framework.R;
import com.android.framework.dao.MemberDao;

import java.util.List;

/**
 * Created by xuhuanchao on 2015/11/15.
 */
public class SQLiteFragment extends Fragment {

    View root;
    Handler mHandler;
    Button createTableBtn, addDataBtn, deleteDataBtn, modifyDataBtn, searchDataBtn;
    MemberDao dao = null;
    List<Object> data = null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return root = inflater.inflate(R.layout.sqlite_fragment_layout, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        bindClickListener();
    }

    void initView(){
        createTableBtn = (Button) root.findViewById(R.id.createTableBtn);
        addDataBtn = (Button) root.findViewById(R.id.addDataBtn);
        deleteDataBtn = (Button) root.findViewById(R.id.deleteDataBtn);
        modifyDataBtn = (Button) root.findViewById(R.id.modifyDataBtn);
        searchDataBtn = (Button) root.findViewById(R.id.searchDataBtn);
        mHandler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {


                return true;
            }
        });
    }

    /**
     * 绑定监听器
     */
    void bindClickListener(){
        createTableBtn.setOnClickListener(new OnBtnClickListener());
        addDataBtn.setOnClickListener(new OnBtnClickListener());
        deleteDataBtn.setOnClickListener(new OnBtnClickListener());
        modifyDataBtn.setOnClickListener(new OnBtnClickListener());
        searchDataBtn.setOnClickListener(new OnBtnClickListener());
    }

    /**
     * 内部类，实现按钮点击监听
     */
    class OnBtnClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.createTableBtn:
                    createTable();
                    break;
                case R.id.addDataBtn:
                    break;
                case R.id.deleteDataBtn:
                    break;
                case R.id.modifyDataBtn:
                    break;
                case R.id.searchDataBtn:
                    break;
            }
        }
    }



    void createTable(){
        dao = new MemberDao(getActivity());
        Toast.makeText(getActivity(), "ok", Toast.LENGTH_SHORT).show();
    }

    void addData(){

    }

    void deleteData(){

    }

    void modifyData(){

    }

    void searchDataBtn(){

    }

}
