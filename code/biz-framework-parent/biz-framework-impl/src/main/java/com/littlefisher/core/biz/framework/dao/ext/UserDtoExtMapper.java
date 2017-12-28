package com.littlefisher.core.biz.framework.dao.ext;

import tk.mybatis.mapper.common.Mapper;

import java.util.List;

import com.littlefisher.core.biz.framework.dao.UserDtoMapper;
import com.littlefisher.core.biz.framework.model.UserDto;
import com.littlefisher.core.biz.framework.request.GetUserList4PagerByCondRequest;

/**
 * Description: UserDtoExtMapper.java
 *
 * Created on 2017年12月27日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public interface UserDtoExtMapper extends UserDtoMapper, Mapper<UserDto> {

    /**
     * 根据条件查询
     *
     * @param req req
     * @return List<UserDto>
     */
    List<UserDto> selectByCond(GetUserList4PagerByCondRequest req);
}