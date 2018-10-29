package com.karlo.web.domain;

/**
 * 功能描述:
 *
 * @author karlo
 * @date 2018/10/20 15:01
 * @since 1.0.0
 */

public class User {
    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
