/*
 * Copyright (c) 2004-2018 by UCWeb All rights reserved
 */
package com.fitt.gbt.qbank.common.model.order;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * qbank
 *
 * @author <a href="mailto:zhengbodi@163.com">谷粑糖</a>
 * @version 1.0.0
 * @since 2018/04/27
 */
@Data
public class Record implements Serializable {
    private static final long serialVersionUID = -4036884208081266881L;

    private String BizID;

    private String YYDate;

    private List<TimeRecord> TimeRecord;

    private Integer count;

    private String time;
}