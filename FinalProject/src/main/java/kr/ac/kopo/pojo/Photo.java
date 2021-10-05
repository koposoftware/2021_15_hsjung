package kr.ac.kopo.pojo;

import java.io.Serializable;
import javax.persistence.*;

import com.javamodeling.common.CommonPojo;
import com.javamodeling.common.ResultValue;


/**
 * The persistent class for the PHOTO database table.
 * 
 */
@Entity
@Table(name="PHOTO")
public class Photo extends CommonPojo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="PHOTO_SEQ")
	private Long photoSeq;

	@Column(name="PHOTO_FILE_NAME")
	private String photoFileName;

	@Column(name="PHOTO_FILE_SIZE")
	private Long photoFileSize;

	@Column(name="PHOTO_FILE_TYPE")
	private String photoFileType;

	@Column(name="PHOTO_INPUT_DATE")
	private String photoInputDate;

	@Column(name="PHOTO_SAVED_FILE_NAME")
	private String photoSavedFileName;

	@Column(name="PHOTO_THUMBNAIL_FILE_NAME")
	private String photoThumbnailFileName;

	public Photo() {
	}

	public Long getPhotoSeq() {
		return this.photoSeq;
	}

	public void setPhotoSeq(Long photoSeq) {
		this.photoSeq = photoSeq;
	}

	public String getPhotoFileName() {
		return this.photoFileName;
	}

	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}

	public Long getPhotoFileSize() {
		return this.photoFileSize;
	}

	public void setPhotoFileSize(Long photoFileSize) {
		this.photoFileSize = photoFileSize;
	}

	public String getPhotoFileType() {
		return this.photoFileType;
	}

	public void setPhotoFileType(String photoFileType) {
		this.photoFileType = photoFileType;
	}

	public String getPhotoInputDate() {
		return this.photoInputDate;
	}

	public void setPhotoInputDate(String photoInputDate) {
		this.photoInputDate = photoInputDate;
	}

	public String getPhotoSavedFileName() {
		return this.photoSavedFileName;
	}

	public void setPhotoSavedFileName(String photoSavedFileName) {
		this.photoSavedFileName = photoSavedFileName;
	}

	public String getPhotoThumbnailFileName() {
		return this.photoThumbnailFileName;
	}

	public void setPhotoThumbnailFileName(String photoThumbnailFileName) {
		this.photoThumbnailFileName = photoThumbnailFileName;
	}

}