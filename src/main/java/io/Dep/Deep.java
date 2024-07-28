package io.Dep;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Deep {
	

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
		
		int rownum=1;
		int counts=0;
		
		XSSFRow row=sheet.createRow(0);
		
		XSSFCell cell=row.createCell(0);
		cell.setCellValue("Directory");
		XSSFCell cell1=row.createCell(1);
		cell1.setCellValue("No of files");
		XSSFCell SizeInBytes=row.createCell(2);
		SizeInBytes.setCellValue("SizeInBytes");
		
		
		/*for(String datas:filedata) {
			if(count==filedata.size()-1) {
				break;
			}
			if(datas.contains("Directory") & !datas.contains("/") ) {
				System.out.println(datas+filedata.get(count+1));
				row=sheet.createRow(rownum++);
				
				cell=row.createCell(0);
				cell.setCellValue(datas.substring(11));
				System.out.println(datas.substring(11, 17));
			}
			
			
			count++;
		}*/
		for (int count = 1; count < filedata.size(); count++) {
		    String datas = filedata.get(count);
		    
		    if (count == filedata.size() - 1) {
		        break;
		    }
		    
		    if (datas.contains("Directory") && !datas.contains("/")) {
		        System.out.println(datas + filedata.get(count + 1));
		        row = sheet.createRow(rownum++);
		        
		         cell = row.createCell(0);
		        cell.setCellValue(datas.substring(11));
		        System.out.println(datas.substring(11, 17));
		        
		        cell1=row.createCell(1);
		        SizeInBytes=row.createCell(2);
		        cell1.setCellValue(filedata.get(count+2).substring(14));
		        SizeInBytes.setCellValue(filedata.get(count+3).substring(14));
		    }
		}

		
		
		File outputfile=new File(excelPath);
		FileOutputStream outputstream=new FileOutputStream(outputfile);
		workbook.write(outputstream);
		outputstream.close();
		System.out.println("data writen succefully");
		
		

	}
	}


