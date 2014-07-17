package com.wdf.service;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import net.iharder.Base64;

import org.springframework.stereotype.Service;

import com.wdf.common.init.InitContext;

@Service
@SuppressWarnings("static-access")
public class CaptchaService {
	private InitContext initContext = InitContext.getInstance();
	private final DateFormat df = new SimpleDateFormat("yyyyMMddhhmmss");
	
	public String saveImg() throws IOException {
		String fileName = "/captcha_" + df.format(new Date()) + ".jpg";
		URL url = new URL("http://railway.hinet.net/ImageOut.jsp?pageRandom=" + Math.random());
		InputStream in = new BufferedInputStream(url.openStream());
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		byte[] buf = new byte[1024];
		int n = 0;
		while (-1 != (n = in.read(buf))) {
			out.write(buf, 0, n);
		}
		out.close();
		in.close();
		byte[] response1 = out.toByteArray();

		FileOutputStream fos = new FileOutputStream(initContext.getWebRootTmpCaptcha_().concat(fileName));
		fos.write(response1);
		fos.close();
		
		String imgPath = initContext.getWebRootTmp().concat(initContext.getWebRootTmpCaptcha()).concat(fileName);
		// return imgPath.substring(1, imgPath.length());
		return base64(initContext.getWebRootTmpCaptcha_().concat(fileName));
	}
	
	public String doGray(String imgId){
		Image image = null;
		return "";
	}
	
	private String tagImg(String imgPath){
		return "<img id=\"captcha\" name=\"captcha\" src=\"" + imgPath + "\" />";
	}
	
	private String base64(String imgPath){
		BufferedImage img;
		ByteArrayOutputStream baos = null;
		try {
			img = ImageIO.read(new File(imgPath));
			baos = new ByteArrayOutputStream();
			ImageIO.write(img, "jpg", baos);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				baos.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return Base64.encodeBytes(baos.toByteArray());
	}
}
