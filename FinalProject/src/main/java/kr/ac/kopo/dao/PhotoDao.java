package kr.ac.kopo.dao;

import java.util.List;

import com.javamodeling.common.Pagination;
import com.javamodeling.component.DaoInterface;

import kr.ac.kopo.pojo.HanaFile;
import kr.ac.kopo.pojo.Member;
import kr.ac.kopo.pojo.Product;
import kr.ac.kopo.pojo.ProductImg;

public interface PhotoDao extends DaoInterface {

	public HanaFile addPhoto(HanaFile photo);

	public HanaFile removePhoto(HanaFile photo);
	
	HanaFile obtainPhoto(HanaFile photo);

	HanaFile obtainPhotoByPk(HanaFile photo);




}
