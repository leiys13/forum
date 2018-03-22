package org.applesline.forum.base;

/**
 * @date 2018年3月19日
 * @author lei.ys
 * @addr company
 * @desc 状态码设定
 */
public enum Status {

	/**
	 * code：100  请求成功
	 */
	SUCCESS,
	/**
	 * code：600  请求出错（通用）
	 */
	REQUEST_ERROR,
	/**
	 * code：610   参数不正确，缺少必须参数或者参数值非法
	 */
	REQUEST_PARAM_ERROR,
	/**
	 * code：620  验证错误（参数为合法值，但是受系统限制，如用户名不能重复）
	 */
	REQUEST_VALID_ERROR,
	/**
	 * code：630  无权限
	 */
	REQUEST_AUTH_ERROR,
	/**
	 * code：640  请求不存在的数据
	 */
	REQUEST_NOT_EXIST_ERROR,
	/**
	 * code：680  未登录
	 */
	REQUEST_NO_LOGIN_ERROR,
	/**
	 * code：800  系统错误（通用）
	 */
	SYSTEM_ERROR,
	/**
	 * code：810  系统处理时间过长
	 */
	SYSTEM_SLOW_ERROR

}
