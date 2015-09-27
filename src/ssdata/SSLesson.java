package ssdata;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlType(propOrder = {"description", "beginDate", "endDate", "text"})
@XmlRootElement(name = "Lesson")
public class SSLesson extends SSBase{
	
	private String text;
	
	
	public String getText() {
		return text;
	}
	@XmlElement(name = "text")
	public void setText(String text) {
		this.text = text;
	}
}
