package fr.sosmessage.domain;


public class Message {

	private String id;
	private String type;
	private String category;
	private String categoryId;
	private String text;
	private String createdAt;
	private String modifiedAt;
	private String contributorName;
	private Vote vote;
	private Rating rating;

	public String getText() {
		return text;
	}

	public String getContributorName() {
		return contributorName;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCategory() {
		return category;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setModifiedAt(String modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	public String getModifiedAt() {
		return modifiedAt;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setContributorName(String contributorName) {
		this.contributorName = contributorName;
	}

	public void setVote(Vote vote) {
		this.vote = vote;
	}

	public Vote getVote() {
		return vote;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

	public Rating getRating() {
		return rating;
	}

}
