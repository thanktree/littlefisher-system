package com.littlefisher.blog.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import net.sf.oval.constraint.NotBlank;

import javax.validation.constraints.NotNull;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.littlefisher.blog.request.AddCommentaryRequest;
import com.littlefisher.blog.request.UpdateCommentaryRequest;
import com.littlefisher.blog.service.ICommentaryService;
import com.littlefisher.blog.model.CommentaryDto;
import com.littlefisher.blog.model.ext.CommentaryExtDto;
import com.littlefisher.blog.request.GetCommentaryList4PagerByCondRequest;
import com.littlefisher.core.stereotype.constants.BaseConstants;

/**
 * Description: 评价Controller
 *
 * Created on 2017年5月22日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@RestController
@RequestMapping(BaseConstants.BASE_API_PREFIX + "/blog/v1/commentaries")
@Api(value = "commentary", description = "commentary 接口API")
public class CommentaryController {

    /**
     * commentaryService
     */
    @Autowired
    private ICommentaryService commentaryService;

    /**
     * Description: 查询评价列表，分页用
     *
     * @param req req
     * @return PageInfo<CommentaryDto>
     */
    @RequestMapping(value = "/pager", method = RequestMethod.GET)
    @ApiOperation("查询评价列表，分页用")
    public PageInfo<CommentaryExtDto> getCommentaryList4PagerByCond(
            @ApiParam(required = true, value = "查询评价列表条件") @ModelAttribute GetCommentaryList4PagerByCondRequest req) {
        List<CommentaryExtDto> commentaryList = commentaryService.getCommentaryList4PagerByCond(req);
        return new PageInfo<>(commentaryList);
    }

    /**
     * Description: 根据主键查询评价
     *
     * @param commentaryId commentaryId
     * @return CommentaryDto
     */
    @RequestMapping(value = "/{commentaryId}", method = RequestMethod.GET)
    @ApiOperation("根据主键查询评价")
    public CommentaryDto getCommentaryById(@ApiParam(required = true, value = "评价主键") @PathVariable("commentaryId")
    @NotNull(message = "commentaryId不能为空") Long commentaryId) {
        return commentaryService.getCommentaryById(commentaryId);
    }

    /**
     * Description: 新增评价
     *
     * @param request 请求入参
     * @return CommentaryDto
     */
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation("新增评价")
    public CommentaryDto addCommentary(
            @ApiParam(required = true, value = "评价实体") @RequestBody @NotNull(message = "评价不能为空")
                    AddCommentaryRequest request) {
        return commentaryService.addCommentary(request);
    }

    /**
     * Description: 修改评价
     *
     * @param request 请求入参
     * @return CommentaryDto
     */
    @RequestMapping(method = RequestMethod.PATCH)
    @ApiOperation("修改评价")
    public CommentaryDto updateCommentary(
            @ApiParam(required = true, value = "评价实体") @RequestBody @NotNull(message = "入参不能为空")
                    UpdateCommentaryRequest request) {
        return commentaryService.updateCommentary(request);
    }

    /**
     * Description: 删除评价
     *
     * @param commentaryId commentaryId
     * @return int
     */
    @RequestMapping(value = "/{commentaryId}", method = RequestMethod.DELETE)
    @ApiOperation("删除评价")
    public int deleteCommentary(
            @ApiParam(required = true, value = "评价主键") @PathVariable("commentaryId") @NotNull(message = "评价id不能为空")
            @NotBlank(message = "评价id不能为空") Long commentaryId) {
        return commentaryService.deleteCommentary(commentaryId);
    }
}
