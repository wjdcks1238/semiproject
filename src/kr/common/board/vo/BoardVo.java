package kr.common.board.vo;

import java.sql.Date;

public class BoardVo {
//	------------- -------- -------------- 
//	BOARD_ID      NOT NULL NUMBER         
//	TITLE         NOT NULL VARCHAR2(100)  
//	BOARD_USER             VARCHAR2(20)   
//	SUBMIT_DATE            DATE           
//	BOARD_CONTENT NOT NULL VARCHAR2(4000) 
//	READ_COUNT    NOT NULL NUMBER
	
	private int boardId;
	private String title;
	private String boardUser;
	private Date submitDate;
	private String boardContent;
	private int readCount;
	
	@Override
	public String toString() {
		return "BoardVo [boardId=" + boardId + ", title=" + title + ", boardUser=" + boardUser + ", submitDate="
				+ submitDate + ", boardContent=" + boardContent + ", readCount=" + readCount + "]";
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBoardUser() {
		return boardUser;
	}

	public void setBoardUser(String boardUser) {
		this.boardUser = boardUser;
	}

	public Date getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(Date submitDate) {
		this.submitDate = submitDate;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}
}
