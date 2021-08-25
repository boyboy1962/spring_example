package com.example.lesson02.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.lesson02.model.Album;

@Repository // null이면 어노테이션 확인 필요.
public interface AlbumDAO {//또는 Mapper라고도 한다. 
	
	public List<Album> selectAlbumList();
	
}
