package com.hysd.domain;

/**
 * 商品的实体类
 * @author jf3q.com
 *
 */
public class Goods {

	private Integer gid;//商品id
	private String gname;//商品名称 
	private Directory2 directory2;//关联二级目录
	private Integer special;//0代表不是促销商品，1代表是促销商品
	private Integer status;//0下架，1上架
	private String cts;//创建时间 
	private String img;//商品图片
	private Integer orderby;//排序
	private String norms;//产品规格
	private Price price;//单价单位
	private Double priceValue;
	private Double vipPrice;//会员价
	private Double specialPrice;//促销价
	private Integer store;//库存
	private String address;//收货地址
	private String gparam;//商品参数
	private Integer isPost;//1包邮，0不包邮，2满多少钱包邮（此时必须填写postMoney）
	private Double postMoney;//邮费
	private String putawayTs;//上架时间
	private String soldoutTs;//下架时间
	private Integer soldNum;//已卖出的数量
	private Double lessMoney;//至少多少钱包邮
	private Integer associated;//0没有关联，1需要关联
	private String postDesc;//邮费说明
	
	public Integer getGid() {
		return gid;
	}
	public void setGid(Integer gid) {
		this.gid = gid;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public Directory2 getDirectory2() {
		return directory2;
	}
	public void setDirectory2(Directory2 directory2) {
		this.directory2 = directory2;
	}
	public Integer getSpecial() {
		return special;
	}
	public void setSpecial(Integer special) {
		this.special = special;
	}
	public Double getPriceValue() {
		return priceValue;
	}
	public void setPriceValue(Double priceValue) {
		this.priceValue = priceValue;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getCts() {
		return cts;
	}
	public void setCts(String cts) {
		this.cts = cts;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public Integer getOrderby() {
		return orderby;
	}
	public void setOrderby(Integer orderby) {
		this.orderby = orderby;
	}
	public String getNorms() {
		return norms;
	}
	public void setNorms(String norms) {
		this.norms = norms;
	}
	public Price getPrice() {
		return price;
	}
	public void setPrice(Price price) {
		this.price = price;
	}
	public Double getVipPrice() {
		return vipPrice;
	}
	public void setVipPrice(Double vipPrice) {
		this.vipPrice = vipPrice;
	}
	public Double getSpecialPrice() {
		return specialPrice;
	}
	public void setSpecialPrice(Double specialPrice) {
		this.specialPrice = specialPrice;
	}
	public Integer getStore() {
		return store;
	}
	public void setStore(Integer store) {
		this.store = store;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGparam() {
		return gparam;
	}
	public void setGparam(String gparam) {
		this.gparam = gparam;
	}
	public Integer getIsPost() {
		return isPost;
	}
	public void setIsPost(Integer isPost) {
		this.isPost = isPost;
	}
	public Double getPostMoney() {
		return postMoney;
	}
	public void setPostMoney(Double postMoney) {
		this.postMoney = postMoney;
	}
	public String getPutawayTs() {
		return putawayTs;
	}
	public void setPutawayTs(String putawayTs) {
		this.putawayTs = putawayTs;
	}
	public String getSoldoutTs() {
		return soldoutTs;
	}
	public void setSoldoutTs(String soldoutTs) {
		this.soldoutTs = soldoutTs;
	}
	public Integer getSoldNum() {
		return soldNum;
	}
	public void setSoldNum(Integer soldNum) {
		this.soldNum = soldNum;
	}
	public Double getLessMoney() {
		return lessMoney;
	}
	public void setLessMoney(Double lessMoney) {
		this.lessMoney = lessMoney;
	}
	public Integer getAssociated() {
		return associated;
	}
	public void setAssociated(Integer associated) {
		this.associated = associated;
	}
	public String getPostDesc() {
		return postDesc;
	}
	public void setPostDesc(String postDesc) {
		this.postDesc = postDesc;
	}
	
	
	
	
	
}
