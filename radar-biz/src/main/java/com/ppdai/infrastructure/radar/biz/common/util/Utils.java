package com.ppdai.infrastructure.radar.biz.common.util;

import java.util.Date;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ppdai.infrastructure.radar.biz.dal.SoaLockRepository;
import com.ppdai.infrastructure.radar.biz.entity.InstanceEntity;

@Component
public class Utils {
	@Autowired
	private SoaLockRepository checkSkRep;	

	public Date getDbNow() {
		return checkSkRep.getDbNow();
	}	
		
	private static String LogTempate = "app_{}_{}_instance_{}_{}";

	public static void log(Logger log, InstanceEntity t1, String action) {
		log.info(LogTempate + "_{}", t1.getAppId(), t1.getCandAppId(), t1.getId(), t1.getCandInstanceId(),
				action.replaceAll(" ", "_"));
	}

	public static void log(Logger log, InstanceEntity t1, String action, String info) {
		log.info(LogTempate + "_{},{}", t1.getAppId(), t1.getCandAppId(), t1.getId(), t1.getCandInstanceId(),
				action.replaceAll(" ", "_"), info);
	}	
}
