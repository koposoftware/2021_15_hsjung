package com.javamodeling.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.RandomStringUtils;
import org.json.simple.JSONObject;
import org.springframework.web.multipart.MultipartFile;

import com.javamodeling.common.Pagination;
import com.javamodeling.spring.SpringConstants;

import net.coobird.thumbnailator.Thumbnails;

public class ControllerSupport {

	protected String savePhotoFile(MultipartFile multipartFile, String username) {

		String saveFileName = null;

		try {

			if (multipartFile != null) {

				String fileName = multipartFile.getOriginalFilename();

				String folder = username.replace("@", "_");
				String folderPath = SpringConstants.PHOTO_FOLDER + folder;
				String extension = "";
				File newFolder = new File(folderPath);

				if (!newFolder.exists()) {
					newFolder.mkdirs();
				}

				saveFileName = System.currentTimeMillis() + "@@" + fileName;
				int i = saveFileName.lastIndexOf('.');
				if (i >= 0) {
					extension = saveFileName.substring(i+1);
				}

				File file = new File(folderPath + "/" + saveFileName);

				if(multipartFile.getSize() > 1048576){
					File tmpFile = new File(folderPath + "/tmp_" + saveFileName);
					multipartFile.transferTo(tmpFile);
					Thumbnails.of(ImageIO.read(tmpFile)).outputFormat(extension).scale(0.6).toFile(folderPath + "/" + saveFileName);
					Thumbnails.of(ImageIO.read(tmpFile)).outputFormat(extension).scale(0.25).toFile(folderPath + "/T" + saveFileName);
					tmpFile.delete();
				} else {
					multipartFile.transferTo(file);
					Thumbnails.of(ImageIO.read(file)).outputFormat(extension).scale(0.5).toFile(folderPath + "/T" + saveFileName);
				}

			}

		} catch (Exception e) {
			saveFileName = null;
			e.printStackTrace();
		}

		return saveFileName;
	}
	
	public static String removePhotoFile(String photoSavedFileName) {

		try {

			if (photoSavedFileName != null) {
				
				String folderPath = SpringConstants.PHOTO_FOLDER + photoSavedFileName;
				
				File removeFolder = new File(folderPath);

				if (!removeFolder.exists()) {
					removeFolder.delete();
				}
			}

		} catch (Exception e) {
			photoSavedFileName = null;
			e.printStackTrace();
		}

		return photoSavedFileName;
	}
	
	/**
	 * upload 하는 이미지를 저장
	 * @param multipartFile : 이미지 파일
	 * @param upperFolderName : 업무를 구문하는 폴더 이름(예: 게시판 -> notice, 이벤트 -> event)
	 * @param folderName : 파일이 저장되는 해당 폴더, 주로 PK 값으로 폴더를 만든다.
	 * @return
	 */
	protected String saveImageFile(MultipartFile multipartFile, String upperFolderName, String folderName) {

		String saveFileName = null;
		
		if (upperFolderName == null) {
			upperFolderName = "";
		}
		
		if (folderName == null) {
			folderName = "";
		}
		else {
			folderName = "/" + folderName;
		}

		try {

			if (multipartFile != null) {

				String fileName = multipartFile.getOriginalFilename();

				String folderPath = SpringConstants.UPLOAD_FOLDER + upperFolderName + folderName;
				String extension = "";
				File newFolder = new File(folderPath);

				if (!newFolder.exists()) {
					newFolder.mkdirs();
				}

				saveFileName = System.currentTimeMillis() + "@@" + fileName;
				int i = saveFileName.lastIndexOf('.');
				if (i >= 0) {
					extension = saveFileName.substring(i+1);
				}

				File file = new File(folderPath + "/" + saveFileName);

				if(multipartFile.getSize() > 1048576){
					File tmpFile = new File(folderPath + "/tmp_" + saveFileName);
					multipartFile.transferTo(tmpFile);
					Thumbnails.of(ImageIO.read(tmpFile)).outputFormat(extension).scale(0.6).toFile(folderPath + "/" + saveFileName);
					Thumbnails.of(ImageIO.read(tmpFile)).outputFormat(extension).scale(0.25).toFile(folderPath + "/T" + saveFileName);
					tmpFile.delete();
				} else {
					multipartFile.transferTo(file);
					Thumbnails.of(ImageIO.read(file)).outputFormat(extension).scale(0.5).toFile(folderPath + "/T" + saveFileName);
				}

			}

		} catch (Exception e) {
			saveFileName = null;
			e.printStackTrace();
		}

		return saveFileName;
	}
	
