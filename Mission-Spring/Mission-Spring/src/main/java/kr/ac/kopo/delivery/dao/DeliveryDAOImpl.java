package kr.ac.kopo.delivery.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.delivery.vo.HyunSeeugDelivery;

@Repository
public class DeliveryDAOImpl implements DeliveryDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public void addDelivery(HyunSeeugDelivery hyunseeugDelivery) {

		sqlSessionTemplate.insert("delivery.DeliveryDAO.addDelivery" , hyunseeugDelivery);
	}

	public HyunSeeugDelivery obtainDeliveryByUnsongJang(HyunSeeugDelivery hyunseeugDelivery) {
		
		HyunSeeugDelivery hyunseeugDeliveryResult = new HyunSeeugDelivery();
		
		hyunseeugDeliveryResult = sqlSessionTemplate.selectOne("delivery.DeliveryDAO.obtainDeliveryByUnsongJang" , hyunseeugDelivery);
		
		return hyunseeugDeliveryResult;
	}

	public void modifyDeliveryStatus(HyunSeeugDelivery hyunseeugDelivery) {

		
		sqlSessionTemplate.update("delivery.DeliveryDAO.modifyDeliveryStatus" , hyunseeugDelivery);
		
	}
		
		
}
