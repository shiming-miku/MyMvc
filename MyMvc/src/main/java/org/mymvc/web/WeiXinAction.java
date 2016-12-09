package org.mymvc.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.servlet.http.HttpServletResponse;

import org.mymvc.model.WeixinAccess;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.script.DigestUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/weixin")
public class WeiXinAction {

	private final Logger logger=LoggerFactory.getLogger(WeiXinAction.class);
	
	@RequestMapping(value="/access.html",method=RequestMethod.GET)
	private String Access(WeixinAccess access,HttpServletResponse response){
		logger.info("微信验证请求来了");
        logger.info("微信请求参数:"+access.toString());	
        //获取微信封装的参数
        String signature=access.getSignature();
        String timestamp=access.getTimestamp();
        String nonce=access.getNonce();
        String token="shiming";
        //进行排序
        ArrayList<String> list=new ArrayList<String>();
        list.add(nonce);
        list.add(timestamp);
        list.add(token);

        Collections.sort(list);
        String signature2 = DigestUtils.sha1DigestAsHex(list.get(0)+list.get(1)+list.get(2));
        System.out.println(signature2);
        if(signature.equals(signature2)){
        	logger.info("微信请求验证成功");
        	try {
				response.getWriter().print(access.getEchostr());
				logger.info(response.toString());
			} catch (IOException e) {
				e.printStackTrace();
			} finally{
				return null;
			}
        }else{
        	return null;
        }
		
	}
}
