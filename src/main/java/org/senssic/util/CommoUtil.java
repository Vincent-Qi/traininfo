package org.senssic.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.httpclient.NameValuePair;

public class CommoUtil {
	public static List<NameValuePair> createNameValuePair(String params) {
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		if (null != params && !params.trim().equals("")) {
			String[] _params = params.split("&");
			for (int i = 0; i < _params.length; i++) {
				int _i = _params[i].indexOf("=");
				if (_i != -1) {
					String name = _params[i].substring(0, _i);
					String value = _params[i].substring(_i + 1);
					nvps.add(new NameValuePair(name, value));
				}
			}
		}
		return nvps;
	}


}
