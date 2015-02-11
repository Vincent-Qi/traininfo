package org.senssic.query;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.senssic.bean.remticket.TicketInfo;
import org.senssic.bean.trainway.TrainInfo;
import org.senssic.util.HttpDoRequest;
import org.senssic.util.TrainSetCnf;

import com.alibaba.fastjson.JSON;

public class TrainUtil {
	private static HttpDoRequest hq = HttpDoRequest.gethDoRequest();

	public static TicketInfo geTicketInfo(String purpose, String date,
			String start, String end) {
		purpose = (purpose == null || "".equals(purpose)) ? "ADULT" : purpose;
		date = (date == null || "".equals(date)) ? new SimpleDateFormat(
				"yyyy-MM-dd").format(new Date()) : date;
		String str = hq.RequestGet(TrainSetCnf.QUERY_SEAT_SLEFT
				+ "?purpose_codes=" + purpose + "&queryDate=" + date
				+ "&from_station=" + start + "&to_station=" + end);
		return JSON.parseObject(str, TicketInfo.class);

	}

	public static TrainInfo geTrainInfo(String train_no, String start,
			String end, String date) {
		date = (date == null || "".equals(date)) ? new SimpleDateFormat(
				"yyyy-MM-dd").format(new Date()) : date;
		String str = hq.RequestGet(TrainSetCnf.QUERY_WAY_STATION + "?train_no="
				+ train_no + "&from_station_telecode=" + start
				+ "&to_station_telecode=" + end + "&depart_date="+date);
		return JSON.parseObject(str, TrainInfo.class);
	}

}
