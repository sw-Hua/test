package com.asd.backened.common;

/**
 * This is an encapsulation tool. The user saves and obtains the currently logged in user ID
 */
public class BaseContext {
    private static ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    /**
     * Xuhao Guo
     * @param id
     */
    public static void setCurrentId(Long id){
        threadLocal.set(id);
    }

    /**
     * Get value
     * @return
     */
    public static Long getCurrentId(){
        return threadLocal.get();
    }
}