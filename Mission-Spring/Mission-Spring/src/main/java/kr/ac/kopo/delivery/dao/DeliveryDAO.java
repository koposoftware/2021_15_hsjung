package kr.ac.kopo.delivery.dao;

import java.util.List;

import kr.ac.kopo.delivery.vo.HyunSeeugDelivery;

public interface DeliveryDAO {

	void addDelivery(HyunSeeugDelivery hyunseeugDelivery);

	HyunSeeugDelivery obtainDeliveryByUnsongJang(HyunSeeugDelivery hyunseeugDelivery);

	void modifyDeliveryStatus(HyunSeeugDelivery hyunseeugDelivery);


}
