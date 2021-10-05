package com.javamodeling.dao;

import com.javamodeling.pojo.Photo;

public interface PhotoDao {

	/**
	 * Photo 정보를 입력한다.
	 * 
	 * @param photo
	 * @return
	 */
	public Photo addPhoto(Photo photo);

	/**
	 * Photo 정보를 삭제한다.
	 * 
	 * @param photo
	 * @return
	 */
	public Photo removePhoto(Photo photo);

	/**
	 * Photo 정보를 조회한다.
	 * 
	 * @param photo
	 *            <br>
	 *            -> photoSeq : Photo PK
	 * @return
	 */
	public Photo obtainPhoto(Photo photo);

	/**
	 * 해당 프로필의 사진을 변경한다.
	 * 
	 * @param memberPhoto
	 * @return
	 */
	public String changeProfilePhoto(Long photo);

}
