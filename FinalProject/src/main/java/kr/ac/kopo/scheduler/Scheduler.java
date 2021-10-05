package kr.ac.kopo.scheduler;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import kr.ac.kopo.service.AuctionService;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Component
public class Scheduler {
  
  @Autowired
  private AuctionService auctionService;
	
  @Scheduled(cron = "0 0 0 * * *")
  public void autoUpdate() throws Exception {//
     
     System.out.println("00시 땡");
     
     auctionService.addAuctionSuccessBidTransaction();//입찰자에게 송금 메소드 (입찰 시간 종료 파악 후 송금은 00시)
     
     
  }
  

  

}