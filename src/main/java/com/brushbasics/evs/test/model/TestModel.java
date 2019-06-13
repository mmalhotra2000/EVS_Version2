package com.brushbasics.evs.test.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "test_model",schema= "Schema_Mohit")
public class TestModel extends BaseModel {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "test_model_gen")
	@SequenceGenerator(name = "test_model_gen", sequenceName = "test_model_seq")
	private BigDecimal seq;
	private String attr1;
	private String attr2;

	public TestModel(BigDecimal seq, String attr1, String attr2) {
		super();
		this.seq = seq;
		this.attr1 = attr1;
		this.attr2 = attr2;
	}

	public TestModel() {
	}

	public BigDecimal getSeq() {
		return seq;
	}

	public void setSeq(BigDecimal seq) {
		this.seq = seq;
	}

	public String getAttr1() {
		return attr1;
	}

	public void setAttr1(String attr1) {
		this.attr1 = attr1;
	}

	public String getAttr2() {
		return attr2;
	}

	public void setAttr2(String attr2) {
		this.attr2 = attr2;
	}

}
