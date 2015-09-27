package ssdata;
import java.util.List;
//import javax.xml.bind.J






import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
//import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"description", "beginDate", "endDate", "modules"})
//@XmlRootElement(name = "Course")
public class SSCourse extends SSBase{
	private List<SSCourseModule> modules;
	
	public List<SSCourseModule> getModules() {
		return modules;
	}
	
	@XmlElementWrapper( name="modules" )
	@XmlElement(name = "module")
	public void setModules(List<SSCourseModule> modules) {
		this.modules = modules;
	}
	
	
}


