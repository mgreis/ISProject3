package exec;

import java.io.IOException;
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
		String r = asp.loadXML(readFile("sample.xml"));
		System.out.println(r);
	}

	static String readFile(String path) {
		byte[] encoded = null;
		try {
			encoded = Files.readAllBytes(Paths.get(path));
		} catch (IOException e) {
			System.out.println("Error reading file.");
			e.printStackTrace();
		}
		String aux = new String(encoded);
		return aux;
	}
}