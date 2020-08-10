package com.example.sunmitest;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

import android.text.TextUtils;

/**
 * 商米客显显示订单详情的实体类
 * 
 * @author Administrator
 *
 */
public class SunMiOrderBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5893047897024255792L;
	/**
	 * 商品列表
	 */
	private List<Shop> orderList;
	/**
	 * 收款
	 */
	private double collection;
	/**
	 * 优惠
	 */
	private double preferential;
	/**
	 * 找零
	 */
	private double change;
	/**
	 * 实收
	 */
	private double realPrice;
	/**
	 * 总数量
	 */
	private int number;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public List<Shop> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Shop> orderList) {
		this.orderList = orderList;
	}

	public double getCollection() {
		return keepTwoSecimalStr(collection);
	}

	public void setCollection(double collection) {
		this.collection = collection;
	}

	public double getPreferential() {
		return keepTwoSecimalStr(preferential);
	}

	public void setPreferential(double preferential) {
		this.preferential = preferential;
	}

	public double getChange() {
		return keepTwoSecimalStr(change);
	}

	public void setChange(double change) {
		this.change = change;
	}

	public double getRealPrice() {
		return keepTwoSecimalStr(realPrice);
	}

	public void setRealPrice(double realPrice) {
		this.realPrice = realPrice;
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

}
