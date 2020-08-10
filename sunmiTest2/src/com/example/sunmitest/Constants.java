package com.example.sunmitest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WangBin
 * @date 2015年6月2日 下午6:46:12
 * @Description: TODO
 * @version V1.0
 */
public class Constants {
	// public static String IP =
	// "http://192.168.19.102:8000/ShopCashier_SI/";//测试ip
	public static String IP = "http://shopcashiersi.liantuobank.com/ShopCashier_SI/"; // 线上
	// public static String IP = "http://192.168.80.150:8080/app/";
	// public static String IP = "http://192.168.80.128:8000/app/";
	// public static String IP = "http://192.168.80.171:8080/app/";
	// public static String IP = "http://192.168.80.145:8080/app/"; //雪松
	// public static String IP = "http://sihd.liantuobank.com/ShopCashier_SI/";
	// public static String IP =
	// "http://testshsi.51ebill.com:49527/ShopCashier_SI/";
	// public static String IP = "http://intscsi.51ebill.com/ShopCashier_SI/";
	// public static String IP = "http://192.168.4.178:8000/ShopCashier_SI/";
	public static String[] IPS = { "http://192.168.19.102:8000/ShopCashier_SI/", "http://intsi.51ebill.com/ShopCashier_SI/", "http://shopcashiersi.liantuobank.com/ShopCashier_SI/",
			"http://192.168.19.112:8000/ShopCashier_SI/", "http://sihd.liantuobank.com/ShopCashier_SI/", "http://192.168.4.202:8000/ShopCashier_SI/",
			"http://testshsi.51ebill.com:49527/ShopCashier_SI/", "http://192.168.4.178:8000/ShopCashier_SI/", "http://192.168.5.183:8080/ShopCashier_SI/" };

	public static String TakeoutIp = "http://openapi.kuaishouyin.com";
//	public static String TakeoutIp = "http://testsctci.liantuobank.cn:8080";
	public static String Service_Tel = "快收银友情提供技术支持/4000-122-155";
	public static String receiptTitle = "如需发票请扫描下方二维码";
	// public static String receiptTitle = "国防教育高速公路又能开工啦！\n微信扫码可开电子发票";
	public static String[] SetMealItemNos = { "牛馍王B套餐", "牛馍王A套餐", "孜然B套餐", "孜然A套餐", "西少爷B套餐", "西少爷A套餐", "甑糕套餐", "荷叶饼套餐", "孜然早餐", "秘辣蔬菜早餐", "健康蔬菜早餐" };
	// public static String[] SetMealItemNos = {"cccc"};
	public static String xsyOtherMemberId = "376";// 西少爷非会员等级
	// public static String xsyOtherMemberId = "167";// 红包测试总部非会员等级
	public static String xsySuperorMerchantId = "10150271";// 西少爷核心门店ID
	// public static String xsySuperorMerchantId = "10084193";// 红包测试总部核心门店ID
	// public static String xsySuperorMerchantId = "10148365";// dy核心门店ID

	public static String wlSuperorMerchantId = "10182655";// 王利客户的核心门店ID

	public static int Card_Key = 1234567890;// 会员卡key
	public static String dbName = "LOCAL_ORDER_DB";// 挂单数据库名字

	// 是否是堂食，取单号的时候用来小票打印堂食外带文字,如果是桌号不显示堂食外带
	public static int isTangshi = 0;


	/**
	 * 线上登陆地址
	 */
	public static String ONLINE_IP = "http://shopcashiersi.liantuobank.com/ShopCashier_SI/";

	/**
	 * 灰度登陆地址
	 */
	public static String HD_IP = "http://sihd.liantuobank.com/ShopCashier_SI";

	/**
	 * 微信注册
	 */
	public static String WXregister_URL = "http://wx.liantuo.com/registerMember.do?key=";

	/**
	 * 核销自提
	 */
	public static String WXVerification = "http://shopcashier.liantuobank.cn/ShopCashier/microVerification/cancelOrderStatus.in?key=";
	/**
	 * 红包核销获取短连接
	 */
	public static String GetWXVerification = "http://wx.liantuo.com/shortUrlConvert.do";
	// 图片线上地址
	public static String ImageURL = "http://upload.liantuobank.com/public_upload/shopcashier/";

