package com.javamodeling.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.javamodeling.common.ResultValue;



/**
 * The persistent class for the QUICK_PHOTO database table.
 * 
 */
@Entity
@Table(name="PLUS_PHOTO")
public class Photo extends ResultValue implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="PHOTO_FILE_NAME")
	private String photoFileName;

	@Column(name="PHOTO_INPUT_DATE")
	private String photoInputDate;

	@Column(name="PHOTO_SAVED_FILE_NAME")
	private String photoSavedFileName;
	
	@Column(name="PHOTO_FILE_TYPE")
	private String photoFileType;
	
	@Column(name="PHOTO_FILE_SIZE")
	private Long photoFileSize;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PHOTO_SEQ")
	private Long photoSeq;

	@Column(name="PHOTO_THUMBNAIL_FILE_NAME")
	private String photoThumbnailFileName;

	public Photo() {
	}

	public String getPhotoFileName() {
		return this.photoFileName;
	}

	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}

	public String getPhotoInputDate() {
		return this.photoInputDate;
	}

	public void setPhotoInputDate(String photoInputDate) {
		this.photoInputDate = photoInputDate;
	}

	public String getPhotoSavedFileName() {
		return photoSavedFileName;
	}

	public void setPhotoSavedFileName(String photoSavedFileName) {
		this.photoSavedFileName = photoSavedFileName;
	}

	public String getPhotoFileType() {
		return photoFileType;
	}

	public void setPhotoFileType(String photoFileType) {
		this.photoFileType = photoFileType;
	}

	public Long getPhotoFileSize() {
		return photoFileSize;
	}

	public void setPhotoFileSize(Long photoFileSize) {
		this.photoFileSize = photoFileSize;
	}

	public Long getPhotoSeq() {
		return this.photoSeq;
	}

	public void setPhotoSeq(Long photoSeq) {
		this.photoSeq = photoSeq;
	}

	public String getPhotoThumbnailFileName() {
		return this.photoThumbnailFileName;
	}

	public void setPhotoThumbnailFileName(String photoThumbnailFileName) {
		this.photoThumbnailFileName = photoThumbnailFileName;
	}

}