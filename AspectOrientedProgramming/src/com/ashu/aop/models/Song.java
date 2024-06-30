package com.ashu.aop.models;

public class Song {

	private String title;
	private String singerName;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSingerName() {
		return singerName;
	}

	public void setSingerName(String singerName) {
		this.singerName = singerName;
	}

	@Override
	public String toString() {
		return "Song [title=" + title + ", singerName=" + singerName + "]";
	}
}
