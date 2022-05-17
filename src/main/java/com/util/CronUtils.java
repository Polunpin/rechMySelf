package com.util;

import cn.hutool.core.lang.Console;
import cn.hutool.cron.CronUtil;
import cn.hutool.cron.task.Task;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 * 日期转换cron表达式
 * @author Administrator
 *
 */
public class CronUtils {

    //"ss mm HH dd MM ? yyyy"
    private static final SimpleDateFormat sdf = new SimpleDateFormat("ss mm HH dd MM ? yyyy-yyyy");

    /***
     *  功能描述：日期转换cron表达式
     * @param date 日期
     */
    public static String formatDateByPattern(Date date) {
        String formatTimeStr = null;
        if (Objects.nonNull(date)) {
            formatTimeStr = sdf.format(date);
        }
        return formatTimeStr;
    }

    /***
     * convert Date to cron, eg "0 07 10 15 1 ?"
     * @param date  : 时间点
     */
    public static String getCron(Date date) {
        return formatDateByPattern(date);
    }

    public static void main(String[] args) {
        String cron = getCron(new Date());
        System.out.println(cron);
        //    CronUtil.schedule("00 56 16 09 01 ? 2022-2022", new Task() {
        //    @Override
        //    public void execute() {
        //        Console.log("Task excuted.");
        //    }
        //});
        //// 支持秒级别定时任务
        //CronUtil.setMatchSecond(true);
        //CronUtil.start();
    }
}