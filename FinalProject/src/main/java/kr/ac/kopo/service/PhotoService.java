package kr.ac.kopo.service;

import kr.ac.kopo.pojo.HanaFile;

public interface PhotoService {

	public HanaFile addPhoto(HanaFile quickPhoto);

	public HanaFile removePhoto(HanaFile quickPhoto);
	
	public HanaFile obtainPhoto(HanaFile photo);
	
}
