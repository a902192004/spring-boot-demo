package com.demo.common.request;

public class PageReqDto {

    /**
     * 请求页码，默认第 1 页
     */
    private int pageNum = 1;

    /**
     * 每頁資料數
     */
    private int pageSize = 20;

    /**
     * 是否查詢所有，默認不查所有 為 true 時，pageNum 和 pageSize 無效
     */
    private boolean fetchAll = false;
}
