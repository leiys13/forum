package org.applesline.forum.base;

/**
 * @date 2018年3月19日
 * @author lei.ys
 * @addr company
 * @desc 状态码设定
 */
public enum Status {

	/**
	 * code：100
	 */
	SUCCESS,
	/**
	 * code：600
	 */
	REQUEST_ERROR,
	/**
	 * code：610
	 */
	REQUEST_PARAM_ERROR,
	/**
	 * code：620
	 */
	REQUEST_VALID_ERROR,
	/**
	 * code：630
	 */
	REQUEST_AUTH_ERROR,
	/**
	 * code：640
	 */
	REQUEST_NOT_EXIST_ERROR,
	/**
	 * code：800
	 */
	SYSTEM_ERROR,
	/**
	 * code：810
	 */
	SYSTEM_SLOW_ERROR

}
