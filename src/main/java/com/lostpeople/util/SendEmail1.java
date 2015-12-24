package com.lostpeople.util;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.lostpeople.forms.FindForm;
import com.lostpeople.forms.LostForm;

public class SendEmail1 {
	public static void sendEmail(Object object, int type) throws MessagingException {
		
        // 配置发送邮件的环境属性
        final Properties props = new Properties();
        /*
         * 可用的属性： mail.store.protocol / mail.transport.protocol / mail.host /
         * mail.user / mail.from
         */
        // 表示SMTP发送邮件，需要进行身份验证
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.163.com");
        // 发件人的账号
        props.put("mail.user", "xd_wangye@163.com");
        // 访问SMTP服务时需要提供的密码
        props.put("mail.password", "wangye888");

        // 构建授权信息，用于进行SMTP进行身份验证
        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                // 用户名、密码
                String userName = props.getProperty("mail.user");
                String password = props.getProperty("mail.password");
                return new PasswordAuthentication(userName, password);
            }
        };
        // 使用环境属性和授权信息，创建邮件会话
        Session mailSession = Session.getInstance(props, authenticator);
        // 创建邮件消息
        MimeMessage message = new MimeMessage(mailSession);
        // 设置发件人
        InternetAddress form = new InternetAddress(
                props.getProperty("mail.user"));
        message.setFrom(form);
        if (type == 0) {
			FindForm info  = (FindForm)object;
			// 设置收件人
	        InternetAddress to = new InternetAddress(info.getEmail());
	        message.setRecipient(RecipientType.TO, to);

	        // 设置抄送
	        InternetAddress cc = new InternetAddress("luo_aaaaa@yeah.net");
	        message.setRecipient(RecipientType.CC, cc);

	        // 设置密送，其他的收件人不能看到密送的邮件地址
	        InternetAddress bcc = new InternetAddress("aaaaa@163.com");
	        message.setRecipient(RecipientType.CC, bcc);

	        // 设置邮件标题
	        message.setSubject("恭喜您，"+info.getName()+"的信息已成功匹配！");

	        // 设置邮件的内容体
	        message.setContent("<!DOCTYPE html>  <html>  <head lang='en'>      <meta charset='UTF-8'>      <meta name='description'            content='app, web app, responsive, admin dashboard, admin, flat, flat ui, ui kit, off screen nav' />      <meta name='viewport'            content='width=device-width, initial-scale=1, maximum-scale=1' />      <title></title>      <style type='text/css'>          div{              font-size: 12pt;              line-height: 30px;          }          .style{              height: 30px;          }          .style1{              height: 50px;          }          .txt{              margin-left: 32px;              float: left;          }          .txt1{              margin-left: 32px;              float: left;              height: 50px;              line-height: 50px;          }          .imagediv          {              height: 84px;              width: 100%;          }          .image          {              max-height: 80px;              max-width: 80px;              margin: 2px 5px;          }      </style>  </head>  <body style='margin: 20px auto;'>      <div style='width: 90%; margin: 0px auto;'>          <div style='float: left;'>尊敬的</div>          <!--姓名-->          <div style='float: left;'></div>          <div>家人你好：</div>          <div>&nbsp;&nbsp;您于“归巢”公众号上传的“我要回家/等你回家”上传的寻人信息目前匹配到相似人员一名。</div>          <div>对方与您上传照片的相似匹配度为：</div><div style='font-weight: bold;'></div>          <div class='imagediv'>              <img class='image' src='images/icon.png'>              <img class='image' src='images/icon.png'>              <img class='image' src='images/icon.png'>          </div>          <div><strong>对方信息：</strong></div>          <div class='style'>              <div class='txt'>姓名：</div><div></div>          </div>          <div class='style'>              <div class='txt'>年龄：</div><div></div>          </div>          <div class='style'>              <div class='txt'>性别：</div><div></div>          </div>          <div class='style'>              <div class='txt'>走失时间：</div><div></div>          </div>          <div class='style'>              <div class='txt'>走失地点：</div><div></div>          </div>          <div class='style'>              <div class='txt'>特征描述：</div>              <div style='height: 30px;width: 60%;float: left;'></div>          </div>          <div class='style'>              <div class='txt'>其他描述：</div>              <div style='height: 30px;width: 60%;float: left;'></div>          </div>          <div>&nbsp;&nbsp;请您仔细确认对方信息，若对方信息与您走失的家人相似，请您尽快联系对方。</div>          <div class='style'>              <div class='txt'>对方邮箱：</div><div></div>          </div>          <div class='style'>              <div class='txt'>联系电话：</div><div></div>          </div>          <div style='color: red;'><strong>特别提示：</strong>由于社会上的各类骗子比较多，希望各位寻亲家属提高警惕。我们会为您提供与您提交信息匹配人员的联系方式，请您不要相信陌生来电信息。同时，对各种以提供线索为名索要报酬的人要加强防范，不要轻信他人以免给您造成损失。</div>        </div>  </body>  </html>", "text/html;charset=UTF-8");
		} else if (type == 1) {
			LostForm info = (LostForm)object;
			// 设置收件人
	        InternetAddress to = new InternetAddress(info.getEmail());
	        message.setRecipient(RecipientType.TO, to);

	        // 设置抄送
	        InternetAddress cc = new InternetAddress("luo_aaaaa@yeah.net");
	        message.setRecipient(RecipientType.CC, cc);

	        // 设置密送，其他的收件人不能看到密送的邮件地址
	        InternetAddress bcc = new InternetAddress("aaaaa@163.com");
	        message.setRecipient(RecipientType.CC, bcc);

	        // 设置邮件标题
	        message.setSubject("恭喜您，"+info.getName()+"的信息已成功匹配！");
	        //"尊敬的XX家人你好：\n\t您于“归巢”公众号上传的“我要回家/等你回家”上传的寻人信息目前匹配到相似人员一名。\n\t对方与您上传照片的相似匹配度为：XX%\n\t（照片）\n\t对方信息：\n\t姓名：\n\t年龄：\n\t性别：\n\t走失时间：\n\t走失地点：\n\t特征描述：\n\t其他描述：\n\n\t请您仔细确认对方信息，若对方信息与您走失的家人相似，请您尽快联系对方。\n\t对方邮箱：\n\t联系电话：\n\n\t特别提示：由于社会上的各类骗子比较多，希望各位寻亲家属提高警惕。我们会为您提供与您提交信息匹配人员的联系方式，请您不要相信陌生来电信息。同时，对各种以提供线索为名索要报酬的人要加强防范，不要轻信他人以免给您造成损失。"
	        // 设置邮件的内容体
	        message.setContent("<!DOCTYPE html>  <html>  <head lang='en'>      <meta charset='UTF-8'>      <meta name='description'            content='app, web app, responsive, admin dashboard, admin, flat, flat ui, ui kit, off screen nav' />      <meta name='viewport'            content='width=device-width, initial-scale=1, maximum-scale=1' />      <title></title>      <style type='text/css'>          div{              font-size: 12pt;              line-height: 30px;          }          .style{              height: 30px;          }          .style1{              height: 50px;          }          .txt{              margin-left: 32px;              float: left;          }          .txt1{              margin-left: 32px;              float: left;              height: 50px;              line-height: 50px;          }          .imagediv          {              height: 84px;              width: 100%;          }          .image          {              max-height: 80px;              max-width: 80px;              margin: 2px 5px;          }      </style>  </head>  <body style='margin: 20px auto;'>      <div style='width: 90%; margin: 0px auto;'>          <div style='float: left;'>尊敬的</div>          <!--姓名-->          <div style='float: left;'></div>          <div>家人你好：</div>          <div>&nbsp;&nbsp;您于“归巢”公众号上传的“我要回家/等你回家”上传的寻人信息目前匹配到相似人员一名。</div>          <div>对方与您上传照片的相似匹配度为：</div><div style='font-weight: bold;'></div>          <div class='imagediv'>              <img class='image' src='images/icon.png'>              <img class='image' src='images/icon.png'>              <img class='image' src='images/icon.png'>          </div>          <div><strong>对方信息：</strong></div>          <div class='style'>              <div class='txt'>姓名：</div><div></div>          </div>          <div class='style'>              <div class='txt'>年龄：</div><div></div>          </div>          <div class='style'>              <div class='txt'>性别：</div><div></div>          </div>          <div class='style'>              <div class='txt'>走失时间：</div><div></div>          </div>          <div class='style'>              <div class='txt'>走失地点：</div><div></div>          </div>          <div class='style'>              <div class='txt'>特征描述：</div>              <div style='height: 30px;width: 60%;float: left;'></div>          </div>          <div class='style'>              <div class='txt'>其他描述：</div>              <div style='height: 30px;width: 60%;float: left;'></div>          </div>          <div>&nbsp;&nbsp;请您仔细确认对方信息，若对方信息与您走失的家人相似，请您尽快联系对方。</div>          <div class='style'>              <div class='txt'>对方邮箱：</div><div></div>          </div>          <div class='style'>              <div class='txt'>联系电话：</div><div></div>          </div>          <div style='color: red;'><strong>特别提示：</strong>由于社会上的各类骗子比较多，希望各位寻亲家属提高警惕。我们会为您提供与您提交信息匹配人员的联系方式，请您不要相信陌生来电信息。同时，对各种以提供线索为名索要报酬的人要加强防范，不要轻信他人以免给您造成损失。</div>        </div>  </body>  </html>","text/html;charset=UTF-8");
		}
        // 发送邮件
        Transport.send(message);
    }
}
