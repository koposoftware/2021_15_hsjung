package com.javamodeling.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javamodeling.component.StaticClass;
import com.javamodeling.pojo.Photo;
import com.javamodeling.service.PhotoService;

@Controller
@RequestMapping("/photo")
public class PhotoController {

	@Autowired
	protected PhotoService photoService;

	@RequestMapping(value = "/img/{photoSeq}")
	public ResponseEntity<byte[]> photo(HttpServletRequest request, @PathVariable Long photoSeq) throws IOException {

		Photo photo = new Photo();

		if (photoSeq == null || photoSeq == 0) {

			photo.setPhotoSeq(new Long(1));
		} else {

			photo.setPhotoSeq(photoSeq);
		}

		photo = photoService.obtainPhoto(photo);

		String photoPath = null;

		if (photo.getResultCode() <= 0) {

			photoPath = StaticClass.PHOTO_FOLDER + "male.png";
		} else {
			photoPath = StaticClass.PHOTO_FOLDER + photo.getPhotoSavedFileName();
		}

		InputStream in = new FileInputStream(new File(photoPath));
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_PNG);
		headers.setContentLength(in.available());

		return new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.OK);

	}

	@RequestMapping(value = "/{photoSeq}")
	public ResponseEntity<byte[]> photoThumb(HttpServletRequest request, @PathVariable Long photoSeq)
			throws IOException {

		Photo photo = new Photo();

		if (photoSeq == null || photoSeq == 0) {

			photo.setPhotoSeq(new Long(1));
		} else {

			photo.setPhotoSeq(photoSeq);
		}

		photo = photoService.obtainPhoto(photo);

		String photoPath = null;

		if (photo.getResultCode() <= 0) {

			photoPath = StaticClass.PHOTO_FOLDER + "tb_male.png";
		} else {
			photoPath = StaticClass.PHOTO_FOLDER + photo.getPhotoThumbnailFileName();
		}

		try {

			InputStream in = new FileInputStream(new File(photoPath));
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.IMAGE_PNG);
			headers.setContentLength(in.available());

			return new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	@RequestMapping(value = "/download/{photoSeq}")
	public void downloadPhoto(HttpServletRequest request, HttpServletResponse response, @PathVariable Long photoSeq)
			throws IOException {

		Photo photo = new Photo();

		if (photoSeq == null || photoSeq == 0) {

			return ;
		} else {

			photo.setPhotoSeq(photoSeq);
		}

		photo = photoService.obtainPhoto(photo);

		String photoPath = null;

		if (photo.getResultCode() <= 0) {

			photoPath = StaticClass.PHOTO_FOLDER + "tb_male.png";
		} else {
			photoPath = StaticClass.PHOTO_FOLDER + photo.getPhotoSavedFileName();
		}

		String filename = photo.getPhotoFileName();
		
		File file1 = new File(photoPath);
		if (!file1.exists()) {
			return ;
		}

		response.setContentType("application/octer-stream");
        response.setHeader("Content-Transfer-Encoding", "binary;");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");
		
        try {
            OutputStream os = response.getOutputStream();
            FileInputStream fis = new FileInputStream(photoPath);
 
            int ncount = 0;
            byte[] bytes = new byte[512];
 
            while ((ncount = fis.read(bytes)) != -1 ) {
                os.write(bytes, 0, ncount);
            }
            fis.close();
            os.close();
        } catch (FileNotFoundException ex) {
            System.out.println("FileNotFoundException");
        } catch (IOException ex) {
            System.out.println("IOException");
        }

		return ;
	}
	
	
	@RequestMapping(value = "/upload/img/{photoSeq}")
	public ResponseEntity<byte[]> upload(HttpServletRequest request, @PathVariable Long photoSeq) throws IOException {

		Photo photo = new Photo();

		if (photoSeq == null || photoSeq == 0) {

			photo.setPhotoSeq(new Long(1));
		} else {

			photo.setPhotoSeq(photoSeq);
		}

		photo = photoService.obtainPhoto(photo);

		String photoPath = null;

		if (photo.getResultCode() <= 0) {

			photoPath = StaticClass.UPLOAD_FOLDER + "male.png";
		} else {
			photoPath = StaticClass.UPLOAD_FOLDER + photo.getPhotoSavedFileName();
		}

		InputStream in = new FileInputStream(new File(photoPath));
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_PNG);
		headers.setContentLength(in.available());

		return new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.OK);

	}

	@RequestMapping(value = "/upload/{photoSeq}")
	public ResponseEntity<byte[]> uploadThumb(HttpServletRequest request, @PathVariable Long photoSeq)
			throws IOException {

		Photo photo = new Photo();

		if (photoSeq == null || photoSeq == 0) {

			photo.setPhotoSeq(new Long(1));
		} else {

			photo.setPhotoSeq(photoSeq);
		}

		photo = photoService.obtainPhoto(photo);

		String photoPath = null;

		if (photo.getResultCode() <= 0) {

			photoPath = StaticClass.UPLOAD_FOLDER + "tb_male.png";
		} else {
			photoPath = StaticClass.UPLOAD_FOLDER + photo.getPhotoThumbnailFileName();
		}

		try {

			InputStream in = new FileInputStream(new File(photoPath));
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.IMAGE_PNG);
			headers.setContentLength(in.available());

			return new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	@RequestMapping(value = "/file/download/{photoSeq}")
	public void fileDownload(HttpServletRequest request, HttpServletResponse response, @PathVariable Long photoSeq)
			throws IOException {

		Photo photo = new Photo();

		if (photoSeq == null || photoSeq == 0) {

			return ;
		} else {

			photo.setPhotoSeq(photoSeq);
		}

		photo = photoService.obtainPhoto(photo);

		String photoPath = null;

		if (photo.getResultCode() <= 0) {

			photoPath = StaticClass.UPLOAD_FOLDER + "tb_male.png";
		} else {
			photoPath = StaticClass.UPLOAD_FOLDER + photo.getPhotoSavedFileName();
		}

		String filename = photo.getPhotoFileName();
		
		File file1 = new File(photoPath);
		if (!file1.exists()) {
			return ;
		}

		response.setContentType("application/octer-stream");
        response.setHeader("Content-Transfer-Encoding", "binary;");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");
		
        try {
            OutputStream os = response.getOutputStream();
            FileInputStream fis = new FileInputStream(photoPath);
 
            int ncount = 0;
            byte[] bytes = new byte[512];
 
            while ((ncount = fis.read(bytes)) != -1 ) {
                os.write(bytes, 0, ncount);
            }
            fis.close();
            os.close();
        } catch (FileNotFoundException ex) {
            System.out.println("FileNotFoundException");
        } catch (IOException ex) {
            System.out.println("IOException");
        }

		return ;
	}
	
}
