package ssdata;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashSet;
import java.util.List;

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

	public void add(SSCourse course) {
		if (courses == null) courses = new LinkedHashSet<SSCourse>();
		courses.add(course);
	}
	
	public List<SSCourse> getStartedCourses(Calendar start, Calendar end) {
		ArrayList<SSCourse> list = new ArrayList<SSCourse>();
		
		for(SSCourse course : courses){
			if( start.before(course.getBeginDate()) && 
				end.after(course.getBeginDate())
			) list.add(course);
		}
		
		return list;
	}
}
