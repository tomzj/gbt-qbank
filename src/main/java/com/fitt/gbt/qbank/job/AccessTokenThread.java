package com.fitt.gbt.qbank.job;

import com.fitt.gbt.qbank.common.model.AccessToken;
import com.fitt.gbt.qbank.common.utils.WeixinUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * <p>@Description: 定时获取access_token
 * 定时获取微信access_token的线程
 * 在WechatMpDemoApplication中注解@EnableScheduling，在程序启动时就开启定时任务
 * 每7200秒执行一次
 * </p>
 * <p>@Copyright: Copyright(C) 2017 by AIRAG</p>
 * <p>@Author: Chuck[ZhengCongChun]</p>
 * <p>@Created: 2017-08-01</p>
 * <p>@version: 1.0</p>
 */
@Component
public class AccessTokenThread {
	private static Logger log = LoggerFactory.getLogger(AccessTokenThread.class);

	// 第三方用户唯一凭证
	public static String appid = "";

	// 第三方用户唯一凭证密钥
	public static String appsecret = "";
	// 第三方用户唯一凭证
	public static AccessToken accessToken = null;

	@Scheduled(fixedDelay = 2 * 3600 * 1000)
	//7200秒执行一次
	public void gettoken() {
		accessToken = WeixinUtil.getAccessToken(appid, appsecret);
		if (null != accessToken) {
			log.info("获取成功，accessToken:" + accessToken.getToken());
		} else {
			log.error("获取token失败");
		}
	}
}
