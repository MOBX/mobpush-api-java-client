/**
 * Project Name:mobpush-api-java-client
 * File Name:ApiException.java
 * Package Name:mob.push.api.exception
 * Date: 2018年2月6日
 * Time: 上午11:07:10
 *
*/

package mob.push.api.exception;
/**
 * ClassName:ApiException
 * TODO ADD DESCRIPTION
 * Date: 2018年2月6日
 * Time: 上午11:07:10
 * @author   hlliu 	 
 */
public class ApiException extends Exception{
	
	/**
	 * serialVersionUID:TODO FIELD DESCRIPTION
	 */
	private static final long serialVersionUID = 3497788855492748601L;

	/**
	 * status: HTTP状态码
	 */
	private int status;
	
	/**
	 * errorMessage: 错误信息
	 */
	private String errorMessage;
	 
	/**
	 * errorCode: 错误状态码
	 */
	private int errorCode;
	
	public ApiException(){
		
	}
	
	public ApiException(int status, int errorCode, String errorMessage){
		super(errorMessage);
		this.status = status;
		this.errorCode = errorCode;
		this.errorMessage = errorMessage; 
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
}

