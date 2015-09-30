package ssdata;

import java.io.File;

/**
 * 
 * interface for classes which convert and save in file our data
 * 
 * @author Maftey
 *
 */
public interface SSIOInterface {

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
}
