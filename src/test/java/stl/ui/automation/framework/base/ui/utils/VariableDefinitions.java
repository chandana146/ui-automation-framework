package stl.ui.automation.framework.base.ui.utils;

import com.deque.html.axecore.results.Results;
import com.deque.html.axecore.results.Rule;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class VariableDefinitions {


    private HashMap<String, String> variableMap = new HashMap<>();
    private HashMap<String, String> locatorMap = new HashMap<>();
    private HashMap<String, String> testcaseMap = new HashMap<>();
    private Results results = null;
    private List<Rule> violations = new ArrayList<>();
    public String getVariableMapMap(String key) {
    	System.out.println("key "+key+" value "+variableMap.get(key));
        return variableMap.get(key);
    }
    public void setVariableMapMap(String key, String value) {
        variableMap.put(key,value);
        System.out.println("varmapsize ---"+variableMap.size()+"  key"+ key + " value" +value);
    }

    public String getTestcaseMap(String key) {
    	System.out.println("testmapsize --"+testcaseMap.size()+"  key"+ key+ " value = "+testcaseMap.get(key));
        return testcaseMap.get(key);
        
    }

    public void setTestcaseMap(String key, String value) {
        testcaseMap.put(key,value);
        System.out.println("testcasemapsize --"+testcaseMap.size()+"  key"+ key+" value" + value);
    }

    public String getLocatorMapMap(String key) {
    	System.out.println("locmapsize ---"+locatorMap.size()+"  key"+ key + " value" + locatorMap.get(key));
       // return locatorMap.get(key+"-homepage");
        return locatorMap.get(key);
    }

    public void setLocatorMapMap(String key, String value) {
        locatorMap.put(key,value);
        System.out.println("locmapsize ---"+locatorMap.size()+"  key"+ key + " value" + locatorMap.get(key));
    }

    public String returnReportFilePath(){
        return Paths.get(System.getProperty("user.dir")+"/output/accessibilityReport.json").toString();
    }

    public List<Rule> getViolations() {
        return violations;
    }

    public void setViolations(List<Rule> violations) {
        this.violations = violations;
    }

    public Results getResults() {
        return results;
    }

    public void setResults(Results results) {
        this.results = results;
    }
}
