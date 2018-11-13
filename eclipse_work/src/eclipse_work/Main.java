package eclipse_work;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		PhoneRecognitionService phoneRecognizeService = new PhoneRecognition();
        Scanner scanner = new Scanner(System.in);
        System.out.println("input:");
        while (scanner.hasNext()) {
            PhoneInformation phoneInformation;
			try {
				phoneInformation = phoneRecognizeService.search(scanner.next());
				System.out.println(phoneInformation.getProvince()+"Ê¡ "+ phoneInformation.getCity()+"ÊÐ "+phoneInformation.getOperater()+ "  " + phoneInformation.getArea_Code()+"  "+phoneInformation.getZip_Code());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("invalid input");
			}         
        }
	}
}
