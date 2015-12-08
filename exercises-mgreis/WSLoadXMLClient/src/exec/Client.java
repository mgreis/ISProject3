package exec;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import artifact.LoadXML;
import artifact.LoadXMLService;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LoadXMLService as = new LoadXMLService();
		LoadXML asp = as.getLoadXMLPort();
		asp.loadXML(readFile("exp.xml"));
	}

	static String readFile(String path) {
		byte[] encoded = null;
		try {
			encoded = Files.readAllBytes(Paths.get(path));
		} catch (IOException e) {
			System.out.println("Error reading file.");
			e.printStackTrace();
		}
		return new String(encoded, StandardCharsets.UTF_8);
	}
}