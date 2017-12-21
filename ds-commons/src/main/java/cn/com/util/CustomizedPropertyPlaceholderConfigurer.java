package cn.com.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * 自定义PropertyPlaceholderConfigurer返回properties内容
 * Created on 2013-12-12
 * <p>Title:       XXXX系统_[模块名]/p>
 * <p>Description: [描述该类概要功能介绍]</p>
  * <p>Copyright:   Copyright (c) 2011</p>
 * <p>Company:     </p>
 * <p>Department:  网站运维部</p>
 * @author         zhl
 */
public class CustomizedPropertyPlaceholderConfigurer extends
		PropertyPlaceholderConfigurer {

	private static Map<String, Object> ctxPropertiesMap;

	@Override 
	protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess,Properties props) throws BeansException {
		super.processProperties(beanFactoryToProcess, props); 
		ctxPropertiesMap = new HashMap<String, Object>();
		for (Object key : props.keySet()) {
		    String keyStr = key.toString();
		    String value = props.getProperty(keyStr);
		    ctxPropertiesMap.put(keyStr, value);
		}
	}
	public static Object getContextProperty(String name) {
		return ctxPropertiesMap.get(name);
	}

}

