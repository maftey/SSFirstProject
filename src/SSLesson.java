import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlType(propOrder = {"description", "text"})
//@XmlRootElement(name = "Lesson")
public class SSLesson extends SSBase{
	private String description;
	private String text;
	
	public String getDescription() {
		return description;
	}
	
	@XmlElement(name = "description")
	public void setDescription(String description) {
		this.description = description;
	}
	public String getText() {
		return text;
	}
	@XmlElement(name = "text")
	public void setText(String text) {
		this.text = text;
	}
}
