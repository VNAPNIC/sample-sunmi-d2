package com.example.sunmitest;

import java.io.File;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import sunmi.ds.DSKernel;
import sunmi.ds.callback.ISendCallback;
import sunmi.ds.callback.ISendFilesCallback;

import com.example.sunmitest.bean.DataModel;
import com.example.sunmitest.bean.DemoDataModel;
import com.example.sunmitest.bean.ItemBean;
import com.example.sunmitest.bean.UPacketFactory;

/**
 * 商米工具类，客显+打印
 * 
 * @author Administrator
 *
 */
public class SunMiUtil {

	/**
	 * 商米显示广告
	 * 
	 * @param mDSKernel
	 *            商米客显初始化对象
	 * @param pathList
	 *            文件本地路径
	 */
	public static void sunMiAdvertising(DSKernel mDSKernel,
			List<String> pathList) {
		sendImgFiles(mDSKernel, pathList);
	}

	/**
	 * 商米显示广告和点单详情
	 * 
	 * @param mDSKernel
	 *            商米客显初始化对象
	 * @param path
	 *            本地图片路径
	 * @param sunMiOrderBean
	 *            商品客显显示商品详情类
	 */
	public static void sunMiAdvertisingAndOrder(DSKernel mDSKernel,
			String path, SunMiOrderBean sunMiOrderBean) {
		List<Shop> shopList = sunMiOrderBean.getOrderList();
		DemoDataModel mDataModel = DemoDataModel.getInstance();
		// 总额
		double sumPrice = 0;
		// 实收
		double realPrice = 0;
		// 总数
		int number = 0;
		if (shopList != null) {
			for (Shop shop : shopList) {
				ItemBean mItemBean1 = new ItemBean();
				mItemBean1.setParam1(shop.getItemName());
				mItemBean1.setParam2(shop.getDiscountPrice());
				mItemBean1.setParam3(shop.getNumber() + "");
				mDataModel.addGoods(mItemBean1);
				sumPrice += keepTwoSecimalStr(Double.parseDouble(shop
						.getDiscountPrice()) * shop.getNumber());
				number += shop.getNumber();
			}
		}
		realPrice = keepTwoSecimalStr(sumPrice
				- sunMiOrderBean.getPreferential());
		sunMiOrderBean.setCollection(sumPrice);
		sunMiOrderBean.setRealPrice(realPrice);
		sunMiOrderBean.setNumber(number);
		String json = mDataModel.rebuildData(sunMiOrderBean);
		sendFile(mDSKernel, path, null, DataModel.SHOW_IMG_WELCOME);
	}

	/**
	 * 四舍五入保留两位小数点(整数在后面补.00)
	 * 
	 * @param numberStr
	 *            需要处理的数
	 * @return
	 */
	private static double keepTwoSecimalStr(double numberStr) {
		DecimalFormat format = new DecimalFormat("0.00");
		return Double.parseDouble(format.format(new BigDecimal(numberStr)));
	}

	/**
	 * 发送图片集合 生成缓存id
	 * 
	 * @param mDSKernel
	 * @param imgsPath
	 */
	private static void sendImgFiles(final DSKernel mDSKernel,
			List<String> imgsPath) {

		JSONObject json = new JSONObject();
		try {
			json.put("rotation_time", 5000);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		for (String path : imgsPath) {
			File file = new File(path);
			if (!file.exists()) {
				return;
			}
		}

		mDSKernel.sendFiles(DSKernel.getDSDPackageName(), json.toString(),
				imgsPath, new ISendFilesCallback() {
					@Override
					public void onAllSendSuccess(long l) {
						showImgs(mDSKernel, l);
					}

					@Override
					public void onSendSuccess(final String path,
							final long fileId) {
					}

					@Override
					public void onSendFaile(final int i, final String s) {
					}

					@Override
					public void onSendFileFaile(String s, int i, String s1) {
					}

					@Override
					public void onSendProcess(final String s, final long l,
							final long l1) {
					}
				});

	}

	/**
	 * 显示幻灯片
	 * 
	 * @param mDSKernel
	 * @param taskId_sendImgsText
	 */
	private static void showImgs(DSKernel mDSKernel, long taskId_sendImgsText) {
		String json = UPacketFactory.createJson(DataModel.IMAGES, "");
		mDSKernel.sendCMD(DSKernel.getDSDPackageName(), json,
				taskId_sendImgsText, null);
	}

	/**
	 * 发送单张图片获取缓存id，显示单张图片和复杂布局
	 * 
	 * @param mDSKernel
	 * @param path
	 * @param json
	 * @param dataModel
	 *            =IMAGE json可以为null 只显示一张图片，如果是SHOW_IMG_LIST 必须传json 订单详情数据
	 */
	private static void sendFile(final DSKernel mDSKernel, String path,
			final String json, final DataModel dataModel) {

		mDSKernel.sendFile(DSKernel.getDSDPackageName(), path,
				new ISendCallback() {

					@Override
					public void onSendFail(int arg0, String arg1) {
					}

					@Override
					public void onSendProcess(long arg0, long arg1) {
					}

					@Override
					public void onSendSuccess(long arg0) {
						showImgListCMD(mDSKernel, arg0, json, dataModel);
					}

				});
	}

	/**
	 * 显示图和列表
	 *
	 * @param fileId
	 *            图片缓存id
	 */
	private static void showImgListCMD(DSKernel mDSKernel, long fileId,
			String json, DataModel dataModel) {
		json = UPacketFactory.createJson(dataModel, json);
		mDSKernel.sendCMD(DSKernel.getDSDPackageName(), json, fileId, null);
	}
}
