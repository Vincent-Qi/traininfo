package org.senssic.bean.order;

import java.util.List;

public class Data {
	private String order_total_number;
	private List<Info> OrderDTODataList;

	public String getOrder_total_number() {
		return order_total_number;
	}

	public void setOrder_total_number(String order_total_number) {
		this.order_total_number = order_total_number;
	}

	public List<Info> getOrderDTODataList() {
		return OrderDTODataList;
	}

	public void setOrderDTODataList(List<Info> orderDTODataList) {
		OrderDTODataList = orderDTODataList;
	}
}
