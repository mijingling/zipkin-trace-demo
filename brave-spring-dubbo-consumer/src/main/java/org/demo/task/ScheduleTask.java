package org.demo.task;

import org.apache.log4j.Logger;
import org.gmall.service.OtherUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

@Component
public class ScheduleTask {
	private static Logger log=Logger.getLogger(ScheduleTask.class);
	
	@Autowired
	private OtherUserService otherUserService;
	
	@Scheduled(cron = "0 */30 * * * *")//执行频率
    public void run() throws InterruptedException {
		try {
			String checkDubboResult=JSON.toJSONString(otherUserService.getUserAddressList("2-brave"));//访问dubbo服务
			log.info(checkDubboResult);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
}
