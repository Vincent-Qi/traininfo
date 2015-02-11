package org.senssic.query;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CheakUtil {

	public static boolean checkDate(String datestr) {
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {

			Date date = sFormat.parse(datestr);
			Date now = new Date();
			if (date.after(now)||datestr.equals(sFormat.format(now))) {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}

	public static boolean checkBFDate(String sdate, String edate) {
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			sFormat.parse(sdate);
			sFormat.parse(edate);
		} catch (Exception e) {
			return false;
		}
		if (sdate.compareTo(edate) == 1) {
			return false;
		}
		return true;
	}


}