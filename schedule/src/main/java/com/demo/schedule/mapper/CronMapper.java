package com.demo.schedule.mapper;

import com.demo.schedule.po.CronPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CronMapper {

    @Select("SELECT * FROM util_task_cron ")
    List<CronPO> getCron();

}
