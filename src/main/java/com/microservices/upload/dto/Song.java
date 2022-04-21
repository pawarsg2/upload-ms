package com.microservices.upload.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

//@Data
@Entity
public class Song {
	@Id
    @GeneratedValue(generator = "uuid")
	private long id;
	private String title;
	private String fileType;
	@Lob
	private byte[] byteData;

	public Song(String title, String fileType,byte[] byteData) {
		this.title = title;
		this.fileType = fileType;
		this.byteData = byteData;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	
	public byte[] getByteData() {
		return byteData;
	}
	public void setByteData(byte[] byteData) {
		this.byteData = byteData;
	}
	

}
