package com.example.sunmitest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.os.Environment;

public class DownloadUtil {

	/**
	 * 文件缓存路径
	 */
	private static String cachePath = Environment.getExternalStorageDirectory()
			+ "/cashierdesk/image/image/";

	/**
	 * 将网络图片缓存到本地
	 * 
	 * @param url
	 */
	public static List<String> IamgeCache(final List<String> list) {
		List<String> pathList = new ArrayList<String>();
		for (String url : list) {
			if (!url.startsWith("http")) {
				// url= Constants.ImageURL +
				// CashierDeskApp.cdApp.merchant.getCodeName() + "/" +
				// url;
			}

			Bitmap bitmap = null;
			FileOutputStream fos = null;
			try {
				URL logoUrl = new URL(url);
				HttpURLConnection connection = (HttpURLConnection) logoUrl
						.openConnection();
				connection.setConnectTimeout(6000);
				connection.setDoInput(true);
				connection.setUseCaches(false);
				InputStream is = connection.getInputStream();
				bitmap = BitmapFactory.decodeStream(is);
				if (bitmap == null) {
					continue;
				}
				String[] str = url.split("/");
				File file = new File(cachePath + str[str.length - 1]);
				if (!file.exists()) {
					file.createNewFile();
				} else {
					continue;
				}
				fos = new FileOutputStream(file);
				bitmap.compress(CompressFormat.JPEG, 100, fos);
				fos.flush();
				pathList.add(file.getPath());
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (fos != null) {
					try {
						fos.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (bitmap != null) {
					bitmap.recycle();
					bitmap = null;
				}
			}

		}
		return pathList;
	}
}
