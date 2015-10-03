package ssdata;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.LinkedHashSet;

import static ssdata.SSSpecFormatReader.FieldsName.*;

//Type = {C/Course, M/Module, L/Lesson}
//{"Type", "name", "description", "beginDate", "endDate", "address"}//format for Course, Module
//{"Type", "name", "description", "beginDate", "endDate", "address", "text"}//format for Lesson
public class SSSpecFormatReader {
	private SSCourses courses = new SSCourses();;
	
	class FieldsName {
		static final int TYPE = 0;
		static final int NAME = 1;
		static final int DESCRIPTION = 2;
		static final int BEGIN_DATE = 3;
		static final int END_DATE = 4;
		static final int ADDRESS = 5;
		static final int TEXT = 6;
	}
	
	public SSCourses getCourses() {
		return courses;
	}

	public void setCourses(SSCourses courses) {
		this.courses = courses;
	}

	public SSSpecFormatReader() {
	}
	
	public SSSpecFormatReader(SSCourses courses) {
		this.courses = courses;
	}
	
	/**
	 * 
	 * 
	 * @param format:
	 * {"Type", "name", "description", "beginDate", "endDate"} //format for Course
	 * {"Type", "name", "description", "beginDate", "endDate", "address"}//format for Module
	 * {"Type", "name", "description", "beginDate", "endDate", "address", "text"}//format for Lesson
	 * Type = {C/Course, M/Module, L/Lesson}
	 * if address = "" the it in top(Course)
	 * else parent element divadet by .
	 * exemple:
	 * {"C", "Java", "cours obut java", "2015-09-22T00:00:00+03:00", "2015-12-22T00:00:00+02:00", ""}
	 * {"L", "lesons 1", "the lessons 1", "2015-12-22T00:00:00+02:00", "2015-12-22T00:00:00+02:00",
	 *  "Java courses.Module 1", "bla bla bla. bla blal bla"}
	 */
	public String addSSObject(String object){
		//(^[\s]*\{[\s]*\")|(\"[\s]*\}[\s]*$)/g
		//\"[\s]*\,[\s]*\"/g
		//String obj = object.replaceAll("(^[\\s]*\\{[\\s]*\\\")|(\\\"[\\s]*\\}[\\s]*$)", "");//trim with {} and "
		//String fields[] = obj.split("\"[\\s]*\\,[\\s]*\"");
		String fields[] = object.replaceAll("(^[\\s]*\\{[\\s]*\\\")|(\\\"[\\s]*\\}[\\s]*$)", "") //trim with {} and "
								.split("\"[\\s]*\\,[\\s]*\"");
		
		if (fields.length < 5) return "not enough fields";
		//Type
		//(^[c,m,l]$)|(^course$)|(^module$)|(^lesson$)/i
		//String type = fields[0];
		if (!fields[TYPE].toLowerCase().matches("(^[c,m,l]$)|(^course$)|(^module$)|(^lesson$)/i"))	
			return "incorrect type";
		
		//TODO: Maybe forbid variant input of type
		String type;
		if (fields[TYPE].toLowerCase().matches("(^[l]$)|(^lesson$)/i")) {
			type = "L";
		} else if (fields[TYPE].toLowerCase().matches("(^[m]$)|(^module$)/i")) {
			type = "M";
		} else if (fields[TYPE].toLowerCase().matches("(^[c]$)|(^course$)/i")) {
			type = "C";
		} else {
			return "incorrect type";
		}
		
		String name;
		if (!fields[NAME].matches("^[^\\}\\\"\\.]+$")) {
			return "incorrect name";
		} 
		
		String description;
		if (!fields[DESCRIPTION].matches("^[^\\}\\\"]+$")) {
			return "incorrect description";
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm"); //2015-09-22 00:00
		GregorianCalendar beginDate;
		if (!fields[BEGIN_DATE].matches("^[0-9]{4}-[0-9]{2}-[0-9]{2} [0-9]{2}:[0-9]{2}$")) { //TODO validation for check number(mounth < 12 and something like that)
			return "incorrect star date";
		} else {
			beginDate = new GregorianCalendar();
			try {
				beginDate.setTime(sdf.parse(fields[BEGIN_DATE]) );
			} catch (ParseException e) {
				return "incorrect star date";
			}
		}
		
		GregorianCalendar endDate;
		if (!fields[END_DATE].matches("^[0-9]{4}-[0-9]{2}-[0-9]{2} [0-9]{2}:[0-9]{2}$")) { //TODO validation for check number(mounth < 12 and something like that)
			return "incorrect finish date";
		} else {
			endDate = new GregorianCalendar();
			try {
				endDate.setTime(sdf.parse(fields[END_DATE]));
			} catch (ParseException e) {
				return "incorrect end date";
			}
		}
		
		SSBase dataObject;
		switch (type) {
		case "C": dataObject = new SSCourse(); break;
		case "M": dataObject = new SSCourseModule(); break;
		case "L": dataObject = new SSLesson(); break;
		default: return "error";
		}
		
		dataObject.setName(fields[NAME]);
		dataObject.setDescription(fields[DESCRIPTION]);
		dataObject.setBeginDate(beginDate);
		dataObject.setEndDate(endDate);
		
		boolean isAdd = false;
		switch (type) {
		case "C":
			courses.add((SSCourse) dataObject);
			isAdd = true;
			break;
		case "M":
		{
			if (fields.length < 6) return "not enough fields";
			if (!fields[ADDRESS].matches("^[^\\.]+$")) {
				return "incorrect address";
			}
			SSCourseModule module = (SSCourseModule) dataObject;
			LinkedHashSet<SSCourse> courses = this.courses.getCourse();
			
			for (SSCourse course: courses) {
				if (fields[ADDRESS].equals(course.getName())) {
					course.add(module);
					isAdd = true;
					break;
				}
			}
			
			
			break;
		}
		case "L":
			SSLesson lesson = (SSLesson) dataObject;
			if (fields.length < 7) return "not enough fields";
			if (!fields[ADDRESS].matches("^[^\\}\\\"\\.]+\\.[^\\}\\\"\\.]+$")) {
				return "incorrect address";
			}
			
			/*if (!fields[TEXT].matches("")) {
				return "incorrect address";
			}*/
			lesson.setName(fields[TEXT]);
			
			String[] adress = fields[ADDRESS].split("\\.");
			
			LinkedHashSet<SSCourse> courses = this.courses.getCourse();
			
			findPlaceLabel:
			for (SSCourse course: courses) {
				if (adress[0].equals(course.getName())) {
					LinkedHashSet<SSCourseModule> modules = course.getModules();
					for (SSCourseModule module: modules) {
						if (adress[1].equals(module.getName())) {
							module.add(lesson);
							isAdd = true;
							break findPlaceLabel;
						}
					}
				}
			}
			
			break;
		}
		
		if (!isAdd) {
			return "incorrect address";
		}
				
		
		//System.out.println(obj);
		return "OK";
	}
	//public void addSSObjects(String object){}
	//public void addSSObjects(String[] object){}
}
