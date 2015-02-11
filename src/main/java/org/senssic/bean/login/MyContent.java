package org.senssic.bean.login;

import java.util.List;

public class MyContent {
	List<Info> info;

	@Override
	public String toString() {
		String string = "姓名\t" + "证件类型\t" + "证件号码\t" + "手机/电话\t" + "旅客类型\t"
				+ "核验状态";
		for (Info inf : info) {
			string += "\n"+inf.getPassenger_name() + "\t"
					+ inf.getPassenger_id_type_name() + "\t"
					+ inf.getPassenger_id_no() + "\t" + inf.getMobile_no()
					+ "\t" + inf.getPassenger_type_name() + "\t\t"
					+ ("98".equals(inf.getTotal_times()) ? "未核验" : "已核验");
		}
		return string;
	}

	public List<Info> getInfo() {
		return info;
	}

	public void setInfo(List<Info> info) {
		this.info = info;
	}
}