	/**
	 * 图片宽高
	 */
	public static String imageWidthHeight = "?w=180&h=180";

	/**
	 * 微信扫码支付带红包核销地址
	 */
	public static String WXHBPay_URL = "http://wx.liantuo.com/retransExit.do?commonKey=";

	// /**
	// * 会员扫码支付
	// */
	// public static String URL_MemberPay =
	// "http://wx.liantuo.com/appMicroMemberPay.do?exitKey=";
	/**
	 * 更改微信相关地址为线上地址
	 */
	public static void setOnlineWXUrl() {
		WXVerification = "http://shopcashier.liantuobank.cn/ShopCashier/microVerification/cancelOrderStatus.in?key=";
		WXregister_URL = "http://wx.liantuo.com/registerMember.do?key=";
		GetWXVerification = "http://wx.liantuo.com/shortUrlConvert.do";
		ImageURL = "http://upload.liantuobank.com/public_upload/shopcashier/";
		WXHBPay_URL = "http://wx.liantuo.com/retransExit.do?commonKey=";
		// URL_MemberPay =
		// "http://wx.liantuo.com/appMicroMemberPay.do?exitKey=";
	}

	/**
	 * 更改微信相关地址为线下地址
	 */
	public static void setOfflineWXUrl() {
		WXVerification = "http://shopcashiertest.liantuobank.com/ShopCashier/microVerification/cancelOrderStatus.in?key=";
		WXregister_URL = "http://wxcs.liantuo.com/registerMember.do?key=";
		GetWXVerification = "http://wxcs.liantuo.com/shortUrlConvert.do";
		ImageURL = "http://192.168.19.91:8000/public_upload/shopcashier/";
		WXHBPay_URL = "http://wxcs.liantuo.com/retransExit.do?commonKey=";
		// URL_MemberPay =
		// "http://wxcs.liantuo.com/appMicroMemberPay.do?commonKey=";
	}

	/**
	 * 更改微信相关地址为灰度地址
	 */
	public static void setHDWXUrl() {
		WXVerification = "http://sctest.liantuobank.com/ShopCashier/microVerification/cancelOrderStatus.in?key=";
		WXregister_URL = "http://wxhdcs.liantuo.com/registerMember.do?key=";
		ImageURL = "http://upload.liantuobank.com/public_upload/shopcashier/";
		GetWXVerification = "http://wxcs.liantuo.com/shortUrlConvert.do";
		WXHBPay_URL = "http://wxcs.liantuo.com/retransExit.do?commonKey=";
	}

	/**
	 * 访问钱包提交pos数据到钱包
	 */

	// public static final String mposallinpay =
	// "http://192.168.81.71:8080/pos/pay/mposallinpay.in";

	// 测试环境
	// public static final String mposallinpay =
	// "http://testpos.liantuobank.com:55553/pos/pay/mposallinpay.in";
	// 线上pos地址
	public static final String mposallinpay = "http://pos.liantuobank.com/pos/pay/mposallinpay.in";

	public static final String PRINT_ACTION = "com.liantuo.cashierdesk.printaction";

	public static String userName = "15811124123"; // 如果你们所有设备都绑定一个会员号和密码，这里就可以写死
	public static String password = "124123";

	public static final String LOCALPRINTER_IP = "127.0.0.1";// 本地小票机IP
	public static final String MATCHING_IP = "127.0.0.";// 匹配的本地IP
	public static String LABELPRINTER_IP = "";// 标签打印机IP

	public static final long DELAYTIME = 5000;// 轮询获取小票打印信息延迟时间

	public static final long PERIOD = 5000;// 轮询获取小票打印信息间隔时间

	public static final boolean DEBUG = true;

	public static final String READCARD_ACTION = "com.liantuo.readCard";// 刷卡广播
	public static final String NEWTAKEOUT = "com.liantuo.newtakeout";
	public static final String LOCAL_ORDER_ACTION = "com.liantuo.localorder";// 挂单开启广播
	public static final String LOCAL_ORDER_RESULT = "com.liantuo.result";

	/**
	 * 网络断开广播
	 */
	public static final String networkDisconnect = "com.liantuo.networkDisconnect";

