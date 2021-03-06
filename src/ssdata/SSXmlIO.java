package ssdata;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class SSXmlIO implements SSIOInterface {

	@Override
	public <T> boolean saveToFile(T db, /* Class<T> structure, */File file) {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(db.getClass());
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(db, file);

			return true;
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public <T> T readFromFile(File file, Class<T> structure) {

		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(structure);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			return (T) jaxbUnmarshaller.unmarshal(file);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	

}
