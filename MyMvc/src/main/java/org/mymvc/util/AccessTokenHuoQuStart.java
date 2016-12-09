package org.mymvc.util;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.mymvc.dao.AccessTokenDao;
import org.mymvc.model.AccessToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class AccessTokenHuoQuStart implements ApplicationListener<ContextRefreshedEvent> {

	private static final Logger logger=LoggerFactory.getLogger(AccessTokenHuoQuStart.class);
	@Autowired
	private AccessTokenDao accessTokenDao;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		logger.info("服务启动获取access_token定时任务开始执行开始");
		CloseableHttpClient httpclient = HttpClients.createDefault();
		try {
			// 创建httpget.
			HttpGet httpget = new HttpGet(
					"https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wxc0335db37a5c80a0&secret=7bbea11342af906032e72053a46367a5");
			
			System.out.println("executing request " + httpget.getURI());
			// 执行get请求.
			CloseableHttpResponse response = httpclient.execute(httpget);
			try {
				// 获取响应实体
				HttpEntity entity = response.getEntity();
				System.out.println("--------------------------------------");
				// 打印响应状态
				System.out.println(response.getStatusLine());
				if (entity != null) {
					// 打印响应内容长度
					System.out.println("Response content length: "
							+ entity.getContentLength());
				    AccessToken accessToken = new ObjectMapper().readValue(EntityUtils.toString(entity),AccessToken.class);
				    logger.info("获取的accessToken为"+accessToken);
				    accessTokenDao.insertAccessToken(accessToken);
			    }
			} finally {
				response.close();
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			logger.error(e.getMessage(),e);
		} catch (ParseException e) {
			e.printStackTrace();
			logger.error(e.getMessage(),e);
		} catch (IOException e) {
			e.printStackTrace();
			logger.error(e.getMessage(),e);
		} finally {
			// 关闭连接,释放资源
			try {
				httpclient.close();
				logger.info("服务启动获取access_token定时任务开始执行结束");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