	public static final String phone = "1581124123";
	/**
	 * 登录接口
	 */
	public static final String login = "android/login.in";
	/**
	 * 交接班接口
	 */
	public static final String Sift = "android/shift.in";
	/**
	 * 新交接班接口 2016.8.23
	 */
	public static final String ShiftData = "android/shiftdata.in";

	/**
	 * 8.2.首页订单信息
	 */
	public static final String indexData = "android/getClerkIndexData.in";

	/**
	 * 8.6.获取所有分类下全部商品
	 */
	public static final String getShopItemByCodeName = "android/getShopItemByCodeName.in";

	/**
	 * 获取所有分类下全部商品(带下架的)
	 */
	// public static final String getShopItemByCodeNameForPrinter =
	// "getShopItemByCodeNameForPrinter.in";

	/**
	 * 获取所有分类下全部商品(带下架的，带套餐的)
	 */
	public static final String getShopItemByCodeNameForPrinter = "android/getAllSetMeal.in";// ////////////////////////套餐

	/**
	 * 8.5更改商品沽清状态 沽清传0，想要上架则传1
	 */
	public static final String updateIsSaleOut = "android/updateIsSaleOut.in";

	/**
	 * 8.11.获取订单及对应的订单集合
	 */
	public static final String getAllSaleOrdersAndDetials = "android/getAllSaleOrdersAndDetials.in";

	/**
	 * 8.10.将订单状态由未取单更改为取单
	 */
	public static final String updateOrderOutState = "android/updateOrderOutState.in";

	/**
	 * 8.7.获取所有当日订单
	 */
	public static final String getAllSaleOrders = "android/getAllSaleOrders.in";

	/**
	 * 根据自定义条件查询订单及详情，按照时间倒叙查询，一次查询20条
	 */
	public static final String getOrderByConditions = "android/getOrderByConditions.in";

	/**
	 * 8.14.获取微信支付宝的支付链接
	 */
	public static final String getPayLink = "android/getPayLink.in";

	/**
	 * 获取支付宝的支付链接
	 */
	public static final String getAliPayLink = "android/getAliPayLink.in";

	/**
	 * 获取微信的支付链接
	 */
	public static final String getWxPayLink = "android/getWxPayLink.in";

	/**
	 * 8.16.判断订单号是否支付成功
	 */
	public static final String getPayedOrderNo = "android/getPayedOrderNo.in";

	/**
	 * 8.18.手机下单
	 */
	// public static final String saveOrderDetail = "saveOrderDetail.in";

	/**
	 * 8.18.手机下单
	 */
	public static final String saveOrderDetail = "android/saveOrderDetailForSetMeal.in";// ///////////////////////////套餐

	/**
	 * 8.17.现金支付确认
	 */
	public static final String payCash = "android/payCash.in";

	/**
	 * 会员卡支付
	 */
	public static final String getReceiveMoney = "android/getReceiveMoney.in";

	/**
	 * 8.15.取消支付宝、微信支付链接
	 */
	public static final String payReverse = "android/payReverse.in";

	/**
	 * 提醒取餐
	 */
	public static final String takeOrderNo = "android/takeOrderNo.in";

	/**
	 * 按门店获取会员级别
	 */
	public static final String getMemberLevel = "android/getMemberLevel.in";

	/**
	 * 按照会员级别分页查询会员
	 */
	public static final String getMemberByLevel = "android/getMemberByLevel.in";

	/**
	 * 获取会员总数
	 */
	public static final String getMemberCount = "android/getMemberCount.in";

	/**
	 * 会员卡储值卡总额显示
	 */
	public static final String getAmountSum = "android/getAmountSum.in";

	/**
	 * 根据手机号模糊查询会员
	 */
	public static final String getMemberByMobile = "android/getMemberByMobile.in";

	/**
	 * 作废订单
	 */
	public static final String invalidOrder = "android/invalidOrder.in";

	/**
	 * 退改
	 */
	// public static final String changeOrder = "android/changeOrder.in";

	/**
	 * 退改
	 */
	public static final String changeOrder = "android/changeOrderForSetMeal.in";// //////////////////////////套餐

	/**
	 * 订单补打
	 */
	public static final String orderPrintAgain = "android/orderPrintAgain.in";

	/**
	 * 是否是店长
	 */
	public static final String isStoreManager = "android/isStoreManager.in";

