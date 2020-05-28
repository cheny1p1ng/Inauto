package com.course.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Administrator on 2019/6/4.
 */
public class MyCookiesForGet {

    private String url;
    private ResourceBundle bundle;
    //用来存储cookies信息的变量
    private CookieStore store;
    @BeforeTest
    public void  beforeTest(){
        bundle = ResourceBundle.getBundle("application",Locale.CHINA);
        url = bundle.getString("test.url");
    }

    @Test
    public void testGetCookies() throws IOException {
        String result;
        String uri = bundle.getString("getCookies.uri");
        String testUrl = this.url+uri;
        HttpGet get = new HttpGet(testUrl);
        //CloseableHttpClient替换DefaultHttpClient获取cookies
        this.store = new BasicCookieStore();
        CloseableHttpClient httpClient = HttpClients.custom().setDefaultCookieStore(this.store).build();
        HttpResponse response = httpClient.execute(get);
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.printf(result);
        List<Cookie> CookieList =  this.store.getCookies();
        for (Cookie cookie:CookieList){
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.printf("cookies name = "+name  +";");
            System.out.printf("cookies value = "+value);
        }
    }

    @Test(dependsOnMethods ={"testGetCookies"} )
    public void testGetWithCookies() throws IOException {

        String result;
        String uri = bundle.getString("test.get.with.cookies");
        String testUrl = this.url+uri;
        HttpGet get = new HttpGet(testUrl);
        CloseableHttpClient httpClient = null;
        //设置cookies信息
        httpClient = HttpClients.custom().setDefaultCookieStore(this.store).build();
        HttpResponse response = httpClient.execute(get);
        //获取响应状态码
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println(statusCode);
        if (statusCode==200){
            result = EntityUtils.toString(response.getEntity(),"utf-8");
            System.out.printf(result);
        }

    }
}