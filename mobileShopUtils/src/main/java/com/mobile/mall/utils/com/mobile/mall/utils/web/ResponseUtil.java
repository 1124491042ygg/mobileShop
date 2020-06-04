package com.mobile.mall.utils.com.mobile.mall.utils.web;

import com.github.pagehelper.Page;
import com.mobile.mall.utils.dto.request.BaseResponse;

import java.util.List;

public class ResponseUtil {
    /**
     * 返回请求成功
     * @param data
     * @return
     */
    public static BaseResponse ok(Object data){
        BaseResponse obj = new BaseResponse();
        obj.setErrno(0);
        obj.setErrmsg("成功");
        obj.setData(data);
        return obj;
    }

    /**
     * 返回请求成功(无参)
     * @return
     */
    public static BaseResponse ok() {
        BaseResponse obj = new BaseResponse();
        obj.setErrno(0);
        obj.setErrmsg("成功");
        return obj;
    }

    /**
     * 返回列表查询成功
     * @param list
     * @return
     */
    public static <T> BaseResponse okList(List<T> list) {
        PageDto data = new PageDto();
        data.setList(list);
        if(list instanceof Page){
            Page page = (Page)list;
            data.setTotal(page.getTotal());
            data.setPage(page.getPageNum());
            data.setLimit(page.getPageSize());
            data.setPages(page.getPages());
        } else {
            data.setTotal(list.size());
            data.setPage(1);
            data.setLimit(list.size());
            data.setPages(1);
         }

        return  ok(data);
    }

    /**
     * 存在list数据和分页list的成功请求
     * @param list
     * @param pagedList
     * @return
     */
    public static <T> BaseResponse okList(List<T> list, List pagedList) {
        PageDto data = new PageDto();
        data.setList(list);

        if (pagedList instanceof Page) {
            Page page = (Page) pagedList;
            data.setTotal(page.getTotal());
            data.setPage(page.getPageNum());
            data.setLimit(page.getPageSize());
            data.setPages(page.getPages());
        } else {
            data.setTotal(pagedList.size());
            data.setPage(1);
            data.setLimit(pagedList.size());
            data.setPages(1);
        }

        return ok(data);
    }

    /**
     * 返回错误
     * @return
     */
    public static BaseResponse fail() {
        BaseResponse obj = new BaseResponse();
        obj.setErrno(-1);
        obj.setErrmsg("错误");
        return obj;
    }

    /**
     * 返回错误携带错误信息和错误码
     * @param errno
     * @param errmsg
     * @return
     */
    public static BaseResponse fail(int errno, String errmsg) {
        BaseResponse obj = new BaseResponse();
        obj.setErrno(errno);
        obj.setErrmsg(errmsg);
        return obj;
    }

    public static BaseResponse badArgument() {
        return fail(401, "请求参数不对");
    }

    public static BaseResponse badArgumentValue() {
        return fail(402, "请求参数值不对");
    }

    public static BaseResponse serious() {
        return fail(502, "系统内部错误");
    }
}
