package com.lilei.cn.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lilei.cn.dao.NoteMapper;
import com.lilei.cn.entity.Note;
import com.lilei.cn.entity.NoteExample;
import com.lilei.cn.service.NoteService;

@Service
public class NoteServiceImpl implements NoteService {
	@Autowired
	private NoteMapper notemapper;

	@Override
	public int insertSelective(Note record) {
		// TODO Auto-generated method stub
		return notemapper.insertSelective(record);
	}

	@Override
	public Note selectByPrimaryKey(Integer noteid) {
		// TODO Auto-generated method stub
		return notemapper.selectByPrimaryKey(noteid);
	}

	@Override
	public List<Note> selectAll() {
		// TODO Auto-generated method stub
		return notemapper.selectAll();
	}

	@Override
	public List<Note> selecttimelineAll() {
		// TODO Auto-generated method stub
		return notemapper.selecttimelineAll();
	}
}
