package com.github.yxchange.metadata.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.alibaba.fastjson.annotation.JSONField;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Base {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "JDBC")
    protected Integer id;
    
    /**
     * 创建时间
     */
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    @Column(insertable=false, updatable=false)
    protected Date createtime;

    /**
     * 最后更改时间
     */
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    @Column(insertable=false, updatable=false)
    protected Date modifytime;
    
    @JSONField(serialize=false, deserialize=false)
    public boolean isNotEmpty() {
    	return id != null && id > 0;
    }
    
    @JSONField(serialize=false, deserialize=false)
    public boolean isEmpty() {
    	return !isNotEmpty();
    }

}
