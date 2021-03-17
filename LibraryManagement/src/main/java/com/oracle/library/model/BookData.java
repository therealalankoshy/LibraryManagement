package com.oracle.library.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "v_book_data")
public class BookData {

	@Column
	@Id
	private Integer copyId;

	@Column
	private Integer bookId;

	@Column
	private String bookName;

	@Column
	private String categoryName;

	@Column
	private String authorName;

	@Column
	private String shelfSectionName;

	@Column
	private Integer issueId;

	@Column
	private Date issueDateCreated;

	@Column
	private Date issueLastUpdated;

	@Column
	private Integer issueBookCopyId;

	@Column
	private String issueUsername;

	@Column
	private Date issueDateIssued;

	@Column
	private Date issueDateDue;

	@Column
	private Date issueReturnDate;

	public Integer getCopyId() {
		return copyId;
	}

	public void setCopyId(Integer copyId) {
		this.copyId = copyId;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getShelfSectionName() {
		return shelfSectionName;
	}

	public void setShelfSectionName(String shelfSectionName) {
		this.shelfSectionName = shelfSectionName;
	}

	public Integer getIssueId() {
		return issueId;
	}

	public void setIssueId(Integer issueId) {
		this.issueId = issueId;
	}

	public Date getIssueDateCreated() {
		return issueDateCreated;
	}

	public void setIssueDateCreated(Date issueDateCreated) {
		this.issueDateCreated = issueDateCreated;
	}

	public Date getIssueLastUpdated() {
		return issueLastUpdated;
	}

	public void setIssueLastUpdated(Date issueLastUpdated) {
		this.issueLastUpdated = issueLastUpdated;
	}

	public Integer getIssueBookCopyId() {
		return issueBookCopyId;
	}

	public void setIssueBookCopyId(Integer issueBookCopyId) {
		this.issueBookCopyId = issueBookCopyId;
	}

	public String getIssueUsername() {
		return issueUsername;
	}

	public void setIssueUsername(String issueUsername) {
		this.issueUsername = issueUsername;
	}

	public Date getIssueDateIssued() {
		return issueDateIssued;
	}

	public void setIssueDateIssued(Date issueDateIssued) {
		this.issueDateIssued = issueDateIssued;
	}

	public Date getIssueDateDue() {
		return issueDateDue;
	}

	public void setIssueDateDue(Date issueDateDue) {
		this.issueDateDue = issueDateDue;
	}

	public Date getIssueReturnDate() {
		return issueReturnDate;
	}

	public void setIssueReturnDate(Date issueReturnDate) {
		this.issueReturnDate = issueReturnDate;
	}

}
