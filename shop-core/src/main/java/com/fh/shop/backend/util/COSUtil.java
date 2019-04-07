package com.fh.shop.backend.util;


import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.model.ObjectMetadata;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;

import java.io.InputStream;
import java.util.Date;
import java.util.UUID;

public class COSUtil {

    public static final String COS_SECRET_ID = "AKIDRo8H8szDXmjZjruzemn09HKFVWOJPabf";

    public static final String COS_SECRET_KEY = "7Wnz4zijXDmQBoYK0Vs52pl2FICxXuun";

    public static final String COS_BUCKET_NAME = "rwl-1258849244";

    public static final String COS_BUCKET_REGION = "ap-beijing";

    public static final String COS_SHOW_PATH_PREFIX = "https://rwl-1258849244.cos.ap-beijing.myqcloud.com/";


    //从cos删除文件
    public static void deleteFile(String path){
        COSClient cosClient = null;
        try {
            //获取cos客户端
            cosClient = createCosClient();
            //删除文件
            cosClient.deleteObject(COS_BUCKET_NAME, path.replace(COS_SHOW_PATH_PREFIX ,""));
        } finally {
            //关闭客户端
            if (null != cosClient){
                cosClient.shutdown();
            }
        }

    }


    //上传文件到cos
    public static String uplaodFile(InputStream is, String fileName) {
        //生成 cos 客户端。
        COSClient cosClient = null;
        try {
            cosClient = createCosClient();
            // bucket的命名规则为{name}-{appid} ，此处填写的存储桶名称必须为此格式
            String bucketName = COS_BUCKET_NAME;
            ObjectMetadata objectMetadata = new ObjectMetadata();
            // 指定要上传到 COS 上对象键
            String key = DateUtil.date2Str(new Date(), DateUtil.PATTERN_Y_M_D) + "/" + UUID.randomUUID() + FileUtil.getSuffix(fileName);
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, is, objectMetadata);
            PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);
            //上传成功之后返回图片路径	https://rwl-1258849244.cos.ap-beijing.myqcloud.com/2019-03-26/4ad04a4f-cddc-411a-949e-3c806f441ee2.jpg
            String filePath = COS_SHOW_PATH_PREFIX + key;
            return filePath;
        } finally {
            //关闭客户端
            if (null != cosClient){
                cosClient.shutdown();
            }
        }
    }

    public static COSClient createCosClient() {
        // 1 初始化用户身份信息（secretId, secretKey）。
        COSCredentials cred = new BasicCOSCredentials(COS_SECRET_ID, COS_SECRET_KEY);
        // 2 设置bucket的区域, COS地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
        // clientConfig中包含了设置 region, https(默认 http), 超时, 代理等 set 方法, 使用可参见源码或者接口文档 FAQ 中说明。
        ClientConfig clientConfig = new ClientConfig(new Region(COS_BUCKET_REGION));
        // 3 生成 cos 客户端。
        COSClient  cosClient = new COSClient(cred, clientConfig);
        return cosClient;
    }


}
