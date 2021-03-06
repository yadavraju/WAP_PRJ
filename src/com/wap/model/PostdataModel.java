package com.wap.model;

import java.util.Date;
import java.util.List;

public class PostdataModel {
	private int pid;
	private String product_you_offer;
	private String describe_your_offer;
	private String product_you_need;
	private String describe_your_need;
	private int like_count;
	private int comment_count;
	private int userid;
	private Date date;
	private List<CommentModel> listCommentModel;
	private String fname;
	private String lname;
	
	private String latitude;
	private String longitude;
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getProduct_you_offer() {
		return product_you_offer;
	}
	public void setProduct_you_offer(String product_you_offer) {
		this.product_you_offer = product_you_offer;
	}
	public String getDescribe_your_offer() {
		return describe_your_offer;
	}
	public void setDescribe_your_offer(String describe_your_offer) {
		this.describe_your_offer = describe_your_offer;
	}
	public String getProduct_you_need() {
		return product_you_need;
	}
	public void setProduct_you_need(String product_you_need) {
		this.product_you_need = product_you_need;
	}
	public String getDescribe_your_need() {
		return describe_your_need;
	}
	public void setDescribe_your_need(String describe_your_need) {
		this.describe_your_need = describe_your_need;
	}
	public int getLike_count() {
		return like_count;
	}
	public void setLike_count(int like_count) {
		this.like_count = like_count;
	}
	public int getComment_count() {
		return comment_count;
	}
	public void setComment_count(int comment_count) {
		this.comment_count = comment_count;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public List<CommentModel> getListCommentModel() {
		return listCommentModel;
	}
	public void setListCommentModel(List<CommentModel> listCommentModel) {
		this.listCommentModel = listCommentModel;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	
	
	
	
	
}
