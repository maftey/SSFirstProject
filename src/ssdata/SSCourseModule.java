package ssdata;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"description", "beginDate", "endDate", "lessons"})
@XmlRootElement(name = "module")
public class SSCourseModule extends SSBase{
	private List<SSLesson> lessons;
	
	public List<SSLesson> getLessons() {
		return lessons;
	}
	@XmlElementWrapper( name="lessons" )
	@XmlElement(name = "lesson")
	public void setLessons(List<SSLesson> lessons) {
		this.lessons = lessons;
	}
}
