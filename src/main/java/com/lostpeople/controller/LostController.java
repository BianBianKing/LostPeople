package com.lostpeople.controller;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.lostpeople.forms.FindForm;
import com.lostpeople.forms.LostForm;
import com.lostpeople.service.api.FindService;
import com.lostpeople.service.api.LostService;
import com.lostpeople.util.MatchFace;
import com.lostpeople.util.MatchResult;
import com.lostpeople.util.SendEmail;

@Controller
public class LostController {
	@Autowired
	@Qualifier("lostServiceImpl")
	private LostService lostService;
	@Autowired
	@Qualifier("findServiceImpl")
	private FindService findService;
	
	
	@RequestMapping(value = "lost.htm", method = {RequestMethod.POST, RequestMethod.GET }) 
	public ModelAndView lostPeople(HttpServletRequest request,HttpServletResponse response){
		return new ModelAndView("/LostPeopleInfo");
	}
	
	@RequestMapping(value = "lost.form", method = {RequestMethod.POST, RequestMethod.GET }) 
	public void findForm(@RequestParam("uploadfile") CommonsMultipartFile[] files,HttpServletRequest request,HttpServletResponse response) throws IllegalStateException, IOException, ParseException, InterruptedException{
		response.setContentType("application/json");  
	    response.setCharacterEncoding("UTF-8");
	    request.setCharacterEncoding("UTF-8");
	    
	    String type = request.getParameter("selecttype");
	    String name = request.getParameter("name");
	    String ageTemp = request.getParameter("age");
	    int age = Integer.parseInt(ageTemp);
	    String rd = request.getParameter("rd");
	    String endDate = request.getParameter("endTime");
	    String locatxt = request.getParameter("locatxt");
	    String s_province = request.getParameter("s_province");
	    String s_city = request.getParameter("s_city");
	    locatxt = s_province+","+s_city+","+locatxt;
	    String detail1 = request.getParameter("detail1");
	    String detail2 = request.getParameter("detail2");
	    String tele = request.getParameter("tele");
	    String email = request.getParameter("email");
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	    System.out.println(endDate);
		Date lostDate = sdf.parse(endDate);
	    System.out.println(lostDate);
	    final LostForm temp = new LostForm();	
	    temp.setType(type);
	    temp.setName(name);
	    temp.setAge(age);
	    temp.setSex(rd);
	    temp.setLostDate(lostDate);
	    temp.setLostLocation(locatxt);
	    temp.setCharacteristic(detail1);
	    temp.setRemark(detail2);
	    temp.setPhone(tele);
	    temp.setEmail(email);
	    
	    
	    //获取图片
	    for(int i = 0;i<files.length;i++){  
            if(files[i] != null){  
                //取得当前上传文件的文件名称  
                String myFileName = files[i].getOriginalFilename();  
                //如果名称不为“”,说明该文件存在，否则说明该文件不存在  
                if(myFileName.trim() !=""){  
                    //重命名上传后的文件名  
                	
                	//SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            		//String timestamp = sdf.format(date);
            	
            		String imageRootDir = "lostImage/";
            		Date date = new Date();
            		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMddHHmmss");
            		String timestamp = sdf1.format(date);
            		String imageFileName = timestamp+".jpg";
            		String imageDir = imageRootDir + imageFileName;
            		String curRealPath = request.getSession().getServletContext().getRealPath("/");
            		
            		//String imageCompressPath = curRealPath + imageXiangduiDir + "compress/" + imageXiangduiFileName;
                    //定义上传路径  
            		String imagePath = curRealPath+imageDir;
            		System.out.println(imagePath);
            		 File localFile = new File(imagePath);
                     files[i].transferTo(localFile); 
                     Image img = ImageIO.read(new File(imagePath));   
                     // 判断图片格式是否正确   
                     int newWidth; int newHeight;   
                     // 为等比缩放计算输出的图片宽度及高度   
                     double rate1 = ((double) img.getWidth(null)) / (double) 1000 + 0.1;   
                     double rate2 = ((double) img.getHeight(null)) / (double) 1000 + 0.1;   
                     // 根据缩放比率大的进行缩放控制   
                     double rate = rate1 > rate2 ? rate1 : rate2;   
                     newWidth = (int) (((double) img.getWidth(null)) / rate);   
                     newHeight = (int) (((double) img.getHeight(null)) / rate);   
                     BufferedImage tag = new BufferedImage((int) newWidth, (int) newHeight, BufferedImage.TYPE_INT_RGB);   
                          
                    /* 
                     * Image.SCALE_SMOOTH 的缩略算法 生成缩略图片的平滑度的 
                     * 优先级比速度高 生成的图片质量比较好 但速度慢 
                     */   
                    tag.getGraphics().drawImage(img.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH), 0, 0, null);  
                    ImageIO.write(tag, "jpg", new File(imagePath)); 
                    switch(i) {
                    	case 0:
                    		temp.setPhoto1(imageDir);
                    		break;
                    	case 1:
                    		temp.setPhoto2(imageDir);
                    		break;
                    	case 2:
                    		temp.setPhoto3(imageDir);
                    		break;
                    }
                    
                }  
            }  
        }
	    lostService.addLostInfo(temp);
	    if (temp.getType().equals("0")) {
	    	MatchFace.lostNowAddFace(temp);
	    } else {
	    	MatchFace.lostAddFace(temp);
	    }
	    
	    Thread t = new Thread(  
            new Thread(){  
                @Override  
                public void run() {  
            		MatchResult result = MatchFace.matchFaceInFind(temp);
                	if (result != null) {
                		result.setObject(findService.getFindById(result.getPerson_id()));
                		System.out.println(result.getResult());
                		System.out.println(result.getPerson_id());
    			    	//在Lost中匹配成功，发邮件
                		try {
							SendEmail.sendEmail(((FindForm) result.getObject()).getEmail(), temp, result.getResult(), 1);
							SendEmail.sendEmail(temp.getEmail(), result.getObject(), result.getResult(), 0);
						} catch (MessagingException e) {
							e.printStackTrace();
						}
    			    }
                }  
            }  
        );  
        t.start();
        if (type.equals("0")) {
        	response.sendRedirect("infoCard.htm?id="+temp.getId()+"&type=lostNow");
        } else {
        	response.sendRedirect("infoCard.htm?id="+temp.getId()+"&type=lost");
        }
        
	}
}