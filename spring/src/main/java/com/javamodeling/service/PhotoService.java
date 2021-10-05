package com.javamodeling.service;

import com.javamodeling.pojo.Photo;

public interface PhotoService {

	public Photo addPhoto(Photo quickPhoto);

	public Photo removePhoto(Photo quickPhoto);

	public Photo obtainPhoto(Photo quickPhoto);
}
