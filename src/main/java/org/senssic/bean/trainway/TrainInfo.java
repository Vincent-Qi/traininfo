package org.senssic.bean.trainway;

import java.util.List;
/**
 * 车次信息
 * @author qiss
 *
 */
public class TrainInfo {
	private Data data;
	private int httpstatus;
	private List<String> messages;
	private boolean status;
	private Object validateMessages;
	private String validateMessagesShowId;

	
	
	@Override
	public String toString() {
		StringBuilder sbBuilder = new StringBuilder(
				"站序\t站名\t到站时间\t出发时间\t停留时间\n");

		for (Info inf : data.getData()) {
			sbBuilder.append(inf.getStation_no() + "\t" + inf.getStation_name()
					+ "\t" + inf.getArrive_time() + "\t\t"
					+ inf.getStart_time() + "\t\t" + inf.getStopover_time()
					+ "\n");
		}
		return sbBuilder.toString();
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
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

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Object getValidateMessages() {
		return validateMessages;
	}

	public void setValidateMessages(Object validateMessages) {
		this.validateMessages = validateMessages;
	}

	public String getValidateMessagesShowId() {
		return validateMessagesShowId;
	}

	public void setValidateMessagesShowId(String validateMessagesShowId) {
		this.validateMessagesShowId = validateMessagesShowId;
	}
}
