package kr.ac.kopo.pojo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import com.javamodeling.common.CommonPojo;
import com.javamodeling.common.ResultValue;


/**
 * The persistent class for the HANA_FILE database table.
 * 
 */
@Entity
@Table(name="HANA_FILE")
public class HanaFile extends CommonPojo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HanaFileSequenceGenerator")
	@SequenceGenerator(sequenceName = "HANA_FILE_SEQ", name = "HanaFileSequenceGenerator", allocationSize = 1)
	@Column(name="FILE_SQ")
	private Long fileSq;

	@Column(name="FILE_INPUT_DATE")
	private String fileInputDate;

	@Column(name="FILE_SAVED_FILE_NAME")
	private String fileSavedFileName;

	@Column(name="FILE_SIZE")
	private Long fileSize;

	@Column(name="FILE_THUMBNAIL_FILE_NAME")
	private String fileThumbnailFileName;

	@Column(name="FILE_TYPE")
	private String fileType;

	@Column(name="FILE_NAME")
	private String fileName;

	public HanaFile() {
	}

	public Long getFileSq() {
		return this.fileSq;
	}

	public void setFileSq(Long fileSq) {
		this.fileSq = fileSq;
	}

	public String getFileInputDate() {
		return this.fileInputDate;
	}

	public void setFileInputDate(String fileInputDate) {
		this.fileInputDate = fileInputDate;
	}

	public String getFileSavedFileName() {
		return this.fileSavedFileName;
	}

	public void setFileSavedFileName(String fileSavedFileName) {
		this.fileSavedFileName = fileSavedFileName;
	}

	public Long getFileSize() {
		return this.fileSize;
	}

	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}

	public String getFileThumbnailFileName() {
		return this.fileThumbnailFileName;
	}

	public void setFileThumbnailFileName(String fileThumbnailFileName) {
		this.fileThumbnailFileName = fileThumbnailFileName;
	}

	public String getFileType() {
		return this.fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	@Transient
	private List<MultipartFile> fileNameI;
	
	public List<MultipartFile> getFileNameI() {
		return fileNameI;
	}
	public void setFileNameI(List<MultipartFile> fileNameI) {
		this.fileNameI = fileNameI;
	}

}