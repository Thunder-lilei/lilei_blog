package com.lilei.cn.dao;

import com.lilei.cn.entity.Note;
import com.lilei.cn.entity.NoteExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NoteMapper {
    int insertSelective(Note record);

    List<Note> selectAll();
    
    List<Note> selecttimelineAll();

    Note selectByPrimaryKey(Integer noteid);

}