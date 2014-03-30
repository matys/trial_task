/*
 * Any use, copying, modification, distribution and selling of this software
 * and its documentation for any purposes without SoftwareMind's written permission
 * is hereby prohibited
 *
 */
package ee.playtech.trial.server.model.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@Table(name = "PROCESSED_QUERIES_STATISTICS")
public class ProcessedQueriesStatistics extends GenericEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "processed_queries_quantity")
	private Long processedQueriesQuantity;

	@Column(name = "min_processing_time")
	private Long minProcessingTime;

	@Column(name = "max_processing_time")
	private Long maxProcessingTime;

	@Column(name = "average_processing_time")
	private BigDecimal averageProcessingTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProcessedQueriesQuantity() {
		return processedQueriesQuantity;
	}

	public void setProcessedQueriesQuantity(Long processedQueriesQuantity) {
		this.processedQueriesQuantity = processedQueriesQuantity;
	}

	public Long getMinProcessingTime() {
		return minProcessingTime;
	}

	public void setMinProcessingTime(Long minProcessingTime) {
		this.minProcessingTime = minProcessingTime;
	}

	public Long getMaxProcessingTime() {
		return maxProcessingTime;
	}

	public void setMaxProcessingTime(Long maxProcessingTime) {
		this.maxProcessingTime = maxProcessingTime;
	}

	public BigDecimal getAverageProcessingTime() {
		return averageProcessingTime;
	}

	public void setAverageProcessingTime(BigDecimal averageProcessingTime) {
		this.averageProcessingTime = averageProcessingTime;
	}

}
