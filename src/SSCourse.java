import java.util.List;
//import javax.xml.bind.J



import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"description", "modules"})
@XmlRootElement(name = "Course")
public class SSCourse {
	private String description;
	private List<SSCourseModule> modules;
	
	public String getDescription() {
		return description;
	}
	@XmlElement(name = "description")
	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<SSCourseModule> getModules() {
		return modules;
	}
	
	@XmlElementWrapper( name="modules" )
	@XmlElement(name = "module")
	public void setModules(List<SSCourseModule> modules) {
		this.modules = modules;
	}
	
	
}


