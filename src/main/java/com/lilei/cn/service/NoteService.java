package com.lilei.cn.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lilei.cn.entity.Note;
import com.lilei.cn.entity.NoteExample;

public interface NoteService {
	int countByExample(NoteExample example);

    int deleteByExample(NoteExample example);

    int deleteByPrimaryKey(String noteid);

    int insert(Note record);

    int insertSelective(Note record);

    List<Note> selectByExampleWithBLOBs(NoteExample example);

    List<Note> selectByExample(NoteExample example);
    
    List<Note> selectAll();

    Note selectByPrimaryKey(Integer noteid);

    int updateByExampleSelective(@Param("record") Note record, @Param("example") NoteExample example);

    int updateByExampleWithBLOBs(@Param("record") Note record, @Param("example") NoteExample example);

    int updateByExample(@Param("record") Note record, @Param("example") NoteExample example);

    int updateByPrimaryKeySelective(Note record);

    int updateByPrimaryKeyWithBLOBs(Note record);

    int updateByPrimaryKey(Note record);
}