	/**
	 * 获得pos流水号列表
	 */
	public static final String getPosFlowNo = "android/getPosFlowNo.in";

	/**
	 * pos支付
	 */
	public static final String payPos = "android/payPos.in";

	/**
	 * 退改审批
	 */
	public static final String approveOrder = "android/approveOrder.in";

	/**
	 * 获取所有桌号接口
	 */
	public static final String getAllDeskNo = "android/getAllDeskNo.in";

	/**
	 * 沽清商品
	 */
	public static final String getShopItemsNumStatus = "android/getShopItemsNumStatus.in";

	/**
	 * 支付宝被扫
	 */
	public static final String payByAliQrcode = "android/payByAliQrcode.in";

	/**
	 * 微信被扫
	 */
	public static final String payByWXQrcode = "android/payByWXQrcode.in";

	/**
	 * 查询小票机信息
	 */
	public static final String getAllPrinter = "android/getAllPrinter.in";

	/**
	 * 删除打印机
	 */
	public static final String deletePrinter = "android/deletePrinter.in";

	/**
	 * 增加小票机
	 */
	public static final String insertPrinter = "android/insertPrinter.in";

	/**
	 * 修改小票机
	 */
	public static final String updatePrinter = "android/updatePrinter.in";

	/**
	 * 微信退款
	 */
	public static final String wxRefund = "android/wxRefund.in";

	/**
	 * 支付宝退款
	 */
	public static final String aliRefund = "android/aliRefund.in";

	/**
	 * pos退款
	 */
	public static final String posRefund = "android/posRefund.in";

	/**
	 * 微信退款失败现金补退接口
	 */
	public static final String wxRefundByCash = "android/wxRefundByCash.in";

	/**
	 * 小票轮询接口
	 */
	public static final String getOrderFromRedis = "android/getOrderFromRedis.in";

	/**
	 * 红包核销轮询接口
	 */
	public static final String getPadhxOrderFromRedis = "android/getPadhxOrderFromRedis.in";

	/**
	 * 新小票轮询接口
	 */
	public static final String newgetorderfromredis = "/android/getOrderFromRedisWithMachinecode.in";

	/**
	 * 退款失败现金补退接口
	 */
	public static final String refundByCash = "android/refundByCash.in";

	/**
	 * 添加会员
	 */
	public static final String addMember = "android/addMember.in";

	/**
	 * 会员充值
	 */
	public static final String memberRecharge = "android/memberRecharge.in";

	/**
	 * 根据会员卡号查询会员
	 */
	public static final String findByCardNo = "android/findByCardNo.in";

	/**
	 * 发送验证码
	 */
	public static String SendVerificationCode = "android/getValidateCode.in";
	/**
	 * 检查登陆名称是否重复
	 */
	public static String CheckLoginName = "android/checkLoginName.in";
	/**
	 * 添加核心商户和成员
	 */
	public static String AddUser = "android/addAppMerchant.in";

	/**
	 * 添加开临时卡
	 */
	public static String createSaleCard = "foodCity/createSaleCard.in";

	/**
	 * 会员卡退卡
	 */
	public static String logoutSaleCard = "foodCity/logoutSaleCard.in";

	/**
	 * 获取所有新增外卖接口订单号
	 */
	public static String orderNoFromRedis = "takeout/orderNoFromRedis.in";

	/**
	 * 获取外卖订单详情
	 */
	public static String getTakeOutOrderAndDetialsByOrderNo = "takeout/getTakeOutOrderAndDetialsByOrderNo.in";

	/**
	 * 外卖接单
	 */
	public static String acceptShopTakeOutOrder = "takeout/acceptShopTakeOutOrder.in";

	/**
	 * 外卖拒单
	 */
	public static String refuseOrder = "takeout/refuseOrder.in";

	/**
	 * 外卖使用状态0：未启用，1：已启用
	 */
	public static String getTakeOutIsUse = "takeout/getTakeOutIsUse.in";

	/**
	 * 更新外卖是否启用0：未启用，1：已启用
	 */
	public static String updateTakeIsUse = "takeout/updateTakeIsUse.in";

	/**
	 * 获取订单备注
	 */
	public static String getRemarksByMerchantId = "android/getRemarksByMerchantId.in";

