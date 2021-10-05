package kr.ac.kopo.delivery.service;

import java.util.List;

import kr.ac.kopo.delivery.vo.HyunSeeugDelivery;

public interface DeliveryService {

	void addDelivery(HyunSeeugDelivery hyunseeugDelivery);

	HyunSeeugDelivery obtainDeliveryByUnsongJang(HyunSeeugDelivery hyunseeugDelivery);

	void modifyDeliveryStatus(HyunSeeugDelivery hyunseeugDelivery);



}
