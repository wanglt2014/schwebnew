package com.et59.cus.domain.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class BsProduct implements Serializable {

	/**
	 * This field was generated by Abator for iBATIS. This field corresponds to the database column bs_product.id
	 * @abatorgenerated
	 */
	private Integer id;
	/**
	 * This field was generated by Abator for iBATIS. This field corresponds to the database column bs_product.product_code
	 * @abatorgenerated
	 */
	private String productCode;
	/**
	 * This field was generated by Abator for iBATIS. This field corresponds to the database column bs_product.product_name
	 * @abatorgenerated
	 */
	private String productName;
	/**
	 * This field was generated by Abator for iBATIS. This field corresponds to the database column bs_product.product_price
	 * @abatorgenerated
	 */
	private BigDecimal productPrice;
	/**
	 * This field was generated by Abator for iBATIS. This field corresponds to the database column bs_product.product_image_url
	 * @abatorgenerated
	 */
	private String productImageUrl;
	/**
	 * This field was generated by Abator for iBATIS. This field corresponds to the database column bs_product.product_info
	 * @abatorgenerated
	 */
	private String productInfo;
	/**
	 * This field was generated by Abator for iBATIS. This field corresponds to the database column bs_product.productcategory_code
	 * @abatorgenerated
	 */
	private String productcategoryCode;
	/**
	 * This field was generated by Abator for iBATIS. This field corresponds to the database column bs_product.supplier_code
	 * @abatorgenerated
	 */
	private String supplierCode;
	/**
	 * This field was generated by Abator for iBATIS. This field corresponds to the database column bs_product.isactice
	 * @abatorgenerated
	 */
	private String isactice;
	/**
	 * This field was generated by Abator for iBATIS. This field corresponds to the database column bs_product.createdate
	 * @abatorgenerated
	 */
	private Date createdate;

	/**
	 * This method was generated by Abator for iBATIS. This method returns the value of the database column bs_product.id
	 * @return  the value of bs_product.id
	 * @abatorgenerated
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method sets the value of the database column bs_product.id
	 * @param id  the value for bs_product.id
	 * @abatorgenerated
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method returns the value of the database column bs_product.product_code
	 * @return  the value of bs_product.product_code
	 * @abatorgenerated
	 */
	public String getProductCode() {
		return productCode;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method sets the value of the database column bs_product.product_code
	 * @param productCode  the value for bs_product.product_code
	 * @abatorgenerated
	 */
	public void setProductCode(String productCode) {
		this.productCode = productCode == null ? null : productCode.trim();
	}

	/**
	 * This method was generated by Abator for iBATIS. This method returns the value of the database column bs_product.product_name
	 * @return  the value of bs_product.product_name
	 * @abatorgenerated
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method sets the value of the database column bs_product.product_name
	 * @param productName  the value for bs_product.product_name
	 * @abatorgenerated
	 */
	public void setProductName(String productName) {
		this.productName = productName == null ? null : productName.trim();
	}

	/**
	 * This method was generated by Abator for iBATIS. This method returns the value of the database column bs_product.product_price
	 * @return  the value of bs_product.product_price
	 * @abatorgenerated
	 */
	public BigDecimal getProductPrice() {
		return productPrice;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method sets the value of the database column bs_product.product_price
	 * @param productPrice  the value for bs_product.product_price
	 * @abatorgenerated
	 */
	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method returns the value of the database column bs_product.product_image_url
	 * @return  the value of bs_product.product_image_url
	 * @abatorgenerated
	 */
	public String getProductImageUrl() {
		return productImageUrl;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method sets the value of the database column bs_product.product_image_url
	 * @param productImageUrl  the value for bs_product.product_image_url
	 * @abatorgenerated
	 */
	public void setProductImageUrl(String productImageUrl) {
		this.productImageUrl = productImageUrl == null ? null : productImageUrl
				.trim();
	}

	/**
	 * This method was generated by Abator for iBATIS. This method returns the value of the database column bs_product.product_info
	 * @return  the value of bs_product.product_info
	 * @abatorgenerated
	 */
	public String getProductInfo() {
		return productInfo;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method sets the value of the database column bs_product.product_info
	 * @param productInfo  the value for bs_product.product_info
	 * @abatorgenerated
	 */
	public void setProductInfo(String productInfo) {
		this.productInfo = productInfo == null ? null : productInfo.trim();
	}

	/**
	 * This method was generated by Abator for iBATIS. This method returns the value of the database column bs_product.productcategory_code
	 * @return  the value of bs_product.productcategory_code
	 * @abatorgenerated
	 */
	public String getProductcategoryCode() {
		return productcategoryCode;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method sets the value of the database column bs_product.productcategory_code
	 * @param productcategoryCode  the value for bs_product.productcategory_code
	 * @abatorgenerated
	 */
	public void setProductcategoryCode(String productcategoryCode) {
		this.productcategoryCode = productcategoryCode == null ? null
				: productcategoryCode.trim();
	}

	/**
	 * This method was generated by Abator for iBATIS. This method returns the value of the database column bs_product.supplier_code
	 * @return  the value of bs_product.supplier_code
	 * @abatorgenerated
	 */
	public String getSupplierCode() {
		return supplierCode;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method sets the value of the database column bs_product.supplier_code
	 * @param supplierCode  the value for bs_product.supplier_code
	 * @abatorgenerated
	 */
	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode == null ? null : supplierCode.trim();
	}

	/**
	 * This method was generated by Abator for iBATIS. This method returns the value of the database column bs_product.isactice
	 * @return  the value of bs_product.isactice
	 * @abatorgenerated
	 */
	public String getIsactice() {
		return isactice;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method sets the value of the database column bs_product.isactice
	 * @param isactice  the value for bs_product.isactice
	 * @abatorgenerated
	 */
	public void setIsactice(String isactice) {
		this.isactice = isactice == null ? null : isactice.trim();
	}

	/**
	 * This method was generated by Abator for iBATIS. This method returns the value of the database column bs_product.createdate
	 * @return  the value of bs_product.createdate
	 * @abatorgenerated
	 */
	public Date getCreatedate() {
		return createdate;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method sets the value of the database column bs_product.createdate
	 * @param createdate  the value for bs_product.createdate
	 * @abatorgenerated
	 */
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
}