package org.senssic.bean.remticket;

import java.util.List;

public class Data {
	
	
	private List<Info> datas;
	private String searchDate;
	private boolean flag;

	public List<Info> getDatas() {
		return datas;
	}

	public void setDatas(List<Info> datas) {
		this.datas = datas;
	}

	public String getSearchDate() {
		return searchDate;
	}

	public void setSearchDate(String searchDate) {
		this.searchDate = searchDate;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
}
