package com.zhuzs.admin;

import com.zhuzs.common.entity.admin.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
  * @ClassName AdminApplication
  * @Description TODO
  * @Author zhu_zishuang
  * @Date 2020-04-21 16:17
  */
@SpringBootApplication
@RestController
public class AdminApplication {

    public static void main(String[] args) {

        SpringApplication.run(AdminApplication.class, args);

    }

    /**
     * @Description TODO
     * @Param []
     * @Return com.zhuzs.common.entity.admin.User
     * @Throws        
     * @Author zhu_zishuang
     * @Date 2020-04-21 15:59
     */
    @RequestMapping("/123")
    public User getUser() {
        return new User("zhuzs", 29);
    }


}
