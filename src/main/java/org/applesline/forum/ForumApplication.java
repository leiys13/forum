/**
 * 
 */
package org.applesline.forum;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Controller;

/**
 * @author liuyaping
 *
 *         创建时间：2018年2月8日
 */
@Controller
@EnableAutoConfiguration
@ImportResource("classpath:spring/*.xml")
public class ForumApplication {

	@Value("${author}")
	public String name;
	
	public String getAuthor() {
		return name;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ForumApplication.class, args);
	}

}
