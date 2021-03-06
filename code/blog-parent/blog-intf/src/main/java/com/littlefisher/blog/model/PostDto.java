package com.littlefisher.blog.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import tk.mybatis.mapper.annotation.ColumnType;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

import org.apache.ibatis.type.JdbcType;

import com.littlefisher.blog.enums.EnumPostState;
import com.littlefisher.blog.enums.EnumPostType;
import com.littlefisher.core.stereotype.enums.EnumBizBool;

/**
 *
 * Description: post 实体
 *
 * Created on 2018年01月10日
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Table(name = "post")
@ApiModel("post实体")
public class PostDto implements Serializable {
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @ApiModelProperty("id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 标题
     */
    @ApiModelProperty("标题")
    private String title;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    @Column(name = "created_date")
    private Date createdDate;

    /**
     * 原文链接
     */
    @ApiModelProperty("原文链接")
    @Column(name = "original_url")
    private String originalUrl;

    /**
     * 类型
     */
    @ApiModelProperty("类型")
    private EnumPostType type;

    /**
     * 文章分类 主键
     */
    @ApiModelProperty("文章分类 主键")
    @Column(name = "archive_id")
    private Long archiveId;

    /**
     * 作者主键
     */
    @ApiModelProperty("作者主键")
    @Column(name = "author_id")
    private Long authorId;

    /**
     * 是否可评论
     */
    @ApiModelProperty("是否可评论")
    @Column(name = "enable_comment")
    private EnumBizBool enableComment;

    /**
     * 状态
     */
    @ApiModelProperty("状态")
    private EnumPostState state;

    /**
     * 状态变更时间
     */
    @ApiModelProperty("状态变更时间")
    @Column(name = "state_date")
    private Date stateDate;

    /**
     * 修改时间
     */
    @ApiModelProperty("修改时间")
    @Column(name = "update_date")
    private Date updateDate;

    /**
     * 博文
     */
    @ApiModelProperty("博文")
    @ColumnType(jdbcType = JdbcType.LONGVARCHAR)
    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public EnumPostType getType() {
        return type;
    }

    public void setType(EnumPostType type) {
        this.type = type;
    }

    public Long getArchiveId() {
        return archiveId;
    }

    public void setArchiveId(Long archiveId) {
        this.archiveId = archiveId;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public EnumBizBool getEnableComment() {
        return enableComment;
    }

    public void setEnableComment(EnumBizBool enableComment) {
        this.enableComment = enableComment;
    }

    public EnumPostState getState() {
        return state;
    }

    public void setState(EnumPostState state) {
        this.state = state;
    }

    public Date getStateDate() {
        return stateDate;
    }

    public void setStateDate(Date stateDate) {
        this.stateDate = stateDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", title=").append(title);
        sb.append(", createdDate=").append(createdDate);
        sb.append(", originalUrl=").append(originalUrl);
        sb.append(", type=").append(type);
        sb.append(", archiveId=").append(archiveId);
        sb.append(", authorId=").append(authorId);
        sb.append(", enableComment=").append(enableComment);
        sb.append(", state=").append(state);
        sb.append(", stateDate=").append(stateDate);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", content=").append(content);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}