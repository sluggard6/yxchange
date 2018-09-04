package com.github.yxchange.metadata.entity;

import java.io.Serializable;

import javax.persistence.*;

import lombok.Getter;

@Table(name = "coin")
@Getter
public class Coin implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -2041049608822481755L;

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