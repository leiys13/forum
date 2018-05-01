package org.applesline.forum.web;

/**
 * 接口枚举。
 *
 * Created by liuyaping on 2018/3/26
 */
public enum UrlsEnum {

    Article_list("文章列表","/article/list"),
    Article_detail("文章详情","/article/");

    private static final String baseUrl = "http://localhost:8080";
    public String name;
    public String url;

    private UrlsEnum(String name,String url) {
        this.name = name;
        this.url = baseUrl + url;
    }
}
