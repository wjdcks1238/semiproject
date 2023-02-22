package kr.common.comment.vo;

import java.sql.Date;

public class CommentVo {
//	--------------- -------- -------------- 
//	BOARD_ID        NOT NULL NUMBER         
//	COMMENT_ID      NOT NULL NUMBER         
//	USERNAME        NOT NULL VARCHAR2(20)   
//	COMMENT_CONTENT NOT NULL VARCHAR2(1000) 
//	SUBMIT_DATE              DATE
	
	private int boardId;
	private int commentId;
	private String userName;
	private String commentContent;
	private Date submitDate;
	
	@Override
	public String toString() {
		return "CommentVo [boardId=" + boardId + ", commentId=" + commentId + ", userName=" + userName
				+ ", commentContent=" + commentContent + ", submitDate=" + submitDate + "]";
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public Date getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(Date submitDate) {
		this.submitDate = submitDate;
	}
	
	
}
