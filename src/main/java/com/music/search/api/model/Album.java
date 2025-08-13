package com.music.search.api.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Album {


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer albumId;
	
	private String title;
	
	private String yearOfRelease;
	
	private String genre;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artist_id")
	@JsonIgnore
	private Artist artist;

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	public Integer getAlbumId() {
		return albumId;
	}

	public void setAlbumId(Integer albumId) {
		this.albumId = albumId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getYearOfRelease() {
		return yearOfRelease;
	}

	public void setYearOfRelease(String yearOfRelease) {
		this.yearOfRelease = yearOfRelease;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "Album [albumId=" + albumId + ", title=" + title + ", yearOfRelease=" + yearOfRelease + ", genre="
				+ genre + "]";
	}
	
	public Album(Integer albumId, String title, String yearOfRelease, String genre) {
		super();
		this.albumId = albumId;
		this.title = title;
		this.yearOfRelease = yearOfRelease;
		this.genre = genre;
	}

	public Album() {
		super();
	}
}
