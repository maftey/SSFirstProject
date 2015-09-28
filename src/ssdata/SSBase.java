package ssdata;
import java.util.GregorianCalendar;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlTransient
public abstract class SSBase {
	protected String name;
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

	//TODO: maybe move it in child classes
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
