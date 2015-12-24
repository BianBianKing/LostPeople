package com.lostpeople.util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class CompressPic {
	private File file = null; // 文件对象
	public String compressPic() {   
        try {   
            //获得源文件   
            file = new File("");   
            if (!file.exists()) {   
                return "";   
            }   
            Image img = ImageIO.read(file);   
            // 判断图片格式是否正确   
            if (img.getWidth(null) == -1) {  
                System.out.println(" can't read,retry!" + "<BR>");   
                return "no";   
            } else {   
                int newWidth; int newHeight;   
                // 判断是否是等比缩放   
                   
                    // 为等比缩放计算输出的图片宽度及高度   
                    double rate1 = ((double) img.getWidth(null)) / (double) 100 + 0.1;   
                    double rate2 = ((double) img.getHeight(null)) / (double) 100 + 0.1;   
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
               FileOutputStream out = new FileOutputStream("");  
                
               
               out.close();   
            }   
        } catch (IOException ex) {   
            ex.printStackTrace();   
        }   
        return "ok";   
	}
}
