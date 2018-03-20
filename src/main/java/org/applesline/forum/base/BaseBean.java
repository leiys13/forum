package org.applesline.forum.base;

import java.io.Serializable;

import org.applesline.forum.util.JsonUtil;

/**
 * @date 2018年3月8日
 * @author lei.ys
 * @addr company
 * @desc
 */
public class BaseBean implements Serializable {

	private static final long serialVersionUID = 4906437546451769683L;

	@Override
	public String toString() {
		return JsonUtil.writeJson(this);
	}

}
