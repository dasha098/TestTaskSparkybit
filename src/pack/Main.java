package pack;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		List<String>list=new ArrayList<>();
		List<String>reversList=new ArrayList<String>();
		File outputFile = new File("src/pack/outputText.txt");
		FileWriter fw = new FileWriter(outputFile);
		File inputFile = new File("src/pack/inputText.txt");
		FileReader fr = new FileReader(inputFile);
		BufferedReader reader = new BufferedReader(fr);
		int num=1;
		String line = null;
		while((line = reader.readLine())!=null) {
			list.add(line);
		}
		reader.close();
		for (int i = 0; i < list.size(); i++) {
			if (i+1==findFibonacciByNum(num)) { //сравнение порядкового номера строки с числом фибоначчи под таким же номером
				reversList.add(reverseRow(list.get(i)));
				num++;
			}
		}

		for (int i = 0; i < reversList.size(); i++) {
			fw.write(reversList.get(i)+"\n");
		}
		fw.close();
		
	}
	//метод инверсии строки by charAt()
	public static String reverseRow(String row) { 
		int rowLength = row.length();
		String resultRow = "";
		for(int i = 0; i <rowLength; i++) {
			resultRow = row.charAt(i) + resultRow;
		}
		return resultRow;
	}
	//рекурсивный метод поиска n-го элемента Фибоначчи
	private static int findFibonacciByNum(int n) {
		if(n==1)
			return 1;
		if(n==2)
			return 2;
		return findFibonacciByNum(n-1)+findFibonacciByNum(n-2);
	}

}
