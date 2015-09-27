package ssdata;
import java.util.GregorianCalendar;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlTransient
public abstract class SSBase {
	private String description;
	private GregorianCalendar beginDate;
	private GregorianCalendar endDate;
	
	
	@XmlElement(name = "description")
	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
	
	public GregorianCalendar getBeginDate() {
		return beginDate;
	}
	
	@XmlElement(name = "beginDate")
	public void setBeginDate(GregorianCalendar beginDate) {
		this.beginDate = beginDate;
	}

	public GregorianCalendar getEndDate() {
		return endDate;
	}
	
	@XmlElement(name = "endDate")
	public void setEndDate(GregorianCalendar endDate) {
		this.endDate = endDate;
	}
}
