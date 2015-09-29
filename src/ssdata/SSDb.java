package ssdata;

import java.io.File;

/**
 * 
 * interface for classes which convert our data
 * @author maftey
 *
 */
public interface SSDb {
	
	/**
	 * 
	 * @param structura with data
	 * @param file
	 * @return if successful then return true else false
	 */
	 public <T> boolean saveToFile(T db, /*Class<T> structure,*/ File file);
	 
	 /**
	  * 
	  * @param file
	  * @param structure
	  * @return if successful then return structure with data else null
	  */
	 public <T> T readFromFile(File file, Class<T> structure);
	 
	 /**
	  * 
	  * @param db
	  * @return if successful then return json text else null
	  */
	 public <T> String marshal(T db/*, Class<T> structure*/);
	 
	 /**
	  * 
	  * @param text
	  * @param structure
	  * @return if successful then return structure with data else null
	  */
	 public <T> T unmarshal(String text, Class<T> structure);
}
