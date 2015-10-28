package com.example.waterfalldemo.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.waterfalldemo.R;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageLoadingListener;

public class WaterfallAdapter extends BaseAdapter {

	ArrayList<String> list;
	Context context;
	private Drawable drawable;

	public WaterfallAdapter(ArrayList<String> list, Context context) {
		this.list = list;
		this.context = context;
		drawable = context.getResources().getDrawable(R.drawable.load_default);
	}

	@Override
	public int getCount() {
		return list != null ? list.size() : 0;
	}

	@Override
	public Object getItem(int arg0) {
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		return 0;
	}

	@Override
	public View getView(final int position, View view, ViewGroup group) {
		final Holder holder;
		// 得到View
		if (view == null) {
			holder = new Holder();
			LayoutInflater inflater = LayoutInflater.from(context);
			view = inflater.inflate(R.layout.image_item, null);
			holder.ivIcon = (ImageView) view.findViewById(R.id.row_icon);
			holder.pbLoad = (ProgressBar) view.findViewById(R.id.pb_load);

			view.setTag(holder);
		} else {
			holder = (Holder) view.getTag();
		}

		String url = list.get(position);
		ImageLoader.getInstance().displayImage(url, holder.ivIcon, new ImageLoadingListener() {
			@Override
			public void onLoadingStarted(String imageUri, View view) {

				// 这儿初先初始化出来image所占的位置的大小，先把瀑布流固定住，这样瀑布流就不会因为图片加载出来后大小变化了
				// LayoutParams lp = (LayoutParams)
				// holder.ivIcon.getLayoutParams();
				// 多屏幕适配
				// int dWidth = 480;
				// int dHeight = 800;
				// float wscale = dWidth / 480.0f;
				// float hscale = dHeight / 800.0f;
				// lp.height = (int) (yourImageHeight * hscale);
				// lp.width = (int) (yourImageWidth * wscale);
				// holder.ivIcon.setLayoutParams(lp);

				holder.ivIcon.setImageDrawable(drawable);
				holder.pbLoad.setVisibility(View.VISIBLE);
			}

			@Override
			public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
				String message = null;
				switch (failReason.getType()) {
				case IO_ERROR:
					message = "Input/Output error";
					break;
				case DECODING_ERROR:
					message = "can not be decoding";
					break;
				case NETWORK_DENIED:
					message = "Downloads are denied";
					break;
				case OUT_OF_MEMORY:
					message = "内存不足";
					Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
					break;
				case UNKNOWN:
					message = "Unknown error";
					Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
					break;
				}
				holder.pbLoad.setVisibility(View.GONE);
			}

			@Override
			public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
				holder.pbLoad.setVisibility(View.GONE);
			}

			@Override
			public void onLoadingCancelled(String paramString, View paramView) {
			}
		});

		holder.ivIcon.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				Log.i("TAG", "image click");
			}
		});

		return view;
	}

}

class Holder {
	public ImageView ivIcon;
	public ProgressBar pbLoad;
}