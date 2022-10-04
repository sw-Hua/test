package com.asd.backened.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**  Yongyan Liu and Xuhao Guo
 * General return results. The data responded by the server will eventually be encapsulated into this object
 * @param <T>
 */
@Data
@ApiModel("Return Results")
public class R<T> implements Serializable{

    @ApiModelProperty("Code")
    private Integer code; //Code: 1 success, 0 and other numbers are failure

    @ApiModelProperty("Error message")
    private String msg; //Error message

    @ApiModelProperty("Data")
    private T data; //Data

    @ApiModelProperty("Dynamic data")
    private Map map = new HashMap(); //Dynamic data

    public static <T> R<T> success(T object) {
        R<T> r = new R<T>();
        r.data = object;
        r.code = 1;
        return r;
    }

    public static <T> R<T> error(String msg) {
        R r = new R();
        r.msg = msg;
        r.code = 0;
        return r;
    }

    public R<T> add(String key, Object value) {
        this.map.put(key, value);
        return this;
    }

}
