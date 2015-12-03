package com.omn.mpfactory.jsf.administation;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@ManagedBean(name = "administrationController", eager = true)
@SessionScoped
public class AdministrationController {

	private static Log LOG = LogFactory.getLog(AdministrationController.class);

	private String step;

	public String getStep() {
		AdministrationPagesEnum ape = AdministrationPagesEnum.LOGIN;
		if (step == null) {
			LOG.error("Current step is null.");
			return ape.getTemplate();
		}
		try {
			ape = AdministrationPagesEnum.valueOf(step);
		} catch (IllegalArgumentException e) {
			LOG.error(String.format("No page with step name=[%s]", step), e);
		}
		return ape.getTemplate();
	}

	public void nextStep(String step) {
		this.step = step;
	}

	public void setStep(String step) {
		this.step = step;
	}

}