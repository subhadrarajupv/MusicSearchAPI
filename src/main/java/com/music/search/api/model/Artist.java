package com.music.search.api.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Artist {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer artistId;
	
	@Column
	private String artistName;
	
	@OneToMany(mappedBy = "artist", fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
	@JsonIgnore
	private List<Album> albums;

	public Integer getArtistId() {
		return artistId;
	}

	public void setArtistId(Integer artistId) {
		this.artistId = artistId;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public List<Album> getAlbums() {
		return albums;
	}

	public void setAlbums(List<Album> albums) {
		this.albums = albums;
	}
	
	@Override
	public String toString() {
		return "Artist [artistId=" + artistId + ", artistName=" + artistName + "]";
	}

	public Artist() {
		super();
	}

	public Artist(Integer artistId, String artistName) {
		super();
		this.artistId = artistId;
		this.artistName = artistName;
	}

}
