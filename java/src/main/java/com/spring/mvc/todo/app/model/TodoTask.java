package com.spring.mvc.todo.app.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author kameshkr258
 *
 */
public class TodoTask {

	/**
	 * ID
	 */
	Long id;
	/**
	 * title
	 */
	String title;
	/**
	 * description
	 */
	String description;
	/**
	 * status
	 */
	String status;
	/**
	 * createdDate
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date createdDate;
	/**
	 * completionDate
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date completionDate;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the completionDate
	 */
	public Date getCompletionDate() {
		return completionDate;
	}

	/**
	 * @param completionDate the completionDate to set
	 */
	public void setCompletionDate(Date completionDate) {
		this.completionDate = completionDate;
	}
}
