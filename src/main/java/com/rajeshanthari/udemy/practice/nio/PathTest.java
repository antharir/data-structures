package com.rajeshanthari.udemy.practice.nio;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;

public class PathTest {
	private static final String DIRECTORY_PATH = "C:\\Users\\ranthari\\Downloads\\AL_FILTER\\";
	private static final String FILE_PATH = "C:\\Users\\ranthari\\Downloads\\xanadu.txt";
	private static final String OUTPUT_PATH = "C:\\Users\\ranthari\\Downloads\\filesystem1223.txt";

	public static void main(String[] args) throws IOException {
		{
			// Path path = Path.of(FILE_PATH);
			// System.out.println(path.getFileName());
			// System.out.println(path);
		}
		{
//			Path inputFile = Paths.get(FILE_PATH);
//			System.out.println(Files.isExecutable(inputFile));
//			System.out.println(Files.isReadable(inputFile));
//			System.out.println(Files.isWritable(inputFile));
//			System.out.println(Files.exists(inputFile));
//			System.out.println(Files.notExists(inputFile));
//			
//			try {
//				Files.delete(inputFile);
//			} catch (NoSuchFileException e) {
//				System.out.format("Missed file %s ", e.getFile());
//			} catch (DirectoryNotEmptyException e) {
//				System.out.format("direct not emply %s ", e.getFile());
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}

		}
		{
//			Path fileToCopy = Path.of(FILE_PATH);
//			Path fileToDirect = Path.of(DIRECTORY_PATH);
//			Files.copy(fileToCopy, fileToDirect, StandardCopyOption.REPLACE_EXISTING);
		}
//		{
//			Path fileToCopy = Path.of(FILE_PATH);
//			BasicFileAttributes readAttributes = Files.readAttributes(fileToCopy, BasicFileAttributes.class);
//			System.out.println(readAttributes.size());
//			Path tempFile = Files.createTempFile(null, ".txt");
//			System.out.println(tempFile);
//		}
		{
//			FileSystems.getDefault().getRootDirectories().forEach(obj -> {
//				try (PrintWriter writer = new PrintWriter(new FileOutputStream(OUTPUT_PATH))) {
//					printData(obj, 0, writer);
//				} catch (FileNotFoundException e) {
//					e.printStackTrace();
//				}
//			});
//			try (PrintWriter writer = new PrintWriter(new FileOutputStream(OUTPUT_PATH))) {
//				printData(Path.of("D:"), 0, writer);
//			} catch (FileNotFoundException e) {
//				e.printStackTrace();
//			}
		}
//		{
//			Path directories = Files.createDirectories(Path.of(DIRECTORY_PATH,"rajesh","anthari","newFolder"));
//			System.out.println(directories);
//		}
		{
			
//			Path destPath = Path.of(DIRECTORY_PATH,"rajesh","anthari","newFolder","newSmb.lnk");
			//Path createSymbolicLink = Files.createSymbolicLink(Path.of(OUTPUT_PATH), Path.of("C:\\Users\\ranthari\\Downloads\\AL_FILTER\\world\\webservices\\java\\webapps\\alfilter","alfilter.war"));
			//System.out.println(createSymbolicLink);
//			Path createLink = Files.createLink(Path.of(OUTPUT_PATH), Path.of("C:\\Users\\ranthari\\Downloads\\AL_FILTER\\world\\webservices\\java\\webapps\\alfilter","alfilter.war"));
//			System.out.println(createLink);
		}
		{
			Path path = Paths.get("C:\\Users\\ranthari\\Downloads\\AL_FILTER\\world\\webservices\\java\\webapps\\alfilter","alfilter.war");
			String contentType = Files.probeContentType(path);
			System.out.println(path);
			System.out.println(contentType);
		}
		{
			// Path inputFile = Paths.get(FILE_PATH);
//			System.out.println(inputFile);
//			System.out.println(inputFile.getFileName());
//			System.out.println(inputFile.getName(0));
//			System.out.println(inputFile.getNameCount());
//			System.out.println(inputFile.subpath(0, 2));
//			System.out.println(inputFile.getParent());
//			System.out.println(inputFile.getRoot());
//			System.out.println(inputFile.toUri());
//			System.out.println(inputFile.resolve("Hello"));
//			System.out.println(inputFile.toRealPath());
		}

	}

	public static void printData(Path path, int indent, PrintWriter writer) {
		printIndent(indent);
		writer.println(path.getFileName());
		System.out.println(path.getFileName());
		if (Files.isDirectory(path)) {
			try {
				Files.list(path).forEach(i -> printData(i, indent + 1, writer));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	static HashMap<Integer, String> indents = new HashMap<>();

	public static void printIndent(int indent) {
		if (indent == 0) {
			return;
		}
		String ind = indents.get(indent);
		if (ind == null) {
			StringBuilder sb = new StringBuilder(indent);
			for (int i = 0; i < indent; i++) {
				sb.append('\t');
			}
			ind = sb.toString();
			indents.put(indent, ind);
		}
		System.out.print(ind);

	}

}
