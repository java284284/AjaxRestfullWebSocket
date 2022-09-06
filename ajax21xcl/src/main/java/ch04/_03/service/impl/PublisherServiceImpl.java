package ch04._03.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ch04._03.dao.PublisherDao;
import ch04._03.model.PublisherBean;
import ch04._03.service.PublisherService;

@Service
@Transactional
public class PublisherServiceImpl implements PublisherService {
	
	@Autowired
	PublisherDao dao;
	
	public PublisherServiceImpl() {
	}

	@Override
	public List<PublisherBean> getAllPublisher() {
		return dao.getAllPublisher();
	}

}
