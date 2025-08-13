package com.music.search.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.music.search.api.dao.MusicSearchAPIAlbumRepository;
import com.music.search.api.dao.MusicSearchAPIArtistRepository;
import com.music.search.api.model.Album;
import com.music.search.api.model.Artist;

@Service
public class MusicSearchAPIService {
	
	@Autowired
	private MusicSearchAPIArtistRepository artistRepo;
	
	@Autowired
	private MusicSearchAPIAlbumRepository albumRepo;

	public  List<Artist> retrieveAllArtists() {
		return artistRepo.findAll();
	}
	
	public Artist retrieveArtistById(Integer artistId) {
		Optional<Artist> artist = artistRepo.findById(artistId);
		if (!artist.isPresent()) {
			throw new IllegalArgumentException("Artist ID: " + artistId + " not found!");
		}
		return artist.get();
	}
	
	public List<Album> retrieveAllAlbumsByArtistId(Integer artistId) {
		Artist artist = retrieveArtistById(artistId);
		if (artist==null) {
			return null;
		}
		return artist.getAlbums();
	}
	
	public Artist saveArtist(Artist artist) {
		return artistRepo.save(artist);
	}
		
	public List<Album> saveAlbumsByArtistId(List<Album> albums, Integer artistId) {
		Artist artist = retrieveArtistById(artistId);
		for (Album album : albums) {
			album.setArtist(artist);
		}
		return albumRepo.saveAll(albums);
	}
	
	public void saveAlbumByArtistId(Integer artistId, Album album) {
		Artist artist = retrieveArtistById(artistId);
		album.setArtist(artist);
		albumRepo.save(album);
	}
}
