package io.Dep;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;
import org.apache.*;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Ddeep {

	public static void main(String[] args) throws Exception{
		ArrayList<String> filedata=new ArrayList<>();
		String FilePath="E:\\Arshadalee\\Testing\\Java\\PorjectWork\\output.txt";
		
		String excelPath="E:\\Arshadalee\\Testing\\Java\\PorjectWork\\output.xlsx";
		
		try {
			
			
			File op=new File(FilePath);
			
			Scanner sc=new Scanner(op);
			
			while(sc.hasNextLine()){
				String data=sc.nextLine();
				filedata.add(data);
				//System.out.println(data);
				
			}
			System.out.println(filedata);
			
			sc.close();
		
		
		

	}catch(FileNotFoundException e) {
		System.out.println("error file not found");
		e.printStackTrace();
	}
		
		
		XSSFWorkbook workbook=new XSSFWorkbook();
		XSSFSheet sheet=workbook.createSheet("Ddeep");
		
		int rownum=0;
		int count=0;
		
		for(String datas:filedata) {
			if(count==filedata.size()-1) {
				break;
			}
			if(datas.contains("Directory") & !datas.contains("/") ) {
				System.out.println(datas+filedata.get(count+1));
				XSSFRow row=sheet.createRow(rownum++);
				
				XSSFCell cell=row.createCell(0);
				cell.setCellValue(datas.substring(11));
				System.out.println(datas.substring(11, 17));
			}
			
			
			count++;
		}
		
		File outputfile=new File(excelPath);
		FileOutputStream outputstream=new FileOutputStream(outputfile);
		workbook.write(outputstream);
		outputstream.close();
		System.out.println("datawriten succefully");
		
		

	}
}
