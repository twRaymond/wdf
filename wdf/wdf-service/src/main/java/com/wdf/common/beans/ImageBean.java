package com.wdf.common.beans;

public class ImageBean {
	private String Id;
	private String base64Code;
	private String savePath;
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getBase64Code() {
		return base64Code;
	}
	public void setBase64Code(String base64Code) {
		this.base64Code = base64Code;
	}
	public String getSavePath() {
		return savePath;
	}
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
}
