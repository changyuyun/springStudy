package com.ityun.repository;

import com.ityun.dao.EsUser;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface EsUserRepository extends ElasticsearchRepository<EsUser, String> {
}
