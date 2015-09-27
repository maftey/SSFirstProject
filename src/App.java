import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.google.gson.Gson;

import ssdata.*;


public class App {

	public static void main(String[] args) {
		//TODO: delete(fill for test)
		SSLesson javaLesson1 = new SSLesson();
		javaLesson1.setDescription("First lesson");
		javaLesson1.setText("This is my first lesson");
		javaLesson1.setBeginDate(new GregorianCalendar(2015, Calendar.SEPTEMBER, 22));
		javaLesson1.setEndDate(new GregorianCalendar(2015, Calendar.OCTOBER, 1));
		
		
		SSLesson javaLesson2 = new SSLesson();
		javaLesson2.setDescription("Second lesson");
		javaLesson2.setText("This is my Second lesson");
		javaLesson2.setBeginDate(new GregorianCalendar(2015, Calendar.OCTOBER, 2));
		javaLesson2.setEndDate(new GregorianCalendar(2015, Calendar.OCTOBER, 21));
		
		SSCourseModule javaModule1 = new SSCourseModule();
		javaModule1.setDescription("First module1");
		ArrayList<SSLesson> javaModuleLessons = new ArrayList<SSLesson>();
		javaModuleLessons.add(javaLesson1);
		javaModuleLessons.add(javaLesson2);
		javaModule1.setLessons(javaModuleLessons);
		javaModule1.setBeginDate(new GregorianCalendar(2015, Calendar.SEPTEMBER, 22));
		javaModule1.setEndDate(new GregorianCalendar(2015, Calendar.OCTOBER, 21));
		
		//
		SSLesson javaLesson3 = new SSLesson();
		javaLesson3.setDescription("3 lesson");
		javaLesson3.setText("This is my 3 lesson");
		javaLesson3.setBeginDate(new GregorianCalendar(2015, Calendar.OCTOBER, 22));
		javaLesson3.setEndDate(new GregorianCalendar(2015, Calendar.DECEMBER, 1));
		
		SSLesson javaLesson4 = new SSLesson();
		javaLesson4.setDescription("4 lesson");
		javaLesson4.setText("This is my 4 lesson");
		javaLesson4.setBeginDate(new GregorianCalendar(2015, Calendar.DECEMBER, 2));
		javaLesson4.setEndDate(new GregorianCalendar(2015, Calendar.DECEMBER, 22));
		
		SSCourseModule javaModule2 = new SSCourseModule();
		javaModule2.setDescription("Second module1");
		ArrayList<SSLesson> javaModuleLessons2 = new ArrayList<SSLesson>();
		javaModuleLessons2.add(javaLesson3);
		javaModuleLessons2.add(javaLesson4);
		javaModule2.setLessons(javaModuleLessons2);
		javaModule2.setBeginDate(new GregorianCalendar(2015, Calendar.OCTOBER, 22));
		javaModule2.setEndDate(new GregorianCalendar(2015, Calendar.DECEMBER, 22));
		//
		
		SSCourse javaCourse = new SSCourse();
		javaCourse.setDescription("Java Course");
		ArrayList<SSCourseModule> javaModules = new ArrayList<SSCourseModule>();
		javaModules.add(javaModule1);
		javaModules.add(javaModule2);
		javaCourse.setModules(javaModules);
		javaCourse.setBeginDate(new GregorianCalendar(2015, Calendar.SEPTEMBER, 22));
		javaCourse.setEndDate(new GregorianCalendar(2015, Calendar.DECEMBER, 22));
		//
		SSCourses courses = new SSCourses();
		ArrayList<SSCourse> coursesList = new ArrayList<SSCourse>();
		coursesList.add(javaCourse);
		courses.setCourse(coursesList);
		
		/*try {
			JAXBContext jaxbContext = JAXBContext.newInstance(SSCourses.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );
			jaxbMarshaller.marshal( courses, System.out );
			jaxbMarshaller.marshal( courses, new File("data.xml") );
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		Gson gson = new Gson();
		String jsonCourses = gson.toJson(courses);
		System.out.println(jsonCourses);
		
		System.out.println("writed, read:");
		
		SSCourses readenCourses = new SSCourses();
		readenCourses = gson.fromJson(jsonCourses, SSCourses.class);
		System.out.println(gson.toJson(readenCourses));
		/*File data = new File("data.xml");
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(SSCourses.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			readenCourses = (SSCourses) jaxbUnmarshaller.unmarshal(data);
			
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );
			jaxbMarshaller.marshal( readenCourses, System.out );
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	}

}
