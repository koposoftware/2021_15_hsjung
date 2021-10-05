package com.javamodeling.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.javamodeling.dao.PhotoDao;
import com.javamodeling.pojo.Photo;

@Service
@Transactional(readOnly = true)
public class PhotoServiceImpl implements PhotoService {

	@Autowired
	PhotoDao photoDao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Photo addPhoto(Photo photo) {

		return photoDao.addPhoto(photo);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Photo removePhoto(Photo photo) {

		return photoDao.removePhoto(photo);
	}

	@Override
	public Photo obtainPhoto(Photo photo) {

		Photo photoResult = photoDao.obtainPhoto(photo);

		return photoResult;
	}

}
