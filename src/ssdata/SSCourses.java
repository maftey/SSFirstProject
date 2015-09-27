package ssdata;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Courses")
public class SSCourses {
	private List<SSCourse> course;

	public List<SSCourse> getCourse() {
		return course;
	}

	@XmlElement(name = "Course")
	public void setCourse(List<SSCourse> course) {
		this.course = course;
	}

}
