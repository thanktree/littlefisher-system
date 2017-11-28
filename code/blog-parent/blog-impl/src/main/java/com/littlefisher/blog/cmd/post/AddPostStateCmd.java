package com.littlefisher.blog.cmd.post;

import com.littlefisher.blog.dao.post.PostStateDtoMapper;
import com.littlefisher.blog.model.post.PostStateDto;
import com.littlefisher.core.interceptor.AbstractCommand;

/**
 * Description:
 *
 * Created on 2017年5月25日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class AddPostStateCmd extends AbstractCommand<PostStateDto> {

    /**
     * postStateDto
     */
    private PostStateDto postStateDto;

    /**
     * Description: 构造函数
     *
     * @param postStateDto postStateDto
     */
    public AddPostStateCmd(PostStateDto postStateDto) {
        super();
        this.postStateDto = postStateDto;
    }

    @Override
    public PostStateDto execute() {
        PostStateDtoMapper postStateDtoMapper = this.getMapper(PostStateDtoMapper.class);
        postStateDtoMapper.insert(postStateDto);
        return postStateDto;
    }

}