package com.sh.papago.dao;

import com.sh.papago.vo.UserVo;

public interface UserDao {
	public UserVo doLogin(UserVo uv);
	public int insertUser(UserVo uv);
}
