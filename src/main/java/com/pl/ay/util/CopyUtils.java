package com.pl.ay.util;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.alibaba.fastjson.JSON;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CopyUtils {
    private CopyUtils() {

    }
    public static <T> List copyList(List<T> list, Class className) {
        if (CollectionUtils.isEmpty(list)) {
            return new ArrayList();
        }
        return JSON.parseArray(JSON.toJSONString(list), className);
    }

    public static Map<String, Object> copyMap(Map map) {
        return JSON.parseObject(JSON.toJSONString(map));
    }

    /*public static <T>Page copyPage(Page<T> page, Class className) {
        List<T> list = page.getContent();
        List newList = copyList(list, className);
        Page ret = new PageImpl(newList);
        return ret;
    }*/

    public static <T>Page copyPage(final Page<T> page, Class className) {
        List<T> list = page.getContent();
        final List newList = copyList(list, className);
        Page ret = new Page() {
            @Override
            public int getTotalPages() {
                return page.getTotalPages();
            }

            @Override
            public long getTotalElements() {
                return page.getTotalElements();
            }

            @Override
            public int getNumber() {
                return page.getNumber();
            }

            @Override
            public int getSize() {
                return page.getSize();
            }

            @Override
            public int getNumberOfElements() {
                return page.getNumberOfElements();
            }

            @Override
            public List getContent() {
                return newList;
            }

            @Override
            public boolean hasContent() {
                return page.hasContent();
            }

            @Override
            public Sort getSort() {
                return page.getSort();
            }

            @Override
            public boolean isFirst() {
                return page.isFirst();
            }

            @Override
            public boolean isLast() {
                return page.isLast();
            }

            @Override
            public boolean hasNext() {
                return page.hasNext();
            }

            @Override
            public boolean hasPrevious() {
                return page.hasPrevious();
            }

            @Override
            public Pageable nextPageable() {
                return page.nextPageable();
            }

            @Override
            public Pageable previousPageable() {
                return page.previousPageable();
            }

            @Override
            public Iterator iterator() {
                return page.iterator();
            }
        };
        return ret;
    }

}
