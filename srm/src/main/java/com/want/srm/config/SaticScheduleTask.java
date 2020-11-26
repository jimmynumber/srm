//package com.want.srm.config;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.util.HashMap;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.annotation.Async;
//import org.springframework.scheduling.annotation.EnableAsync;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.Scheduled;
//
//import com.want.srm.service.IPurchaseOrderService;
//
//@Configuration      //1.主要用于标记配置类，兼备Component的效果。
//@EnableScheduling   // 2.开启定时任务
//@EnableAsync        // 3.开启多线程
//public class SaticScheduleTask {
//   
//	@Autowired
//	private IPurchaseOrderService service;
//	
//	@Async
//	//3.添加定时任务
//    //@Scheduled(cron = "0/5 * * * * ?")
//	@Scheduled(fixedDelay = 1000*60*15)
//   //或直接指定时间间隔，例如：5秒
//   //@Scheduled(fixedRate=5000)
//	public void configureTasks() {
//       System.err.println("执行静态定时任务时间: " + LocalDateTime.now());
//       Map<String,String> map=new HashMap<>();
//       map.put("bedat_s", LocalDate.now()+"");
//       map.put("bedat_e", LocalDate.now()+"");
//       service.getPurchaseByZrfcqqt003(map);
//       
//   }
////   
////   @Async
////   @Scheduled(fixedDelay = 1000)  //间隔1秒
////   public void first() throws InterruptedException {
////       System.out.println("第一个定时任务开始 : " + LocalDateTime.now().toLocalTime() + "\r\n线程 : " + Thread.currentThread().getName());
////       System.out.println();
////       Thread.sleep(1000 * 10);
////   }
////
////   @Async
////   @Scheduled(fixedDelay = 2000)
////   public void second() {
////       System.out.println("第二个定时任务开始 : " + LocalDateTime.now().toLocalTime() + "\r\n线程 : " + Thread.currentThread().getName());
////       System.out.println();
////   }
////   
//}