	/**
	 * 通联I付支付雪松接口
	 */
	public static String payIPos = "android/payIPos.in";

	/**
	 * 会员充值成功调用si接口
	 */
	public static String recharge = "currencypos/recharge.in";

	/**
	 * 生成会员充值订单号
	 */
	public static String getRechargePayOrderNo = "currencypos/getRechargePayOrderNo.in";

	/**
	 * 获取是否是通联pos支付接口，返回ShopSalesOrderPay
	 */
	public static String getOrderIPayInfo = "android/getOrderIPayInfo.in";

	/**
	 * POS刷卡成功把数据给SI
	 */
	public static String consumer = "currencypos/consumer.in";

	/**
	 * POS获取刷卡信息
	 */
	public static String queryPosPay = "currencypos/queryPosPay.in";

	/**
	 * 实物商品
	 */
	public static final String SHOP_ITEM_TYPE_PHYSJCAL = "0";

	/**
	 * 虚拟商品
	 */
	public static final String SHOP_ITEM_TYPE_VIRTUAL = "1";

	/**
	 * 自定义商品
	 */
	public static final String SHOP_ITEM_TYPE_CUSTOM = "2";

	/**
	 * 套餐商品
	 */
	public static final String SHOP_ITEM_TYPE_SET_MEAL = "3";

	/**
	 * 套餐明细商品
	 */
	public static final String SHOP_ITEM_TYPE_SET_MEAL_DETAIL = "4";

	/**
	 * 发送kds，整单个单个菜
	 */
	public static String kdsAll = "android/getKDSMessage.in";

	/**
	 * 上传离线订单
	 */
	public static String uploadOffLineOrder = "android/uploadOffLineOrder.in";

	/**
	 * 检测网络是否连通
	 */
	public static String isOnLine = "android/isOnLine.in";

	/**
	 * 添加商品
	 */
	public static String ADD_SHOP = "ItemAndItemCategoryController/addShopItem.in";
	/**
	 * 修改商品
	 */
	public static String EDIT_SHOP = "ItemAndItemCategoryController/modShopItem.in";
	/**
	 * 添加商品分类
	 */
	public static String ADD_SHOPTYPE = "ItemAndItemCategoryController/addShopItemCategory.in";
	/**
	 * 修改商品分类
	 */
	public static String EDIT_SHOPTYPE = "ItemAndItemCategoryController/modShopItemCategory.in";
	/**
	 * 删除商品分类
	 */
	public static String DEL_SHOPTYPE = "ItemAndItemCategoryController/delShopItemCategory.in";
	/**
	 * 桌号设置：增加区域 android/addArea.in?departNo=门店编号&areaName=区域
	 */
	public static String ADD_AREA = "android/addArea.in";
	/**
	 * 桌号设置：修改区域 android/modArea.in?departNo=门店编号&areaName=区域名称&areaId=区域id
	 */
	public static String MOD_AREA = "android/modArea.in";
	/**
	 * 数据库版本 1-2：OffLinOrderInfo+cardNo+isTakeout
	 */
	public static final int DBVERSION = 3;
	/**
	 * /** 需要缓存的接口
	 */
	public static String[] cacheIp = { login, getShopItemByCodeNameForPrinter, getAllPrinter, getAllDeskNo, getRemarksByMerchantId, getRemarksByMerchantId };
	/**
	 * 新的退改
	 */
	public static final String orderRefund = "orderRefund/orderRefund.in";

	/**
	 * 新的退改审批
	 */
	public static final String refundApproval = "orderRefund/refundApproval.in";
	/**
	 * 桌号设置：删除区域 android/delArea.in?areaId=区域id
	 */
	public static String DEL_AREA = "android/delArea.in";
	/**
	 * 桌号设置：增加桌号 android/addDeskNo.in?deskName=桌号名称&areaId=区域id
	 */
	public static String ADD_DESK_NO = "android/addDeskNo.in";
	/**
	 * 桌号设置：修改桌号 android/modDeskNo.in？deskId=桌号id&deskName=桌号名称&areaId=区域id
	 */
	public static String MOD_DESK_NO = "android/modDeskNo.in";
	/**
	 * 获取商品分类
	 */
	public static String GET_SHOP_TYPE = "ItemAndItemCategoryController/selectShopItemCategory.in";
	/**
	 * 桌号设置：删除桌号 android/delDeskNo.in?deskId=桌号id
	 */
	public static String DEL_DESK_NO = "android/delDeskNo.in";
	/**
	 * 获取所有区域和桌号数据
	 */
	public static String GET_DESK_ALL_DATA = "android/getDeskNoCategory.in";

