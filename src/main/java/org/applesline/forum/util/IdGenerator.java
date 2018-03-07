/**
 * 
 */
package org.applesline.forum.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author liuyaping
 *
 *         创建时间：2018年3月3日
 */
public class IdGenerator {
	private static final int minIncrementNum = 1;
	private static final int maxIncrementNum = 10000;
	private static AtomicInteger atomicId = new AtomicInteger(minIncrementNum);
	private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMddHHmmssSSS");

	public static Long generateId() {
		String sid = simpleDateFormat.format(new Date());
		int aid = atomicId.getAndIncrement();
		atomicId.compareAndSet(maxIncrementNum, minIncrementNum);
		return Long.parseLong(sid + aid);
	}

}
