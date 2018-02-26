/**
 * Project Name:mobpush-api-java-client
 * File Name:MobHelper.java
 * Package Name:mob.push.api.utils
 * Date: 2018年2月6日
 * Time: 下午5:14:47
 *
*/

package mob.push.api.utils;

import java.nio.charset.Charset;

/**
 * ClassName:MobHelper
 * TODO ADD DESCRIPTION
 * Date: 2018年2月6日
 * Time: 下午5:14:47
 * @author   hlliu 	 
 */
public class MobHelper {
	
	/** 编码相关常量 */
    public static final String    ENCODE_UTF8                   = "UTF-8";
    public static final String    ENCODE_GBK                    = "GBK";
    public static final Charset   CHARSET_UTF8                  = Charset.forName(ENCODE_UTF8);
    public static final Charset   CHARSET_GBK                   = Charset.forName(ENCODE_GBK);
    
    /**
     * HTTP_STATUS_200: HTTP响应码200
     */
    public static final int       HTTP_STATUS_200 				= 200;
    
    /**
     * HTTP_STATUS_400: HTTP响应码400
     */
    public static final int       HTTP_STATUS_400 				= 400;
	
	public static boolean isBlank(String str){
		return str == null || "".equals(str.trim());
	}
	
	public static boolean isNotBlank(String str){
		return !isBlank(str);
	}

}

