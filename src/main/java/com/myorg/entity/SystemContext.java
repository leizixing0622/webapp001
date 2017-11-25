package com.myorg.entity;

public class SystemContext {

    private static ThreadLocal<Integer> pageSize = new ThreadLocal<Integer>();
    private static ThreadLocal<Integer> pageIndex = new ThreadLocal<Integer>();
    private static ThreadLocal<Integer> pageOffset = new ThreadLocal<Integer>();
    private static ThreadLocal<String> order = new ThreadLocal<String>();
    private static ThreadLocal<String> sort = new ThreadLocal<String>();

    public static int getPageSize() {
        return pageSize.get();
    }

    public static void setPageSize(ThreadLocal<Integer> pageSize) {
        SystemContext.pageSize = pageSize;
    }

    public static ThreadLocal<Integer> getPageIndex() {
        return pageIndex;
    }

    public static void setPageIndex(ThreadLocal<Integer> pageIndex) {
        SystemContext.pageIndex = pageIndex;
    }

    public static int getPageOffset() {
        return pageOffset.get();
    }

    public static void setPageOffset(ThreadLocal<Integer> pageOffset) {
        SystemContext.pageOffset = pageOffset;
    }

    public static ThreadLocal<String> getOrder() {
        return order;
    }

    public static void setOrder(ThreadLocal<String> order) {
        SystemContext.order = order;
    }

    public static ThreadLocal<String> getSort() {
        return sort;
    }

    public static void setSort(ThreadLocal<String> sort) {
        SystemContext.sort = sort;
    }
}
