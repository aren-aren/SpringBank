package com.moveone.app.utils;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.moveone.app.board.BoardFileDTO;

import java.io.File;
import java.util.UUID;

@Component
public class FileManager {

    public String fileSave(MultipartFile file, String path) throws Exception {
        File f = new File(path);

        if(f.isFile()) {
            throw new Exception(path + "가 파일 입니다.");
        }
        if(!f.exists()) {
            f.mkdirs();
        }

        String fileName = UUID.randomUUID().toString() + file.getOriginalFilename();

        f = new File(f, fileName);
        file.transferTo(f);

        return fileName;
    }

	public void fileDelete(String fileName, String path) {
		File f = new File(path, fileName);
		
		if(f.exists()) f.delete();
	}
}
