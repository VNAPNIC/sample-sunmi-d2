package com.example.sunmitest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import sunmi.ds.DSKernel;
import sunmi.ds.callback.IConnectionCallback;
import sunmi.ds.callback.ISendCallback;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.example.sunmitest.bean.DemoDataModel;

public class MainActivity extends Activity {

	DSKernel mDSKernel;// SDK核心类
	DemoDataModel mDataModel = null;
	String pathSmall = Environment.getExternalStorageDirectory().getPath() + "/small.png";
	private static final String SHOW_IMG_LIST_ID = "SHOW_IMG_LIST_ID";
	long taskId;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mDataModel = DemoDataModel.getInstance();
		mDSKernel = DSKernel.newInstance();
		mDSKernel.init(this, mConnCallback);
		findViewById(R.id.btn1).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				try {
					List<String> pathList = new ArrayList<String>();
					String[] paths = getResources().getAssets().list("custom_img");
					for (String path : paths) {
						pathList.add(SendRotarion.getAssetsCacheFile(MainActivity.this, "custom_img/" + path));
					}
					SunMiUtil.sunMiAdvertising(mDSKernel, pathList);
				} catch (Exception e) {
				}
			}
		});
		findViewById(R.id.btn2).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// ItemBean mItemBean1 = new ItemBean();
				// mItemBean1.setParam1("测试商品");
				// mItemBean1.setParam2("10.00");
				// mItemBean1.setParam3("1");
				// mDataModel.addGoods(mItemBean1);
				// String json = mDataModel.rebuildData();
				// json = UPacketFactory.createJson(DataModel.SHOW_IMG_LIST,
				// json);
				// sendImg2DSD(SHOW_IMG_LIST_ID, json, pathSmall);
				try {

					// List<String> pathList = new ArrayList<String>();
					// String[] paths = getResources().getAssets().list(
					// "custom_img");
					// for (String path : paths) {
					// pathList.add(SendRotarion.getAssetsCacheFile(
					// MainActivity.this, "custom_img/" + path));
					// }
					//
					SunMiOrderBean sunMiOrderBean = new SunMiOrderBean();
					// List<Shop> shopList = new ArrayList<Shop>();
					// for (int i = 0; i < 5; i++) {
					// Shop shop = new Shop();
					// shop.setDiscountPrice("1");
					// shop.setItemName("商品" + i);
					// shop.setNumber(i);
					// shopList.add(shop);
					// }
					// sunMiOrderBean.setOrderList(shopList);

					new Thread() {
						public void run() {

							SunMiOrderBean sunMiOrderBean = new SunMiOrderBean();
							String path = savePicIdToSD(MainActivity.this, R.drawable.ic_launcher, "ic_launcher.jpg");
							SunMiUtil.sunMiAdvertisingAndOrder(mDSKernel, path, sunMiOrderBean);
						};
					}.start();
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		});
		findViewById(R.id.btn3).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				new Thread() {
					public void run() {

						SunMiOrderBean sunMiOrderBean = new SunMiOrderBean();
						String path = savePicIdToSD(MainActivity.this, R.drawable.a2, "a2.png");
						SunMiUtil.sunMiAdvertisingAndOrder(mDSKernel, path, sunMiOrderBean);
					};
				}.start();
			}
		});

	}

	/**
	 * 文件缓存路径
	 */
	public static String cachePath = Environment.getExternalStorageDirectory() + "/cashierdesk/image/image/";

	/**
	 * 保存资源id文件到本地sd卡
	 * 
	 * @param context
	 * @param id
	 * @param fileName
	 */
	public static String savePicIdToSD(Context context, Integer id, String fileName) {
		File cacheFile = new File(cachePath, fileName);
		try {
			new File(cachePath).mkdirs();
			InputStream welcomeInput = context.getResources().openRawResource(id);
			try {
				FileOutputStream outputStream = new FileOutputStream(cacheFile);
				try {
					byte[] buf = new byte[1024];
					int len;
					while ((len = welcomeInput.read(buf)) > 0) {
						outputStream.write(buf, 0, len);
					}
				} finally {
					outputStream.close();
				}
			} finally {
				welcomeInput.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return cacheFile.getPath();
	}

	/**
	 * 显示图和列表
	 *
	 * @param fileId
	 */
	private void showImgListCMD(long fileId, String json) {

		mDSKernel.sendCMD(DSKernel.getDSDPackageName(), json, fileId, null);
	}

	/**
	 * 向副屏发送数据
	 */
	private void sendImg2DSD(String key, final String json, String path) {

		// taskId = SharedPreferencesUtil.getLong(this, key);
		// if (taskId != -1L) {
		// showImgListCMD(taskId, json);
		// return;
		// }
		//
		File file2 = new File(path);
		if (!file2.exists()) {
			Toast.makeText(getApplicationContext(), "文件不存在", Toast.LENGTH_SHORT).show();
			return;
		}
		taskId = mDSKernel.sendFile(DSKernel.getDSDPackageName(), path, new ISendCallback() {

			@Override
			public void onSendFail(int arg0, String arg1) {
			}

			@Override
			public void onSendProcess(long arg0, long arg1) {
				// TODO Auto-generated method stub
			}

			@Override
			public void onSendSuccess(long arg0) {
				SharedPreferencesUtil.put(getApplicationContext(), SHOW_IMG_LIST_ID, taskId);
				showImgListCMD(taskId, json);
			}

		});
	}

	IConnectionCallback mConnCallback = new IConnectionCallback() {// SDK链接状态回调
		@Override
		public void onDisConnect() {
		}

		@Override
		public void onConnected(final ConnState state) {
			runOnUiThread(new Runnable() {
				@Override
				public void run() {
					switch (state) {
					case AIDL_CONN:
						// 与本地service的连接畅通
						break;
					case VICE_SERVICE_CONN:
						// 与副屏service连接畅通
						break;
					case VICE_APP_CONN:
						// 与副屏app连接畅通
						break;

					default:
						break;
					}
					System.err.println(state);
				}
			});
		}
	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
