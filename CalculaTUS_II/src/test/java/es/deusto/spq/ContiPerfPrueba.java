package es.deusto.spq;

import static org.junit.Assert.*;

import es.deusto.spq.ventanas.*;

import org.junit.Test;

import org.junit.Rule;
import org.databene.contiperf.Required;
import org.databene.contiperf.PerfTest;
import org.databene.contiperf.junit.ContiPerfRule;
import org.databene.contiperf.report.EmptyReportModule;

@PerfTest(invocations = 2)
@Required(max = 1200, average = 250)
public class ContiPerfPrueba {

	@Rule public ContiPerfRule rule = new ContiPerfRule();
	
	@Test
	@PerfTest(invocations = 4, threads = 20)
    @Required(max = 120, average = 30)
	public void test() {
		Users us = new Users("Admin", "Root", "admin@root.es", "root", 1, "null");
		Ventana_CalculaTUS_II VenCal = new Ventana_CalculaTUS_II(us);
		
	}

}
