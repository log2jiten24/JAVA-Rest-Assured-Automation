package advancedAPIConcepts_Utilities;

import au.com.bytecode.opencsv.CSVReader;
import com.google.gson.Gson;
import com.vladsch.flexmark.ast.Link;
import convertJsontoPOJO.*;
import net.bytebuddy.dynamic.scaffold.MethodGraph;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/*
This class converts the CSV to JSON - by doing the following conversions :-
a) First with the help of LinkedHashMap as key and value as Map of Map - > again passing LinkedHashMap as values
b) Convert the CSV to Java Object - once the CSV is converted to Java Object.
c)With the help of Gson Library - we can easily convert the Java Object to the Json File and store it in a specific locsstion/
 */
public class ConvertCSV_to_JSon {


    /**
     * This method will read complete test data present in CSV File and create a big LinkedHashMap.
     * Big HashMap contains test case id as key and value as <title , heading ,title value >
     *     <"1" ,<"Nqme" , "Kumar">, "SurName" : "Jitendra"  >
     *  LinkedHashMap choosen because it retrieves the data in sequence as it is arranged in CSV
     */

    public static LinkedHashMap<String , LinkedHashMap<String , String>> readCompleteCSVFile (File file) throws IOException {

        FileReader fr = new FileReader(file) ;
        //read the CSV File
        CSVReader csvReader = new CSVReader(fr) ;
        List<String[]> allCSVData = csvReader.readAll();
        //close the csv file
        csvReader.close();
        //Create Map of Map of values
        LinkedHashMap <String , LinkedHashMap<String , String>> bigLinkedHashMap = new LinkedHashMap<>() ;

        String [] headersArray = allCSVData.get(0) ;
        List<String> headersList = Arrays.asList(headersArray) ;

        for (int i = 1 ; i < allCSVData.size() ; i ++ ) {
            List<String> bodyRow = Arrays.asList(allCSVData.get(i)) ;

            LinkedHashMap<String , String> smallLinkedHashMap = new LinkedHashMap<>() ;
            for (int j = 0 ; j < headersList.size(); j ++) {
                smallLinkedHashMap.put(headersList.get(j) , bodyRow.get(j));
            }
            bigLinkedHashMap.put(bodyRow.get(0), smallLinkedHashMap);
        }

       return bigLinkedHashMap;


    }

    /*
    Convert the CSV Linked HashMap to the Java Object
    Use the main Employee POJO Class which we have used for the Json Node
     */
    public static Employee_POJO_List convertLinkedHashMaptoPOJOObject (LinkedHashMap<String, LinkedHashMap<String, String>> bigMap) {

        Employee_POJO_List service = new Employee_POJO_List() ;

        List<Employee_POJO_Class> lsEmp = new ArrayList<>();

        //run as per row count excluding headers
        for (LinkedHashMap<String , String> lhm : bigMap.values()) {
            //Create the Object of all the POJO Classes
            Employee_POJO_Class employee_pojo_obj = new Employee_POJO_Class();
            AddressGeoPOJOClass addressGeo = new AddressGeoPOJOClass();
            Address_POJO_Class_Update_03 address_obj = new Address_POJO_Class_Update_03();
            Office_POJO_Class office_obj = new Office_POJO_Class();

            for (Map.Entry<String , String> entry : lhm.entrySet()) {
                //Fetch the key and value from the Map
             String key = entry.getKey();
             String value = entry.getValue();

             //all classes have been initialised - pass the csv header values
             switch (key) {
                 case "Name" : employee_pojo_obj.setName(value); break;
                 case "Surname" : employee_pojo_obj.setSurname(value); break;
                 case "Age" : employee_pojo_obj.setAge(value); break;

                 case "address#Hno"    : address_obj.setHno(value); break;
                 case "address#Street" : address_obj.setStreet(value);break;
                 case "address#State"  : address_obj.setState(value); break;
                 case "address#addressGeo#latitude"  :addressGeo.setLatitude(value);break;
                 case "address#addressGeo#longitude"  :addressGeo.setLongitude(value);break;
                 case "office#officeA" : office_obj.setOfficeA(value); break;
                 case "office#officeB" : office_obj.setOfficeB(value); break;

             }
                }
            //create single service POJO object for one row
            address_obj.setAddressGeoClass(addressGeo);
            employee_pojo_obj.setAddressobj(address_obj);
            employee_pojo_obj.setOffice_pojo_obj(office_obj);

            lsEmp.add(employee_pojo_obj);
        }
        //Final JSON Object method called to finalize the list
        service.setEmployee(lsEmp);

        return service ;


    }

    public static void main(String[] args) throws IOException {

        //read the input csv
        String csvPath = "./JsonPractice/input_data.csv" ;

        LinkedHashMap<String , LinkedHashMap<String ,String>> bigLinkedHashMap =
                readCompleteCSVFile(new File(csvPath));

        //Convert the whole csv to the Java Object
        Employee_POJO_List service = convertLinkedHashMaptoPOJOObject(bigLinkedHashMap);
        //Create the new json File
        String json_file = "./JsonPractice/emp_csv_to_json.json" ;
        FileWriter fw = null ;

        Gson gson = new Gson();
        try{
            fw = new FileWriter(json_file) ;
            gson.toJson(service,fw) ;
            fw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println ("Json file named 'emp_csv_to_json' created successfully from 'inputdata.csv' file ");


    }

}
