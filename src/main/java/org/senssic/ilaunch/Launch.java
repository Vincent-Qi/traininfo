package org.senssic.ilaunch;

import org.senssic.bean.login.MyContent;
import org.senssic.bean.login.SelfContent;
import org.senssic.bean.order.Orders;
import org.senssic.bean.remticket.TicketInfo;
import org.senssic.bean.trainway.TrainInfo;
import org.senssic.login.ContsMage;
import org.senssic.login.OrderMage;
import org.senssic.login.UserLogin;
import org.senssic.query.CheakUtil;
import org.senssic.query.TrainUtil;
import org.senssic.util.TrainConvert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Launch implements Ilaunch {
	private ContsMage contsMage;
	private OrderMage ordermage;
	private Logger log = LoggerFactory.getLogger(Launch.class);

	public Launch() {
		new UserLogin();
		contsMage = new ContsMage();
		ordermage = new OrderMage();
	}

	private void check(String... arg) {
		if (arg.length == 1) {
			if (!CheakUtil.checkDate(arg[0])) {
				log.info("查询余票-->输入的日期格式不对或者小于当前日期!");
				throw new IllegalAccessError();
			}
		}
		if (arg.length == 2) {
			if (!CheakUtil.checkBFDate(arg[0], arg[1])) {
				log.info("输入的日期格式不对或开始日期大于当结束日期!");
				throw new IllegalAccessError();
			}
		}

	}

	@Override
	public TicketInfo querySeatsLeftAsBean(String purpose, String date,
			String start, String end) {
		this.check(date);
		start = TrainConvert.getStation(start);
		end = TrainConvert.getStation(end);
		if ("".equals(start) || "".equals(end)) {
			log.info("车站信息未搜索到,请重新正确输入!");
			throw new IllegalAccessError();
		}
		return TrainUtil.geTicketInfo(purpose, date, start, end);
	}

	@Override
	public String querySeatsLeftAsString(String purpose, String date,
			String start, String end) {
		return this.querySeatsLeftAsBean(TrainConvert.getType(purpose), date,
				start, end).toString();
	}

	@Override
	public TrainInfo queryTrainInfoAsBean(String train_no, String start,
			String end) {

		train_no = TrainConvert.getTrannumByCZ(train_no);
		start = TrainConvert.getStation(start);
		end = TrainConvert.getStation(end);
		if ("".equals(train_no)) {
			log.info("车次信息未搜索到,请重新正确输入!");
			throw new IllegalAccessError();
		}

		if ("".equals(start) || "".equals(end)) {
			log.info("车站信息未搜索到,请重新正确输入!");
			throw new IllegalAccessError();
		}
		return TrainUtil.geTrainInfo(train_no, start, end, "");
	}

	@Override
	public String queryTrainInfoAsString(String train_no, String start,
			String end) {
		return this.queryTrainInfoAsBean(train_no, start, end).toString();
	}

	@Override
	public SelfContent querySelfCountAsBean() {
		return contsMage.getSefInfo();
	}

	@Override
	public String querySelfCountAsString() {
		return this.querySelfCountAsBean().toString();
	}

	@Override
	public MyContent queryMyContentAsBean() {
		return contsMage.getMyContent();
	}

	@Override
	public String queryMyContentAsString() {
		// TODO Auto-generated method stub
		return this.queryMyContentAsBean().toString();
	}

	@Override
	public Orders queryOrdersAsBean(String startdate, String enddate,
			String queryinfo) {
		// TODO Auto-generated method stub
		this.check(startdate,enddate);
		return ordermage.orderQuery(startdate, enddate, queryinfo);
	}

	@Override
	public String queryOrdersAsString(String startdate, String enddate,
			String queryinfo) {
		// TODO Auto-generated method stub
		return this.queryOrdersAsBean(startdate, enddate, queryinfo).toString();
	}

	public static void main(String[] args) {
		Ilaunch iaun = new Launch();
		System.out.println(iaun.queryMyContentAsString());
		System.out.println(iaun.querySelfCountAsString());
		System.out.println(iaun.queryTrainInfoAsString("k8554", "阜阳", "合肥"));
		 System.out.println( iaun.querySeatsLeftAsString("成人", "2015-02-05",
		 "阜阳", "合肥"));
		 System.out.println(iaun.queryOrdersAsString("2014-10-03",
		 "2015-02-02", ""));
	}
}
