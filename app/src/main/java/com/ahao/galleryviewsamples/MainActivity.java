package com.ahao.galleryviewsamples;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;

import com.ahao.galleryview.GalleryView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private final static String className = MainActivity.class.getSimpleName();

    private GalleryView galleryView;
    private List<MyData> datas;

    private View emptyView;
    private View settingView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        galleryView = (GalleryView) findViewById(R.id.view_gallery);
        emptyView = findViewById(R.id.view_empty);
        settingView = findViewById(R.id.view_setting);

        initData();
        galleryView.setEmptyView(emptyView);
        galleryView.setAdapter(new MyAdapter<MyData>(this, datas, R.layout.list_item) {
            @Override
            protected void convert(MyViewHolder holder, MyData data) {
                holder.setText(R.id.item_title, data.getTitle());
                holder.setImageResId(R.id.item_image, data.getImageResId());
            }
        });

        galleryView.setOnGestureListener(new GalleryView.OnGestureListener() {
            @Override
            public boolean onScale(ScaleGestureDetector detector) {
                settingView.setVisibility(View.GONE);
                return true;
            }

            @Override
            public boolean onSingleTapConfirmed(MotionEvent e) {
                settingView.setVisibility(settingView.getVisibility()==View.VISIBLE?View.GONE:View.VISIBLE);
                return true;
            }

            @Override
            public boolean onDoubleTap(MotionEvent e) {
                settingView.setVisibility(View.GONE);
                return true;
            }
        });

    }

    /** 初始化数据 */
    private void initData() {
        datas = new ArrayList<MyData>();
        datas.add(new MyData(R.drawable.image1, "标题:"+1));
        datas.add(new MyData(R.drawable.image2, "标题:"+2));
        datas.add(new MyData(R.drawable.image3, "标题:"+3));
        datas.add(new MyData(R.drawable.image4, "标题:"+4));
        datas.add(new MyData(R.drawable.image5, "标题:"+5));
        datas.add(new MyData(R.drawable.image6, "标题:"+6));
        datas.add(new MyData(R.drawable.image7, "标题:"+7));
        datas.add(new MyData(R.drawable.image8, "标题:"+8));
        datas.add(new MyData(R.drawable.image9, "标题:"+9));
    }
}
