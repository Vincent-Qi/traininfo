package org.senssic.bean.order;

public class StationDTO {
	private Object trainDTO;
	private String station_train_code;
	private String from_station_telecode;
	private String from_station_name;
	private String start_time;
	private String to_station_telecode;
	private String to_station_name;
	private String arrive_time;
	private String distance;

	public Object getTrainDTO() {
		return trainDTO;
	}

	public void setTrainDTO(Object trainDTO) {
		this.trainDTO = trainDTO;
	}

	public String getStation_train_code() {
		return station_train_code;
	}

	public void setStation_train_code(String station_train_code) {
		this.station_train_code = station_train_code;
	}

	public String getFrom_station_telecode() {
		return from_station_telecode;
	}

	public void setFrom_station_telecode(String from_station_telecode) {
		this.from_station_telecode = from_station_telecode;
	}

	public String getFrom_station_name() {
		return from_station_name;
	}

	public void setFrom_station_name(String from_station_name) {
		this.from_station_name = from_station_name;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getTo_station_telecode() {
		return to_station_telecode;
	}

	public void setTo_station_telecode(String to_station_telecode) {
		this.to_station_telecode = to_station_telecode;
	}

	public String getTo_station_name() {
		return to_station_name;
	}

	public void setTo_station_name(String to_station_name) {
		this.to_station_name = to_station_name;
	}

	public String getArrive_time() {
		return arrive_time;
	}

	public void setArrive_time(String arrive_time) {
		this.arrive_time = arrive_time;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}
}
