package com.hd.modules.oss.entity;

import com.aliyun.oss.OSSClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * oss 工具类
 * by eric 2019-05-08 14:55:06
 */
@Component
public class OSSClientComponent {

    private String endpoint;

    private String accessKeyId;  // 你的访问AK信息

    private String accessKeySecret; //你的访问AK信息

    private String bucketName = "baohan-img";  // 你之前创建的bucket，确保这个bucket已经创建

    private  SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

    public String getEndpoint() {
        return endpoint;
    }
    @Value("${image.endPoint}")
    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getAccessKeyId() {
        return accessKeyId;
    }
    @Value("${image.accessKeyId}")
    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public String getAccessKeySecret() {
        return this.accessKeySecret;
    }
    @Value("${image.accessKeySecret}")
    public void setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }

    public String getBucketName() {
        return bucketName;
    }
    @Value("${image.bucketName}")
    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    //获取OSSClient实例
    private OSSClient getOSSClient(){
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        return ossClient;
    }

    /**
     *  上传图片
     * @param file
     * @return  返回图片的路径
     * @throws Exception
     */
    public  String uploadImage(File file)  throws Exception{
        if(file==null) return  null;
        OSSClient ossClient = null;
        try {
            ossClient = getOSSClient();
            //生成图片名称
            String originFileName = file.getName();
            String suffix = originFileName.substring(originFileName.lastIndexOf(".")+1);
            String key = sdf.format(new Date())+"."+suffix;


            // 上传文件流
            ossClient.putObject(bucketName, key , file);
            return  getImgUrl(key);
        } finally {
            if(ossClient!=null){
                ossClient.shutdown();
            }
        }
    }

    /**
     * MultipartFile方式上传图片
     * @param file
     * @return  返回图片的路径
     * @throws Exception
     */
    public  String uploadImage(MultipartFile file) throws Exception{
        if(file==null){
            return  null;
        }
        OSSClient ossClient = null;
        try {
            ossClient = getOSSClient();
            //生成图片名称
            String originFileName = file.getOriginalFilename();
            String suffix = originFileName.substring(originFileName.lastIndexOf(".")+1);
            String key = sdf.format(new Date())+"."+suffix;
            System.out.println(key);
            System.out.println(originFileName);
            //上传文件流
            ossClient.putObject(bucketName, key ,file.getInputStream());
            return getImgUrl(key);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
            if(ossClient!=null){
                ossClient.shutdown();
            }
        }
        return null;
    }

    /**
     * 删除图片
     * @param key
     */
    public  void deleteImage(String key) throws Exception{
        // 创建OSSClient实例。
        OSSClient ossClient = null;
        try {
            ossClient = getOSSClient();
            // 删除文件。
            ossClient.deleteObject(bucketName,key);
        } finally {
            if(ossClient!=null){
                ossClient.shutdown();
            }
        }
    }

    /**
     * 获得url链接(暂时保存半年)
     * @param key
     * @return
     */
    public  String getImgUrl(String key) {
        OSSClient ossClient = getOSSClient();
        //设置过期时间
        Date expiration = new Date(System.currentTimeMillis() + 3600L * 1000 * 24 * 365/2);
        //生成URL
        URL url = ossClient.generatePresignedUrl(bucketName, key, expiration);
        if (url != null) {
            return url.toString();
        }
        return null;
    }
}
