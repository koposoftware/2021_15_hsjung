package kr.ac.kopo.service;

import java.io.File;

import com.javamodeling.spring.SpringConstants;

import kr.ac.kopo.pojo.Photo;

public class ServiceSupport {

	/**
	 * 사진 파일을 삭제한다.
	 * @param photo : PLUS_PHOTO 객체
	 * @param username : 이메일
	 */
	protected void deletePhotoFile(Photo photo) {

		try {

			String savedFileName = photo.getPhotoSavedFileName();
			String thumbnailFileName = photo.getPhotoThumbnailFileName();
			
			File savedFile = new File(SpringConstants.PHOTO_FOLDER + savedFileName);
			
			savedFile.delete();
			
			File thumbnailFile = new File(SpringConstants.PHOTO_FOLDER + thumbnailFileName);
			
			thumbnailFile.delete();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	/**
	 * 업로드한 이미지 파일을 삭제한다.
	 * @param photo : PLUS_PHOTO 객체
	 * @param upperFolderName : 상위 폴더 이름
	 * @param folder : 이미지가 저장된 폴더 이름
	 */
	protected void deleteImageFile(Photo photo) {

		try {

			String savedFileName = photo.getPhotoSavedFileName();
			String thumbnailFileName = photo.getPhotoThumbnailFileName();
			
			File savedFile = new File(SpringConstants.UPLOAD_FOLDER + savedFileName);
			
			savedFile.delete();
			
			File thumbnailFile = new File(SpringConstants.UPLOAD_FOLDER + thumbnailFileName);
			
			thumbnailFile.delete();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
}
