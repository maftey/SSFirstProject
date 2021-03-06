package ssdata;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class SSXMLConverter implements SSDataConverterInterface {
	@Override
	public <T> String marshal(T db/* , Class<T> structure */) {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(db.getClass());
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			StringWriter w = new StringWriter();
			jaxbMarshaller.marshal(db, w);

			return w.toString();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public <T> T unmarshal(String text, Class<T> structure) {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(structure);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			return (T) jaxbUnmarshaller.unmarshal(new StringReader(text));
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
