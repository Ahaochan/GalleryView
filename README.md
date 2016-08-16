# GalleryView

![GalleryView.gif](https://github.com/Ahaochan/GalleryView/blob/master/GalleryView.gif)

通过操作canvas实现的可缩放的recyclerView,可用于漫画app的阅读界面。

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
<ViewGroup ...

	<android.support.v4.view.ViewPager
        android:id="@+id/view_pager"
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_weight="1"/>
		
    <com.ahao.GalleryView.ui.GalleryView
        android:id="@+id/tab_layout"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:textSize="12sp"
        app:textGravity="bottom"
        app:visibleCount="3"
        app:indicatorColor="@color/colorAccent"/>
</ViewGroup>
```

```
GalleryView.setOnTabClickListener(new OnTabClickListener() {
    @Override
        public void OnTabClick(View view, int position) {
			viewPager.setCurrentItem(position);
        }
    });
viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        GalleryView.scrollToTab(position, positionOffset);
        }
    });
```