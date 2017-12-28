package com.littlefisher.blog.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.littlefisher.blog.model.FriendLinkDto;
import com.littlefisher.blog.model.ext.AuthorExtDto;

/**
 * Description: AuthorController.java
 *
 * Created on 2017年12月28日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@RestController
@RequestMapping("/api/blog/v1/authors")
@Api(value = "author", description = "author 接口API")
public class AuthorController {

    /**
     * 首页作者详情
     * @param authorId 作者id
     * @return 作者详情
     */
    @RequestMapping(value = "/index/{authorId}", method = RequestMethod.GET)
    @ApiOperation("首页作者详情")
    public AuthorExtDto getAuthorInfo4Index(
            @ApiParam(required = true, value = "作者主键") @PathVariable("authorId") Long authorId) {
        // TODO: 首页作者详情
        return null;
    }

    /**
     * 作者友情链接
     * @param authorId 作者id
     * @return 友情链接
     */
    @RequestMapping(value = "/{authorId}/friendLinks", method = RequestMethod.GET)
    public List<FriendLinkDto> getFriendLinkDto(
            @ApiParam(required = true, value = "作者主键") @PathVariable("authorId") Long authorId) {
        // TODO: 作者友情链接
        return null;
    }
}