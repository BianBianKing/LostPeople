package test;

import javax.mail.MessagingException;

import com.lostpeople.forms.LostForm;
import com.lostpeople.util.SendEmail;

public class emailFormat {
	public static void main(String[] args) throws MessagingException {
		LostForm test = new LostForm();
		test.setName("aaa");
		test.setEmail("493877356@qq.com");
		SendEmail.sendEmail("493877356@qq.com",test,0, 2);
	}
}
