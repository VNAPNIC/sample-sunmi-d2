package com.example.sunmitest.bean;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;

import com.example.sunmitest.App;
import com.example.sunmitest.R;
import com.example.sunmitest.SunMiOrderBean;
import com.google.gson.Gson;

/**
 * Created by 徐荣 on 2016/9/20.
 */
public class DemoDataModel {
	private Context mContext;
	// head
	HeadBean mHeadBean = new HeadBean();
	// lists
	List<ItemBean> items = new ArrayList<>();
	// statement
	List<KVP> smBeens = new ArrayList<>();

	private static DemoDataModel mDataModel = null;

	private DemoDataModel() {
		this.mContext = App.app;
	}

	public static DemoDataModel getInstance() {
		if (mDataModel == null) {
			mDataModel = new DemoDataModel();
		}
		return mDataModel;
	}

	/**
	 * 设置表头
	 *
	 * @return
	 */
	public HeadBean setHeadBean() {
		mHeadBean.setParam1("商品");
		mHeadBean.setParam2("单价");
		mHeadBean.setParam3("数量");
		return mHeadBean;
	}

	/**
	 * 添加商品
	 *
	 * @param mItemBean
	 * @return
	 */
	public void addGoods(ItemBean mItemBean) {
		items.add(mItemBean);
	}


	/**
	 * 设置清算
	 */
	public List<KVP> setSmBeen(SunMiOrderBean sunMiOrderBean) {
		smBeens.clear();
		// 总价
		KVP mKVP = new KVP();
		mKVP.setName(mContext.getString(R.string.main_total_price));
		mKVP.setValue("￥" + sunMiOrderBean.getCollection());
		smBeens.add(mKVP);

		// 数量
		KVP mKVP0 = new KVP();
		mKVP0.setName(mContext.getString(R.string.main_num));
		mKVP0.setValue("" + sunMiOrderBean.getNumber());
		smBeens.add(mKVP0);

		// 优惠
		KVP mKVP1 = new KVP();
		mKVP1.setName(mContext.getString(R.string.main_favorable_money));
		mKVP1.setValue("￥" + sunMiOrderBean.getPreferential());
		smBeens.add(mKVP1);

		// 收款
		KVP mKVP2 = new KVP();
		mKVP2.setName(mContext.getString(R.string.main_collect));
		mKVP2.setValue("￥" + sunMiOrderBean.getRealPrice());
		smBeens.add(mKVP2);

		return smBeens;
	}

	/**
	 * 重构json数据
	 *
	 * @return
	 */
	public String rebuildData(SunMiOrderBean sunMiOrderBean) {
		ListingBean mListingBean = new ListingBean();
		// title
		mListingBean.setTitle(mContext.getString(R.string.main_sunmilk));
		mListingBean.setHead(setHeadBean());
		mListingBean.setList(items);
		mListingBean.setKVPList(setSmBeen(sunMiOrderBean));

		String json = new Gson().toJson(mListingBean);

		return json;
	}

}
