package stl.ui.automation.framework.base.ui.testdata;

import java.io.FileReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.csv.*;
import stl.ui.automation.framework.base.ui.UiFactory;
import stl.ui.automation.framework.base.ui.customexception.CustomException;

public class TestDataReadCsv {

  public void readCsv(){
    try {
      HashMap<String, String> dataMap = new HashMap<>();
      Reader in = new FileReader(System.getProperty("user.dir") +
          UiFactory.customVar.getVariableMapMap("testdataCsv"));
      CSVParser csvParser = new CSVParser(in,CSVFormat.DEFAULT.withHeader());
      List<CSVRecord> csvRecords = csvParser.getRecords();
      Map<String, Integer> headerMap = csvParser.getHeaderMap();
      for (CSVRecord record : csvRecords) {
        for(Map.Entry<String, Integer> header : headerMap.entrySet()){
           if(!header.getKey().equalsIgnoreCase("TestCase")) {
             dataMap.put(header.getKey(), record.get(header.getKey()));
           }
          String dataMapString = record.get("TestCase")+"%"+dataMap;
          UiFactory.customVar.setTestcaseMap(record.get("TestCase"), dataMapString);
        }

      }





    }catch (Exception e){
      new CustomException("Issue in reading csvFile",false);

    }
  }

}