	/**
	 * 파일을  저장
	 * @param multipartFile : 저장할 파일
	 * @param upperFolderName : 업무를 구문하는 폴더 이름(예: 게시판 -> notice, 이벤트 -> event)
	 * @param folderName : 파일이 저장되는 해당 폴더, 주로 PK 또는 이메일 값으로 폴더를 만든다.
	 * @return 실제로 저장되는 파일명, 동일한 파일명으로 Overwrite 되는걸 방지하기 위해서, 실제로 저장되는 파일명이 변경된다.
	 */
	protected String uploadFile(MultipartFile multipartFile, String upperFolderName, String folderName) {

		String saveFileName = null;
		
		if (upperFolderName == null) {
			upperFolderName = "";
		}
		
		if (folderName == null) {
			folderName = "";
		}
		else {
			folderName = "/" + folderName;
		}

		try {

			if (multipartFile != null) {

				String fileName = multipartFile.getOriginalFilename();

				String folderPath = SpringConstants.UPLOAD_FOLDER + upperFolderName + folderName;
				File newFolder = new File(folderPath);

				if (!newFolder.exists()) {
					newFolder.mkdirs();
				}

				saveFileName = System.currentTimeMillis() + "@@" + fileName;

				File file = new File(folderPath + "/" + saveFileName);

				multipartFile.transferTo(file);
				
			}

		} catch (Exception e) {
			saveFileName = null;
			e.printStackTrace();
		}

		return saveFileName;
	}
	protected String generateJsonMessage(String title, String message) {
		
		Map<String, String> jsonObject = new HashMap<String, String>();
		
		jsonObject.put("title", title);
		jsonObject.put("message", message);
		
		return JSONObject.toJSONString(jsonObject);
	
		
	}
	
	protected String generateJsonMessage(String title, String message, Map<String, String> values) {
		
		values.put("title", title);
		values.put("message", message);
		
		return generateJsonMessage(values);
	}
	
	protected String generateJsonMessage(Map<String, String> values) {
		
		return JSONObject.toJSONString(values);
	}
	
	protected String generatePagination(Pagination pagination, String url, Map<String, String> parameterMap) {
		
		String parameter = "";
		
		if (parameterMap != null && parameterMap.size() > 0) {
			
			for (String key : parameterMap.keySet()) {
				parameter = parameter + "&" + key + "=" + parameterMap.get(key);
			}
		}
		
		int startPageNo = pagination.getStartPageNo();
		int endPageNo = pagination.getEndPageNo();
		
		if (endPageNo == 0) {
			return "";
		}
		
		StringBuffer buffer = new StringBuffer();
		
		String preDisabled = "";
		int preStartPageNo = startPageNo - 1;
		
		if (startPageNo == 1) {
			preDisabled = "disabled";
			preStartPageNo = 1;
		}
		
		String nextDisabled = "";
		int nextEndPageNo = endPageNo + 1;
		
		if (endPageNo == pagination.getLastPageNo()) {
			nextDisabled = "disabled";
			nextEndPageNo = endPageNo;
		}
		
		buffer.append("<nav>");
		buffer.append("  <ul class='pagination justify-content-center'>");
		buffer.append("            <li class='page-item " + preDisabled + "' id='firstPage'>");
		buffer.append("           	<a href='" + url + "?currentPage=1" + parameter + "' class='page-link'>&lt;&lt;</a>");
		buffer.append("            </li>");
		buffer.append("            <li class='page-item " + preDisabled + "' id='prePage'>");
		buffer.append("            	<a href='" + url + "?currentPage=" + preStartPageNo + parameter + "' class='page-link'>&lt;</a>");
		buffer.append("            </li>");
		
		for (int i = startPageNo; i <= endPageNo; i++) {
			
			String active = "";
			
			if (i == pagination.getCurrentPage()) {
				active = "active";
			}
			
			buffer.append("            <li class='page-item " + active + "'>");
			buffer.append("            	<a href='" + url + "?currentPage=" + i + parameter + "' class='page-link'>" + i + "</a>");
			buffer.append("            </li>");
		}
         
		buffer.append("            <li class='page-item" + nextDisabled + "' id='nextPage'>");
		buffer.append("            	<a href='" + url + "?currentPage=" + nextEndPageNo + parameter + "' class='page-link'>&gt;</a>");
		buffer.append("            </li>");
		buffer.append("            <li class='page-item" + nextDisabled + "' id='lastPage'>");
		buffer.append("            	<a href='" + url + "?currentPage=" + pagination.getLastPageNo() + parameter + "' class='page-link'>&gt;&gt;</a>");
		buffer.append("            </li>");
		buffer.append("        </ul>");
		buffer.append("    </nav>");
		
		return buffer.toString();
	}

}
