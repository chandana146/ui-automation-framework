package stl.ui.automation.framework.base.ui.testdata;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import stl.ui.automation.framework.base.ui.UiFactory;


public class TestDataReadExcel {

  private int[] getRowColumnCount() {
    int[] countArray = new int[2];
    boolean flag = false;
    int columnCount = 0;
    int rowCount = 0;
    try {
      FileInputStream file = new FileInputStream(
          new File(System.getProperty("user.dir") +
              UiFactory.customVar.getVariableMapMap("testdataExcel")));
      XSSFWorkbook workbook = new XSSFWorkbook(file);
      XSSFSheet sheet = workbook.getSheet(UiFactory.customVar.getVariableMapMap("sheet"));
      Iterator<Row> rowIterator = sheet.iterator();
      while (rowIterator.hasNext()) {
        Row row = rowIterator.next();
        Iterator<Cell> cellIterator = row.cellIterator();

        while (cellIterator.hasNext()) {
          Cell cell = cellIterator.next();
          if (!cell.getStringCellValue().isEmpty()) {
            flag = true;
            columnCount = columnCount + 1;
          }

        }
        if (flag == true) {
          rowCount = rowCount + 1;
          flag = false;
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    countArray[0] = rowCount;
    countArray[1] = columnCount/rowCount;

    return countArray;
  }

  public void readTestDataExcel(){
    HashMap<String, String> dataMap = new HashMap<>();
    int[] rowColumnCount = getRowColumnCount();
    System.out.println(System.getProperty("user.dir") +
        UiFactory.customVar.getVariableMapMap("testdataExcel"));
    try {
      FileInputStream file = new FileInputStream(
          new File(System.getProperty("user.dir") +
              UiFactory.customVar.getVariableMapMap("testdataExcel")));
      XSSFWorkbook workbook = new XSSFWorkbook(file);
      XSSFSheet sheet = workbook.getSheet(UiFactory.customVar.getVariableMapMap("sheet"));
      for (int i = 1; i <=rowColumnCount[0]-1; i++) {
        System.out.println(i);
        Row row = sheet.getRow(i);
        for(int j = 1;j<=rowColumnCount[1]-1;j++){
          dataMap.put(sheet.getRow(0).getCell(j).getStringCellValue(),
              row.getCell(j).getStringCellValue());
        }
        String dataMapString = sheet.getRow(i).getCell(0).getStringCellValue()+"%"+dataMap;
        UiFactory.customVar.setTestcaseMap(sheet.getRow(i).getCell(0).getStringCellValue(), dataMapString);
 }

    }catch (Exception e){
     e.printStackTrace();
    }
  }

}
