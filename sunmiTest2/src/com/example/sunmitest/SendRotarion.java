package com.example.sunmitest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import sunmi.ds.DSKernel;
import sunmi.ds.callback.ISendFilesCallback;
import android.content.Context;
import android.os.Environment;
import android.widget.Toast;

import com.example.sunmitest.bean.DataModel;
import com.example.sunmitest.bean.UPacketFactory;

/**
 * 项目名称：DSC 类描述： 创建人：Abtswiath丶lxy 创建时间：2016/10/18 16:03 修改人：longx
 * 修改时间：2016/10/18 16:03 修改备注：
 */
public class SendRotarion {

	private static SendRotarion mInstance;
	private Context mContext;
	private DSKernel mDSKernel;
	private long taskId_sendImgsText;
	private MainActivity activity;
	private static final String IMGS_ID = "LXY";

	public SendRotarion(Context context, DSKernel mDSKernel) {
		this.mContext = context;
		this.mDSKernel = mDSKernel;
	}

	public static SendRotarion getInstance(Context context, DSKernel mDSKernel) {
		if (mInstance == null) {
			mInstance = new SendRotarion(context, mDSKernel);
		}
		return mInstance;
	}

	public static String getAssetsCacheFile(Context context, String fileName) {
		String path = Environment.getExternalStorageDirectory() + "/test/";
		new File(path).mkdirs();
		String[] s = fileName.split("/");
		if (s.length == 0) {
			return "";
		}
		File cacheFile = new File(path, s[s.length - 1]);
		try {
			InputStream inputStream = context.getAssets().open(fileName);
			try {
				FileOutputStream outputStream = new FileOutputStream(cacheFile);
				try {
					byte[] buf = new byte[1024];
					int len;
					while ((len = inputStream.read(buf)) > 0) {
						outputStream.write(buf, 0, len);
					}
				} finally {
					outputStream.close();
				}
			} finally {
				inputStream.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return cacheFile.getAbsolutePath();
	}

	public void sendRotarion(MainActivity activity) {
		this.activity = activity;
		// GalleryFinal.openGalleryMuti(1, 50, new
		// GalleryFinal.OnHanlderResultCallback() {
		// @Override
		// public void onHanlderSuccess(int reqeustCode, List<PhotoInfo>
		// resultList) {
		// List<String> imgsPath = new ArrayList<>();
		// if (resultList.size() > 0) {
		// imgsPath.clear();
		// for (PhotoInfo p : resultList) {
		// imgsPath.add(p.getPhotoPath());
		// }
		// }
		// }
		//
		// @Override
		// public void onHanlderFailure(int requestCode, String errorMsg) {
		//
		// }
		// });
		try {
			List<String> pathList = new ArrayList<String>();
			String[] paths = mContext.getResources().getAssets()
					.list("custom_img");
			for (String path : paths) {
				pathList.add(getAssetsCacheFile(mContext, "custom_img/" + path));
			}
			sendImgFiles(pathList);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void sendImgFiles(List<String> imgsPath) {

		JSONObject json = new JSONObject();
		try {
			json.put("rotation_time", 2000);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		for (String path : imgsPath) {
			File file = new File(path);
			if (!file.exists()) {
				Toast.makeText(mContext, path + "目录文件不存在", Toast.LENGTH_SHORT)
						.show();
				return;
			}
		}

		taskId_sendImgsText = mDSKernel.sendFiles(DSKernel.getDSDPackageName(),
				json.toString(), imgsPath, new ISendFilesCallback() {
					@Override
					public void onAllSendSuccess(long l) {
						activity.runOnUiThread(new Runnable() {

							@Override
							public void run() {
								showToast("所有发送文件成功");
							}
						});
						showImgs();
						SharedPreferencesUtil.put(mContext, IMGS_ID,
								taskId_sendImgsText);
					}

					@Override
					public void onSendSuccess(final String path,
							final long fileId) {
					}

					@Override
					public void onSendFaile(final int i, final String s) {
						activity.runOnUiThread(new Runnable() {

							@Override
							public void run() {
								showToast("发送失败");
							}
						});
					}

					@Override
					public void onSendFileFaile(String s, int i, String s1) {
						activity.runOnUiThread(new Runnable() {

							@Override
							public void run() {
								showToast("发送文件失败!");
							}
						});
					}

					@Override
					public void onSendProcess(final String s, final long l,
							final long l1) {
					}
				});

	}

	private void showImgs() {
		String json = UPacketFactory.createJson(DataModel.IMAGES, "");
		mDSKernel.sendCMD(DSKernel.getDSDPackageName(), json,
				taskId_sendImgsText, null);
	}

	private void showToast(String msg) {
		Toast.makeText(activity.getApplicationContext(), msg,
				Toast.LENGTH_SHORT).show();
	}

}
