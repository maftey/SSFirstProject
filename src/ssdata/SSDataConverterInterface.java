package ssdata;

public interface SSDataConverterInterface {
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
