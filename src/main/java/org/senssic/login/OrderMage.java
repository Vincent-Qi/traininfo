package org.senssic.login;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.httpclient.NameValuePair;
import org.senssic.bean.order.Orders;
import org.senssic.util.HttpDoRequest;
import org.senssic.util.TrainSetCnf;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;

public class OrderMage {
	private HttpDoRequest hRequest = HttpDoRequest.gethDoRequest();
	private Logger log = LoggerFactory.getLogger(OrderMage.class);

	public OrderMage() {
		
	}
	public Orders orderQuery(String startdate, String enddate, String queryinfo) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.YEAR, -1);
		startdate = "".equals(startdate) || null == startdate ? new SimpleDateFormat(
				"yyyy-MM-dd").format(calendar.getTime()) : startdate;
		enddate = "".equals(enddate) || null == enddate ? new SimpleDateFormat(
				"yyyy-MM-dd").format(new Date()) : enddate;
		List<NameValuePair> list = new ArrayList<NameValuePair>();
		list.add(new NameValuePair("queryType", "1"));
		list.add(new NameValuePair("queryStartDate", startdate));
		list.add(new NameValuePair("queryEndDate", enddate));
		list.add(new NameValuePair("come_from_flag", "my_order"));
		list.add(new NameValuePair("pageSize", "100"));
		list.add(new NameValuePair("pageIndex", "0"));
		list.add(new NameValuePair("query_where", "H"));
		list.add(new NameValuePair("sequeue_train_name", queryinfo));
		String string = hRequest.RequestPost(TrainSetCnf.ORDER_QUERY, list);

		if ("".equals(string) || null == string) {
			log.info("查询条件无记录");
			return null;
		}
		return JSON.parseObject(string, Orders.class);
	}
}
