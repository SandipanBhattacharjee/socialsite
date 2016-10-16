package sf.crom.restservice.bean;

import javax.ws.rs.QueryParam;

public class MessageParamBean {

	@QueryParam(value = "year") int year;
	@QueryParam(value = "start") int start;
	@QueryParam(value = "size") int size;
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	
}
