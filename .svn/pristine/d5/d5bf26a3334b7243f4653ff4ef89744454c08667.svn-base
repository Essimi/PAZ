package kr.or.ddit.utils;

import java.io.File;
import java.util.Iterator;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

public class ClassReaderTest {
	public static void main(String[] args) {
		String directoryName = "D:\\A_TeachingMaterial\\7.LastProject\\workspace\\PAZ\\src\\main\\java";
		File directory = new File(directoryName);
		Iterator<File> files =  FileUtils.iterateFiles(directory, new String[] {"java"}, true);
		while(files.hasNext()) {
			File file = files.next();
			if(file.isFile()) {
				String fullFileName = file.toString();
				fullFileName = fullFileName.substring(directoryName.length()+1);
				String path = FilenameUtils.getPath(fullFileName).replaceAll("\\\\", ".");
				System.out.println(path.substring(0, path.length()-1)+"\t"
				+FilenameUtils.getBaseName(fullFileName));
			}

		}
	}
}
