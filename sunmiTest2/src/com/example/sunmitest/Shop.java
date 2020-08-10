package com.example.sunmitest;

import java.io.Serializable;

import android.text.TextUtils;

/**
 * 菜品信息，包含分类
 * 
 * @author 杨通海 2015年5月27日下午3:25:09
 */
public class Shop implements Serializable {

	/**
	 * itemName为商品名称，categoryName为商品分类名称， merchantNo为总店code，departmentNo为门店code，
	 * stockQty为库存数量，purchasePrice为采购价格,
	 * salePrice为销售价格discountPrice为折扣价，status值为1表示上架,0:。
	 */
	private String id;

	private String merchantNo;

	private String departmentNo;

	private String itemNo;

	private String itemName;

	private String categoryNo;

	private String categoryName;

	private String stockQty;

	private String purchasePrice;

	private String salePrice;

	private String discountRate = "1";

	private String discountPrice;

	private String integral;

	private String status;

	private String gmtCreated;

	private String creatorNo;

	private String creatorCn;

	private String gmtModified;

	private String modifierNo;

	private String modifierCn;

	private String inDate;
	private String type;// 商品类型 0普通商品 1虚拟商品 2自定义商品 3套餐 4套餐明细商品
						// 6代表这个商品有多个规格商品，同时7的back_co1记录的itemNo是属于哪个商品的规格
	private String useCount;

	private String itemBarNo;// 条形码

	private String isSaleOut;// 0是沽清 1未沽清


	private String backCol1;

	private String backCol2;

	private int number = 0;// 自己加的 下单中商品数量
	private int newNumber;// 自己加的挂单新增的商品数量

	private boolean isSelectPrint;// 自己加的 打印菜品中标记是否被选中要打印
	private String itemPic;

	private int count;// 自己加的 点了菜时菜品列表数字展示（自助）

	private String shopRmk = "";// 自己加的 (点菜是备注)

	private boolean isSaveDate = false;// 自己加的(是否是挂单商品)
	private String index;// 自己加的 (首字母)
	// 挂单状态，0默认状态，1加菜，2减菜
	private int guaState;
	// 用于KDS标记菜，划菜屏和后厨屏联动
	private String kdsId;

	public String getKdsId() {
		return kdsId;
	}

	public void setKdsId(String kdsId) {
		this.kdsId = kdsId;
	}

	public int getGuaState() {
		return guaState;
	}

	public void setGuaState(int guaState) {
		this.guaState = guaState;
	}

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public String getShopRmk() {
		if (shopRmk == null) {
			return "";
		}
		return shopRmk;
	}

	public void setShopRmk(String shopRmk) {
		this.shopRmk = shopRmk;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getItemPic() {
		return itemPic;
	}

	public void setItemPic(String itemPic) {
		this.itemPic = itemPic;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMerchantNo() {
		return merchantNo;
	}

	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	public String getDepartmentNo() {
		return departmentNo;
	}

	public void setDepartmentNo(String departmentNo) {
		this.departmentNo = departmentNo;
	}

	public String getItemNo() {
		return itemNo;
	}

	public void setItemNo(String itemNo) {
		this.itemNo = itemNo;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(String categoryNo) {
		this.categoryNo = categoryNo;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getStockQty() {
		return stockQty;
	}

	public void setStockQty(String stockQty) {
		this.stockQty = stockQty;
	}

	public String getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(String purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public String getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(String salePrice) {
		this.salePrice = salePrice;
	}

	public String getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(String discountRate) {
		this.discountRate = discountRate;
	}

	public String getDiscountPrice() {
		if (TextUtils.isEmpty(discountPrice)) {
			return salePrice;
		}else{
			return discountPrice;
		}
	}

	public void setDiscountPrice(String discountPrice) {
		this.discountPrice = discountPrice;
	}

	public String getIntegral() {
		return integral;
	}

	public void setIntegral(String integral) {
		this.integral = integral;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getGmtCreated() {
		return gmtCreated;
	}

	public void setGmtCreated(String gmtCreated) {
		this.gmtCreated = gmtCreated;
	}

	public String getCreatorNo() {
		return creatorNo;
	}

	public void setCreatorNo(String creatorNo) {
		this.creatorNo = creatorNo;
	}

	public String getCreatorCn() {
		return creatorCn;
	}

	public void setCreatorCn(String creatorCn) {
		this.creatorCn = creatorCn;
	}

	public String getGmtModified() {
		return gmtModified;
	}

	public void setGmtModified(String gmtModified) {
		this.gmtModified = gmtModified;
	}

	public String getModifierNo() {
		return modifierNo;
	}

	public void setModifierNo(String modifierNo) {
		this.modifierNo = modifierNo;
	}

	public String getModifierCn() {
		return modifierCn;
	}

	public void setModifierCn(String modifierCn) {
		this.modifierCn = modifierCn;
	}

	public String getInDate() {
		return inDate;
	}

	public void setInDate(String inDate) {
		this.inDate = inDate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUseCount() {
		return useCount;
	}

	public void setUseCount(String useCount) {
		this.useCount = useCount;
	}

	public String getIsSaleOut() {
		return isSaleOut;
	}

	public void setIsSaleOut(String isSaleOut) {
		this.isSaleOut = isSaleOut;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public boolean getSelectPrint() {
		return isSelectPrint;
	}

	public void setSelectPrint(boolean isSelectPrint) {
		this.isSelectPrint = isSelectPrint;
	}

	public String getItemBarNo() {
		return itemBarNo;
	}

	public void setItemBarNo(String itemBarNo) {
		this.itemBarNo = itemBarNo;
	}


	public String getBackCol1() {
		return backCol1;
	}

	public void setBackCol1(String backCol1) {
		this.backCol1 = backCol1;
	}

	public String getBackCol2() {
		return backCol2;
	}

	public void setBackCol2(String backCol2) {
		this.backCol2 = backCol2;
	}

	public boolean isSaveDate() {
		return isSaveDate;
	}

	public void setSaveDate(boolean isSaveDate) {
		this.isSaveDate = isSaveDate;
	}

	public int getNewNumber() {
		return newNumber;
	}

	public void setNewNumber(int newNumber) {
		this.newNumber = newNumber;
	}

}