	/**
	 * 支付检测
	 */
	public static String payCheck = "android/payCheck.in";

	/**
	 * 会员开卡（最新）
	 */
	public static String createCard = "foodCity/createCard.in";

	/**
	 * 会员退卡（最新）
	 */
	public static String logoutCard = "foodCity/logoutCard.in";

	/**
	 * 会员充值（最新）
	 */
	public static String membersRecharge = "foodCity/membersRecharge.in";

	/**
	 * 充反活动
	 */
	public static final String getConsumptionAndRechargeActivity = "foodCity/getConsumptionAndRechargeActivity.in";

	/**
	 * 手动确认支付
	 */
	public static final String confirmWxAlPay = "orderPay/confirmWxAlPay.in";

	/**
	 * 订单查询
	 */
	public static final String selectQueryOrderIndex = "orderQuery/selectQueryOrderIndex.in";

	/**
	 * 订单全部信息
	 */
	public static final String getOrderAllInfo = "orderQuery/getOrderAllInfo.in";

	/**
	 * 自定义支付
	 */
	public static final String customPay = "orderPay/customPay.in";

	/**
	 * 获取自定义支付方式
	 */
	public static final String getCustomPay = "orderPay/getCustomPay.in";

	/**
	 * 现金下单支付接口
	 */
	public static final String orderPayByCash = "orderPay/orderPayByCash.in";

	/**
	 * 微信下单获取支付链接接口
	 */
	public static final String orderPayByWXLink = "orderPay/orderPayByWXLink.in";

	/**
	 * 支付宝下单获取支付链接接口
	 */
	public static final String orderPayByAliLink = "orderPay/orderPayByAliLink.in";

	/**
	 * 微信下单刷卡接口
	 */
	public static final String orderPayByWXQrcode = "orderPay/payByWXQrcode.in";

	/**
	 * 支付宝下单刷卡接口
	 */
	public static final String orderPayByAliQrcode = "orderPay/payByAliQrcode.in";

	/**
	 * 会员下单支付接口
	 */
	public static final String orderPayByMember = "orderPay/orderPayByMember.in";

	/**
	 * 红包核销下单接口（生成订单号）
	 */
	public static final String orderPayByRedRiteOff = "orderPay/orderPayByRedRiteOff.in";

	/**
	 * 自定义支付下单支付接口
	 */
	public static final String orderPayByCustom = "orderPay/orderPayByCustom.in";

	/**
	 * POS下单支付接口（包括大pos和蓝牙pos）
	 */
	public static final String orderPayByPos = "orderPay/orderPayByPos.in";

	/**
	 * 标记处理异常订单
	 */
	public static final String misTakeOrderDeal = "orderPay/misTakeOrderDeal.in";

	// H5
	public static final String ORDER_SOURCE_MOBILE = "1";
	// pad端
	public static final String ORDER_SOURCE_PAD = "2";
	// 自助点单机 pad端
	public static final String ORDER_SOURCE_SELF_PAD = "3";
	// 手机 pad端
	public static final String ORDER_SOURCE_MOBILE_PAD = "4";
	/**
	 * 盲缴接口
	 */
	public static final String BLIND_CONTRIBUTE = "android/saveTempBlindPay.in";
	/**
	 * 上传设备信息
	 */
	public static final String UPLOAD_DEVICE_INFO = "loginShift/insertOperationRecord.in";
	/**
	 * 挂单
	 */
	public static final String DOENTRYORDER = "entryorder/doentryorder.in";
	/**
	 * 并桌
	 */
	public static final String ANDTHETABLE = "entryorder/andTheTable.in";
	/**
	 * 改单
	 */
	public static final String MODIFYENTRYORDER = "entryorder/modifyentryorder.in";
	/**
	 * 改桌
	 */
	public static final String MODIFYORDERDESKNO = "entryorder/modifyorderdeskno.in";
	/**
	 * 获取挂单信息
	 */
	public static final String QUERYORDERLIST = "entryorder/queryorderlist.in";
	/**
	 * 锁定订单
	 */
	public static final String SETTLEORDER = "entryorder/paylock.in";
	/**
	 * 删除挂单
	 */
	public static final String REMOVEORDER = "entryorder/removeorder.in";
	/**
	 * 解锁订单
	 */
	public static final String REINISTALLORDER = "entryorder/payunlock.in";

