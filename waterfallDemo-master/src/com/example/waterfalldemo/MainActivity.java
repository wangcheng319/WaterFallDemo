package com.example.waterfalldemo;

import java.util.ArrayList;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;

import com.example.waterfalldemo.adapter.WaterfallAdapter;
import com.huewu.pla.lib.MultiColumnListView;
import com.nostra13.universalimageloader.cache.memory.impl.UsingFreqLimitedMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;

public class MainActivity extends Activity {

	private MultiColumnListView waterfallView;// 可以把它当成一个listView

	// 如果不想用下拉刷新这个特性，只是瀑布流，可以用这个：MultiColumnListView 一样的用法

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// 初始化图片加载库
		DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder().cacheOnDisc(true)
				// 图片存本地
				.cacheInMemory(true).displayer(new FadeInBitmapDisplayer(50))
				.bitmapConfig(Bitmap.Config.RGB_565).imageScaleType(ImageScaleType.EXACTLY) // default
				.build();
		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
				getApplicationContext())
				.memoryCache(new UsingFreqLimitedMemoryCache(16 * 1024 * 1024))
				.defaultDisplayImageOptions(defaultOptions).build();
		ImageLoader.getInstance().init(config);

		waterfallView = (MultiColumnListView) findViewById(R.id.list);

		ArrayList<String> imageList = new ArrayList<String>();
		imageList.add("http://testjfmall.hmyd.cn:8101/uploadFile/2015-08-04/d98b6f57-ec1d-4c5b-b929-7be8321a6c83.jpg");
		imageList.add("http://testjfmall.hmyd.cn:8101/uploadFile/2015-08-04/2abd824c-2883-4ce9-beb4-2bd8e1ee0bd2.jpg");
		imageList.add("http://testjfmall.hmyd.cn:8101/uploadFile/2015-08-04/3571b87a-6b56-4205-9058-8d3d1e8d34d1.gif");
		imageList.add("http://testjfmall.hmyd.cn:8101/uploadFile/2015-08-04/65c5e098-7a5d-40f6-854b-e0a80a0d27ae.jpg");
		imageList.add("http://pic8.nipic.com/20100701/5290458_114840036316_2.jpg");
		imageList.add("http://pic1.nipic.com/2008-12-25/2008122510134038_2.jpg");
		imageList.add("http://img3.3lian.com/2013/s1/20/d/57.jpg");
		imageList.add("http://img3.3lian.com/2013/s1/20/d/56.jpg");
		imageList.add("http://img.61gequ.com/allimg/2011-4/201142614314278502.jpg");
		imageList.add("http://pic2.nipic.com/20090424/1468853_230119053_2.jpg");
		imageList.add("http://pic3.nipic.com/20090618/2173387_131809033_2.jpg");
		imageList.add("http://testjfmall.hmyd.cn:8101/uploadFile/2015-08-04/d98b6f57-ec1d-4c5b-b929-7be8321a6c83.jpg");
		imageList.add("http://testjfmall.hmyd.cn:8101/uploadFile/2015-08-04/2abd824c-2883-4ce9-beb4-2bd8e1ee0bd2.jpg");
		imageList.add("http://testjfmall.hmyd.cn:8101/uploadFile/2015-08-04/3571b87a-6b56-4205-9058-8d3d1e8d34d1.gif");
		imageList.add("http://testjfmall.hmyd.cn:8101/uploadFile/2015-08-04/65c5e098-7a5d-40f6-854b-e0a80a0d27ae.jpg");
		imageList.add("http://pic8.nipic.com/20100701/5290458_114840036316_2.jpg");
		imageList.add("http://pic1.nipic.com/2008-12-25/2008122510134038_2.jpg");
		imageList.add("http://img3.3lian.com/2013/s1/20/d/57.jpg");
		imageList.add("http://img3.3lian.com/2013/s1/20/d/56.jpg");
		imageList.add("http://img.61gequ.com/allimg/2011-4/201142614314278502.jpg");
		imageList.add("http://pic2.nipic.com/20090424/1468853_230119053_2.jpg");
		imageList.add("http://pic3.nipic.com/20090618/2173387_131809033_2.jpg");
		imageList.add("http://testjfmall.hmyd.cn:8101/uploadFile/2015-08-04/d98b6f57-ec1d-4c5b-b929-7be8321a6c83.jpg");
		imageList.add("http://testjfmall.hmyd.cn:8101/uploadFile/2015-08-04/2abd824c-2883-4ce9-beb4-2bd8e1ee0bd2.jpg");
		imageList.add("http://testjfmall.hmyd.cn:8101/uploadFile/2015-08-04/3571b87a-6b56-4205-9058-8d3d1e8d34d1.gif");
		imageList.add("http://testjfmall.hmyd.cn:8101/uploadFile/2015-08-04/65c5e098-7a5d-40f6-854b-e0a80a0d27ae.jpg");
		imageList.add("http://pic8.nipic.com/20100701/5290458_114840036316_2.jpg");
		imageList.add("http://pic1.nipic.com/2008-12-25/2008122510134038_2.jpg");
		imageList.add("http://img3.3lian.com/2013/s1/20/d/57.jpg");
		imageList.add("http://img3.3lian.com/2013/s1/20/d/56.jpg");
		imageList.add("http://img.61gequ.com/allimg/2011-4/201142614314278502.jpg");
		imageList.add("http://pic2.nipic.com/20090424/1468853_230119053_2.jpg");
		imageList.add("http://pic3.nipic.com/20090618/2173387_131809033_2.jpg");

		WaterfallAdapter adapter = new WaterfallAdapter(imageList, this);
		waterfallView.setAdapter(adapter);
		// waterfallView.setOnRefreshListener(new OnRefreshListener() {
		// @Override
		// public void onRefresh() {
		// // TODO Auto-generated method stub
		// //下拉刷新要做的事
		//
		// //刷新完成后记得调用这个
		// waterfallView.onRefreshComplete();
		// }
		// });

	}

}
