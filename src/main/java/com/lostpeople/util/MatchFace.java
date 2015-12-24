package com.lostpeople.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.lostpeople.forms.FindForm;
import com.lostpeople.forms.LostForm;
import com.lostpeople.forms.VolunteerForm;
import com.lostpeople.service.api.FindService;
import com.lostpeople.service.api.LostService;

public class MatchFace {
	@Autowired
	@Qualifier("findServiceImpl")
	private FindService findService;
	
	@Autowired
	@Qualifier("lostServiceImpl")
	private LostService lostService;
	public static double matchFace(String image1, String image2) throws IOException {
		try {
			//String cammond = "C:/Python27/python C:/Users/bbk/Desktop/FaceCompare_sdk/find_kid.py C:/Users/bbk/workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/LostPeople/"+image1+" C:/Users/bbk/workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/LostPeople/"+image2+" 0";
			String cammond = "python /home/tools/apache-tomcat-8.0.23/webapps/FaceCompare_sdk/find_kid.py /home/tools/apache-tomcat-8.0.23/webapps/LostPeople/"+image1+" /home/tools/apache-tomcat-8.0.23/webapps/LostPeople/"+image2+" 0";
			Process pr = Runtime.getRuntime().exec(cammond);
			System.out.println(cammond);
			BufferedReader in = new BufferedReader(new InputStreamReader(pr.getInputStream()));
			String line;
			pr.waitFor();
			line = in.readLine();
			System.out.println(line);
			Double temp = Double.parseDouble(line);
			in.close();
			return temp;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public static void findAddFace(FindForm findForm) throws IOException, InterruptedException {
		//String cammond = "C:/Python27/python C:/Users/bbk/Desktop/lostMatch/add_person.py "+findForm.getId()+" find C:/Users/bbk/workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/LostPeople/"+findForm.getPhoto1()+" 0";
		String cammond = "python /home/tools/apache-tomcat-8.0.23/webapps/FaceCompare_sdk/add_person.py "+findForm.getId()+" find /home/tools/apache-tomcat-8.0.23/webapps/LostPeople/"+findForm.getPhoto1()+" 0";
		Process pr = Runtime.getRuntime().exec(cammond);
		BufferedReader in = new BufferedReader(new InputStreamReader(pr.getInputStream()));
		String line;
		pr.waitFor();
		line = in.readLine();
		System.out.println(line);
		line = in.readLine();
		System.out.println(line);
		line = in.readLine();
		System.out.println(line);
	}
	
	public static void lostAddFace(LostForm lostForm) throws IOException, InterruptedException {
		//String cammond = "C:/Python27/python C:/Users/bbk/Desktop/lostMatch/add_person.py "+lostForm.getId()+" lost C:/Users/bbk/workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/LostPeople/"+lostForm.getPhoto1()+" 0";
		String cammond = "python /home/tools/apache-tomcat-8.0.23/webapps/FaceCompare_sdk/add_person.py "+lostForm.getId()+" lost /home/tools/apache-tomcat-8.0.23/webapps/LostPeople/"+lostForm.getPhoto1()+" 0";
		Process pr = Runtime.getRuntime().exec(cammond);
		pr.waitFor();
		BufferedReader in = new BufferedReader(new InputStreamReader(pr.getInputStream()));
		String line;
		pr.waitFor();
		line = in.readLine();
		System.out.println(line);
		line = in.readLine();
		System.out.println(line);
		line = in.readLine();
		System.out.println(line);
	}
	
	public static void lostNowAddFace(LostForm lostForm) throws IOException, InterruptedException {
		//String cammond = "C:/Python27/python C:/Users/bbk/Desktop/lostMatch/add_person.py "+lostForm.getId()+" lostNow C:/Users/bbk/workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/LostPeople/"+lostForm.getPhoto1()+" 0";
		String cammond = "python /home/tools/apache-tomcat-8.0.23/webapps/FaceCompare_sdk/add_person.py "+lostForm.getId()+" lostNow /home/tools/apache-tomcat-8.0.23/webapps/LostPeople/"+lostForm.getPhoto1()+" 0";
		Process pr = Runtime.getRuntime().exec(cammond);
		pr.waitFor();
		BufferedReader in = new BufferedReader(new InputStreamReader(pr.getInputStream()));
		String line;
		pr.waitFor();
		line = in.readLine();
		System.out.println(line);
		line = in.readLine();
		System.out.println(line);
		line = in.readLine();
		System.out.println(line);
	}
	
	public static MatchResult matchFaceInFind(LostForm lostForm) {
		try {
			//String cammond = "C:/Python27/python C:/Users/bbk/Desktop/lostMatch/faceidentify.py find C:/Users/bbk/workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/LostPeople/"+lostForm.getPhoto1()+" 0";
			String cammond = "python /home/tools/apache-tomcat-8.0.23/webapps/FaceCompare_sdk/faceidentify.py find /home/tools/apache-tomcat-8.0.23/webapps/LostPeople/"+lostForm.getPhoto1()+" 0";
			Process pr = Runtime.getRuntime().exec(cammond);
			System.out.println(cammond);
			BufferedReader in = new BufferedReader(new InputStreamReader(pr.getInputStream()));
			pr.waitFor();
			in.readLine();
			String person_id = in.readLine();
			String result = in.readLine();
			MatchResult tempResult = new MatchResult();
			if (person_id != null && result != null) {
				tempResult.setPerson_id(Long.parseLong(person_id));
				tempResult.setResult(Double.parseDouble(result));
				if (tempResult.getPerson_id() == -1 || tempResult.getResult() == -1) {
					throw new Exception();
				}
			} else {
				throw new Exception();
			}
			
			in.close();
			if (tempResult.getResult() >= 60 && tempResult.getResult() < 100) {
				return tempResult;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static MatchResult matchFaceInLost(FindForm findForm) {
		try {
			//String cammond = "C:/Python27/python C:/Users/bbk/Desktop/lostMatch/faceidentify.py lost C:/Users/bbk/workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/LostPeople/"+findForm.getPhoto1()+" 0";
			String cammond = "python /home/tools/apache-tomcat-8.0.23/webapps/FaceCompare_sdk/faceidentify.py lost /home/tools/apache-tomcat-8.0.23/webapps/LostPeople/"+findForm.getPhoto1()+" 0";
			Process pr = Runtime.getRuntime().exec(cammond);
			System.out.println(cammond);
			BufferedReader in = new BufferedReader(new InputStreamReader(pr.getInputStream()));
			pr.waitFor();
			in.readLine();
			String person_id = in.readLine();
			String result = in.readLine();
			
			MatchResult tempResult = new MatchResult();
			if (person_id != null && result != null) {
				tempResult.setPerson_id(Long.parseLong(person_id));
				tempResult.setResult(Double.parseDouble(result));
				if (tempResult.getPerson_id() == -1 || tempResult.getResult() == -1) {
					throw new Exception();
				}
			} else {
				throw new Exception();
			}
			in.close();
			if (tempResult.getResult() >= 60 && tempResult.getResult() < 100) {
				return tempResult;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public static MatchResult matchFaceInLost(VolunteerForm volunteerForm) {
		try {
			//String cammond = "C:/Python27/python C:/Users/bbk/Desktop/lostMatch/faceidentify.py lostNow C:/Users/bbk/workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/LostPeople/"+volunteerForm.getPhoto1()+" 0";
			String cammond = "python /home/tools/apache-tomcat-8.0.23/webapps/FaceCompare_sdk/faceidentify.py lostNow /home/tools/apache-tomcat-8.0.23/webapps/LostPeople/"+volunteerForm.getPhoto1()+" 0";
			Process pr = Runtime.getRuntime().exec(cammond);
			System.out.println(cammond);
			BufferedReader in = new BufferedReader(new InputStreamReader(pr.getInputStream()));
			pr.waitFor();
			in.readLine();
			String person_id = in.readLine();
			String result = in.readLine();
			
			MatchResult tempResult = new MatchResult();
			if (person_id != null && result != null) {
				tempResult.setPerson_id(Long.parseLong(person_id));
				tempResult.setResult(Double.parseDouble(result));
				if (tempResult.getPerson_id() == -1 || tempResult.getResult() == -1) {
					throw new Exception();
				}
				System.out.println(person_id);
			} else {
				throw new Exception();
			}
			in.close();
			if (tempResult.getResult() >= 60 && tempResult.getResult() < 100) {
				return tempResult;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