	/**
	 * （核心）修改密码
	 */
	public static String MODIFY_PWD = "coreStore/modPassword.in";

	/**
	 * 自定义支付退款（作废）
	 */
	public static String toCancelOrder = "orderRefund/toCancelOrder.in";

	/**
	 * 获取初始化配置接口
	 */
	public static String initAllMerchantSetting = "loginShift/initAllMerchantSetting.in";
	/**
	 * 小票设置接口
	 */
	public static String shopReceiptSetting = "/android/shopReceiptSetting.in";

	/**
	 * 微信支付宝主扫充值
	 */
	public static String getpayurl = "/payway/getpayurl.in";

	/**
	 * 微信支付宝主扫充值结果
	 */
	public static String checksuccess = "/payway/checksuccess.in";

	/**
	 * 会员冻结解冻
	 */
	public static String modMemberInfo = "/foodCity/modMemberInfo.in";

	/**
	 * 补卡接口
	 */
	public static String replaceCard = "/foodCity/replaceCard.in";

	/**
	 * 上传打印日志
	 */
	public static String insertAppOperationLog = "/loginShift/insertAppOperationLog.in";

	/**
	 * 广告图片
	 */
	public static String selectShopBannerImgSetting = "/android/selectShopBannerImgSetting.in";

	/**
	 * 混合支付
	 */
	public static String doMixedPay = "/mixedPay/doMixedPay.in";

	/**
	 * 单品折扣
	 */
	public static String getSingleItemDiscountList = "/android/getSingleItemDiscountList.in";

	/**
	 * 日结算报表
	 */
	public static String dailySettlement = "/loginShift/dailySettlement.in";

	/**
	 * 销售报表
	 */
	public static String dailySettlementItems = "/loginShift/dailySettlementItems.in";

	/**
	 * 销售报表
	 */
	public static String dailySettlementSales = "/loginShift/dailySettlementSales.in";
	
	/**
	 * 获取外卖订单列表
	 */
	public static String getTakeoutOrderList = TakeoutIp + "/platform/order/list";

	/**
	 * 外卖操作
	 */
	public static String getTakeoutAction = TakeoutIp + "/platform/order/";

	/**
	 * 获取外卖食物类别列表
	 */
	public static String queryFoodCategories = TakeoutIp + "/elemeFoodCategory/queryFoodCategories";

	/**
	 * 更新食物类别
	 */
	public static String updateFoodCategories = TakeoutIp + "/elemeFoodCategory/updateFoodCategories";

	/**
	 * 增加饿了么打印机
	 */
	public static String addPrinterAndItems = TakeoutIp + "/eleme/printer/addPrinterAndItems";

	/**
	 * 更新饿了么打印机
	 */
	public static String updatePrinterAndItems = TakeoutIp + "/eleme/printer/updatePrinterAndItems";

	/**
	 * 查询商户下所有饿了么打印机
	 */
	public static String queryAllPrinters = TakeoutIp + "/eleme/printer/queryAllPrinters";

	/**
	 * 删除饿了么打印机
	 */
	public static String delPrinter = TakeoutIp + "/eleme/printer/delPrinter";

	/**
	 * 推送消息类型
	 * 
	 * @author 杨通海
	 *
	 *         创建时间：2016年10月18日 类说明：
	 */
	public static final class OrderType {
		/**
		 * 美团、饿了么、百度第三方外卖推送消息类型
		 */
		public static final int pushType_threeTakeOut = 100;

		/**
		 * 快收银自己外卖推送消息类型
		 */
		public static final int pushType_takeOut = 4;

		/**
		 * 1、2都是自助订单推送消息类型
		 */
		public static final int pushType_selfHelp1 = 1;

		/**
		 * 1、2都是自助订单推送消息类型
		 */
		public static final int pushType_selfHelp2 = 2;
	}
}
