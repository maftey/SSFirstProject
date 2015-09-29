package ssdata;

import java.io.File;

/**
 * 
 * interface for classes which convert our data
 * 
 * @author maftey
 *
 */
public interface SSDb {

	/**
	 * 
	 * @param structura
	 *            with data
	 * @param file
	 * @return if successful then return true else false
	 */
	<T> boolean saveToFile(T db, /* Class<T> structure, */File file);

	/**
	 * 
	 * @param file
	 * @param structure
	 * @return if successful then return structure with data else null
	 */
	<T> T readFromFile(File file, Class<T> structure);

	/**
	 * 
	 * @param db
	 * @return if successful then return json text else null
	 */
	<T> String marshal(T db/* , Class<T> structure */);

	/**
	 * 
	 * @param text
	 * @param structure
	 * @return if successful then return structure with data else null
	 */
	<T> T unmarshal(String text, Class<T> structure);
}
