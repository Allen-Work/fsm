package com.gtstar.util;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @ClassName MyMapper
 *
 * @Description 自己的Mapper接口
 *              特别注意: 该接口不能被Spring扫描到,否则可能会出错
 *
 * @Author yuxiang
 * @Date 2019/12/13 17:23
 **/
public interface MyMapper<T> extends Mapper<T>,MySqlMapper<T>{
}
