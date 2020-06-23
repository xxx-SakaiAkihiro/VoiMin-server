package com.example.service;

import java.util.ArrayList;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.domain.Password;
import com.example.mapper.PasswordMapper;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private PasswordMapper passwordMapper;
	
	
	@Override
	public UserDetails loadUserByUsername(String mailAddress) throws UsernameNotFoundException {

		Password password = passwordMapper.load(mailAddress);
		// 本来ならここでDBなどからユーザを検索することになるが、サンプルのためリストに含まれるかで判定している
		if (password==null) {
			throw new UsernameNotFoundException(mailAddress);
		}
		// ここで権限を付与
		Collection<GrantedAuthority> authorityList = new ArrayList<>();
		authorityList.add(new SimpleGrantedAuthority("ROLE_USER"));
		UserDetails user = User.withUsername(password.getMailAddress()).password(password.getPassword()).authorities(authorityList).build();
		
		// ユーザの権限
		return user;
	}

}
