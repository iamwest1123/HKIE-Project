package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value="upload")
public class UploadController {

	@RequestMapping(value = "image")
	@ResponseBody
	public String uploadifive(
			@RequestParam(value ="Filedata", required = false) MultipartFile hw,
			HttpServletRequest request) {
		
		String newFileName = null;
		FileOutputStream fo = null;
		try {
			newFileName = UUID.randomUUID().toString();
			fo = new FileOutputStream(newFileName);
			
			System.out.println("==========upload==============");
			System.out.println("fileName:...."+hw.getOriginalFilename());
			InputStream in=hw.getInputStream();
			System.out.println("avli...."+in.available());
			Enumeration<String> es1 = request.getParameterNames();
			while (es1.hasMoreElements()) {
				String s = (String) es1.nextElement();
				fo.write(s.getBytes());
				System.out.println(s);
			}
			return newFileName;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			try {
				fo.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}
	}
}
