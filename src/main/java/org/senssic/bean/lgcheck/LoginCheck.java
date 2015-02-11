package org.senssic.bean.lgcheck;

public class LoginCheck {
	private String validateMessagesShowId;
	private boolean status;
	private String httpstatus;
	private Info data;
	private String messages;
	private String validateMessages;

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

	public String getHttpstatus() {
		return httpstatus;
	}

	public void setHttpstatus(String httpstatus) {
		this.httpstatus = httpstatus;
	}

	public Info getData() {
		return data;
	}

	public void setData(Info data) {
		this.data = data;
	}

	public String getMessages() {
		return messages;
	}

	public void setMessages(String messages) {
		this.messages = messages;
	}

	public String getValidateMessages() {
		return validateMessages;
	}

	public void setValidateMessages(String validateMessages) {
		this.validateMessages = validateMessages;
	}

}
