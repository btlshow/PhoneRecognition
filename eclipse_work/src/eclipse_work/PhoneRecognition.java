package eclipse_work;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class PhoneRecognition implements PhoneRecognitionService{
	static Map<String,PhoneInformation> map = new LinkedHashMap<String, PhoneInformation>();
    static {
        String line = null;
		FileReader fReader = null;
		try {
			fReader = new FileReader("phone.data.txt");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		BufferedReader bfReaed = new BufferedReader(fReader);
		try {
			while ((line = bfReaed.readLine())!=null) {
				String[] phone_DataStr = null;
				PhoneInformation phoneInformation = new PhoneInformation();
				phone_DataStr = line.split("");
				phoneInformation.setphone_Number(phone_DataStr[0]);
				phoneInformation.setProvince(phone_DataStr[1]);
				phoneInformation.setCity(phone_DataStr[2]);
				phoneInformation.setOperater(phone_DataStr[3]);
				phoneInformation.setArea_Code(phone_DataStr[4]);
				phoneInformation.setZip_Code(phone_DataStr[5]);
				map.put(phoneInformation.getphone_Number(), phoneInformation);
			}
			bfReaed.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	public PhoneInformation search(String phone) {
    	int i = 0;
        String phone_Number = phone.substring(0, 7);
        int[] list =new int[map.size()]; 
        for(Map.Entry<String, PhoneInformation> phoneEntry : map.entrySet()) {
        	list[i++] = Integer.parseInt(phoneEntry.getKey());
        }
        return map.get(String.valueOf(list[Arrays.binarySearch(list,Integer.parseInt(phone_Number))]));
    }
}

