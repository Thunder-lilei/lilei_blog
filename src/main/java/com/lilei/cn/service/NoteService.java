package com.lilei.cn.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lilei.cn.entity.Note;
import com.lilei.cn.entity.NoteExample;

public interface NoteService {
    int insertSelective(Note record);

    List<Note> selectAll();
    
    List<Note> selecttimelineAll();

    Note selectByPrimaryKey(Integer noteid);

}
