package com.julioberina.common;

public record ApiResponse<T>(
        Integer status,
        T data
) {}
