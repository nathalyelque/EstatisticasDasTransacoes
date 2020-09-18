package br.com.praticando.estatisticasdastransacoes.model;

import java.math.BigDecimal;

public class EstatisticasDasTransacoes {

	private int count;
	private BigDecimal sum;
	private BigDecimal avg;
	private BigDecimal min;
	private BigDecimal max;
	
	public EstatisticasDasTransacoes(int count, BigDecimal sum, BigDecimal avg, BigDecimal min, BigDecimal max) {
		this.count = count;
		this.sum = sum;
		this.avg = avg;
		this.min = min;
		this.max = max;
	}

	public int getCount() {
		return count;
	}

	public BigDecimal getSum() {
		return sum;
	}

	public BigDecimal getAvg() {
		return avg;
	}

	public BigDecimal getMin() {
		return min;
	}

	public BigDecimal getMax() {
		return max;
	}
	
		
	
}
