package org.senssic.bean.remticket;

import java.util.List;
/**
 * 余票
 * @author qiss
 *
 */
public class TicketInfo {
	
	
	private Data data;
	private String validateMessagesShowId;
	private boolean status;
	private int httpstatus;
	List<String> messages;
	Object validateMessages;

	@Override
	public String toString() {
		StringBuilder sBuilder = new StringBuilder(
				"车次\t出发站\t到达站\t出发时间\t到达时间\t历时\t商务座\t特等座\t一等座\t二等座\t高级软卧\t软卧\t硬卧\t软座\t硬座\t无座\t其他\n");
		for (Info inf : data.getDatas()) {
			sBuilder.append(inf.getStation_train_code() + "\t"
					+ inf.getFrom_station_name() + "\t"
					+ inf.getTo_station_name() + "\t" + inf.getStart_time()
					+ "\t" + inf.getArrive_time() + "\t" + inf.getLishi()
					+ "\t" + inf.getSwz_num() + "\t" + inf.getTz_num() + "\t"
					+ inf.getZy_num() + "\t" + inf.getZe_num() + "\t"
					+ inf.getGr_num() + "\t"
					+ inf.getRw_num() + "\t" + inf.getYw_num() + "\t"
					+ inf.getRz_num() + "\t" + inf.getYz_num() + "\t"
					+ inf.getWz_num() + "\t" + inf.getQt_num() + "\n");
		}
		return sBuilder.toString();
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

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}
}
