package com.demo.schedule.po;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CronPO {

    private String name;

    private LocalDateTime start;
}
