package com.littlefisher.blog.cmd.user;

import java.util.List;

import com.littlefisher.blog.dao.user.UserStateDtoMapper;
import com.littlefisher.blog.model.user.UserStateDto;
import com.littlefisher.core.interceptor.AbstractCommand;

/**
 * Description: 查询所有用户状态
 *
 * Created on 2017年5月25日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class GetAllUserStateCmd extends AbstractCommand<List<UserStateDto>> {

    @Override
    public List<UserStateDto> execute() {
        UserStateDtoMapper userStateDtoMapper = this.getMapper(UserStateDtoMapper.class);
        return userStateDtoMapper.selectAll();
    }

}
