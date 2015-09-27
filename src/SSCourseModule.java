import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"description", "lessons"})
@XmlRootElement(name = "module")
public class SSCourseModule {
	
	
	private String description;
	private List<SSLesson> lessons;
	
	
	@XmlElement(name = "description")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<SSLesson> getLessons() {
		return lessons;
	}
	@XmlElementWrapper( name="lessons" )
	@XmlElement(name = "lesson")
	public void setLessons(List<SSLesson> lessons) {
		this.lessons = lessons;
	}
}
