package com.moveone.app.util;

import java.io.File;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManager {
	public String fileSave(String path, MultipartFile file) throws Exception {
		System.out.println(path);
		
		//path == realpath
		File f = new File(path);
		
		if(f.isFile()) {
			throw new Exception(path + "가 파일입니다");
			//return;
		}
		
		if (!f.exists()) {
			f.mkdirs();
		}
		// 2. 어떤 파일 명으로 저장
		// a. 시간 사용
		Calendar ca = Calendar.getInstance();
		String filename = ca.getTimeInMillis() + "_" + file.getOriginalFilename();

		// b. UUID 사용(universal unique identity)
		filename = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
		System.out.println(filename);

		f = new File(f, filename);
		// 3. 파일을 저장
		// a. FileCopyUtils 클래스 사용
		//FileCopyUtils.copy(file.getBytes(), f);
		
		//b. MultipartFile의 transferTo 메서드 사용
		file.transferTo(f);
		
		return filename;
	}

	public boolean fileDelete(String path, String fileName) {
		File f = new File(path, fileName);
		
		return f.delete();
	}
}
