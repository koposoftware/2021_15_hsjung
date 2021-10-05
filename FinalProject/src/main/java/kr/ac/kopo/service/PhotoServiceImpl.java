package kr.ac.kopo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import kr.ac.kopo.dao.PhotoDao;
import kr.ac.kopo.pojo.HanaFile;
import kr.ac.kopo.pojo.Photo;

@Service
@Transactional(readOnly=true)
public class PhotoServiceImpl implements PhotoService {

	@Autowired
	PhotoDao photoDao;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public HanaFile obtainPhoto(HanaFile photo) {
		
//		HanaFile hanaFileResult = photoDao.obtainEntityByPk(photo);
		HanaFile hanaFileResult = photoDao.obtainPhoto(photo);
		
		return hanaFileResult;
		
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public HanaFile addPhoto(HanaFile photo) {

		return photoDao.addPhoto(photo);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public HanaFile removePhoto(HanaFile photo) {

		return photoDao.removePhoto(photo);
	}
	
	

}
