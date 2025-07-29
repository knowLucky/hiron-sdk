package com.hiron.open.sdk.model.vo;


import lombok.Data;

import java.util.List;

/**
 * @author Luckymi
 * @since 2025/6/20
 */
@Data
public class PageResponse<T> {
    private List<T> rows;
    private long current;
    private long size;
    private long total;
}
