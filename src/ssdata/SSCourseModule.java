package ssdata;
import java.util.LinkedHashSet;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
//import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"name", "description", "beginDate", "endDate", "lessons"})
//@XmlRootElement(name = "module")
public class SSCourseModule extends SSBase{
	private LinkedHashSet<SSLesson> lessons;
	
	public LinkedHashSet<SSLesson> getLessons() {
		return lessons;
	}
	@XmlElementWrapper( name="lessons" )
	@XmlElement(name = "lesson")
	public void setLessons(LinkedHashSet<SSLesson> lessons) {
		this.lessons = lessons;
	}
	
	public void add(SSLesson lesson){
		lessons.add(lesson);
	}
	
	
}
