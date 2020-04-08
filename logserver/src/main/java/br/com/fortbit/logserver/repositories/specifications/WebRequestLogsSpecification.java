package br.com.fortbit.logserver.repositories.specifications;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import br.com.fortbit.logserver.domain.WebRequestLogs;
import br.com.fortbit.logserver.repositories.filters.WebRequestLogsFilter;

public class WebRequestLogsSpecification implements Specification<WebRequestLogs> {
	private static final long serialVersionUID = 1L;
	
	private final WebRequestLogsFilter criteria;

	public WebRequestLogsSpecification(WebRequestLogsFilter criteria) {
		this.criteria = criteria;
	}

	@Override
	public Predicate toPredicate(Root<WebRequestLogs> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

		final List<Predicate> predicates = new ArrayList<Predicate>();
		if (criteria.getIp() != null && !criteria.getIp().trim().isEmpty()) {
			predicates.add(cb.equal(root.get("ip"), criteria.getIp()));
		}
		
		if (criteria.getInitialDate() != null) {
			predicates.add(cb.greaterThanOrEqualTo(root.get("data"), criteria.getInitialDate().atTime(0, 0)));
		}
		
		if (criteria.getFinalDate() != null) {
			predicates.add(cb.lessThanOrEqualTo(root.get("data"),  criteria.getFinalDate().atTime(0, 0)));
		}
		return cb.and(predicates.toArray(new Predicate[predicates.size()]));
	}
}
