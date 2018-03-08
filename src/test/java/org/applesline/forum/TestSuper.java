/**
 * 
 */
package org.applesline.forum;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 测试类基类。
 * 
 * @author liuyaping
 *
 * 创建时间：2018年3月8日
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ForumApplication.class,webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestSuper {

}
