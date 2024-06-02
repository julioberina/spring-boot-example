package com.julioberina.common;

public record ApiResponse<T>(
        Integer status,
        String message,
        T data
) {}
