package sample;

import java.io.*;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

public class logic {
    public static String passs;
    public static String logg;
    public static String dataQ[] = {"","","","","",""};
    public static boolean ent = false;
    public static boolean log = true;
    public static boolean errsmena = false;
    public static boolean errsmena2 = false;
    public static void enter(String log, String pass) throws IOException {
        FileInputStream inputStream = new FileInputStream(new File("D:/IdeaProjects/Lab2OIB/sec.xls"));
        HSSFWorkbook secur = new HSSFWorkbook(inputStream);
        HSSFSheet mySheet = secur.getSheet("data");
        HSSFRow row = mySheet.getRow(0);
        int i = 0;
        while(mySheet.getRow(i).getCell(0).toString().length()>0){
            passs = mySheet.getRow(i).getCell(2).toString();
            logg = mySheet.getRow(i++).getCell(1).toString();
            if (log.equals(logg) && pass.equals(passs)){
                ent = true;
                break;
            }else ent = false;
        }

        secur.close();
    }
    public static void logincheck(String logi) throws IOException {
        FileInputStream inputStream = new FileInputStream(new File("D:/IdeaProjects/Lab2OIB/sec.xls"));
        HSSFWorkbook secur = new HSSFWorkbook(inputStream);
        HSSFSheet mySheet = secur.getSheet("data");
        for (int i = 0; i < mySheet.getLastRowNum();i++){
            logg = mySheet.getRow(i).getCell(1).toString();
            if (logi.equals(logg)){
                log = false;
                break;
            }
        }

        secur.close();
    }
    public static boolean ispass(String pas, String data){
        if (pas.length()!=8){
            return false;
        }
        if (pas.replaceAll("\\p{Punct}|\\d","").length()>0){
            return false;
        }
        if ((pas.replaceAll("\\.|/","")).contains(data.replaceAll("\\.|/",""))){
            return false;
        }
        return true;
    }
    public static void reg(String log, String pass, String name, String lastname, String postname, String data, String place, String tel) throws IOException {
        FileInputStream inputStream = new FileInputStream(new File("D:/IdeaProjects/Lab2OIB/sec.xls"));
        HSSFWorkbook secur = new HSSFWorkbook(inputStream);
        HSSFSheet mySheet = secur.getSheet("data");
        //System.out.print(mySheet.getLastRowNum());
        HSSFRow row = mySheet.getRow(mySheet.getLastRowNum());
        String dats[] = {log,pass,name,lastname,postname,data,place,tel};
        HSSFCell cell = row.getCell(0);
        cell.setCellValue(mySheet.getRow(mySheet.getLastRowNum()-1).getCell(0).getNumericCellValue() + 1);
        for (int i = 1; i< 9;i++){
            cell = row.createCell(i, CellType.STRING);
            cell.setCellValue(dats[i-1]);
        }
        cell =  mySheet.createRow(mySheet.getLastRowNum()+1).createCell(0, CellType.NUMERIC);
        cell.setCellValue(1);
        inputStream.close();
        FileOutputStream out = new FileOutputStream(new File("D:/IdeaProjects/Lab2OIB/sec.xls"));
        secur.write(out);
        out.close();
        secur.close();
    }
    public static void fillent(String logi) throws IOException {
        FileInputStream inputStream = new FileInputStream(new File("D:/IdeaProjects/Lab2OIB/sec.xls"));
        HSSFWorkbook secur = new HSSFWorkbook(inputStream);
        HSSFSheet mySheet = secur.getSheet("data");
        int o = 0;
        for (int i = 0; i < mySheet.getLastRowNum();i++){
            if (logi.equals(mySheet.getRow(i).getCell(1).toString())){
                o = i;
                break;
            }
        }
        HSSFRow row = mySheet.getRow(o);
        for (int i = 3; i< 9; i++){
            dataQ[i-3]=row.getCell(i).toString();
        }

        inputStream.close();
        secur.close();
    }
    public static void smena(String logi, String pas0,String pas1) throws IOException{
        errsmena = false;
        errsmena2 = false;
        FileInputStream inputStream = new FileInputStream(new File("D:/IdeaProjects/Lab2OIB/sec.xls"));
        HSSFWorkbook secur = new HSSFWorkbook(inputStream);
        HSSFSheet mySheet = secur.getSheet("data");
        int o = 0;
        for (int i = 0; i < mySheet.getLastRowNum();i++){
            if (logi.equals(mySheet.getRow(i).getCell(1).toString())){
                o = i;
                break;
            }
        }
        HSSFCell cell = mySheet.getRow(o).getCell(2);
        if (ispass(pas1,mySheet.getRow(o).getCell(6).toString())){
            if (pas0.equals(cell.toString())){
                cell.setCellValue(pas1);
            }else {
                errsmena2 = true;
            }
        }else{
            //пароль не подходит под условие
            errsmena = true;

        }
        FileOutputStream out = new FileOutputStream(new File("D:/IdeaProjects/Lab2OIB/sec.xls"));
        secur.write(out);
        inputStream.close();
        out.close();
        secur.close();
    }

}
