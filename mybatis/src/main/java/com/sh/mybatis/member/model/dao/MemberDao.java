package com.sh.mybatis.member.model.dao;

import org.apache.ibatis.session.SqlSession;
import com.sh.mybatis.member.model.entity.Member;

public class MemberDao {

    public Member findById(SqlSession session, String id) {

        return session.selectOne("member.findById", id);
    }
}
