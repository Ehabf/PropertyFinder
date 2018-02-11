package helper;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToTextFile {

	// private static final String FILENAME = "D:\\test\\filename.txt";

	public static void main(String info, String location) {

		BufferedWriter bw = null;
		FileWriter fw = null;

		try {

			fw = new FileWriter(location);
			bw = new BufferedWriter(fw);
			bw.write(info);

			System.out.println("Done");

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}

	}

}
