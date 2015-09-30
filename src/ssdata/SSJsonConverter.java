package ssdata;

import com.google.gson.Gson;

public class SSJsonConverter implements SSDataConverterInterface {
	private Gson gson = new Gson();
	@Override
	public <T> String marshal(T db) {
		return gson.toJson(db);// TODO: check if error then return null
	}

	@Override
	public <T> T unmarshal(String text, Class<T> structure) {
		return gson.fromJson(text, structure);// TODO: check if error then
												// return null
	}
}
