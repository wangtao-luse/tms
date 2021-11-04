package com.tms.member.service;

import com.tms.model.member.Account;
import com.tms.member.persist.AccountMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author wangtao
 * @since 2021-11-02
 */
@Service
public class AccountService extends ServiceImpl<AccountMapper, Account>  {

}
