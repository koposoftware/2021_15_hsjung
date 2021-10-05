package kr.ac.kopo.common;

public class COLUMN {

	
	public static final class PRODUCT_DELIVERY {
		
		/**
		 * 안심거래중 (배송접수)
		 */
		public static final String GET_DELIVERY = "GD";
	
		/**
		 * 안심거래중 (상품 이동 중)
		 */
		public static final String MOVE_DELIVERY = "MD";
	
		/**
		 * 안심거래중 (배송지 도착)
		 */
		public static final String ARRIVE_DELIVERY = "AD";
		
		/**
		 * 안심거래중 (배송 출발)
		 */
		public static final String START_DELIVERY = "SD";
		
		/**
		 * 안심거래 완료(배송 도착)
		 */
		public static final String END_DELIVERY = "ED";
		
	}


	

}
