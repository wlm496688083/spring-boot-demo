package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImsiMakeCardPO {
    private Long seqId;

    private String orderId;

    private String fileName;

    private String startImsi;

    private String endImsi;

    private Date operTime;

    private String resDesc;

    private Integer lockNum;

    private Integer successNum;

    private Long subImsi;

    private String status;
}