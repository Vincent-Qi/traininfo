package org.senssic.util;

public class TrainSetCnf {
	// 主域名
	public static String HOST = "https://kyfw.12306.cn";
	// 验证码
	public static String LOGIN_VYCE = "https://kyfw.12306.cn/otn/passcodeNew/getPassCodeNew?module=login&rand=sjrand";
	// 预检测验证码
	public static String LOGIN_FVYCE = "https://kyfw.12306.cn/otn/passcodeNew/checkRandCodeAnsyn";
	// 动态js路径
	public static String LOGIN_DYJS = "https://kyfw.12306.cn/otn/login/init";
	// 登录
	public static String LOGIN_LOGIN = "https://kyfw.12306.cn/otn/login/loginAysnSuggest";
	// 余票查询
	public static String QUERY_SEAT_SLEFT = "https://kyfw.12306.cn/otn/lcxxcx/query";
	// 列车途径站查询
	public static String QUERY_WAY_STATION = "https://kyfw.12306.cn/otn/czxx/queryByTrainNo";
	// 个人信息
	public static String CONTENT_SEF_INFO = "https://kyfw.12306.cn/otn/modifyUser/initQueryUserInfo";
	// 联系人信息
	public static String CONTENT_MYCONTENT_INFO = "https://kyfw.12306.cn/otn/passengers/init";
	// 订单查询
	public static String ORDER_QUERY = "https://kyfw.12306.cn/otn/queryOrder/queryMyOrder";
}
