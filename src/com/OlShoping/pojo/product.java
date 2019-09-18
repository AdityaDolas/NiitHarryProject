package com.OlShoping.pojo;

public class product {


	private int pid;
	private String productname;
	private String productcatagory;
	private String productquantity;
	private String productprice;
	private String productdescription;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getProductcatagory() {
		return productcatagory;
	}
	public void setProductcatagory(String productcatagory) {
		this.productcatagory = productcatagory;
	}
	public String getProductquantity() {
		return productquantity;
	}
	public void setProductquantity(String productquantity) {
		this.productquantity = productquantity;
	}
	public String getProductprice() {
		return productprice;
	}
	public void setProductprice(String productprice) {
		this.productprice = productprice;
	}
	public String getProductdescription() {
		return productdescription;
	}
	public void setProductdescription(String productdescription) {
		this.productdescription = productdescription;
	}
	@Override
	public String toString() {
		return "product [pid=" + pid + ", productname=" + productname + ", productcatagory=" + productcatagory
				+ ", productquantity=" + productquantity + ", productprice=" + productprice + ", productdescription="
				+ productdescription + "]";
	}
	

}