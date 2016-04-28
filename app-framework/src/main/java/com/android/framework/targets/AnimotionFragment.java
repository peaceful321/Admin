package com.android.framework.targets;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

import com.android.framework.R;


public class AnimotionFragment extends Fragment {

    private View animationRoot;
    private ImageView imageOne, imageTwo;

    private ScaleAnimation saOne = new ScaleAnimation(1, 0, 1, 1,
            Animation.RELATIVE_TO_PARENT, 0.5f, Animation.RELATIVE_TO_PARENT, 0.5f);

    private ScaleAnimation saTwo = new ScaleAnimation(0, 1, 1, 1,
            Animation.RELATIVE_TO_PARENT, 0.5f, Animation.RELATIVE_TO_PARENT, 0.5f);


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return animationRoot = inflater.inflate(R.layout.animotion_fragment_layout, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        animationRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                ivOne.startAnimation(saOne);
                if (imageOne.getVisibility() == View.VISIBLE){
                    imageOne.startAnimation(saOne);
                } else {
                    imageTwo.startAnimation(saOne);
                }
            }
        });
    }


    private void initView(){
        imageOne = (ImageView) animationRoot.findViewById(R.id.imageOne);
        imageTwo = (ImageView) animationRoot.findViewById(R.id.imageTwo);
        showOneImg();
        saOne.setDuration(500);
        saTwo.setDuration(500);

        saOne.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if (imageOne.getVisibility() == View.VISIBLE){
                    imageOne.setAnimation(null);
                    showTwoImg();
                    imageTwo.startAnimation(saTwo);
                } else {
                    imageTwo.setAnimation(null);
                    showOneImg();
                    imageOne.startAnimation(saTwo);
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    private void showOneImg(){
        imageOne.setVisibility(View.VISIBLE);
        imageTwo.setVisibility(View.INVISIBLE);
    }

    private void showTwoImg(){
        imageOne.setVisibility(View.INVISIBLE);
        imageTwo.setVisibility(View.VISIBLE);
    }
}
