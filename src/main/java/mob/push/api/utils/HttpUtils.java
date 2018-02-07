package mob.push.api.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import mob.push.api.exception.ApiException;

/**
 * HTTP 工具类
 * @author hlliu
 * Date: 2018年2月5日
 * Time: 下午9:03:09
 */
public class HttpUtils {

	/**
	 * HTTP  POST 处理工具类
	 * @author hlliu
	 * Date: 2018年2月5日
	 * Time: 下午9:03:21
	 */
	public static class PostEntity {

		/**
		 * httpUrl:请求接口地址
		 */
		private String httpUrl;
		/**
		 * statusCode: 接口返回状态
		 */
		private int statusCode;
		/**
		 * resp: 接口返回内容
		 */
		private String resp;
		/**
		 * appkey: MobPush AppKey
		 */
		private String appkey;
		/**
		 * appSecret: MobPush AppKey 对应 secret 
		 */
		private String appSecret;

		/**
		 * orgData: 请求数据体 ： JSON.toString()
		 */
		private String orgData;
 
		public PostEntity(String httpUrl, String appkey, String appSecret, String orgData) {
			this.httpUrl = httpUrl;
			this.orgData = orgData;
			this.appkey = appkey;
			this.appSecret = appSecret;
		}

		public int getStatusCode() {
			return statusCode;
		}

		public String getResp() {
			return resp;
		}

		public String getAppkey() {
			return appkey;
		}

		public String getAppSecret() {
			return appSecret;
		}
  
		protected String serverSign(String decodeData, String appSecret) {
			return MD5.hash(decodeData + appSecret, MobHelper.CHARSET_UTF8);
		}

		public PostEntity invoke(boolean useGzip) throws ApiException {
			
			if(MobHelper.isBlank(appkey) || MobHelper.isBlank(appSecret)){
				throw new ApiException(MobHelper.HTTP_STATUS_400, -1, "appkey or appSecret is null,Please go to MobPushConfig to set them");
			}
			  
			RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(30000).setConnectTimeout(30000)
					.setConnectionRequestTimeout(30000).build();
			HttpPost httpPost = new HttpPost(httpUrl);
			httpPost.setHeader("sign", serverSign(this.orgData, appSecret));
			httpPost.setHeader("key", appkey);
			CloseableHttpClient httpClient = null;
			CloseableHttpResponse response = null;
			HttpEntity entity = null;
			try {
				try {
					httpClient = HttpClients.createDefault();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				httpPost.setConfig(requestConfig);

				if (!useGzip) {
					httpPost.setEntity(new StringEntity(this.orgData, "UTF-8"));
				} else {
					httpPost.setHeader("Content-Encoding", "gzip");
					ByteArrayOutputStream originalContent = new ByteArrayOutputStream();
					originalContent.write(this.orgData.getBytes(Charset.forName("UTF-8")));
					ByteArrayOutputStream baos = new ByteArrayOutputStream();
					GZIPOutputStream gzipOut = new GZIPOutputStream(baos);
					originalContent.writeTo(gzipOut);
					gzipOut.finish();
					httpPost.setEntity(
							(new ByteArrayEntity(baos.toByteArray(), org.apache.http.entity.ContentType.TEXT_PLAIN)));
				}

				// 执行请求
				response = httpClient.execute(httpPost);
				entity = response.getEntity();
				resp = EntityUtils.toString(entity, "UTF-8"); 
				statusCode = response.getStatusLine().getStatusCode(); 

			} catch (Exception e) {
				throw new ApiException(MobHelper.HTTP_STATUS_400, -1, e.toString());
			} finally {
				closeConn(httpClient, response);
			}
			return this;
		} 
	}
 
	/**
	 * HTTP GET 处理工具类
	 * @author hlliu
	 * Date: 2018年2月5日
	 * Time: 下午9:03:40
	 */
	public static class GetEntity {

		/**
		 * httpUrl:请求接口地址
		 */
		private String httpUrl;
		/**
		 * statusCode: 接口返回状态
		 */
		private int statusCode;
		/**
		 * resp: 接口返回内容
		 */
		private String resp;
		/**
		 * appkey: MobPush AppKey
		 */
		private String appkey;
		/**
		 * appSecret: MobPush AppKey 对应 secret 
		 */
		private String appSecret;

		/**
		 * par: 请求参数对
		 */
		private Map<String, Object> par;

		public GetEntity(String httpUrl, String appkey, String appSecret, Map<String, Object> par) {
			this.httpUrl = httpUrl;
			this.par = par;
			this.appkey = appkey;
			this.appSecret = appSecret;
		}

		/**
		 * 键值对排序
		 * @return
		 */
		public String sort() {
			StringBuffer buffer = new StringBuffer();
			if (par == null) {
				return null;
			}
			List<Map.Entry<String, Object>> keys = new ArrayList<Map.Entry<String, Object>>(par.entrySet());
			Collections.sort(keys, new Comparator<Map.Entry<String, Object>>() {
				public int compare(Map.Entry<String, Object> o1, Map.Entry<String, Object> o2) {
					return (o1.getKey()).toString().compareTo(o2.getKey());
				}
			});
			for (Map.Entry<String, Object> key : keys) {
				buffer.append(key.getKey() + "=" + key.getValue() + "&");
			}
			if (buffer.length() > 0) {
				return buffer.toString().substring(0, buffer.length() - 1);
			}

			return buffer.toString();
		}

		public GetEntity invoke() throws ApiException {
			
			if(MobHelper.isBlank(appkey) || MobHelper.isBlank(appSecret)){
				throw new ApiException(MobHelper.HTTP_STATUS_400, -1, "appkey or appSecret is null,Please go to MobPushConfig to set them");
			}
			
			RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(15000).setConnectTimeout(15000)
					.setConnectionRequestTimeout(15000).build();
			if (par != null) {
				httpUrl = httpUrl + this.sort();
			}
			HttpGet httpGet = new HttpGet(httpUrl);
			httpGet.setHeader("sign", serverSign(this.sort(), appSecret));
			httpGet.setHeader("key", appkey);
			CloseableHttpClient httpClient = null;
			CloseableHttpResponse response = null;
			HttpEntity entity = null;
			try {
				httpClient = HttpClients.createDefault();
				httpGet.setConfig(requestConfig);
				response = httpClient.execute(httpGet);
				entity = response.getEntity();
				resp = EntityUtils.toString(entity, "UTF-8");

				statusCode = response.getStatusLine().getStatusCode();
				// 完整响应报文

			} catch (Exception e) { 
				throw new ApiException(MobHelper.HTTP_STATUS_400, -1, e.toString());
			} finally {
				closeConn(httpClient, response);
			}
			return this;
		}

		protected String serverSign(String decodeData, String appSecret) {
			if (decodeData == null || decodeData.equals("")) {
				return MD5.hash(appSecret, MobHelper.CHARSET_UTF8);
			}
			return MD5.hash(decodeData + appSecret, MobHelper.CHARSET_UTF8);
		}

		public String getAppkey() {
			return appkey;
		}

		public int getStatusCode() {
			return statusCode;
		}

		public String getResp() {
			return resp;
		}

		public String getAppSecret() {
			return appSecret;
		}
 
	}

	/** 
	 * HTTP CONN CLOSE 
	 * @param httpClient
	 * @param response
	 */
	private static void closeConn(CloseableHttpClient httpClient, CloseableHttpResponse response) {
		try {
			// 关闭连接,释放资源
			if (response != null) {
				response.close();
			}
			if (httpClient != null) {
				httpClient.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
