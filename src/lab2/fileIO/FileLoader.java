package lab2.fileIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import lab2.common.ItemAuction;

//Singleton Implementation to ensure only one instance of this class is created
public class FileLoader {
	
	private static FileLoader fileLoader;
	@SuppressWarnings("unused")
	private ArrayList<ItemAuction> auctionList;
	
	private FileLoader() {
		if(firstNames == null) {
			System.out.println("Initializing DOJ Interactions FileLoader....");
			firstNames = readFile("src/dojinteractions/resources/textfiles/firstnames.txt");
			lastNames = readFile("src/dojinteractions/resources/textfiles/lastnames.txt");
			pastReports = readFile("src/dojinteractions/resources/textfiles/reports.txt");
			System.out.println("FileLoader proccess complete");
		}
		else {
			System.out.println("New FileLoader initiated, file data already loaded");
		}
	}
	//Reads file, returns ArrayList with each line
	private ArrayList<String> readFile(String fileName) {
		ArrayList<String> holder = new ArrayList<String>();
		try {
			File file = new File(fileName);
			Scanner reader = new Scanner(file);
			while(reader.hasNextLine()) {
				holder.add(reader.nextLine().replaceAll("\\s+",""));
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return holder;
	}
	public ArrayList<auctionList> getList(){
		
	}
	public static FileLoader getInstance() {
		if(fileLoader == null) {
			fileLoader = new FileLoader();
		}
		return fileLoader;
	}
}
