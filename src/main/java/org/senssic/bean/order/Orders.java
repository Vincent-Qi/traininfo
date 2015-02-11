package org.senssic.bean.order;

import java.util.List;

public class Orders {
	private String validateMessagesShowId;
	private boolean status;
	private int httpstatus;
	private Data data;
	private List<String> messages;
	private Object validateMessages;

	@Override
	public String toString() {
		String string = "订单号:\t\t" + "订单日期：\t\t" + "车次信息：\t\t\t\t" + "席位信息\t\t\t\t"
				+ "旅客信息\t\t\t\t" + "票款金额\t\t\t\t" + "车票状态";
		for (Info inf : data.getOrderDTODataList()) {
			string += "\n"+inf.getSequence_no() + "\t" + inf.getOrder_date() + "\t"
					+ inf.getStart_train_date_page() + "*"
					+ inf.getTrain_code_page() + "*"
					+ inf.getFrom_station_name_page().get(0) + "->"
					+ inf.getTo_station_name_page().get(0) + "\t"
					+ inf.getTickets().get(0).getCoach_name() + "车厢 ^"
					+ inf.getTickets().get(0).getSeat_name() + "^"
					+ inf.getTickets().get(0).getSeat_type_name()
					+"\t"+inf.getTickets().get(0).getPassengerDTO().getPassenger_name()+"^"
					+inf.getTickets().get(0).getPassengerDTO().getPassenger_id_type_name()
					+"\t"+inf.getTickets().get(0).getTicket_type_name()+"^"+inf.getTickets().get(0).getStr_ticket_price_page()+"\t"
					+inf.getTickets().get(0).getTicket_status_name();
			
		}
		return string;
	}

	public String getValidateMessagesShowId() {
		return validateMessagesShowId;
	}

	public void setValidateMessagesShowId(String validateMessagesShowId) {
		this.validateMessagesShowId = validateMessagesShowId;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getHttpstatus() {
		return httpstatus;
	}

	public void setHttpstatus(int httpstatus) {
		this.httpstatus = httpstatus;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

	public Object getValidateMessages() {
		return validateMessages;
	}

	public void setValidateMessages(Object validateMessages) {
		this.validateMessages = validateMessages;
	}

}
