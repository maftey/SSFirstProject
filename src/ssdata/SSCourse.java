package ssdata;

import java.util.LinkedHashSet;
//import javax.xml.bind.J

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
//import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "name", "description", "beginDate", "endDate", "modules" })
// @XmlRootElement(name = "Course")
public class SSCourse extends SSBase {
	private LinkedHashSet<SSCourseModule> modules;

	public LinkedHashSet<SSCourseModule> getModules() {
		return modules;
	}

	@XmlElementWrapper(name = "modules")
	@XmlElement(name = "module")
	public void setModules(LinkedHashSet<SSCourseModule> modules) {
		this.modules = modules;
	}

	public void add(SSCourseModule module) {
		if (modules == null) modules = new  LinkedHashSet<SSCourseModule>();
		modules.add(module);
	}
}
