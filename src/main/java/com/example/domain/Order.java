package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by wanglimin1 on 2015/7/21.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order implements Serializable {
    @NonNull
    private Long orderId; //订单ID
    private Long venderId; //商家ID
    private Long supplierId; //供应商ID
    private Integer orderStatus; //订单处理状态 0.未处理 1.修改订单状态及供应商识 2.修改solr中订单状态及供应商识 3.打标erp端订单70位1  4.打标本地订单70位1 5.修改solr中sign 6.推送JMQ消息 100.已完成
    private Integer orderStatusBefore;//存储原订单状态
    private Integer orderType; //订单类型 0.普通sop订单 1.供应商订单 2.需要拆单订单
    private Date modified;
    private Date created;

}
