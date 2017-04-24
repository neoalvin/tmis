package com.neoalvin.tmis.consumer;

import com.neoalvin.tmis.model.UserInfo;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class DubboConsumer {

    public static void main(String[] args) {
        final String port = "8888";

        //测试用户注册服务
        postRequest("http://localhost:" + port + "/services/user/registryUser");

        //测试用户验证服务
        postRequest("http://localhost:" + port + "/services/user/validateUser");
        /*//测试常规服务
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath*:META-INF/spring.xml");
        context.start();
        IUserAuthService userService = context.getBean(IUserAuthService.class);*/
    }


    /**
     * 测试注册接口
     * @param url
     */
    private static void postRequest(String url) {
        System.out.println("The request url: " + url);
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(url);
        UserInfo userInfo = new UserInfo("130420215","alvin");
        Response response = target.request().post(Entity.entity(userInfo, MediaType.APPLICATION_JSON_TYPE));
        try {
            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed with HTTP error code : " + response.getStatus());
            }
            System.out.println("Successfully got result: " + response.readEntity(String.class));
        } finally {
            response.close();
            client.close();
        }
    }
}