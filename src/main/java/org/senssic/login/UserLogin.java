package org.senssic.login;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import org.apache.commons.httpclient.NameValuePair;
import org.senssic.bean.lgcheck.LoginCheck;
import org.senssic.util.HttpDoRequest;
import org.senssic.util.ProUtl;
import org.senssic.util.TrainSetCnf;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;

public class UserLogin {
	private HttpDoRequest hq = HttpDoRequest.gethDoRequest();
	private ProUtl pUtl = new ProUtl();
	private Logger log = LoggerFactory.getLogger(UserLogin.class);
	private String code = "";

	public UserLogin() {
		if (getCheck()) {
			int i=1;
		while (!login(code)) {
			    log.info("登录失败!尝试第"+ ++i+"次登录");
			    if (i==10) {
			    	log.info("登录失败,请重试!");
					throw new IllegalAccessError();
				}
		   }
		 log.info("登录成功。");
		} else {
			log.info("验证码输入错误!");
			throw new IllegalAccessError();
		}
	}

	// 验证码
	private boolean getCheck() {
		try {
			hq.RequestPostFile(TrainSetCnf.LOGIN_VYCE, "check.jpeg");
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(System.in));
			System.out.print("请输入验证码(位于工作目录下):");
			code = bufferedReader.readLine();
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<NameValuePair> lis = new ArrayList<NameValuePair>();
		lis.add(new NameValuePair("randCode", code));
		lis.add(new NameValuePair("rand", "sjrand"));
		lis.add(new NameValuePair("randCode_validate", ""));
		String str = hq.RequestPost(TrainSetCnf.LOGIN_FVYCE, lis);
		LoginCheck lcCheck = JSON.parseObject(str, LoginCheck.class);
		if ("1".equals(lcCheck.getData().getResult())) {
			return true;
		}
		return false;
	}

	// 获取动态字符串加密后的数据
	private String[] getSigByJsStr() {
		try {
			String itsr = hq.RequestGet(TrainSetCnf.LOGIN_DYJS);
			String jsst = hq.RequestGet(TrainSetCnf.HOST
					+ itsr.substring(itsr.indexOf("/otn/dynamicJs"),
							itsr.indexOf("/otn/dynamicJs") + 22));
			String jsstr = jsst.substring(jsst.indexOf("var key=") + 9,
					jsst.indexOf("var key=") + 17);

			ScriptEngineManager sEngineManager = new ScriptEngineManager();
			ScriptEngine sEngine = sEngineManager.getEngineByName("javascript");
			FileReader fReader = new FileReader(new File(ClassLoader
					.getSystemResource("danyjs.js").toURI()));
			sEngine.eval(fReader);
			if (sEngine instanceof Invocable) {
				Invocable invocable = (Invocable) sEngine;
				String str = (String) invocable.invokeFunction("getstr", jsstr);
				return new String[] { jsstr, str };
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		log.info("获取动态字符串失败!");
		return new String[] { "", "" };
	}

	// 登录
	private boolean login(String code) {
		List<NameValuePair> lis = new ArrayList<NameValuePair>();
		lis.add(new NameValuePair("loginUserDTO.user_name", pUtl
				.getValue("user")));
		lis.add(new NameValuePair("userDTO.password", pUtl.getValue("pass")));
		lis.add(new NameValuePair("randCode", code));
		// lis.add(new NameValuePair("randCode_validate", ""));
		String[] str = this.getSigByJsStr();
		lis.add(new NameValuePair(str[0], str[1]));
		lis.add(new NameValuePair("myversion", "undefined"));
		LoginCheck lCheck = JSON.parseObject(
				hq.RequestPost(TrainSetCnf.LOGIN_LOGIN, lis), LoginCheck.class);
		if (lCheck.getData()!=null&&"Y".equals(lCheck.getData().getLoginCheck())) {
				return true;
		}
		return false;
	}
}
