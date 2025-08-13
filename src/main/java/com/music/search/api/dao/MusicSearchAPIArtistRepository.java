package com.music.search.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.music.search.api.model.Artist;

@Repository
public interface MusicSearchAPIArtistRepository extends JpaRepository<Artist, Integer>{
	

}
