package kr.ac.kopo.controller.member;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javamodeling.spring.SpringConstants;

import kr.ac.kopo.common.BaseController;
import kr.ac.kopo.pojo.HanaFile;
import kr.ac.kopo.service.PhotoService;


@Controller
@RequestMapping("/photo")
public class PhotoController extends BaseController {
	
	@Autowired
	private PhotoService hanaFileService;
	
	/**
	 * 썸네일 이미지 파일 출력 
	 * @param request
	 * @param hanaFileSeq 파일 시퀀스
	 * @return
	 * @throws IOException
	 */
	@GetMapping(value = "/{hanaFileSeq}")
	public ResponseEntity<byte[]> photoThumb(HttpServletRequest request, @PathVariable Long hanaFileSeq) throws IOException {

		HanaFile photo = new HanaFile();

		if (hanaFileSeq == null || hanaFileSeq == 0) {

			photo.setFileSq(new Long(1));
		} else {

			photo.setFileSq(hanaFileSeq);
		}

		photo = hanaFileService.obtainPhoto(photo);

		String photoPath = null;

		photoPath = SpringConstants.PHOTO_FOLDER + photo.getFileThumbnailFileName();

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
	
	@RequestMapping(value = "/img/{photoSeq}")
	public ResponseEntity<byte[]> photo(HttpServletRequest request, @PathVariable Long photoSeq) throws IOException {

		HanaFile photo = new HanaFile();

		if (photoSeq == null || photoSeq == 0) {

			photo.setFileSq(new Long(1));
		} else {

			photo.setFileSq(photoSeq);
		}

		photo = hanaFileService.obtainPhoto(photo);

		String photoPath = null;

		photoPath = SpringConstants.PHOTO_FOLDER + photo.getFileSavedFileName();

		InputStream in = new FileInputStream(new File(photoPath));
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_PNG);
		headers.setContentLength(in.available());

		return new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.OK);

	}
	
}
