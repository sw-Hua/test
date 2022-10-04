package com.asd.backened.common;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**Yongyan Liu
 * Customize the original data object processor
 */
@Component
@Slf4j
public class MyMetaObjecthandler implements MetaObjectHandler {
    /**
     * Insert operation auto fill
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("Auto populate public fields [insert]...");
        log.info(metaObject.toString());

        metaObject.setValue("createTime", LocalDateTime.now());
        metaObject.setValue("updateTime",LocalDateTime.now());
        metaObject.setValue("createUser",BaseContext.getCurrentId());
        metaObject.setValue("updateUser",BaseContext.getCurrentId());
    }

    /**
     * Update operation, auto fill
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("Auto populate public fields [update]...");
        log.info(metaObject.toString());

        long id = Thread.currentThread().getId();
        log.info("The thread id is: {}\n" +
                "\n",id);

        metaObject.setValue("updateTime",LocalDateTime.now());
        metaObject.setValue("updateUser",BaseContext.getCurrentId());
    }
}
