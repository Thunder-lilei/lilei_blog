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
	public int countByExample(NoteExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByExample(NoteExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByPrimaryKey(String noteid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Note record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(Note record) {
		// TODO Auto-generated method stub
		return notemapper.insertSelective(record);
	}

	@Override
	public List<Note> selectByExampleWithBLOBs(NoteExample example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Note> selectByExample(NoteExample example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Note selectByPrimaryKey(Integer noteid) {
		// TODO Auto-generated method stub
		return notemapper.selectByPrimaryKey(noteid);
	}

	@Override
	public int updateByExampleSelective(Note record, NoteExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByExampleWithBLOBs(Note record, NoteExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByExample(Note record, NoteExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKeySelective(Note record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKeyWithBLOBs(Note record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Note record) {
		// TODO Auto-generated method stub
		return 0;
	}
}
