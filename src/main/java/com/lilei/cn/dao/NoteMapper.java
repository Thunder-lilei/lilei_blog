package com.lilei.cn.dao;

import com.lilei.cn.entity.Note;
import com.lilei.cn.entity.NoteExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NoteMapper {
    int countByExample(NoteExample example);

    int deleteByExample(NoteExample example);

    int deleteByPrimaryKey(Integer noteid);

    int insert(Note record);

    int insertSelective(Note record);

    List<Note> selectByExample(NoteExample example);
    
    List<Note> selectAll();

    Note selectByPrimaryKey(Integer noteid);

    int updateByExampleSelective(@Param("record") Note record, @Param("example") NoteExample example);

    int updateByExample(@Param("record") Note record, @Param("example") NoteExample example);

    int updateByPrimaryKeySelective(Note record);

    int updateByPrimaryKey(Note record);
}