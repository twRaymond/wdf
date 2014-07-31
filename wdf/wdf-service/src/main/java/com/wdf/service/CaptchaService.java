package com.wdf.service;

import java.awt.Color;
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
import java.util.HashSet;

import javax.imageio.ImageIO;

import net.iharder.Base64;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.wdf.common.beans.ImageBean;
import com.wdf.common.init.InitContext;
import com.wdf.utils.image.HSLColor;


@Service
@SuppressWarnings("static-access")
public class CaptchaService {
	private static final Logger logger = LoggerFactory.getLogger(CaptchaService.class);

	
	private InitContext initContext = InitContext.getInstance();
	private final DateFormat df = new SimpleDateFormat("yyyyMMddhhmmss");
	private Gson gson = new Gson();

	public String saveImg() throws IOException {
		ImageBean imageBean = new ImageBean();
		imageBean.setId("/captcha_" + df.format(new Date()) + ".jpg");
		imageBean.setSavePath(initContext.getWebRootTmpCaptcha_().concat(imageBean.getId()));
		URL url = new URL("http://railway.hinet.net/ImageOut.jsp?pageRandom=" + Math.random());
		byte[] response1 = getByteArrayOutputStreamFromURL(url).toByteArray();
		// save image to server 
		FileOutputStream fos = new FileOutputStream(imageBean.getSavePath());
		fos.write(response1);
		fos.close();
		imageBean.setBase64Code(addBase64(loadImage(imageBean)));
		logger.info(gson.toJson(imageBean));
		return gson.toJson(imageBean);
	}

	public String doGray(String imgId) {
		HashSet<Integer> hashSet = new HashSet<Integer>();
		BufferedImage img;
		ImageBean imageBean = new ImageBean();
		try {
			img = ImageIO.read(new File(initContext.getWebRootTmpCaptcha_().concat(imgId)));
			int width = img.getWidth();
			int height = img.getHeight();
			int[] pixels = new int[width * height];
			img.getRGB(0, 0, width, height, pixels, 0, width);
			int newPixels[] = new int[width * height];
			// remove color to white and black.
			for (int i = 0; i < width * height; i++) {
				HSLColor hslColor = new HSLColor(HSLColor.fromRGB(new Color(pixels[i])));
				newPixels[i] = hslColor.adjustSaturation(0).getRGB();
				hashSet.add(newPixels[i]);
			}
			// remove 
			Integer pixSum = 0;
			Integer pixAVG = 0;
			for(Integer pixInt: hashSet) {
				pixSum += pixInt;
			}
			pixAVG = pixSum / hashSet.size();
			HSLColor hscWhite = new HSLColor(HSLColor.fromRGB(Color.white));
			HSLColor hscRed = new HSLColor(HSLColor.fromRGB(Color.red));
			logger.info(" pix AVG is {} ", pixAVG);
			logger.info(" pix White is {} ", hscWhite.getRGB().getRGB());
			for (int i = 0; i < width * height; i++) {
				newPixels[i] = newPixels[i]>pixAVG?hscWhite.getRGB().getRGB():newPixels[i];
				if(i == 0 || i % width == 1){
					newPixels[i] = newPixels[i]>pixAVG?hscRed.getRGB().getRGB():newPixels[i];
				}
				
			}
			BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			bi.setRGB(0, 0, width, height, newPixels, 0, width);
			imageBean.setBase64Code(addBase64(bi));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return gson.toJson(imageBean);
	}
	
	private BufferedImage loadImage(ImageBean imageBean) throws IOException{
		return ImageIO.read(new File(imageBean.getSavePath()));
	}
	
	private Boolean checkPix(Integer[] newPixels, Integer i, Integer width, Integer hight, Integer pixAVG){
		// check one line
		if(i < width){
			if(i == 0 ){
				int[] indexs = {i , i+1 , i+width, i+width+1};
			} else if(i == width -1){
				
			} else {
				
			}
		}
		return Boolean.FALSE;
	}
	
	private int checkPoint(Integer pixAVG, int[] indexArray){
		int count = 0;
		for(int i : indexArray){
		//	(i > pixAVG)?count++:false;
		}
		return 0;
	}
	
	private String addBase64(BufferedImage bImage) {
		ByteArrayOutputStream baos = null;
		try {
			baos = new ByteArrayOutputStream();
			ImageIO.write(bImage, "jpg", baos);
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
	
	private ByteArrayOutputStream getByteArrayOutputStreamFromURL(URL url) {
		InputStream in = null;
		ByteArrayOutputStream out = null;
		try {
			in = new BufferedInputStream(url.openStream());
			out = new ByteArrayOutputStream();
			byte[] buf = new byte[1024];
			int n = 0;
			while (-1 != (n = in.read(buf))) {
				out.write(buf, 0, n);
			}
			out.close();
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return out;
	}
}
