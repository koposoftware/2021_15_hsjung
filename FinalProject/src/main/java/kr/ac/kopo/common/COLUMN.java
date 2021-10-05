package kr.ac.kopo.common;

/**
 * 미리 설정해둔 값. 미리 해둠으로써 추후 기본값이라 특정 상태 입력할 때 실수를 줄이기 위함
 * @author belbe
 *
 */
public class COLUMN {

	/**
	 * Yes
	 */
	public static final String YES = "Y";

	/**
	 * No
	 */
	public static final String NO = "N";

	public static final Long DEFAULTSTATE = 0L;
	
	public static final class AUCTION {
		
		public static final class AUCTION_STATE {

			/**
			 * 신규
			 */
			public static final Long LIVE = 1L;

			/**
			 * 완료
			 */
			public static final Long DEFAULT = 0L;


		}
	}
	
public static final class PRODUCT {
		
	public static final Long DEFAULT_AMOUNT = 0L;
	
		public static final class PRODUCT_STATUS {

			/**
			 * 판매중
			 */
			public static final String SELLING= "0";

			/**
			 * 판매완료
			 */
			public static final String SELLED = "1";
		}
		
		public static final class PRODUCT_CAN {

			/**
			 * 가능
			 */
			public static final String CAN = "1";

			/**
			 * 불가능
			 */
			public static final String CANNOT = "0";
		}
		
		public static final class PRODUCT_SHIPPING {

			/**
			 *착불
			 */
			public static final String SHIPPING_CUSTOMER = "1";

			/**
			 * 배송비 포함
			 */
			public static final String SHIPPING_OWNER = "0";
		}
		
		public static final class PRODUCT_EXCHANGE {

			/**
			 *착불
			 */
			public static final String CAN_EX = "1";

			/**
			 * 배송비 포함
			 */
			public static final String CANNOT_EX = "0";
		}
		
		public static final class PRODUCT_CATEGORY {

			/**
			 * 패션의류
			 */
			public static final String FASHION = "패션의류";

			/**
			 * 뷰티잡화
			 */
			public static final String BEAUTY = "뷰티잡화";
			/**
			 * 유아용품
			 */
			public static final String BABY = "유아용품";
			/**
			 * 가구생활
			 */
			public static final String FURNITURE = "가구생활";
			/**
			 * 취미컬렉션
			 */
			public static final String HOBBY = "취미컬렉션";
			/**
			 * 디지털
			 */
			public static final String DIGITAL = "디지털";
			/**
			 * 컴퓨터
			 */
			public static final String COMPUTER = "컴퓨터";
			/**
			 * 스포츠레저
			 */
			public static final String SPORTS = "스포츠레저";
			/**
			 * 도서
			 */
			public static final String BOOK = "도서";
			/**
			 * 생활가전
			 */
			public static final String HOME_DIGITAL = "생활가전";
		}
		
		
	}

	public static final class PRODUCT_TRANSACTION {
		
		/**
		 * 안심거래시작 (접수만 진행)
		 */
		public static final String SAFE_START = "ST";
		
		/**
		 * 안심거래중 (배송접수)
		 */
		public static final String GET_DELIVERY = "GD";
		
		/**
		 * 안심거래 완료
		 */
		public static final String SAFE_END = "SE";
			
	}

	public static final class PRODUCT_DELIVERY {
		
		/**
		 * 안심거래중 (상품 인수)
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
		 * 안심거래중 (배송 도착)
		 */
		public static final String END_DELIVERY = "ED";
		
	}

	public static final class POST_IT_STATUS {
		
		/**
		 * 읽음
		 */
		public static final String READ = "RE";
		
		/**
		 * 안읽음
		 */
		public static final String NOT_READ = "N";
		
		/**
		 * 답장
		 */
		public static final String REPLY = "I";
			
	}
	

}
