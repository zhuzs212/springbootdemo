package com.zhuzs.admin.utils;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * HTTP 请求工具类
 *
 * @author zhu_zishuang
 * @date 6/18/21
 */
@Slf4j
public class HttpUtil {

    /**
     * HTTP POST请求
     *
     * @param httpEntity
     * @param httpPost
     * @return 响应结果
     */
    public static String doPostHttp(HttpEntity httpEntity, HttpPost httpPost) throws IOException {
        httpPost.setEntity(httpEntity);
        CloseableHttpClient client = HttpClients.createDefault();
        CloseableHttpResponse response = client.execute(httpPost);
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            return EntityUtils.toString(entity, "UTF-8");
        }
        return null;
    }

    /**
     * HTTP POST请求 (JSON格式)
     *
     * @param url    请求路径
     * @param params 请求参数
     * @return 响应结果
     */
    public static String doPostJsonHttp(String url, Object params) {
        // 声明 口响应数据 接收对象
        String responseJson = "";
        try {
            // 配置http请求参数
            HttpPost httpPost = new HttpPost(url);
            httpPost.setHeader("Content-Type", "application/json");
            BasicHttpEntity basicHttpEntity = new BasicHttpEntity();
            basicHttpEntity.setContent(new ByteArrayInputStream(JSONObject.toJSONString(params).getBytes(Charset.forName("UTF-8"))));
            // 解析 接口响应数据
            responseJson = HttpUtil.doPostHttp(basicHttpEntity, httpPost);
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
        return responseJson;
    }
}