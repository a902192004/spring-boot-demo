package com.demo.common.response;

import lombok.Getter;
import java.util.List;

@Getter
public class PageResDto<T> {

    /**
     * 頁碼
     */
    private final long pageNum;

    /**
     * 每頁大小
     */
    private final long pageSize;

    /**
     * 總數
     */
    private final long total;

    /**
     * 分頁數據
     */
    private final List<? extends T> list;

    /**
     * 構造函數用於通用分頁查詢的場景 接收普通分頁數據和普通集合
     */
    public PageResDto(long pageNum, long pageSize, long total, List<T> list) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.total = total;
        this.list = list;
    }

    public static <T> PageResDto<T> of(long pageNum, long pageSize, long total, List<T> list) {
        return new PageResDto<>(pageNum, pageSize, total, list);
    }

    /**
     * 獲取分頁數
     */
    public long getPages() {
        if (this.pageSize == 0L) {
            return 0L;
        } else {
            long pages = this.total / this.pageSize;
            if (this.total % this.pageSize != 0L) {
                ++pages;
            }
            return pages;
        }
    }
}
