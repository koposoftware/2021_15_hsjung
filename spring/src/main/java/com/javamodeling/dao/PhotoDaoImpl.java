package com.javamodeling.dao;

import org.springframework.stereotype.Repository;

import com.javamodeling.pojo.Photo;

@Repository
public class PhotoDaoImpl extends JPADaoSupport implements PhotoDao {

	@Override
	public Photo addPhoto(Photo photo) {

		entityManager.persist(photo);

		return photo;
	}

	@Override
	public Photo removePhoto(Photo photo) {

		Photo photo2 = entityManager.find(Photo.class, photo.getPhotoSeq());

		entityManager.remove(photo2);

		return photo;
	}

	@Override
	public Photo obtainPhoto(Photo photo) {

		Photo photoResult = entityManager.find(Photo.class, photo.getPhotoSeq());

		return photoResult;
	}

	@Override
	public String changeProfilePhoto(Long photo) {

		Photo findPhoto = entityManager.find(Photo.class, photo);

		String photoSavedFileName = findPhoto.getPhotoSavedFileName();

		entityManager.remove(findPhoto);

		return photoSavedFileName;
	}

}
