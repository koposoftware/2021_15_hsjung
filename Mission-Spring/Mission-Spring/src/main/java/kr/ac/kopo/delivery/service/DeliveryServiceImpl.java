package kr.ac.kopo.delivery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.delivery.dao.DeliveryDAO;
import kr.ac.kopo.delivery.vo.HyunSeeugDelivery;

@Service
public class DeliveryServiceImpl  implements DeliveryService{

	@Autowired
	private DeliveryDAO deliveryDAO;

	public void addDelivery(HyunSeeugDelivery hyunseeugDelivery) {
		
		deliveryDAO.addDelivery(hyunseeugDelivery);
	}

	public HyunSeeugDelivery obtainDeliveryByUnsongJang(HyunSeeugDelivery hyunseeugDelivery) {
		
		HyunSeeugDelivery hyunseeugDeliveryResult = new HyunSeeugDelivery();
		
		hyunseeugDeliveryResult = deliveryDAO.obtainDeliveryByUnsongJang(hyunseeugDelivery);
		
		return hyunseeugDeliveryResult;
	}

	public void modifyDeliveryStatus(HyunSeeugDelivery hyunseeugDelivery) {
		
		deliveryDAO.modifyDeliveryStatus(hyunseeugDelivery);
		
	}


	
	

}
