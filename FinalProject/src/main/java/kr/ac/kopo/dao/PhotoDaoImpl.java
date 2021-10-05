package kr.ac.kopo.dao;

import org.springframework.stereotype.Repository;

import com.javamodeling.component.DaoInterface;
import com.javamodeling.dao.JPADaoSupport;

import kr.ac.kopo.pojo.HanaFile;
import kr.ac.kopo.pojo.Member;
import kr.ac.kopo.pojo.Product;
import kr.ac.kopo.pojo.ProductImg;

@Repository
public class PhotoDaoImpl extends JPADaoSupport implements PhotoDao {

	@Override
	public HanaFile obtainPhoto(HanaFile photo) {

		
		HanaFile photoResult = entityManager.find(HanaFile.class, photo.getFileSq());

		return photoResult;
	}

	@Override
	public HanaFile obtainPhotoByPk(HanaFile photo) {
		
		HanaFile photoResult = new HanaFile();
		try {
			String strSQL ="SELECT a FROM HanaFile as a WHERE a.fileSq = :fileSq";

			photoResult = entityManager.createQuery(strSQL, HanaFile.class)			
			.setParameter("fileSq", photo.getFileSq())
			.getSingleResult();
			
			photoResult.setResultCode(1L);
		} catch (Exception e) {
			e.printStackTrace();
			photoResult.setResultCode(0L);
		} 
			return photoResult;
	}

	@Override
	public HanaFile removePhoto(HanaFile photo) {

		HanaFile photo2 = entityManager.find(HanaFile.class, photo.getFileSq());

		entityManager.remove(photo2);

		return photo;
	}

	@Override
	public HanaFile addPhoto(HanaFile photo) {

		entityManager.persist(photo);

		return photo;
	}




}
