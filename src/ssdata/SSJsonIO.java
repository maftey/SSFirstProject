package ssdata;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;

public class SSJsonIO implements SSIOInterface {
	private Gson gson = new Gson();

	@Override
	public <T> boolean saveToFile(T db, File file) {
		String jspnText = gson.toJson(db);

		try {
			FileWriter writer = new FileWriter(file);
			writer.write(jspnText);
			writer.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public <T> T readFromFile(File file, Class<T> structure) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			return (T) gson.fromJson(br, structure); // TODO: check if error then
													// return null
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	

}
