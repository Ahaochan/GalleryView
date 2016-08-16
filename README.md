# GalleryView

![GalleryView.gif](https://github.com/Ahaochan/GalleryView/blob/master/GalleryView.gif)

通过操作canvas实现的可缩放(Zoomable)的recyclerView,可用于漫画app的阅读界面。

支持：
- 多指缩放
- 双击缩放
- 数据为空时显示emptyView
- 开放单击的接口

缺陷:
- 不能按中心缩放
- 放大后滑动距离也变大

# build
```
git clone https://github.com/Ahaochan/GalleryView
cd GalleryView
./gradlew build
```

## Maven
```
<dependency>
  <groupId>com.ahaochan</groupId>
  <artifactId>GalleryView</artifactId>
  <version>0.0.1</version>
  <type>pom</type>
</dependency>
```
## Gradle
```
compile 'com.ahaochan:GalleryView:0.0.1'
```
## Ivy
```
<dependency org='com.ahaochan' name='GalleryView' rev='0.0.1'>
  <artifact name='$AID' ext='pom'></artifact>
</dependency>
```

# use
```
<FrameLayout >

    <com.ahao.galleryview.GalleryView
        android:id="@+id/view_gallery"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:minScaleFactor="1.0"
        app:maxScaleFactor="4.0"
        app:autoScaleTime="5"
        >
    </com.ahao.galleryview.GalleryView>

    <include layout="@layout/view_empty"/>
    <include layout="@layout/view_setting"/>
</FrameLayout>
```
```
GalleryView galleryView = (GalleryView) findViewById(R.id.view_gallery);
View emptyView = findViewById(R.id.view_empty);
View settingView = findViewById(R.id.view_setting);

galleryView.setEmptyView(emptyView);
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
```