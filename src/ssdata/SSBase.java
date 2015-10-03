package ssdata;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlTransient
public abstract class SSBase {
	protected String name;
	private String description;
	private Calendar beginDate;
	private Calendar endDate;

	@XmlElement(name = "description")
	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public Calendar getBeginDate() {
		return beginDate;
	}

	@XmlElement(name = "beginDate")
	public void setBeginDate(Calendar beginDate) {
		this.beginDate = beginDate;
	}

	public Calendar getEndDate() {
		return endDate;
	}

	@XmlElement(name = "endDate")
	public void setEndDate(Calendar endDate) {
		this.endDate = endDate;
	}

	public String getName() {
		return name;
	}

	@XmlElement(name = "name")
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	
	public boolean isContinues() {
		GregorianCalendar now = new GregorianCalendar();
		return now.after(beginDate) && now.before(endDate);
		
	}

	// TODO: maybe move it in child classes
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof SSBase))
			return false;
		SSBase other = (SSBase) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
