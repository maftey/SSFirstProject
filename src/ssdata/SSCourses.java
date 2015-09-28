package ssdata;
import java.util.LinkedHashSet;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Courses")
public class SSCourses {
	private LinkedHashSet<SSCourse> courses;

	public LinkedHashSet<SSCourse> getCourse() {
		return courses;
	}

	@XmlElement(name = "Course")
	public void setCourse(LinkedHashSet<SSCourse> course) {
		this.courses = course;
	}

	public void add(SSCourse course){
		courses.add(course);
	}
}
