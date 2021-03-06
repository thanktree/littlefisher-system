package com.littlefisher.blog.cmd.post;

import org.springframework.beans.factory.annotation.Autowired;

import com.littlefisher.blog.dao.PostDtoMapper;
import com.littlefisher.blog.model.PostDto;
import com.littlefisher.core.interceptor.AbstractCommand;
import com.littlefisher.core.stereotype.annotations.Command;

/**
 * Description:
 *
 * Created on 2017年5月23日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Command
public class UpdatePostCmd extends AbstractCommand<PostDto> {

    /**
     * postDto
     */
    private PostDto postDto;

    @Autowired
    private PostDtoMapper postDtoMapper;

    public UpdatePostCmd setPostDto(PostDto postDto) {
        this.postDto = postDto;
        return this;
    }

    @Override
    public PostDto execute() {
        postDtoMapper.updateByPrimaryKey(postDto);
        return postDto;
    }

}
