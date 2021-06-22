package com.zhuzs.admin.utils;

import com.alibaba.fastjson.JSONObject;
import com.zhuzs.admin.constant.SysExceptionEnum;
import com.zhuzs.admin.service.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
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
     * 文件推送
     *
     * @param filePath 文件本地路径
     * @param url      第三方文件推送接口
     * @return
     */
    public static String pushPicture(String filePath, String url) {
        try {
            // 配置http请求参数
            HttpPost httpPost = new HttpPost(url);
            // 读取文件并生成 MultipartFile 对象
            byte[] fileByteArray = readFile(filePath, 1024 * 1024 * 20);
            MultipartFile multipartFile = new MockMultipartFile("", "", ContentType.MULTIPART_FORM_DATA.toString(), fileByteArray);
            // 构造请求入参
            MultipartEntityBuilder builder = MultipartEntityBuilder.create();
            builder.setCharset(Charset.forName("utf-8"));
            //加上此行代码解决返回中文乱码问题
            builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
            HttpEntity httpEntity = builder.addBinaryBody("file", multipartFile.getInputStream(), ContentType.MULTIPART_FORM_DATA, multipartFile.getName())
                    // TODO 这里还可以设置一些其他参数
                    .addTextBody("resourceType", "1")
                    .addTextBody("resourceTypeExpand", "pic")
                    .build();
            // 请求图片推送接口 并 解析响应数据
            return HttpUtil.doPostHttp(httpEntity, httpPost);

        } catch (FileNotFoundException e) {
            log.error(e.getMessage(), e);
            throw new ServiceException(SysExceptionEnum.FILE_READ_EXCEPTION.getCode(), e.getMessage());
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            throw new ServiceException(SysExceptionEnum.FILE_READ_EXCEPTION.getCode(), e.getMessage());
        }
    }

    /**
     * 读取本地文件 并 生成字节数组
     *
     * @param filePath   文件路径
     * @param byteArrLen 字节数组长度
     * @return
     */
    public static byte[] readFile(String filePath, int byteArrLen) {
        try {
            // 铜鼓URL获取连接
            URL url = new URL(filePath);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // 设置超时间为3秒
            conn.setConnectTimeout(3 * 1000);
            // 防止屏蔽程序抓取而返回403错误
            conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

            // 得到输入流
            InputStream inputStream = conn.getInputStream();

            // 输入流转换为字节数组
            byte[] buffer = new byte[byteArrLen];
            int len = 0;
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            while ((len = inputStream.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
            bos.close();
            return bos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            throw new ServiceException(SysExceptionEnum.FILE_READ_EXCEPTION);
        }
    }

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