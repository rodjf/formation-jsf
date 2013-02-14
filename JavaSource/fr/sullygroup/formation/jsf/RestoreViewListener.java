package fr.sullygroup.formation.jsf;

import javax.el.ELResolver;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class RestoreViewListener implements PhaseListener {

	@Override
	public void afterPhase(PhaseEvent arg0) {
		System.out.println("après la phase Restore_view");
		FacesContext context = arg0.getFacesContext();
		ELResolver elResolver = context.getApplication().getELResolver();
		
		LoginBean loginBean = (LoginBean)elResolver.getValue(context.getELContext(), null, "loginBean");
		
		System.out.println("View ID : " +context.getViewRoot().getViewId());
		if (! context.getViewRoot().getViewId().equalsIgnoreCase("/connexion.xhtml") && loginBean.getLogin().isEmpty() ){
			System.out.println("Attention, pas dans connexion ou pas authentifié !");
			context.getApplication().getNavigationHandler().handleNavigation(context, null, "connexion");
		}
		
	}

	@Override
	public void beforePhase(PhaseEvent arg0) {
		System.out.println("avant la phase Restore_view");
		
	}

	@Override
	public PhaseId getPhaseId() {
		
		return PhaseId.RESTORE_VIEW;
	}

}
