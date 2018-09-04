package com.github.yxchange.metadata.entity;

import javax.persistence.*;

import lombok.Getter;

@Table(name = "coin")
@Getter
public class Coin{
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "JDBC")
    protected Integer id;

    /**
     * 代币名称
     */
    private String name;

    public Coin(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Coin() {
        super();
    }

    /**
     * 获取代币名称
     *
     * @return name - 代币名称
     */
    public String getName() {
        return name;
    }

}