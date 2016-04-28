package com.android.framework;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.android.framework.adapter.TargetItemAdapter;
import com.android.framework.model.TargetItem;

import java.util.ArrayList;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private static final String TAG = "MainActivityFragment";
    View root = null;

    private List<TargetItem> targetList = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return root = inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
        initView();
    }

    void initData(){
        targetList = new ArrayList<TargetItem>();
        //穆客
        targetList.add(new TargetItem(R.drawable.important, "AsyncTask Load", "com.android.framework.targets.AsnyncTaskFragment"));
        targetList.add(new TargetItem(R.drawable.important, "Service断点续传下载", "com.android.framework.targets.ServiceFragment"));
        targetList.add(new TargetItem(R.drawable.important, "ListView分页查询", "com.android.framework.targets.ListViewPaging"));

        //2014-04-06
        targetList.add(new TargetItem(R.drawable.important, "卫星菜单-自定义控件", "com.android.framework.targets.ArcMenuFragment"));
        targetList.add(new TargetItem(R.drawable.important, "Android 万能适配器", "com.android.framework.targets.OmnipotentAdapterFragment"));
        targetList.add(new TargetItem(R.drawable.important, "Android ViewPager", "com.android.framework.targets.ViewPagerFragment"));
        targetList.add(new TargetItem(R.drawable.important, "Android 动画", "com.android.framework.targets.AnimationFragment"));

        //流媒体：音频、视频、图片
        targetList.add(new TargetItem(R.drawable.camera, "android Media Framework", "com.android.framework.targets.MediaFragment"));
        targetList.add(new TargetItem(R.drawable.important, "Android 图像处理", "com.android.framework.targets.PictureHandleFragment"));

        //中级: 异步处理、拍照摄像、画图、DB、网络
        targetList.add(new TargetItem(R.drawable.replay, "android SQLite", "com.android.framework.targets.SQLiteFragment"));
        targetList.add(new TargetItem(R.drawable.refresh, "android Handler", "com.android.framework.targets.HandlerFragment"));
        targetList.add(new TargetItem(R.drawable.camera, "android Paint & Canvas", "com.android.framework.targets.DrawFragment"));
        targetList.add(new TargetItem(R.drawable.important, "android Animotion", "com.android.framework.targets.AnimotionFragment"));
        targetList.add(new TargetItem(R.drawable.camera, "android Camera", "com.android.framework.targets.CameraFragment"));
        targetList.add(new TargetItem(R.drawable.camera, "android SurfaceView", "com.android.framework.targets.SurfaceViewFragment"));
        targetList.add(new TargetItem(R.drawable.camera, "android HttpClient", "com.android.framework.targets.HttpClientFragment"));
        targetList.add(new TargetItem(R.drawable.camera, "android Camera Widget", "com.android.framework.targets.CameraWidget"));

        //基础部分：四大组件、Intent、UI、布局+常用控件属性、Preference
        targetList.add(new TargetItem(R.drawable.all_widget, "android all widgets", "com.android.framework.targets.WidgetFragment"));
        targetList.add(new TargetItem(R.drawable.camera, "android Intent", "com.android.framework.targets.IntentFragment"));
        targetList.add(new TargetItem(R.drawable.camera, "android BroadcastReceiver", "com.android.framework.targets.BroadcastReceiverSimpleDemo"));
        targetList.add(new TargetItem(R.drawable.camera, "android Popup Window", "com.android.framework.targets.PopupWindowFragment"));
        targetList.add(new TargetItem(R.drawable.camera, "android DrawerLayout", "com.android.framework.targets.DrawerLayoutFragment"));
        targetList.add(new TargetItem(R.drawable.camera, "android Timer+TimerTask", "com.android.framework.targets.TimerFragment"));
        targetList.add(new TargetItem(R.drawable.camera, "android ActionBar", "com.android.framework.targets.ActionBarFragment"));
        targetList.add(new TargetItem(R.drawable.camera, "android Preference", "com.android.framework.targets.PreFerenceFragment"));

    }

    void initView(){
        RelativeLayout layout = (RelativeLayout) root.findViewById(R.id.target_item);
        ListView targetItems = new ListView(getActivity());
        TargetItemAdapter targetItemAdapter = new TargetItemAdapter(getActivity(), targetList);
        targetItemAdapter.setOnTargetClickListener(new TargetItemAdapter.OnTargetClickListener() {
            @Override
            public void onClick(TargetItem item) {
                clickedTarget(item);
            }
        });
        targetItems.setAdapter(targetItemAdapter);
        layout.addView(targetItems);
    }

    /**
     * 点击每一目标项，触发该事件
     * @param item
     */
    private void clickedTarget(TargetItem item){
        getFragmentManager().beginTransaction()
                .addToBackStack(TAG)
                .replace(R.id.container, Fragment.instantiate(getActivity(), item.getTargetFragment()))
                .commit();
    }

}

