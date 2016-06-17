package com.example.didier.unittests.kanjivg;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

/**
 * Created by didier on 6/17/16.
 */
@RunWith(Parameterized.class)
public class KanjiVGHelperTest {
	private String folderPath;

	public KanjiVGHelperTest(String folderPath){
		this.folderPath = folderPath;
	}

	@Parameters
	public static List<Object[]> params(){
		return Arrays.asList(new Object[][]{
				{"/home/didier/Projects/kanjivg/kanji"} // The folder containing the SVG files.
		});
	}

	@Test
	public void generateStrokesTest(){
		File folder = new File(this.folderPath);
		if(folder.exists()){
			for(final File file : folder.listFiles()){
				if(file.canRead()){
					try{
						// Getting the codepoint.
						String hexCodepoint = file.getName().substring(0, file.getName().indexOf('.'));
						int dashIndex = hexCodepoint.indexOf('-');
						if(dashIndex > 0){
							hexCodepoint = hexCodepoint.substring(0, dashIndex);
						}
						int codepoint = Integer.parseInt(hexCodepoint, 16);

						// Getting the paths.
						System.out.println("[" +codepoint +"]");
						String content = this.readFile(file);
						String strPaths = this.getPaths(content);

					}catch(Exception e){
						e.printStackTrace();
					}
				}
			}
		}
	}

	private String readFile(File file) throws IOException {
		InputStream in = new FileInputStream(file);
		byte[] b = new byte[(int) file.length()];
		int len = b.length;
		int total = 0;

		while (total < len) {
			int result = in.read(b, total, len - total);
			if (result == -1) {
				break;
			}
			total += result;
		}

		in.close();

		return new String(b).trim();
	}

	private String getPaths(String content){
		// TODO: Implement me!
		return "";
	}
}
