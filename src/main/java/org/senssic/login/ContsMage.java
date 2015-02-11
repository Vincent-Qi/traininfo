package org.senssic.login;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.senssic.bean.login.MyContent;
import org.senssic.bean.login.SelfContent;
import org.senssic.util.HttpDoRequest;
import org.senssic.util.TrainSetCnf;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;

public class ContsMage {
	private HttpDoRequest hRequest = HttpDoRequest.gethDoRequest();
	private Logger log = LoggerFactory.getLogger(ContsMage.class);

	public ContsMage() {
	
	}

	public  SelfContent getSefInfo() {
		String str = hRequest.RequestPost(TrainSetCnf.CONTENT_SEF_INFO, null);
		Pattern pattern = Pattern.compile("<div class=\"con\">(.*?)</div>");
		Matcher matcher = pattern.matcher(str);
		List<String> list = new ArrayList<String>();
		StringBuilder sBuilder = new StringBuilder();
		while (matcher.find()) {
			String string = matcher.group(1);
			if (!string.startsWith("<") && !"".equals(string)) {
				list.add(string);
				sBuilder.append(string + "--");
			}
		}
		log.info("截取的用户信息:" + sBuilder.toString());
		SelfContent st = new SelfContent();
		st.setLoginname(list.get(0));
		st.setUsername(list.get(1));
		st.setIdtype(list.get(2));
		st.setIdnum(list.get(3));
		st.setSex(list.get(6));
		st.setCountry(list.get(7));
		st.setBirthday(list.get(10));
		st.setPhonenum(list.get(11));
		st.setEmail(list.get(12));
		return st;
	}

	public MyContent getMyContent() {
		String str = hRequest.RequestPost(TrainSetCnf.CONTENT_MYCONTENT_INFO,
				null);
		String string = str.substring(str.indexOf("var passengers=") + 15,
				str.indexOf("var pageSize =") - 2);
		log.info("获取联系人信息:-->" + string);
		string = "{info:" + string + "}";
		return JSON.parseObject(string, MyContent.class);
	}
}
