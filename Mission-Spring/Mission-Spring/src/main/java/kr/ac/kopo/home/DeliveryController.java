package kr.ac.kopo.home;

import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.ac.kopo.common.COLUMN;
import kr.ac.kopo.delivery.service.DeliveryService;
import kr.ac.kopo.delivery.vo.HyunSeeugDelivery;

@Controller 
public class DeliveryController {
	
	@Autowired
	DeliveryService deliveryService;
	
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	@GetMapping("/addDelivery")
	public String addDelivery() {
		return "addDelivery";
	}
	
	@PostMapping("/addDelivery")
	public ModelAndView addDelivery(ModelAndView modelAndView, HyunSeeugDelivery hyunseeugDelivery) {
		
		hyunseeugDelivery.setProductStatus(COLUMN.PRODUCT_DELIVERY.GET_DELIVERY);
		
		deliveryService.addDelivery(hyunseeugDelivery);
		
		modelAndView.setViewName("redirect:/");
		return modelAndView;
	}
	
	@GetMapping("/modifyDelivery")
	public String modifyDeliveryPage() {
		return "modifyDelivery";
	}
	
	@GetMapping("/getDeliveryInformation")
	@ResponseBody
	public String getDeliveryInformation(HyunSeeugDelivery hyunseeugDelivery) {
		
		HyunSeeugDelivery hyunseeugDeliveryResult = new HyunSeeugDelivery();
		
		hyunseeugDeliveryResult = deliveryService.obtainDeliveryByUnsongJang(hyunseeugDelivery);
		
		return JSONValue.toJSONString(hyunseeugDeliveryResult.getProductStatus());
	}
	
	
	@GetMapping("/modifyDeliverySearch")
	public ModelAndView modifyDeliverySearch(ModelAndView modelAndView, HyunSeeugDelivery hyunseeugDelivery) {
		
		HyunSeeugDelivery hyunseeugDeliveryResult = new HyunSeeugDelivery();
		
		hyunseeugDeliveryResult = deliveryService.obtainDeliveryByUnsongJang(hyunseeugDelivery);
		
		modelAndView.addObject("Delivery", hyunseeugDeliveryResult);
		
		modelAndView.setViewName("modifyDeliverySearch");
		
		return modelAndView;
	}
	
	
	@PostMapping("/modifyDeliveryStatus")
	public ModelAndView modifyDelivery(ModelAndView modelAndView, HyunSeeugDelivery hyunseeugDelivery) {
		
		deliveryService.modifyDeliveryStatus(hyunseeugDelivery);
		
		modelAndView.setViewName("redirect:/");
		return modelAndView;
	}
	
	
}
